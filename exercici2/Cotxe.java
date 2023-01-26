package exercici2;

public class Cotxe {
	
	private static final String MARCA = "Renault";
	//private static final String MARCA;
	private static String model = "Clio";
	private final int POTENCIA;
	
	public Cotxe (int potencia) {
		this.POTENCIA = potencia;
	}
	
	public static String getModel() {
		return model;
	}

	public static void setModel(String model) {
		Cotxe.model = model;
	}

	public static String getMarca() {
		return MARCA;
	}

	public int getPOTENCIA() {
		return POTENCIA;
	}
	
	public static void frenar() {
		System.out.println("El vehicle està frenant");
	}
	public void accelerar() {
		System.out.println("El vehicle està accelerant");
	}
	public String toString() {
		return MARCA +", " +model + ", " +POTENCIA;
	}
	
}
