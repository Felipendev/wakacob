package academy.wakanda.wakacop.sessaovotacao.application.api;

import academy.wakanda.wakacop.sessaovotacao.application.api.request.SessaoAberturaRequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.ResultadoSessaoResponse;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.SessaoAberturaResponse;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.VotoResponse;
import academy.wakanda.wakacop.sessaovotacao.application.api.service.SessaoVotacaoService;
import academy.wakanda.wakacop.sessaovotacao.domain.request.VotoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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

    @Override
    public VotoResponse recebeVoto(UUID idSessao, VotoRequest request) {
        log.debug("[start] - SessaoVotacaoController - recebeVoto");
        log.debug("[idSessao] {}", idSessao);
        VotoResponse votoResponse = sessaoVotacaoService.recebeVoto(idSessao, request);
        log.debug("[finish] - SessaoVotacaoController - recebeVoto");
        return votoResponse;
    }

    @Override
    public ResultadoSessaoResponse obtemResultado(UUID idSessao) {
        log.info("[start] - SessaoVotacaoController - obtemResultado");
        ResultadoSessaoResponse resultado = sessaoVotacaoService.obtemResultado(idSessao);
        log.info("[finish] - SessaoVotacaoController - obtemResultado");
        return resultado;
    }
}
