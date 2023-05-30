package container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SetupData extends JFrame {
	private static final long serialVersionUID = 1L;
	public SetupData() {		
		JPanel panel= new JPanel();
		add(panel);		
		add(new GamePanel(MainFrame.DELAY));		
		setTitle("SNAKE GAME OOP");
		pack();		
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}
}