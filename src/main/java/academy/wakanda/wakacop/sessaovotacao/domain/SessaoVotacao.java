package academy.wakanda.wakacop.sessaovotacao.domain;

import academy.wakanda.wakacop.pauta.domain.Pauta;
import academy.wakanda.wakacop.sessaovotacao.application.api.request.SessaoAberturaRequest;
import academy.wakanda.wakacop.sessaovotacao.domain.api.request.VotoRequest;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapKey;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.aspectj.weaver.bcel.LazyClassGen;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.context.annotation.Lazy;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SessaoVotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    private UUID idPauta;
    private Integer tempoDuracao ;
    @Enumerated(EnumType.STRING)
    private StatusSessaoVotacao status;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataEncerramento;

    @OneToMany(
            mappedBy = "sessaoVotacao",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @MapKey(name = "cpfAssociado")
    private Map<String, VotoPauta> votos;

    public SessaoVotacao(SessaoAberturaRequest aberturaRequest, Pauta pauta) {
        this.idPauta = pauta.getId();
        this.tempoDuracao = aberturaRequest.getTempoDuracao().orElse(1);
        this.dataAbertura = LocalDateTime.now();
        this.dataEncerramento = dataAbertura.plusMinutes(this.tempoDuracao);
        this.status = StatusSessaoVotacao.ABERTA;
        this.votos = new HashMap<>();
    }

    public VotoPauta recebeVoto(VotoRequest votoRequest) {
        validaSessaoAberta();
        validaAssocioado(votoRequest.getCpfAssociado());
        VotoPauta voto = new VotoPauta(this, votoRequest);
        votos.put(votoRequest.getCpfAssociado(), voto);
        return voto;
    }

    private void validaSessaoAberta() {
        atualizaSessao();
        if (this.status.equals(StatusSessaoVotacao.FECHADA)) {
            throw new RuntimeException("Sessão está fechada!");
        }
    }

    private void atualizaSessao() {
        if (this.status.equals(StatusSessaoVotacao.ABERTA)) {
            if (LocalDateTime.now().isAfter(this.dataEncerramento))
                fechaSessao();
        }
    }

    private void fechaSessao() {
        this.status = StatusSessaoVotacao.FECHADA;
    }

    private void validaAssocioado(String cpfAssociado) {
        if (this.votos.containsKey(cpfAssociado)){
            new RuntimeException("Assiciado Já Votou nessa Sessão!");
        }
    }
}
