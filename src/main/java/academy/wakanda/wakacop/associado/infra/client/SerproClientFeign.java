package academy.wakanda.wakacop.associado.infra.client;

import academy.wakanda.wakacop.associado.infra.client.response.ConsultaCpfResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "serproClientFeign", url = "https://gateway.apiserpro.serpro.gov.br/consulta-cpf-df-trial/v1/")
public interface SerproClientFeign {

    @GetMapping(value = "/cpf/{cpfAssociado}")
    ConsultaCpfResponse consultaCpf(@RequestHeader(value = "Authorization") String authorization,
                                    @PathVariable String cpfAssociado);
}
