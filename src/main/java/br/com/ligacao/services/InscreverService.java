package br.com.ligacao.services;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import br.com.ligacao.client.forms.FormulariosSolicitacao;
import br.com.ligacao.persistence.model.Acao;
import br.com.ligacao.persistence.model.Voluntario;
import br.com.ligacao.persistence.model.VoluntarioDAO;

public class InscreverService {

	/**
	 * Voluntário a ser inscrito em ação.
	 */
	private static Voluntario voluntario = new Voluntario();
	/**
     * Scanner para entrada de dados pelo usuario.
     */
	private static Scanner scanner;
	
	public static void inscreverEmAcao(Acao acao) throws IOException, InterruptedException, ExecutionException {
		voluntario = login();

		if (voluntario == null) {
			System.out.println("\nUsuário não encontrado ou Usuario/Senha incorreto.\n");
			return;
		} else {
			VoluntarioDAO.cadastraVoluntarioEmAcao(acao.getNomePromotor(), acao.getNomeAcao(), voluntario);
			System.out.println("\n ---- Inscrição em Ação Finalizada ---- \n");
		}
	}

	/**
	 * Realiza login de um voluntário.
	 * @return Voluntário caso exista e null caso não exista.
	 */
	static Voluntario login() {
		StringBuilder sb = new StringBuilder();
		scanner = new Scanner(System.in);

		sb.append("\n ---- Acesso ao Sistema ---- \n");
		sb.append("Informe o nome de usuário: \n");
		System.out.println(sb.toString());

		String user = scanner.nextLine();

		sb = new StringBuilder();
		sb.append("\n ---- Acesso ao Sistema ---- \n");
		sb.append("Informe a senha: \n");
		System.out.println(sb.toString());

		String password = scanner.nextLine();

		return VoluntarioDAO.loginVoluntario(user, password);
	}
}
