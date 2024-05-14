package academy.wakanda.wakacop.pauta.application.api;

import academy.wakanda.wakacop.pauta.application.api.request.NovaPautaRequest;
import academy.wakanda.wakacop.pauta.application.api.response.PautaCadastradaResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pauta")
public interface PautaAPI {

    @PostMapping("/novaPauta")
    PautaCadastradaResponse cadastraPauta(@RequestBody NovaPautaRequest novaPauta);
}
