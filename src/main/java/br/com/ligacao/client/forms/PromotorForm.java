package br.com.ligacao.client.forms;

import br.com.ligacao.persistence.model.Promotor;

public class PromotorForm {

	public static Promotor preencherForm() {
		Promotor promotor = new Promotor("Jo�ozinho do Tren�", "A��es Et�licas", "700.000.231-00", "02-02-2002",
				"Teste de Descri��o Geral", "trenotunado@email.com", "imagem1.jpg", "instagram.com/meprocuraqueacha",
				"6299999999");
		return promotor;
	}

	public static Promotor preencherFormAlterado(String cpf) {
		Promotor promotor = new Promotor("Jo�ozinho do Tren� com N�", "A��es Et�licas", cpf, "02-02-2002",
				"Teste de Descri��o Geral", "trenotunado@email.com", "imagem1.jpg", "instagram.com/meprocuraqueacha",
				"6299999999");
		return promotor;
	}
}
