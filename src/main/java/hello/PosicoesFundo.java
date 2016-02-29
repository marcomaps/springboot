package hello;

import java.util.ArrayList;
import java.util.List;

public class PosicoesFundo {

	private List<PosicaoFundo> posicoes = new ArrayList<PosicaoFundo>();
	
	public void add(PosicaoFundo posicaoFundo) {
		posicoes.add(posicaoFundo);
	}

	public List<PosicaoFundo> getPosicoes() {
		return posicoes;
	}

	public void setPosicoes(List<PosicaoFundo> posicoes) {
		this.posicoes = posicoes;
	}

	public PosicoesFundo() {
	}
	
	public PosicoesFundo(List<PosicaoFundo> posicoes) {
		super();
		this.posicoes = posicoes;
	}
	
	
}
