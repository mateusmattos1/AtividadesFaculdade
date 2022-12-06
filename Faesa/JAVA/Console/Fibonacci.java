package faesa;

import java.util.ArrayList;

public class faesa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> lista = new ArrayList<>();
		lista.add(0); lista.add(1);
		
		for (int i = 0; i < 50; i++) {
			if (i >= 2) {
				int x = lista.get(i-1);
				int y = lista.get(i-2);
				int soma = x+y;
				lista.add(soma);
			}
		}
		
		for (int i : lista) {
			System.out.println(i);
		}
		
	}
}

