package application;

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

public class Intro {
	public static void main(String[] args) {
		JFrame f = new JFrame("LaTeX Editor");
		JPanel sopra = new JPanel();
		JPanel sinistra = new JPanel();
		JPanel centro = new JPanel();
		JPanel destra = new JPanel();
		JPanel sotto = new JPanel();	
		
		Font font = new Font("Arial", Font.BOLD, 19);
		JLabel title = new JLabel("Benvenuto su LaTeX Editor");
        title.setFont(font);
		sopra.setAlignmentX(Component.LEFT_ALIGNMENT);
		sopra.add(title);
		
		f.add(sopra, BorderLayout.PAGE_START);
		f.add(centro, BorderLayout.CENTER);
		f.add(sotto, BorderLayout.PAGE_END);
		f.add(sinistra, BorderLayout.LINE_START);
		f.add(destra, BorderLayout.LINE_END);
		f.setSize(820, 600);
		f.setMinimumSize(new Dimension(820,600));
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
