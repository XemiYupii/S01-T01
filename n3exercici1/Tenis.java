package n3exercici1;

public class Tenis extends Noticia {
	
	private String competicio;
	private String tenistes;

	public Tenis(String titular, String competicio, String tenistes) {
		super(titular);
		this.competicio = competicio;
		this.tenistes = tenistes;
	}
	@Override
	public int calcularPreuNoticia() {
		int preuInicial = 150;
		int preuFinal = 0;
		
		preuFinal += this.tenistes.equalsIgnoreCase("Federer") || this.tenistes.equalsIgnoreCase("Nadal") || this.tenistes.equalsIgnoreCase("Djokovic") ? 100 : 0;
		this.preu = preuInicial + preuFinal;
		return preuInicial + preuFinal;
	}
	@Override
	public int calcularPuntuacioNoticia() {
		int puntuacioInicial = 4;
		int puntuacioFinal = 0;
		
		puntuacioFinal += this.tenistes.equalsIgnoreCase("Federer") || this.tenistes.equalsIgnoreCase("Nadal") || this.tenistes.equalsIgnoreCase("Djokovic") ? 3 : 0;
		this.puntuacio = puntuacioInicial + puntuacioFinal;
		return puntuacioInicial + puntuacioFinal;
	}
	@Override
	public String toString() {
		return super.toString()+", "+competicio+", "+tenistes;
	}
}
