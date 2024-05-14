package academy.wakanda.wakacop.sessaovotacao.infra;

import academy.wakanda.wakacop.sessaovotacao.application.api.repository.SessaoAberturaRepository;
import academy.wakanda.wakacop.sessaovotacao.domain.SessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}
