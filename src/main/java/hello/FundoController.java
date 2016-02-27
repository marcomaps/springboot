package hello;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FundoController {

	private static Map<String, CadastroFundo> fundos = new HashMap<String, CadastroFundo>();

	static {
		add(new CadastroFundo("1", "FUNDO 1", 1.11d));
		add(new CadastroFundo("2", "FUNDO 2", 2.22d));
		add(new CadastroFundo("3", "FUNDO 3", 3.33d));
		add(new CadastroFundo("4", "FUNDO 4", 4.44d));
		add(new CadastroFundo("5", "FUNDO 5", 5.55d));
	}

	static CadastroFundo add(CadastroFundo cad) {
		fundos.put(cad.getCnpj(), cad);
		return cad;
	}

	private QuoteService quoteService;
	
	@Autowired
	public FundoController(QuoteService quoteService) {
		this.quoteService = quoteService;
	}
	
	@RequestMapping("/fundo/cadastro")
	public Collection<CadastroFundo> find(@RequestParam(required = false) String cnpj) {
		return cnpj == null ? fundos.values() : Arrays.asList(fundos.get(cnpj));
	}

	@RequestMapping("/fundo/cadastro/hint")
	public CadastroFundo hint() {
		Quote quote = this.quoteService.newQuote();
		Long idQuote = quote.getValue().getId();
		String quoteValue = quote.getValue().getQuote();
		CadastroFundo novoCad = new CadastroFundo(idQuote.toString(), quoteValue, idQuote * idQuote);
		return novoCad;
	}
	
	// curl --data '{"cnpj" : "6", "nome" : "FUNDO 6", "valorCota" : "6.66"}'
	// -X POST -H 'Content-Type:application/json'
	// http://localhost:8080/fundo/cadastro/novo
	@RequestMapping(method = RequestMethod.POST, path = "/fundo/cadastro/novo")
	public CadastroFundo create(@RequestBody CadastroFundo cad) {
		System.out.println("criando " + cad);
		add(cad);
		return cad;
	}
}