package hello;

public class CadastroFundo {

	private String cnpj;
	private String nome;
	private double valorCota;

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValorCota(double valorCota) {
		this.valorCota = valorCota;
	}

	public CadastroFundo() {
	}

	public CadastroFundo(String cnpj, String nome, double valorCota) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.valorCota = valorCota;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getNome() {
		return nome;
	}

	public double getValorCota() {
		return valorCota;
	}

	@Override
	public String toString() {
		return "CadastroFundo [cnpj=" + cnpj + ", nome=" + nome + ", valorCota=" + valorCota + "]";
	}

}
