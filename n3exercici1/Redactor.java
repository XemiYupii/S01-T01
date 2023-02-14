package n3exercici1;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.IntStream;

public class Redactor {
	
	private String nom;
	private final String dni;
	private static int sou = 1500;
	private ArrayList <Noticia> noticies;
	
	public Redactor (String nom, String dni) {
		this.nom = nom;
		this.dni = dni;
		noticies = new ArrayList<>();
	}
	public String getNom() {
		return nom;
	}
	public String getDni() {
		return dni;
	}
	public ArrayList<Noticia> getNoticies(){
		return noticies;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Redactor))
			return false;
		Redactor other = (Redactor) obj;
		return Objects.equals(dni, other.dni);
	}
	public int buscarNoticia (String titular) {
		return IntStream.range(0, getNoticies().size()).filter(i -> getNoticies().get(i).getTitular().equalsIgnoreCase(titular)).findAny().orElse(-1);
	}
	public void introduirNoticia (Noticia noticia) {
		noticies.add(noticia);
	}
	public void eliminarNoticia (int posicio) {
		noticies.remove(posicio);
	}
	
	
	

}
