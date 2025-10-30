package utiles;

public class Utiles {
	
	public static boolean active=true;
	
	public  static int dameNumero(int limite) {
		return (int) (Math.random() * (limite));
	}

	
	public static int[] damePosicionAlrededor(int lugar) {
		int[][] posicion = { { -1, -1 }, { -1, 0 }, { -1, +1 },
				{ 0, -1 }, { 0, +1 }, { +1, -1 }, { +1, 0 },
				{ +1, +1 } };
		return posicion[lugar];
	}
	
	public static void printLog(String message) {
		if(active) System.out.println(message);
	}
	
	public static void printLog() {
		if(active) System.out.println();
	}


	public static void printLogN(String message) {
		if(active) System.out.print(message);
		
	}
	
	
	
	
	
	
	
	
	
}
