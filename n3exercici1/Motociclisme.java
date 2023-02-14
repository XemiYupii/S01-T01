package n3exercici1;

public class Motociclisme extends Noticia {
	
	private String equip;

	public Motociclisme(String titular, String equip) {
		super(titular);
		this.equip = equip;
	}
	@Override
	public int calcularPreuNoticia() {
		int preuInicial = 100;
		int preuFinal = 0;
		
		preuFinal += this.equip.equalsIgnoreCase("Honda") || this.equip.equalsIgnoreCase("Yamaha") ? 50 : 0;
		this.preu = preuInicial + preuFinal;
		return preuInicial + preuFinal;
	}
	@Override
	public int calcularPuntuacioNoticia() {
		int puntuacioInicial = 3;
		int puntuacioFinal = 0;
		
		puntuacioFinal += this.equip.equalsIgnoreCase("Honda") || this.equip.equalsIgnoreCase("Yamaha") ? 3 : 0;
		this.puntuacio = puntuacioInicial + puntuacioFinal;
		return puntuacioInicial + puntuacioFinal;
	}
	@Override
	public String toString() {
		return super.toString()+", "+equip;
	}

}
