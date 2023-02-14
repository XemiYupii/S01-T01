package n3exercici1;

public abstract class Noticia {
	
	protected String titular;
	protected String text;
	protected int puntuacio;
	protected int preu;
	
	public Noticia (String titular) {
		this.titular = titular;
		text = "";
		this.puntuacio = 0;
		this.preu = 0;
	}
	public String getTitular() {
		return titular;
	}
	
	public abstract int calcularPreuNoticia();
	public abstract int calcularPuntuacioNoticia();
	@Override
	public String toString() {
		return titular+": "+puntuacio+" punts, "+preu+" euros";
	}
	
	

}
