package n3exercici1;

public class F1 extends Noticia {
	
	private String escuderia;
	
	public F1(String titular, String escuderia) {
		super(titular);
		this.escuderia = escuderia;
	}
	@Override
	public int calcularPreuNoticia() {
		int preuInicial = 100;
		int preuFinal = 0;
		
		preuFinal += this.escuderia.equalsIgnoreCase("Ferrari") || this.escuderia.equalsIgnoreCase("Mercedes") ? 50 : 0;
		this.preu = preuInicial + preuFinal;
		return preuInicial + preuFinal;
	}
	@Override
	public int calcularPuntuacioNoticia() {
		int puntuacioInicial = 4;
		int puntuacioFinal = 0;
		
		puntuacioFinal += this.escuderia.equalsIgnoreCase("Ferrari") || this.escuderia.equalsIgnoreCase("Mercedes") ? 2 : 0;
		this.puntuacio = puntuacioInicial + puntuacioFinal;
		return puntuacioInicial + puntuacioFinal;
	}
	@Override
	public String toString() {
		return super.toString()+", "+escuderia;
	}

}
