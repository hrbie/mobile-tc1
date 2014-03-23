//Clase principal

public class Calculadora extends JFrame2 {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Calculadora(){
		super("Calculadora");
		Calcu01 c01 = new Calcu01();
		setContentPane(c01);
		pack();
		setVisible(true);
	}
	public static void main(String args[]){
		new Calculadora();
	}
}
