package interfaz;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextField;
import juego.Estado;
import juego.Juego;

public class ManejoDatos {
	private Juego juego;
	private int numIntento;
	private boolean gano;
	private boolean perdio;

	public ManejoDatos() {
		juego = new Juego();
	}
	
	public void reiniciarJuego() {
		numIntento = 0;
		gano = false;
		perdio = false;
	}

	public void adivinar(JTextField entradaUsuario, JLabel[][] intentos, KeyEvent e) {
		System.out.println(juego.getPalabraSecreta());
		if(e.getKeyCode() == KeyEvent.VK_ENTER && entradaUsuario.getText().length() == intentos[numIntento].length) {
			List<Estado> resultados = juego.compararPalabra(entradaUsuario.getText());
			gano = true;
			for(int j = 0; j < intentos[numIntento].length; j++) {
				intentos[numIntento][j].setText(""+entradaUsuario.getText().charAt(j));
				cambiarColor(intentos[numIntento][j], resultados.get(j));
				gano &= resultados.get(j) == Estado.CORRECTA;
			}
			//Por alguna razon funciona
			if(numIntento < intentos.length-1)
				numIntento++;
			else if(numIntento == intentos.length-1 && !gano)
				perdio = true;
		}

	}
	
//	public void adivinar(JTextField entradaUsuario, JLabel[][] intentos) {
//		System.out.println(juego.getPalabraSecreta());
//		entradaUsuario.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if(e.getKeyCode() == KeyEvent.VK_ENTER && entradaUsuario.getText().length() == intentos[numIntento].length) {
//					List<Estado> resultados = juego.compararPalabra(entradaUsuario.getText());
//					gano = true;
//					for(int j = 0; j < intentos[numIntento].length; j++) {
//						intentos[numIntento][j].setText(""+entradaUsuario.getText().charAt(j));
//						cambiarColor(intentos[numIntento][j], resultados.get(j));
//						gano &= resultados.get(j) == Estado.CORRECTA;
//					}
//					//Por alguna razon funciona
//					if(numIntento < intentos.length-1)
//						numIntento++;
//					else if(numIntento == intentos.length-1 && !gano)
//						perdio = true;
//				}
//			}
//		});
//	}
	
	public boolean isGano() {
		return gano;
	}
	
	public void setGano(boolean gano) {
		this.gano = gano;
	}
	
	public boolean isperdio() {
		return perdio;
	}
	
	public void setPerdio(boolean perdio) {
		this.perdio = perdio;
	}
	
	public void cambiarIdioma(String idioma) {
		juego.cambiarIdioma(idioma);
		System.out.println(juego.getPalabraSecreta());
	}
	
	private void cambiarColor(JLabel casilla, Estado estado) {
		Color color = null;
		if(estado == Estado.CORRECTA)
			color = Color.GREEN;
		if(estado == Estado.INCORRECTA)
			color = Color.BLACK;
		if(estado == Estado.EN_OTRA_POSICION)
			color = Color.YELLOW;
		casilla.setBackground(color);
	}
}