package academy.wakanda.wakacop.sessaovotacao.application.api;

import academy.wakanda.wakacop.sessaovotacao.application.api.request.SessaoAberturaRequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.SessaoAberturaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sessao/abertura")
public interface SessaoVotacaoAPI {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    SessaoAberturaResponse abreSessao(@RequestBody SessaoAberturaRequest request);
}
