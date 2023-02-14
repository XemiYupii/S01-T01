package n3exercici1;

public class Futbol extends Noticia{
	
	private String competicio;
	private String club;
	private String jugador;
	
	public Futbol(String titular, String competicio, String club, String jugador) {
		super(titular);
		this.competicio = competicio;
		this.club = club;
		this.jugador = jugador;
	}

	@Override
	public int calcularPreuNoticia() {
		int preuInicial = 300;
		int preuFinal = 0;
		
		preuFinal += this.competicio.equalsIgnoreCase("Lliga de campions") ? 100 : 0;
		preuFinal += this.club.equalsIgnoreCase("Barça") || this.club.equalsIgnoreCase("Madrid") ? 100 : 0;
		preuFinal += this.jugador.equalsIgnoreCase("Ferran Torres") || this.jugador.equalsIgnoreCase("Benzema") ? 50 : 0;
		this.preu = preuInicial + preuFinal;
		return preuInicial + preuFinal;
	}
	@Override
	public int calcularPuntuacioNoticia() {
		int puntuacioInicial = 5;
		int puntuacioFinal = 0;
		
		puntuacioFinal += this.competicio.equalsIgnoreCase("Lliga de campions") ? 3 : (this.competicio.equalsIgnoreCase("Lliga") ? 2 : 0);
		puntuacioFinal += this.club.equalsIgnoreCase("Barça") || this.club.equalsIgnoreCase("Madrid") ? 1 : 0;
		puntuacioFinal += this.jugador.equalsIgnoreCase("Ferran Torres") || this.jugador.equalsIgnoreCase("Benzema") ? 1 : 0;
		this.puntuacio = puntuacioInicial + puntuacioFinal;
		return puntuacioInicial + puntuacioFinal;
	}
	@Override
	public String toString() {
		return super.toString()+", "+competicio+", "+club+", "+jugador;
	}
	

}
