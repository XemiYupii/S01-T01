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
	public static void tocarDo () {
		System.out.println("Estic tocant la nota Do");
	}
	
}
