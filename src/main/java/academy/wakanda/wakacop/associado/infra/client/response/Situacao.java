package academy.wakanda.wakacop.associado.infra.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Situacao {
    @JsonProperty("codigo")
    private String codigo;
    @JsonProperty("descricao")
    private String descricao;
}

