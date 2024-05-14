package academy.wakanda.wakacop.sessaovotacao.application.api.service;

import academy.wakanda.wakacop.sessaovotacao.application.api.repository.SessaoAberturaRepository;
import academy.wakanda.wakacop.sessaovotacao.application.api.request.SessaoAberturaRequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.SessaoAberturaResponse;
import academy.wakanda.wakacop.sessaovotacao.domain.SessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoApplicationService implements SessaoVotacaoService {
    private final SessaoAberturaRepository sessaoAberturaRepository;

    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest request) {
        log.info("[start] - SessaoVotacaoApplicationService - abreSessao");
        SessaoVotacao sessaoVotacao = sessaoAberturaRepository.salva(new SessaoVotacao(request));
        log.info("[finish] - SessaoVotacaoApplicationService - abreSessao");
        return new SessaoAberturaResponse(sessaoVotacao);
    }
}
