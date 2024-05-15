package academy.wakanda.wakacop.sessaovotacao.domain.api.request;

import academy.wakanda.wakacop.sessaovotacao.domain.OpcaoVoto;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class VotoRequest {
    private String cpfAssociado;
    private OpcaoVoto opcaoVoto;
}
