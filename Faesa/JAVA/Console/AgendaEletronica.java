 package faesa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class faesa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm");


		String name;
		Integer minutes;

		//Manipula��o com data
		Date dt;
		String dateString;

		BufferedWriter bw;
		String choice;

		File file = new File("C:\Users\mateus.ferreira\Downloads\faesa\teste.txt");

		Scanner s = new Scanner(System.in);
		System.out.print("Voce quer gravar um novo evento ou listar os eventos? (New/List) ");
		choice = s.nextLine();

		try {
			if (choice.equals("New")) {

				if (!file.exists()) {
					FileWriter fw = new FileWriter(file);
					bw = new BufferedWriter(fw);
				}
				else {
					FileWriter fw = new FileWriter(file, true);
					bw = new BufferedWriter(fw);
				}


				System.out.print("Digite o nome do evento: ");
				name = s.nextLine();

				System.out.print("Digite a data do evento (ex.: 21/04/2022 13:30): ");
				dateString = s.nextLine();
				dt = dtf.parse(dateString);

				System.out.print("Digite o tempo de dura��o do evento (Em minutos): ");
				minutes = s.nextInt();

				bw.write(name + ";" + dtf.format(dt) + ";" + minutes + "\n");

				bw.close();
			}

			else if (choice.equals("List")) {

				if (!file.exists()) {
					throw new NullPointerException();
				}
	
				BufferedReader br = new BufferedReader(new FileReader(file));
				String linha = br.readLine();

				while (linha != null) {
					String[] dados = linha.split(";");
					String nome = dados[0];
					String data = dados[1];
					String minutos = dados[2];

					System.out.println("T�tulo: " + nome);
					System.out.println("Data de In�cio: " + data);
					System.out.println("Dura��o: " + minutos);
					System.out.println();

					linha = br.readLine();
				}
             }
		 }
		
		catch (Exception e){
			System.out.println(e.getMessage() + ": escolha inv�lida.");
		}

		finally{
			System.out.println("Programa encerrado.");
			s.nextLine();
		}

	}
}
