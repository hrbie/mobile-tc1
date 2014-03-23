import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JFrame2 extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JFrame2(){
		super();
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}

	JFrame2(String titulo){
		super(titulo);
	addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
}
