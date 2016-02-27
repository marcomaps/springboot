package hello;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FundoController {

	private FundoRepository fundoRepository;

	private QuoteService quoteService;

	@Autowired
	public FundoController(FundoRepository fundoRepository, QuoteService quoteService) {
		this.fundoRepository = fundoRepository;
		this.quoteService = quoteService;
	}

	@RequestMapping("/fundo/cadastro")
	public Collection<CadastroFundo> find(@RequestParam(required = false) String cnpj) {
		return cnpj == null ? fundoRepository.findAll() : Arrays.asList(fundoRepository.find(cnpj));
	}

	// curl --data '{"cnpj" : "6", "nome" : "FUNDO 6", "valorCota" : "6.66"}'
	// -X POST -H 'Content-Type:application/json'
	// http://localhost:8080/fundo/cadastro/novo
	@RequestMapping(method = RequestMethod.POST, path = "/fundo/cadastro/novo")
	public CadastroFundo create(@RequestBody CadastroFundo cad) {
		System.out.println("criando " + cad);
		fundoRepository.add(cad);
		return cad;
	}

	@RequestMapping("/fundo/cadastro/hint")
	public CadastroFundo hint() {
		Quote quote = this.quoteService.newQuote();
		Long idQuote = quote.getValue().getId();
		String quoteValue = quote.getValue().getQuote();
		CadastroFundo novoCad = new CadastroFundo(idQuote.toString(), quoteValue, idQuote * idQuote);
		return novoCad;
	}
}