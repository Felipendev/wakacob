package academy.wakanda.wakacop.associado.infra.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ConsultaCpfResponse {
    @JsonProperty("ni")
    private String ni;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("situacao")
    private Situacao situacao;
    @JsonProperty("nascimento")
    private String nascimento;
    @JsonProperty("obito")
    private String obito;

    public boolean isInvalid() {
        return ! isValid();
    }

    private boolean isValid() {
        return this.situacao.getCodigo().equals("0");
    }
}

