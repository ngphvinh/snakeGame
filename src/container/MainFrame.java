package container;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import javax.swing.Timer;

public class MainFrame extends JPanel {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	private static final long serialVersionUID = 1L;
	static int DELAY = 100;
	Timer timer;

	@SuppressWarnings("static-access")
	public MainFrame() {

		ImageIcon image = new ImageIcon("./src/background.jpg");
		Image img = image.getImage();
		Image temp_img = img.getScaledInstance(500, 235, Image.SCALE_SMOOTH);
		image = new ImageIcon(temp_img);

		JLabel background = new JLabel("", image, JLabel.CENTER);
		background.setBounds(0, 0, 500, 300);
		panel.add(background, BorderLayout.CENTER);

		JMenuBar menubar = new JMenuBar();
		frame.add(menubar, BorderLayout.NORTH);

		// menu1
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		fileMenu.addSeparator();
		menubar.add(fileMenu);

		JMenuItem newGameItem = new JMenuItem("New Game");
		fileMenu.add(newGameItem);
		newGameItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SetupData();
			}
		});

		JMenuItem exitItem = new JMenuItem("Quit");
		fileMenu.add(exitItem);
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// menu2
		JMenu levelMenu = new JMenu("Level");
		levelMenu.setMnemonic(KeyEvent.VK_L);
		levelMenu.addSeparator();
		menubar.add(levelMenu);

		JMenuItem[] menuItem2 = new JMenuItem[3];
		String[] array = { "Easy", "Medium", "Difficult" };
		for (int i = 0; i < 3; i++) {
			int level = i + 1;
			menuItem2[i] = new JMenuItem(array[i]);
			menuItem2[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// menuItem2[i].setBackground(Color.green);
					DELAY = 100 - 20 * level;
				}
			});
			levelMenu.add(menuItem2[i]);
		}

		panel.setLayout(new FlowLayout());
		frame.add(panel);
		frame.setTitle("Snake Game OOP");
		frame.setSize(500, 300);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		ImageIcon icon = new ImageIcon("./src/image/snake_icon.png");
		Image imageIcon = icon.getImage();
		frame.setIconImage(imageIcon);
	}

	public void play() {
		System.out.println("The speed you choose is: " + DELAY);
		timer = new Timer(DELAY, (ActionListener) this);
		timer.start();
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}