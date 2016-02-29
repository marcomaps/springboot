package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PosicaoController {

	// TODO pedir data no parâmetro
	@RequestMapping("/fundo/posicao")
	public PosicoesFundo posicao(@RequestParam String cnpj) {
		PosicoesFundo posicoes = new PosicoesFundo();
		posicoes.add(new PosicaoFundo("Renda Fixa", "Título Público", "LFT-2020", 2));
		posicoes.add(new PosicaoFundo("Renda Fixa", "Título Público", "LTN-2020", 3));
		posicoes.add(new PosicaoFundo("Cota", "RF", "FUNDO SOBERANO", 4));
		posicoes.add(new PosicaoFundo("Cota", "Ações", "FUNDO IBOVESPA ATIVO", 5));
		posicoes.add(new PosicaoFundo("Cota", "Imobiliário", "FUNDO SHOPPING MORUMBI", 6));
		return posicoes;
	}
}
