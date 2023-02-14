package n1exercici1;

public class InstrumentsPercussio extends Instrument {
	
	public InstrumentsPercussio (String nom, double preu) {
		super (nom, preu);
	}
	{ 
		tocar();
	}
	static {
		System.out.println("Sóc un bloc estàtic");
	}
	@Override
	public void tocar () {
		System.out.println("Està sonant un instrument de percussió");
	}
	public static void tocarDo () {
		System.out.println("Estic tocant la nota Do");
	}

}
