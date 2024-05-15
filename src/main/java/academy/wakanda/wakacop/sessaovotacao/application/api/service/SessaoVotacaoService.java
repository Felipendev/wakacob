package academy.wakanda.wakacop.sessaovotacao.application.api.service;

import academy.wakanda.wakacop.sessaovotacao.application.api.request.SessaoAberturaRequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.ResultadoSessaoResponse;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.SessaoAberturaResponse;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.VotoResponse;
import academy.wakanda.wakacop.sessaovotacao.domain.request.VotoRequest;

import java.util.UUID;

public interface SessaoVotacaoService {
    SessaoAberturaResponse abreSessao(SessaoAberturaRequest request);
    VotoResponse recebeVoto(UUID idSessao, VotoRequest request);
    ResultadoSessaoResponse obtemResultado(UUID idSessao);
}
