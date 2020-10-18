import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class domino {

public static void main(String[] args) {
	GUI juego = new GUI();
	juego.setup();
	boolean inicio = false;
	juego.botonInicio.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e) {
			//Cambio de pantalla
			juego.panelInicio.setVisible(false);
			juego.ventana.remove(juego.panelInicio);
			juego.ventana.add(juego.panelJuego);
			juego.panelJuego.add(juego.imagenFondo);
			//Crea los jugadores
			Jugador jugador1 = new Jugador();
			Jugador jugador2 = new Jugador();;
			jugador1.nombre = juego.nombreJugador1.getText();
			jugador2.nombre = juego.nombreJugador2.getText();
			juego.mensaje.setText("Es el turno de "+jugador1.nombre);
	}});
}
}
class GUI {
	JFrame ventana;
	JPanel panelInicio;
	JPanel panelPrincipal;
	JPanel panelJuego;
	JLabel mesa;
	JLabel imagenFondo;
	JTextField nombreJugador1;
	JTextField nombreJugador2;
	JButton botonInicio;
	JButton comenzar;
	JLabel mensaje;
	void setup() {
		//Seteo de ventana
		int ancho = 1024;
		int alto = 576;
		ventana = new JFrame("Domino");
		ventana.setSize(ancho,alto);
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);

		//Imagen de fondo
		imagenFondo = new JLabel();
		imagenFondo.setIcon(new ImageIcon("fondo.png"));
		imagenFondo.setSize(ancho,alto);

		//nombre Jugador1
		nombreJugador1 = new JTextField("Jugador 1");
		nombreJugador1.setBounds(50,50,200,50);
		//nombre Jugador2
		nombreJugador2 = new JTextField("Jugador 2");
		nombreJugador2.setBounds(ancho-250,50,200,50);
		//Boton de inicio
		botonInicio = new JButton("Comenzar");
		botonInicio.setBounds(ancho/2-100,alto-200,200,50);
		//Pantalla de inicio
		panelInicio = new JPanel();
		panelInicio.setSize(ancho,alto);
		panelInicio.setLayout(null);
		panelInicio.setVisible(true);
		ventana.add(panelInicio);
		panelInicio.add(imagenFondo);
		panelInicio.add(nombreJugador1);
		panelInicio.add(nombreJugador2);
		panelInicio.add(botonInicio);
		//Mesa
		mesa = new JLabel();
		mesa.setIcon(new ImageIcon("mesa.png"));
		mesa.setBounds(62,44,900,400);	
		//Notificador
		JLabel notificador = new JLabel();
		notificador.setIcon(new ImageIcon("mesa.png"));
		notificador.setBounds(62,10,962,30);
		mensaje = new JLabel();
		mensaje.setBounds(10,0,900,30);
		mensaje.setForeground(Color.WHITE);
		notificador.add(mensaje);
		//Panel del Juego
		panelJuego = new JPanel();
		panelJuego.setSize(ancho,alto);
		panelJuego.setLayout(null);
		panelJuego.add(mesa);
		panelJuego.add(notificador);
		//Mostrar todo
		ventana.setVisible(true);
	}
}

class Jugador {
	String nombre;
	boolean turno;
}

class Ficha {
	boolean Doble;
	int valor1;
	int valor2;
	JLabel imagen = new JLabel();
}


