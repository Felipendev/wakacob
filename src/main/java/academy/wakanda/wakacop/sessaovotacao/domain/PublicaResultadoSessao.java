package academy.wakanda.wakacop.sessaovotacao.domain;

import academy.wakanda.wakacop.sessaovotacao.application.api.response.ResultadoSessaoResponse;

public interface PublicaResultadoSessao {
    void publica(ResultadoSessaoResponse resultadoSessaoResponse);
}
