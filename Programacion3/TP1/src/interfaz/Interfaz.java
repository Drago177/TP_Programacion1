package interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class Interfaz {
	private JFrame frame;
	private JLabel nombre;
	private JPanel menu;
	private JButton botonMenu;
	private JButton botonNormal;
	private JButton botonDificil;
	private JButton botonIdioma;
	private JButton botonReglas;
	private JPanel panelNormal;
	private JPanel panelDificil;
	private JPanel panelIdioma;
	private JLabel[][] intentos;
	private JLabel[][] intentosDificil;
	private JTextField entrada;
	private JTextField entradaDificil;
	private ManejoDatos manejoDatos;
	private ManejoDatos manejoDatosDificil;
	private JCheckBox checkIngles;
	private JCheckBox checkEspaniol;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel labelGanar;
	private JLabel labelPerder;
	private JLabel labelNoExiste;
	private int numIntento;
	private JPanel panelReglas;
	private JLabel labelReglas;
	
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
		manejoDatos = new ManejoDatos();
		manejoDatosDificil = new ManejoDatos();
		intentos = new JLabel[6][5];
		intentosDificil = new JLabel[5][5];
		numIntento = 0;
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 890, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(540, 649);
		
		nombre = new JLabel("W-UNGS-dle");
		nombre.setHorizontalTextPosition(SwingConstants.CENTER);
		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		nombre.setForeground(Color.ORANGE);
		nombre.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 25));
		nombre.setBounds(157, 5, 198, 45);
		
		//Paneles
		menu = new JPanel();
		menu.setBackground(Color.BLACK);
		menu.setForeground(Color.BLACK);
		menu.setBounds(-3, 0, 527, 610);
		menu.setLayout(null);

		panelNormal = new JPanel();
		panelNormal.setBounds(-3, 0, 527, 610);
		panelNormal.setVisible(false);
		panelNormal.setBackground(Color.BLACK);
		panelNormal.setLayout(null);
		panelNormal.setVisible(false);
		
		panelDificil = new JPanel();
		panelDificil.setBackground(Color.BLACK);
		panelDificil.setVisible(false);
		panelDificil.setBounds(-3, 0, 527, 610);
		panelDificil.setLayout(null);
		
		panelIdioma = new JPanel();
		panelIdioma.setVisible(false);
		panelIdioma.setBackground(Color.BLACK);
		panelIdioma.setBounds(-3, 0, 527, 610);
		panelIdioma.setLayout(null);
		
		panelReglas = new JPanel();
        panelReglas.setVisible(false);
        panelReglas.setBackground(Color.BLACK);
        panelReglas.setBounds(-3, 0, 527, 610);
        panelReglas.setLayout(null);
		
		labelPerder = new JLabel("Perdiste!");
		labelPerder.setBorder(new LineBorder(Color.LIGHT_GRAY));
		labelPerder.setBackground(Color.BLACK);
		labelPerder.setOpaque(true);
		labelPerder.setVisible(false);
		labelPerder.setBounds(46, 150, 432, 176);
		labelPerder.setHorizontalAlignment(SwingConstants.CENTER);
		labelPerder.setForeground(Color.RED);
		labelPerder.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 60));
		
		labelGanar = new JLabel("Ganaste!");
		labelGanar.setBorder(new LineBorder(Color.LIGHT_GRAY));
		labelGanar.setBackground(Color.BLACK);
		labelGanar.setOpaque(true);
		labelGanar.setVisible(false);
		labelGanar.setBounds(46, 150, 432, 176);
		labelGanar.setHorizontalAlignment(SwingConstants.CENTER);
		labelGanar.setForeground(Color.GREEN);
		labelGanar.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 60));
		
		labelNoExiste = new JLabel("");
		labelNoExiste.setForeground(Color.WHITE);
		labelNoExiste.setHorizontalAlignment(SwingConstants.CENTER);
		labelNoExiste.setFont(new Font("Arial", Font.BOLD, 20));
		labelNoExiste.setBorder(new LineBorder(Color.YELLOW));
		labelNoExiste.setBackground(Color.BLACK);
		labelNoExiste.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelNoExiste.setVisible(false);
		labelNoExiste.setOpaque(true);
		labelNoExiste.setBounds(86, 431, 347, 55);
		
		//Botones
		botonMenu = new JButton("Menú");
		botonMenu.setVisible(false);
		botonMenu.setForeground(Color.WHITE);
		botonMenu.setFont(new Font("Arial", Font.BOLD, 20));
		botonMenu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		botonMenu.setBackground(Color.DARK_GRAY);
		botonMenu.setBounds(10, 11, 89, 23);

		//Entradas de texto
		entrada = new JTextField();
		entrada.setCaretColor(Color.WHITE);
		entrada.setHorizontalAlignment(SwingConstants.CENTER);
		entrada.setFont(new Font("Arial", Font.BOLD, 28));
		entrada.setForeground(Color.WHITE);
		entrada.setBackground(Color.DARK_GRAY);
		entrada.setBounds(97, 498, 331, 56);
		entrada.setColumns(10);
		
		entradaDificil = new JTextField();
		entradaDificil.setHorizontalAlignment(SwingConstants.CENTER);
		entradaDificil.setForeground(Color.WHITE);
		entradaDificil.setFont(new Font("Arial", Font.BOLD, 28));
		entradaDificil.setColumns(10);
		entradaDificil.setCaretColor(Color.WHITE);
		entradaDificil.setBackground(Color.DARK_GRAY);
		entradaDificil.setBounds(96, 498, 331, 56);
		
		botonNormal = new JButton("Dificultad Normal");
		botonNormal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		botonNormal.setFont(new Font("Arial", Font.BOLD, 20));
		botonNormal.setForeground(Color.WHITE);
		botonNormal.setBackground(Color.DARK_GRAY);
		botonNormal.setBounds(175, 161, 166, 28);
		
		botonDificil = new JButton("Dificultad Difícil");
		botonDificil.setForeground(Color.WHITE);
		botonDificil.setFont(new Font("Arial", Font.BOLD, 20));
		botonDificil.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		botonDificil.setBackground(Color.DARK_GRAY);
		botonDificil.setBounds(175, 226, 166, 28);
		
		botonIdioma = new JButton("Idioma");
		botonIdioma.setForeground(Color.WHITE);
		botonIdioma.setFont(new Font("Arial", Font.BOLD, 20));
		botonIdioma.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		botonIdioma.setBackground(Color.DARK_GRAY);
		botonIdioma.setBounds(175, 285, 166, 28);
		
		botonReglas = new JButton("Reglas");
		botonReglas.setForeground(Color.WHITE);
		botonReglas.setFont(new Font("Arial", Font.BOLD, 20));
		botonReglas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		botonReglas.setBackground(Color.DARK_GRAY);
		botonReglas.setBounds(175, 349, 166, 28);
		
		//CheckBoxs de cambio de idioma
		checkEspaniol = new JCheckBox("Español");
		buttonGroup.add(checkEspaniol);
		checkEspaniol.setSelected(true);
		checkEspaniol.setFont(new Font("Arial", Font.BOLD, 20));
		checkEspaniol.setOpaque(false);
		checkEspaniol.setForeground(Color.WHITE);
		checkEspaniol.setBounds(176, 125, 140, 43);
		
		checkIngles = new JCheckBox("Inglés");
		buttonGroup.add(checkIngles);
		checkIngles.setOpaque(false);
		checkIngles.setForeground(Color.WHITE);
		checkIngles.setFont(new Font("Arial", Font.BOLD, 20));
		checkIngles.setBounds(176, 238, 140, 43);
		
		labelReglas=new JLabel();
        labelReglas.setOpaque(true);
        labelReglas.setBackground(Color.BLACK);
        labelReglas.setBounds(0, 0, 517, 610);
		
		//Creación de cuadriculas
		crearCuadricula(panelNormal, intentos, 96, 85);
		crearCuadricula(panelDificil, intentosDificil, 100, 85);
		
		//Acciones botón menú
        botonMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                botonMenu.setBounds(10, 11, 89, 23);
                botonMenu.setVisible(false);
                menu.setVisible(true);
                panelNormal.setVisible(false);
                panelDificil.setVisible(false);
                panelIdioma.setVisible(false);
                panelReglas.setVisible(false);

                terminarJuego(intentos, entrada, manejoDatos);
                terminarJuego(intentosDificil, entradaDificil, manejoDatosDificil);
            }
        });
		
		//Acciones botón modo normal
		botonNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entrada.setEnabled(true);
				limiteLetras(entrada);
				panelNormal.setVisible(true);
				menu.setVisible(false);
				botonMenu.setVisible(true);
			}
		});

		//Acciones botón modo difícil
		botonDificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entradaDificil.setEnabled(true);
				limiteLetras(entradaDificil);
				panelDificil.setVisible(true);
				menu.setVisible(false);
				botonMenu.setVisible(true);
			}
		});
		
		//Acciones botón reglas
		botonReglas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelReglas.setEnabled(true);
                panelReglas.setVisible(true);
                menu.setVisible(false);
                botonMenu.setVisible(true);
            }
        });
		
		//Acciones botón idioma
		botonIdioma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				panelIdioma.setVisible(true);
				botonMenu.setVisible(true);
			}
		});
		
		//Acciones checkbox español
		checkEspaniol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idioma = "Español";
				manejoDatos.cambiarIdioma(idioma);
				manejoDatosDificil.cambiarIdioma(idioma);
				limpiarTablero(intentos, entrada, manejoDatos);
				limpiarTablero(intentosDificil, entradaDificil, manejoDatosDificil);
			}
		});
		
		//Acciones checkbox inglés
		checkIngles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idioma = "Inglés";
				manejoDatos.cambiarIdioma(idioma);
				manejoDatosDificil.cambiarIdioma(idioma);
				limpiarTablero(intentos, entrada, manejoDatos);
				limpiarTablero(intentosDificil, entradaDificil, manejoDatosDificil);
			}
		});
		
		//Acciones entradaNormal
		entrada.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				labelNoExiste.setVisible(false);
				try {
					manejoDatos.adivinar(entrada, intentos, e);
				}catch(IllegalArgumentException exc) {
					labelNoExiste.setText(exc.getLocalizedMessage());
					labelNoExiste.setVisible(true);
				}
				darResultadoFinal(manejoDatos, entrada);
			}
		});
		
		//Acciones entradaDificil
		entradaDificil.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				labelNoExiste.setVisible(false);
				try {
					manejoDatos.adivinar(entradaDificil, intentosDificil, e);
				}catch(IllegalArgumentException exc) {
					labelNoExiste.setText(exc.getLocalizedMessage());
					labelNoExiste.setVisible(true);
				}
				darResultadoFinal(manejoDatosDificil, entradaDificil);
			}
		});
		
		//Añadir a pantalla
		frame.getContentPane().add(panelReglas);
		frame.getContentPane().add(labelNoExiste);
		frame.getContentPane().add(botonMenu);
		frame.getContentPane().add(labelGanar);
		frame.getContentPane().add(labelPerder);
		frame.getContentPane().add(nombre);
		frame.getContentPane().add(menu);
		menu.add(botonNormal);
		menu.add(botonDificil);
		menu.add(botonReglas);
		menu.add(botonIdioma);
		frame.getContentPane().add(panelNormal);
		panelNormal.add(entrada);
		panelDificil.add(entradaDificil);
		frame.getContentPane().add(panelDificil);
		panelDificil.add(entradaDificil);
		frame.getContentPane().add(panelIdioma);
		panelIdioma.add(checkEspaniol);
		panelIdioma.add(checkIngles);
		panelReglas.add(labelReglas);

	}
	
	private void limiteLetras(JTextField entrada) {
		entrada.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char letra = e.getKeyChar();
				if(Character.isLowerCase(letra))
					e.setKeyChar(Character.toUpperCase(letra));
				if(entrada.getText().length() >= 5 || !(e.getKeyChar() >= 65 && e.getKeyChar() <= 90))
					e.consume();
			}         
		});
	}
	
	private void crearCuadricula(JPanel panel, JLabel[][] intentos, int x, int y) {
		for(int i = 0; i < intentos.length; i++) {
			int xAux = x;
			for(int j = 0; j < intentos[0].length; j++) {
				intentos[i][j] = new JLabel();
				intentos[i][j].setBounds(xAux, y, 65, 66);
				intentos[i][j].setOpaque(true);
				intentos[i][j].setForeground(Color.GRAY);
				intentos[i][j].setBackground(Color.DARK_GRAY);
				intentos[i][j].setFont(new Font("Arial", Font.BOLD, 28));
				intentos[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(intentos[i][j]);
				xAux += 66;
			}
			y += 67;
		}
	}
	
	private void limpiarCuadricula(JLabel[][] intentos, ManejoDatos manejoDatos) {
		for(int i = 0; i < intentos.length; i++) {
			for(int j = 0; j < intentos[0].length; j++) {
				intentos[i][j].setText("");
				intentos[i][j].setBackground(Color.DARK_GRAY);
			}
		}
		manejoDatos.reiniciarJuego();
	}
	
	private void limpiarTablero(JLabel[][] intentos, JTextField entrada, ManejoDatos manejoDatos) {
		limpiarCuadricula(intentos, manejoDatos);
		entrada.setText("");
	}

	private void terminarJuego(JLabel[][] intentos, JTextField entrada, ManejoDatos manejoDatos) {
		if(manejoDatos.isGano() || manejoDatos.isperdio()) {
			if(manejoDatos.isGano()) {
				labelGanar.setVisible(false);
				manejoDatos.setGano(false);
			}
			
			else if(manejoDatos.isperdio()) {
				labelPerder.setVisible(false);
				manejoDatos.setPerdio(false);
			}
			
			limpiarTablero(intentos, entrada, manejoDatos);
		}
	}

	private void darResultadoFinal(ManejoDatos manejoDatos, JTextField entrada) {
		if(manejoDatos.isGano()) {
			botonMenu.setBounds(61, 164, 89, 23);
			labelGanar.setVisible(true);
			entrada.setEnabled(false);
		}
		else if(manejoDatos.isperdio()) {
			botonMenu.setBounds(61, 164, 89, 23);
			labelPerder.setVisible(true);
			entrada.setEnabled(false);
		}
	}
	
}
