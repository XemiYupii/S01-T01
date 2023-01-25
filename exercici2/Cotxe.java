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
	
	/*L'atribut static final MARCA l'hem d'inicialitzar en el moment que el declarem, el propi IDE ja ens ho fa saber, al ser estàtic és un atribut de la classe i és una constant, amb lo kual
	 no podem fer un setter per modificar-lo.
	 L'atribut static model, també fa referència a la classe, el podriem inicialitzar en el constructor, però cada vegda k instanciessim un nou objcte amb akst atribut canviarem el model
	 dels altres objectes anteriors creats. Crec k el més lògic seria instanciar-lo en el moment k el declarem.
	 L'atribut potencia el podem instanciar en el constructor, al ser una constant tampoc es podrà modificar ni crear un setter.
	 El metode frenar al ser estàtic és un metode de la classe per tant per invocar-lo fem servir el nom de la classe . i el nom del metode. No fa falta instanciar cap objecte.
	 El metode accelerar és un metode del propi objecte per tant per invocar-lo abans hem de crear akst objecte.
	 */
	

	

	
	

}
