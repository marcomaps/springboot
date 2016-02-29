package hello;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class FundoRepository {

	private static Map<String, CadastroFundo> fundos = new HashMap<String, CadastroFundo>();

	public FundoRepository() {
		add(new CadastroFundo("1", "FUNDO 1", 1.11d));
		add(new CadastroFundo("2", "FUNDO 2", 2.22d));
		add(new CadastroFundo("3", "FUNDO 3", 3.33d));
		add(new CadastroFundo("4", "FUNDO 4", 4.44d));
		add(new CadastroFundo("5", "FUNDO 5", 5.55d));
	}

	public CadastroFundo add(CadastroFundo cad) {
		fundos.put(cad.getCnpj(), cad);
		return cad;
	}

	public Collection<CadastroFundo> findAll() {
		return fundos.values();
	}

	public CadastroFundo find(String cnpj) {
		return fundos.get(cnpj);
	}
}
