package exercici1;

public class InstrumentsVent extends Instrument {
	
	public InstrumentsVent (String nom, double preu) {
		super (nom, preu);
	}
	{ 
		tocar();
	}
	static {
		System.out.println("Sóc un bloc estàtic");
	}
	public void tocar () {
		System.out.println("Està sonant un instrument de vent");
	}
	public static void repetir () {
		System.out.println("també sóc estàtic");
	}
	
}
//Els bloc de inicialitzacio s'executen cada vegda k s'instancia un objecte, és igual si el poses dins del constructor o fora.
//Els bloc estatics només s'executen una sola vegada, tan si s'instancia l'objecte o es fa referència a la classe.