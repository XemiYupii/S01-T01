package n3exercici1;

public class Basquet extends Noticia{
	
	private String competicio;
	private String club;
	
	public Basquet(String titular, String competicio, String club) {
		super(titular);
		this.competicio = competicio;
		this.club = club;
	}

	@Override
	public int calcularPreuNoticia() {
		int preuInicial = 250;
		int preuFinal = 0;
		
		preuFinal += this.competicio.equalsIgnoreCase("Eurolliga") ? 75 : 0;
		preuFinal += this.club.equalsIgnoreCase("Barça") || this.club.equalsIgnoreCase("Madrid") ? 75 : 0;
		this.preu = preuInicial + preuFinal;
		return preuInicial + preuFinal;
	}
	@Override
	public int calcularPuntuacioNoticia() {
		int puntuacioInicial = 4;
		int puntuacioFinal = 0;
		
		puntuacioFinal += this.competicio.equalsIgnoreCase("Eurolliga") ? 3 : (this.competicio.equalsIgnoreCase("ACB") ? 2 : 0);
		puntuacioFinal += this.club.equalsIgnoreCase("Barça") || this.club.equalsIgnoreCase("Madrid") ? 1 : 0;
		this.puntuacio = puntuacioInicial + puntuacioFinal;
		return puntuacioInicial + puntuacioFinal;
	}
	@Override
	public String toString() {
		return super.toString()+", "+competicio+", "+club;
	}
	

}
