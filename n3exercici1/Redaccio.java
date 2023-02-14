package n3exercici1;

import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class Redaccio {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		Set <Redactor> redactors = new HashSet<>();
		
		menu(redactors);
		
	}
	public static void introduirRedactor (Set <Redactor> redactors ){
		String nom = demanarDada ("Escriu el nom del redactor");
		input.nextLine();
		String dni = demanarDada ("Escriu el DNI");
		Redactor redactor = new Redactor (nom, dni);
		if (redactors.contains(redactor)) {
			System.out.println("Ja existeix un redactor amb DNI "+dni);
		}
		else {
			redactors.add(redactor);
			System.out.println("El redactor amb nom "+nom+" i DNI "+dni+" ha estat introduit.");
		}
	}
	public static void eliminarRedactor (Set <Redactor> redactors) {
		String nom = demanarDada ("Escriu el nom del redactor");
		input.nextLine();
		String dni = demanarDada ("Escriu el DNI");
		Optional <Redactor>redactorOp = buscarRedactor(nom, dni, redactors);
		if (redactorOp.isPresent()) {
			redactors.remove(redactorOp.get());
			System.out.println("El redactor amb nom "+nom+" i DNI "+dni+" ha estat eliminat.");
		}
		else System.out.println("El redactor amb nom "+nom+" i DNI "+dni+" no existeix.");
	}
	public static void introduirNoticiaRedactor (Set<Redactor> redactors) {
		String nom = demanarDada ("Escriu el nom del redactor");
		input.nextLine();
		String dni = demanarDada ("Escriu el DNI");
		Optional <Redactor>redactorOp = buscarRedactor(nom, dni, redactors);
		if (redactorOp.isPresent()) {
			String titular = demanarDada ("Escriu el titular de la notícia");
			int opcio = escollirEsportNoticia();
			switch (opcio) {
				case 1:
					String competicio = demanarDada ("A quina competició fa referència?");
					input.nextLine();
					String club = demanarDada ("Sobre quin club?");
					String jugador = demanarDada ("Sobre quin jugador?");
					redactorOp.get().introduirNoticia(new Futbol(titular, competicio, club, jugador));
					System.out.println("Notícia introduida.");
					break;
				case 2:
					competicio = demanarDada ("A quina competició fa referència?");
					input.nextLine();
					club = demanarDada ("Sobre quin club?");
					redactorOp.get().introduirNoticia(new Basquet(titular, competicio, club));
					System.out.println("Notícia introduida.");
					break;
				case 3:
					competicio = demanarDada ("A quina competició fa referència?");
					input.nextLine();
					String tenista = demanarDada ("Sobre quin tenista?");
					redactorOp.get().introduirNoticia(new Tenis(titular, competicio, tenista));
					System.out.println("Notícia introduida.");
					break;
				case 4:
					String escuderia = demanarDada ("A quina escuderia fa referència?");
					input.nextLine();
					redactorOp.get().introduirNoticia(new F1(titular, escuderia));
					System.out.println("Notícia introduida.");
					break;
				case 5:
					String equip = demanarDada ("A quin equip fa referència?");
					input.nextLine();
					redactorOp.get().introduirNoticia(new Motociclisme(titular, equip));
					System.out.println("Notícia introduida.");
					break;
					default:
			}
		}
		else System.out.println("El redactor amb nom "+nom+" i DNI "+dni+" no existeix.");
	}
	public static void eliminarNoticia (Set <Redactor>redactors) {
		String nom = demanarDada ("Escriu el nom del redactor");
		String dni = demanarDada ("Escriu el DNI");
		Optional <Redactor>redactorOp = buscarRedactor(nom, dni, redactors);
		if (redactorOp.isPresent()) {
			String titular = demanarDada ("Escriu el titular de la notícia");
			int index = redactorOp.get().buscarNoticia(titular);
			if (index != -1) {
				redactorOp.get().eliminarNoticia(index);
				System.out.println("La notícia amb titular "+titular+" ha estat eliminada.");
			}
			else System.out.println("La notícia amb titular "+titular+" no existeix");
		}
		else System.out.println("El redactor amb nom "+nom+" i DNI "+dni+" no existeix.");
	}
	public static void mostrarNoticiesRedactor (Set<Redactor> redactors) {
		redactors.stream().forEach(redactor -> redactor.getNoticies().forEach(System.out::println));
	}
	public static void calcularPuntuacioNoticia (Set <Redactor>redactors) {
		String titular = demanarDada ("Escriu el titular de la notícia");
		input.nextLine();
		Optional <Noticia> noticiaOp = buscarNoticiaRedaccio(titular,redactors);
		Optional<Integer>puntuacio = null;
		if (noticiaOp.isPresent()) {
			puntuacio = noticiaOp.map(noticia -> noticia.calcularPuntuacioNoticia());
			System.out.println("La puntuació és de "+puntuacio.get()+" punts");
		}
		else System.out.println("El titular "+titular+" no correspon a cap notícia");
	}
	public static void calcularPreuNoticia (Set<Redactor>redactors) {
		String titular = demanarDada ("Escriu el titular de la notícia");
		input.nextLine();
		Optional <Noticia> noticiaOp = buscarNoticiaRedaccio(titular,redactors);
		Optional<Integer> preu = null;
		if (noticiaOp.isPresent()) {
			preu = noticiaOp.map(noticia -> noticia.calcularPreuNoticia());
			System.out.println("El preu és de "+preu.get()+" euros");
		}
		else System.out.println("El titular "+titular+" no correspon a cap notícia");
	}
	public static Optional <Redactor> buscarRedactor (String nom, String dni, Set <Redactor> redactors) {
		return redactors.stream().filter(redactor -> redactor.getNom().equalsIgnoreCase(nom) && redactor.getDni().equalsIgnoreCase(dni)).findFirst();
	}
	public static Optional <Noticia> buscarNoticiaRedaccio (String titular, Set<Redactor>redactors) {
		return redactors.stream().flatMap(redactor -> redactor.getNoticies().stream().filter(noticia -> noticia.getTitular().equalsIgnoreCase(titular))).findFirst();
	}
	public static int escollirEsportNoticia() {
		int opcio = demanarOpcio ("A quin esport fa referència la notícia? \n"
				+ "1. Futbol \n"
				+ "2. Bàsquet \n"
				+ "3. Tenis \n"
				+ "4. F1 \n"
				+ "5. Motociclisme");
		while (opcio <= 0 || opcio > 5) {
			System.out.println("ERROR, tria una altra opció."); 
			opcio = input.nextInt();
		}
		return opcio;
	}
	public static void menu (Set<Redactor>redactors) {
		int opcio = 0;
		do {
			opcio = demanarOpcio("Escull una de les següents opcions: \n"
	            + "1.- Introduir redactor.\n"
	            + "2.- Eliminar redactor.\n"
	            + "3.- Introduir notícia a un redactor.\n"
	            + "4.- Eliminar notícia.\n"
	            + "5.- Mostrar totes les notícies per redactor.\n"
	            + "6.- Calcular puntuació de la notícia.\n"
	            + "7.- Calcular preu-notícia.\n"
	            + "8.- Sortir");
	        
	        if (opcio < 1 || opcio > 8) {
	            System.out.println("ERROR, escull una altra opcio");
	        } else {
	            switch (opcio) {
	                case 1:
	                    introduirRedactor(redactors);
	                    break;
	                case 2:
	                    eliminarRedactor(redactors);
	                    break;
	                case 3:
	                    introduirNoticiaRedactor(redactors);
	                    break;
	                case 4:
	                    eliminarNoticia(redactors);
	                    break;
	                case 5:
	                    mostrarNoticiesRedactor(redactors);
	                    break;
	                case 6:
	                    calcularPuntuacioNoticia(redactors);
	                    break;
	                case 7:
	                    calcularPreuNoticia(redactors);
	                    break;
	                case 8:
	                    System.out.println("Gràcies per utilitzar la nostra APP");
	                    break;
	                    default:
	            }
	        }
	    } while (opcio != 8);
	}
	public static String demanarDada (String missatge) {
		System.out.println(missatge);
		String dada = input.nextLine();
		return dada;
	}
	public static int demanarOpcio (String missatge) {
		System.out.println(missatge);
		int opcio = input.nextInt();
		return opcio;
	}
}
