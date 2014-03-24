package apuestas;

public class principal {

	public static void main(String[] args) {

		liga Liga = new liga();
		VentanaLiga frame = new VentanaLiga(Liga);
		frame.setVisible(true);

	}
}