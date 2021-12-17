package application;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Intro {
	public static void main(String[] args) {
		JFrame f = new JFrame("LaTeX Editor");
		JPanel sopra = new JPanel();
		JPanel sinistra = new JPanel();
		JPanel centro = new JPanel();
		JPanel destra = new JPanel();
		JPanel sotto = new JPanel();		
		
		f.setSize(820, 600);
		f.setMinimumSize(new Dimension(820,600));
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
