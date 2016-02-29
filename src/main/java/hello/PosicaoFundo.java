package hello;

public class PosicaoFundo {

	private String segmento;
	private String classificacao;
	public String getClassificacao() {
		return classificacao;
	}

	private String papel;
	private double valor;

	public PosicaoFundo(String segmento, String classificacao, String papel, double valor) {
		super();
		this.segmento = segmento;
		this.classificacao = classificacao;
		this.papel = papel;
		this.valor = valor;
	}

	public String getSegmento() {
		return segmento;
	}

	public String getPapel() {
		return papel;
	}

	public double getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "PosicaoFundo [segmento=" + segmento + ", classificacao=" + classificacao + ", papel=" + papel
				+ ", valor=" + valor + "]";
	}

}
