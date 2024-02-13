package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;
import controlador.Coordinador;
import grafos.Grafo;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;


public class Interfaz extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel panelMapa;
	private JMapViewer mapa;
	private JPanel panelIzquierdo;
	private JButton botonCluster;
	private List<MapPolygonImpl> poligonos;
	private JPanel panelOpciones;
	private int cantClusters;
	private Coordinador miCoordinador;

	public Interfaz() {
		poligonos = new ArrayList<>();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1125, 714);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
				
		panelIzquierdo = new JPanel();
		panelIzquierdo.setBackground(new Color(17, 17, 17));
		panelIzquierdo.setLayout(null);
		
		panelMapa = new JPanel();
		panelMapa.setLayout(new BoxLayout(panelMapa, BoxLayout.X_AXIS));
		
		mapa = new JMapViewer();
		mapa.setDisplayPosition(new Coordinate(-34.521, -58.7008), 15);
		
				
		botonCluster = new JButton("Clustering");
		botonCluster.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botonCluster.setBounds(197, 217, 212, 67);
		
		frame.getContentPane().add(panelIzquierdo);
		
		panelOpciones = new JPanel();
		panelOpciones.setBackground(new Color(0, 0, 0));
		panelOpciones.setBounds(0, 0, 554, 675);
		panelIzquierdo.add(panelOpciones);
		frame.getContentPane().add(panelMapa);
		panelMapa.add(mapa);
		panelOpciones.setLayout(null);
		panelOpciones.add(botonCluster);
		
		detectarCoordenadas();
		
		botonCluster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean valorValido = false;
				while(!valorValido)
					try {
						cantClusters = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de clusters"));
						valorValido = true;
					}catch (Exception exc) {
						JOptionPane.showMessageDialog(null, "No es un valor válido");
					}
				mostrarClustering();
			}
		});
	}

	private void mostrarClustering() {
		try {
			Grafo g = miCoordinador.crearCluster(cantClusters);
			eliminarPoligonos();
			poligonos = new ArrayList<>();
			for(int i = 0; i < g.tamano()-1; i++)
				for(int j = i+1; j < g.tamano(); j++) {
					if(g.existeArista(i, j)) {
						poligonos.add(new MapPolygonImpl(miCoordinador.getCoordenada(i),
								miCoordinador.getCoordenada(i), miCoordinador.getCoordenada(j)));
					}
				}

			agregarPoligonos();
		}catch(IllegalArgumentException iEx){
			JOptionPane.showMessageDialog(null, iEx.getMessage());
			System.out.println(iEx.getMessage());
		}
	}
	
	private void mostrarAgm() {
		eliminarPoligonos();
		poligonos = new ArrayList<>();
		Grafo gAgm = miCoordinador.getAgm();
		for(int i = 0; i < gAgm.tamano()-1; i++)
			for(int j = i+1; j < gAgm.tamano(); j++) {
				if(gAgm.existeArista(i, j)) { 
					poligonos.add(new MapPolygonImpl(miCoordinador.getCoordenada(i),
							miCoordinador.getCoordenada(i), miCoordinador.getCoordenada(j)));
				}
			}
		
		agregarPoligonos();
	}

	private void agregarPoligonos() {
		for(MapPolygonImpl poligono : poligonos)
			mapa.addMapPolygon(poligono);
	}
	
	private void eliminarPoligonos() {
		for(MapPolygonImpl p : poligonos) {
			mapa.removeMapPolygon(p);
		}
	}


//	private void agregarMarcadores() {
//		coordenadas = LectorCoordenadas.getCoordenadas("instancia1.txt");
//		for(Coordinate c : coordenadas)
//			mapa.addMapMarker(new MapMarkerDot(c));
//	}

	private void detectarCoordenadas() {
		mapa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1){

					Coordinate markeradd = (Coordinate) mapa.getPosition(e.getPoint());
					
					miCoordinador.agregarCoordenadas(markeradd);

					mapa.addMapMarker(new MapMarkerDot(markeradd));

				}
				if(miCoordinador.getTamanioCoordenadas() >= 2) {
					mostrarAgm();
				}
			}
		});

	}
	
	public void setVisible(boolean b) {
		frame.setVisible(true);
	}

	public void setCoordinador(Coordinador miCoordinador2) {
		this.miCoordinador= miCoordinador2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
