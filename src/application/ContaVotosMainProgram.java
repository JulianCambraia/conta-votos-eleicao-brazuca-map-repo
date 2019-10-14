package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Criar o arquivo votos.csv Alex Blue,15 Maria Green,22 Bob Brown,21 Alex
 * Blue,30 Bob Brown,15 Maria Green,27 Maria Green,22 Bob Brown,25 Alex Blue,31
 * 
 * @author julian
 *
 */
public class ContaVotosMainProgram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> votos = new HashMap<String, Integer>();

		System.out.print("Entre com o nome do arquivo que contém os votos dos candidatos:");
		String path = sc.next();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String linha = br.readLine();
			while (linha != null) {
				String[] campos = linha.split(",");
				String nome = campos[0];
				Integer voto = Integer.parseInt(campos[1]);
				votos.merge(nome, voto, Integer::sum);
				linha = br.readLine();
			}

			for (String nome : votos.keySet()) {
				System.out.println(nome + ":" + votos.get(nome));
			}
		} catch (IOException e) {
			System.err.println("Erro: " + e.getMessage());
		}

		sc.close();
	}
}
