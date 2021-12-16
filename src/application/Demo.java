package application;

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.*;
import static java.awt.SystemColor.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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

public class Demo {
	public static void main(String[] args) {
		JFrame f = new JFrame("LaTeX Editor");
		JPanel sopra = new JPanel();
		JPanel sinistra = new JPanel();
		sinistra.setBackground(Color.GREEN);
		JPanel centro = new JPanel();
		centro.setBackground(Color.CYAN);
		JPanel destra = new JPanel();
		destra.setBackground(Color.RED);
		JPanel sotto = new JPanel();
		sotto.setBackground(Color.BLUE);
		
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
		
		f.add(sopra, BorderLayout.PAGE_START);
		f.add(sinistra, BorderLayout.LINE_START);
		f.add(centro, BorderLayout.CENTER);
		f.add(destra, BorderLayout.LINE_END);
		f.add(sotto, BorderLayout.PAGE_END);
		f.setSize(800, 600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
