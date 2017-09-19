package lab1;

import java.util.Scanner;

public class MinMax {
	    public static void main(String[] args) {
		 
	      final int NÚMEROS_A_LER = 3;
	      Scanner sc = new Scanner(System.in);
	      int min = Integer.MAX_VALUE;
	      int máx = Integer.MIN_VALUE;
	 
	      for (int i = 0; i < NÚMEROS_A_LER; i++) {
	        int num = recebeProximoInteiro(sc);
	        min = menorNumeroEntre(min, num);
	        máx = maiorNumeroEntre(máx, num);
	      }
	 
	      System.out.println("O menor numero é: " + min);
	      System.out.println("O maior numero é: " + máx);
	   }
	 
	   private static int maiorNumeroEntre(int numero1, int numero2) {
	      return numero2 > numero1? numero2: numero1;
	   }
	 
	   private static int menorNumeroEntre(int numero1, int numero2) {
	      return numero2 < numero1? numero2: numero1;
	   }
	 
	   private static int recebeProximoInteiro(Scanner sc) {
	      System.out.print("Entre com o proximo inteiro:");
	      int num = sc.nextInt();
	      return num;
	   }
	 
	}
