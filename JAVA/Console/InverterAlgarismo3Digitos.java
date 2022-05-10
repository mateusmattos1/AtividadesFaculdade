package faesa;

import java.util.*;

public class faesa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Scanner s = new Scanner(System.in)) {
			System.out.println("Digite um n�mero com 3 caracteres: ");
			
			Integer next = s.nextInt();
			String num = next.toString();
			String aux = "";
			
			for (int i = 2; i >= 0; i--) {
				aux += num.charAt(i);
			}
			
			System.out.println(aux);
		}
	}

}
