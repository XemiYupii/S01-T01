package exercici2;

public class App {

	public static void main(String[] args) {
		
		Cotxe.frenar();
		Cotxe cotxe = new Cotxe (140);
		Cotxe cotxe2 = new Cotxe (220);
		System.out.println(cotxe);
		System.out.println(cotxe2);
		Cotxe.setModel("Arkana");
		Cotxe cotxe3 = new Cotxe (260);
		System.out.println(cotxe);
		System.out.println(cotxe2);
		System.out.println(cotxe3);
		cotxe.accelerar();

	}

}
