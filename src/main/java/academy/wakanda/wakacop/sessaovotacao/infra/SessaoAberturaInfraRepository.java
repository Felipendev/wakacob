package academy.wakanda.wakacop.sessaovotacao.infra;

import academy.wakanda.wakacop.sessaovotacao.application.api.repository.SessaoAberturaRepository;
import academy.wakanda.wakacop.sessaovotacao.domain.SessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Repository
@Log4j2
public class SessaoAberturaInfraRepository implements SessaoAberturaRepository {
    private final SessaoAberturaSpringDataJPARepository sessaoVotacaoSpringDataJPARepository;

    @Override
    public SessaoVotacao salva(SessaoVotacao sessaoVotacao) {
        log.info("[start] - SessaoAberturaInfraRepository - salva");
        sessaoVotacaoSpringDataJPARepository.save(sessaoVotacao);
        log.info("[finish] - SessaoAberturaInfraRepository - salva");
        return sessaoVotacao;
    }

    @Override
    public SessaoVotacao buscaPorId(UUID idSessao) {
        log.info("[start] - SessaoAberturaInfraRepository - buscaPorId");
        SessaoVotacao sessao = sessaoVotacaoSpringDataJPARepository.findById(idSessao)
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada!"));
        log.info("[finish] - SessaoAberturaInfraRepository - buscaPorId");
        return sessao;
    }
}
