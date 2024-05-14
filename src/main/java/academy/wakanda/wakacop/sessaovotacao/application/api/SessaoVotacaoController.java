package academy.wakanda.wakacop.sessaovotacao.application.api;

import academy.wakanda.wakacop.sessaovotacao.application.api.request.SessaoAberturaRequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.SessaoAberturaResponse;
import academy.wakanda.wakacop.sessaovotacao.application.api.service.SessaoVotacaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class SessaoVotacaoController implements SessaoVotacaoAPI {
    private final SessaoVotacaoService sessaoVotacaoService;

    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest request) {
        log.info("[start] - SessaoVotacaoController - abreSessao");
        SessaoAberturaResponse sessaoAberturaResponse = sessaoVotacaoService.abreSessao(request);
        log.info("[finish] - SessaoVotacaoController - abreSessao");
        return sessaoAberturaResponse;
    }
}
