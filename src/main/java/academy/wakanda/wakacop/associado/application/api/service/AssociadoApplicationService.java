package academy.wakanda.wakacop.associado.application.api.service;

import academy.wakanda.wakacop.associado.infra.client.SerproClientFeign;
import academy.wakanda.wakacop.associado.infra.client.response.ConsultaCpfResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AssociadoApplicationService implements AssociadoService {
    private static final String TOKEN = "Bearer 06aef429-a981-3ec5-a1f8-71d38d86481e";
    private final SerproClientFeign serproClientFeign;

    @Override
    public void validaAssociadoAptoVoto(String cpfAssociado) {
        log.debug("[start] - AssociadoApplicationService - validaAssociadoAptoVoto");
        ConsultaCpfResponse consultaCpfResponse = serproClientFeign.consultaCpf(TOKEN, cpfAssociado);
        valida(consultaCpfResponse);
        log.debug("[finish] - AssociadoApplicationService - validaAssociadoAptoVoto");
    }

    private void valida(ConsultaCpfResponse consultaCpfResponse) {
        if (consultaCpfResponse.isInvalid()) {
            throw new RuntimeException("CPF Associado Inválido");
        }
    }
}
