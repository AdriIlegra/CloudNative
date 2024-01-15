package br.adriana.nogueira.tema08.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "historico")
public class CalculoHistorico {

    @Id
    private String id;
    private String operacao;
    private String resultado;


    public CalculoHistorico(String operacao, String resultado) {
        this.operacao = operacao;
        this.resultado = resultado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
