import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Font;
//import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Calcu01 extends JPanel implements ActionListener {

	public CalculadoraJNI operaciones = new CalculadoraJNI();
	
	private static final long serialVersionUID = 1L;

	// Variables Interfaz de usuario
	private String[] nums = {	"1","2","3","+",
								"4","5","6","-",
								"7","8","9","*",
								"0","C","=","/",};
	private JButton[] botones = new JButton[nums.length];
	private JLabel pantalla = null;
	private JPanel botonera = new JPanel(new GridLayout(4,4));
	private Font fuente = new Font("Serif", Font.BOLD, 18);
	private EmptyBorder bordeBotonera, bordePantalla;

	//Variables del Programa

	//Estados de la calculadora
	final int LEER1= 1;
	final int LEER2= 2;
	final int MOSTRAR= 3;
	//Tipos de botones
	final int ESNUM= 1;
	final int ESOP= 2;
	final int ESC= 3;
	final int ESIGUAL= 4;
	//Otras variables
	private String str1="0";
	private long num1=0,num2=0,result=0;
	int estado;
	char operacion;

	//Constructor
	public Calcu01(){

		//Interfaz
		setLayout(new BorderLayout());
		pantalla = new JLabel("0.0",SwingConstants.RIGHT);
		pantalla.setFont(fuente);
		for (int i= 0; i<nums.length; i++)
		{
			botones[i]= new JButton(nums[i]);
			botones[i].addActionListener(this);
			botones[i].setActionCommand(nums[i]);
			botones[i].setFont(fuente);
			botonera.add(botones[i]);
		}

		bordeBotonera=(EmptyBorder)BorderFactory.createEmptyBorder(15,15,15,15);
		bordePantalla=(EmptyBorder)BorderFactory.createEmptyBorder(15,15,0,15);
		botonera.setBorder(bordeBotonera);
		pantalla.setBorder(bordePantalla);
		add(botonera,BorderLayout.CENTER);
		add(pantalla,BorderLayout.NORTH);

		//Funcionamiento
		estado = LEER1;
	}// fin constructor


	//Metodo Auxiliar
	int tipoBoton(char letra) {
		if (Character.isDigit(letra))
			return ESNUM;
		else if ("+-*/".indexOf(letra) != -1)
			return ESOP;
		else if (letra == 'C')
			return ESC;
		else return ESIGUAL;
	}

	//Metodo Principal
	public void actionPerformed(ActionEvent ae){
		char letra = ae.getActionCommand().charAt(0);
		int tb = tipoBoton(letra);
		//Se revisa el estado en el que se encuentra la calculadora
		switch (estado) {
			case LEER1:
					{
					switch(tb){
						case ESNUM: 	if (str1== "0")
											str1 = "" + letra;
										else
											str1 = str1 + letra;
										pantalla.setText(str1);
										break;
						case ESC:		str1 = "0";
										pantalla.setText(str1);
										break;
						case ESIGUAL:	Toolkit.getDefaultToolkit().beep();
										break;
						case ESOP:		operacion = letra;
										num1 = Long.parseLong(str1);
										str1 = "0";
										estado = LEER2;
										break;
						}//fin switch (tb)
					break;
					}// fin case LEER1
			case LEER2:
					{
					switch(tb){
						case ESNUM: 	if (str1== "0")
											str1 = "" + letra;
										else
											str1 = str1 + letra;
										pantalla.setText(str1);
										break;
						case ESC:		str1 = "0";
										pantalla.setText(str1);
										break;
						case ESOP:		Toolkit.getDefaultToolkit().beep();
										break;
						case ESIGUAL:	num2 = Long.parseLong(str1);
										switch (operacion) {
										//case '+': result = num1 + num2;
										case '+': result = operaciones.suma(num1, num2);
												  break;
										//case '-': result = num1 - num2;
										case '-': result = operaciones.resta(num1, num2);
												  break;
										//case '*': result = num1 * num2;
										case '*': result = operaciones.multi(num1, num2);
												  break;
										//case '/': result = num1 / num2;
										case '/': result = operaciones.div(num1, num2);
												  break;
										}
										pantalla.setText(Long.toString(result));
										estado = MOSTRAR;
										break;
						}//fin switch (tb)
					break;
					}// fin case LEER2
			case MOSTRAR:
					{
					switch(tb){
						case ESNUM: 	str1 = "" + letra;
										pantalla.setText(str1);
										estado = LEER1;
										break;
						case ESC:		str1 = "0";
										pantalla.setText(str1);
										break;
						case ESOP:
						case ESIGUAL:	Toolkit.getDefaultToolkit().beep();
										break;
						}//fin switch (tb)
						break;
					}// fin case MOSTRAR

			}//fin switch (estado)
	}//fin metodo

}// fin clase
