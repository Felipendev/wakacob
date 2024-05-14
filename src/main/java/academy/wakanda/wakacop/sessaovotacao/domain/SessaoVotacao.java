package academy.wakanda.wakacop.sessaovotacao.domain;

import academy.wakanda.wakacop.sessaovotacao.application.api.request.SessaoAberturaRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
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
    private LocalDateTime dataAbertura;

    public SessaoVotacao(SessaoAberturaRequest aberturaRequest) {
        this.idPauta = aberturaRequest.getIdPauta();
        this.tempoDuracao = aberturaRequest.getTempoDuracao().orElse(1);
        this.dataAbertura = LocalDateTime.now();
    }
}
