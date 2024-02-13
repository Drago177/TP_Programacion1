package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Interfaz {

	private JFrame frame;
	private JLabel lblCantidadDeSimulaciones;
	private JLabel lblCantidadDeUsuarios;
	private JLabel lblCantidadDeFiguritas;
	private JLabel lblTamaoDePaquete;
	private JPanel panel_simulacion;
	private JButton boton_unUsuario;
	private JButton boton_intercambio;
	private JButton boton_donacion;
	private JTextField textArea_simulaciones;
	private JTextField textArea_usuarios;
	private JTextField textArea_figuritas;
	private JTextField textArea_paquetes;
	private DatosDeEntrada datosEntrada;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 689, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		panel_simulacion = new JPanel();
		panel_simulacion.setBackground(Color.LIGHT_GRAY);
		panel_simulacion.setBounds(0, 0, 673, 466);
		frame.getContentPane().add(panel_simulacion);
		panel_simulacion.setLayout(null);
		
		boton_unUsuario = new JButton("Simular único usuario");
		boton_unUsuario.setBounds(77, 290, 168, 39);
		panel_simulacion.add(boton_unUsuario);
		
		boton_intercambio = new JButton("Simular con intercambio");
		boton_intercambio.setBounds(433, 290, 167, 39);
		panel_simulacion.add(boton_intercambio);
		
		boton_donacion = new JButton("Simular con donación");
		boton_donacion.setBounds(255, 290, 168, 39);
		panel_simulacion.add(boton_donacion);
		
		lblCantidadDeSimulaciones = new JLabel();
		lblCantidadDeSimulaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCantidadDeSimulaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadDeSimulaciones.setText("Cantidad de simulaciones");
		lblCantidadDeSimulaciones.setBounds(170, 77, 159, 29);
		panel_simulacion.add(lblCantidadDeSimulaciones);
		
		lblCantidadDeUsuarios = new JLabel();
		lblCantidadDeUsuarios.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCantidadDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadDeUsuarios.setText("Cantidad de usuarios");
		lblCantidadDeUsuarios.setBounds(171, 117, 158, 29);
		panel_simulacion.add(lblCantidadDeUsuarios);
		
		lblCantidadDeFiguritas = new JLabel();
		lblCantidadDeFiguritas.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCantidadDeFiguritas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadDeFiguritas.setText("Cantidad de figuritas");
		lblCantidadDeFiguritas.setBounds(171, 157, 158, 29);
		panel_simulacion.add(lblCantidadDeFiguritas);
		
		lblTamaoDePaquete = new JLabel();
		lblTamaoDePaquete.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblTamaoDePaquete.setHorizontalAlignment(SwingConstants.CENTER);
		lblTamaoDePaquete.setText("Tamaño de paquete");
		lblTamaoDePaquete.setBounds(171, 197, 158, 29);
		panel_simulacion.add(lblTamaoDePaquete);
		
		textArea_simulaciones = new JTextField();
		textArea_simulaciones.setBounds(339, 79, 127, 22);
		panel_simulacion.add(textArea_simulaciones);
		
		textArea_usuarios = new JTextField();
		textArea_usuarios.setBounds(339, 119, 127, 22);
		panel_simulacion.add(textArea_usuarios);
		
		textArea_figuritas = new JTextField();
		textArea_figuritas.setBounds(339, 159, 127, 22);
		panel_simulacion.add(textArea_figuritas);
		
		textArea_paquetes = new JTextField();
		textArea_paquetes.setBounds(339, 199, 127, 22);
		panel_simulacion.add(textArea_paquetes);
		
		limiteLetras(textArea_figuritas);
		limiteLetras(textArea_paquetes);
		limiteLetras(textArea_simulaciones);
		limiteLetras(textArea_usuarios);
		
		boton_unUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datosEntrada = new DatosDeEntrada(Integer.parseInt(textArea_figuritas.getText()),
						Integer.parseInt(textArea_paquetes.getText()),
						Integer.parseInt(textArea_simulaciones.getText()),
						1,
						false);
				try {
					JOptionPane.showMessageDialog(null, "Promedio de todas las simulaciones: $" + ""+datosEntrada.simular());
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		boton_intercambio.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			datosEntrada = new DatosDeEntrada(Integer.parseInt(textArea_figuritas.getText()),
					Integer.parseInt(textArea_paquetes.getText()),
					Integer.parseInt(textArea_simulaciones.getText()),
					Integer.parseInt(textArea_usuarios.getText()),
					true);
			try {
				JOptionPane.showMessageDialog(null, "Promedio de todas las simulaciones: $" + ""+datosEntrada.simular());
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		});

		boton_donacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datosEntrada = new DatosDeEntrada(Integer.parseInt(textArea_figuritas.getText()),
						Integer.parseInt(textArea_paquetes.getText()),
						Integer.parseInt(textArea_simulaciones.getText()),
						Integer.parseInt(textArea_usuarios.getText()),
						false);
				try {
					JOptionPane.showMessageDialog(null, "Promedio de todas las simulaciones: $" + ""+datosEntrada.simular());
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}

		});
		
	}

	private void limiteLetras(JTextField entrada) {
		entrada.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if(!(caracter >= 48 && caracter <= 57))
					e.consume();
			}         
		});
	}
}
