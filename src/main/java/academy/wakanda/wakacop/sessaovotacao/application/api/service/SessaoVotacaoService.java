package academy.wakanda.wakacop.sessaovotacao.application.api.service;

import academy.wakanda.wakacop.sessaovotacao.application.api.request.SessaoAberturaRequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.SessaoAberturaResponse;

public interface SessaoVotacaoService {
    SessaoAberturaResponse abreSessao(SessaoAberturaRequest request);
}
