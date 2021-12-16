package application;

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.*;
import static java.awt.SystemColor.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.text.StyledEditorKit;
import java.util.Timer;
import java.util.TimerTask;


public class Demo {
	public static void main(String[] args) {
		JFrame f = new JFrame("LaTeX Editor");
		JPanel sopra = new JPanel();
		JPanel sinistra = new JPanel();
		JPanel destra = new JPanel();
		JPanel sotto = new JPanel();
		
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem nuovo = new JMenuItem("Nuovo");
		JMenuItem apri = new JMenuItem("Apri");
		file.add(nuovo);
		file.add(apri);
		menubar.add(file);
		JMenu modifica = new JMenu("Modifica");
		menubar.add(modifica);
		JMenu aiuto = new JMenu("Aiuto");
		menubar.add(aiuto);
		f.setJMenuBar(menubar);
		
		JButton bold = new JButton("Bold");
		JButton italic = new JButton("Italic");
		sopra.add(bold);
		sopra.add(italic);
		
		JTextArea textArea1 = new JTextArea();
		textArea1.setLineWrap(true);
		JScrollPane scrollPane1 = new JScrollPane(textArea1);
		
		JLabel textArea2 = new JLabel("<html><body><i>Ciao</i></body></html>");
		JScrollPane scrollPane2 = new JScrollPane(textArea2);
		scrollPane2.setHorizontalScrollBar(null);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane1, scrollPane2);
		splitPane.setDividerLocation(380);
		splitPane.setDividerSize(20);
		scrollPane2.setMinimumSize(new Dimension(380,0));
		
		f.add(sopra, BorderLayout.PAGE_START);
		f.add(splitPane, BorderLayout.CENTER);
		f.add(sotto, BorderLayout.PAGE_END);
		f.add(sinistra, BorderLayout.LINE_START);
		f.add(destra, BorderLayout.LINE_END);
		f.setSize(820, 600);
		f.setMinimumSize(new Dimension(820,600));
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		textArea1.addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {
				textArea2.setText("<html><body><p>" + textArea1.getText() + "</p></body></html>");
			}
			public void keyPressed(KeyEvent e) {}
		});
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				textArea2.setPreferredSize(new Dimension(scrollPane2.getWidth(), scrollPane2.getHeight()));
			}
		}, 1000, 1000);
	}
}
