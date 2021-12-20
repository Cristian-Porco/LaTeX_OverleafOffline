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

public class Editor {
	public static JTextArea textArea1;
	public static JLabel textArea2;
	public static JLabel caratteri;
	
	public static void aggiornaAnteprima() {
		String tmp = textArea1.getText();
		if(tmp.length() == 1)
			caratteri.setText(tmp.length() + " carattere");
		else 
			caratteri.setText(tmp.length() + " caratteri");
		textArea2.setText("<html><body><p>" + tmp + "</p></body></html>");
	}
	
	public static void bold() {
		String precedente = "";
		try {
			precedente = textArea1.getText(0, textArea1.getSelectionStart());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
		String boldLatex = "";
		if(textArea1.getSelectionStart() != textArea1.getSelectionEnd())
			boldLatex = StringEscapeUtils.escapeJava("\textbf{") + textArea1.getSelectedText() + "}";
		else
			boldLatex = StringEscapeUtils.escapeJava("\textbf{}");
		String successivo = "";
		try {
			successivo = textArea1.getText(textArea1.getSelectionEnd(), textArea1.getText().length()-textArea1.getSelectionEnd());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
		textArea1.setText(precedente + boldLatex + successivo);
		aggiornaAnteprima();
	}
	
	public static void italic() {
		String precedente = "";
		try {
			precedente = textArea1.getText(0, textArea1.getSelectionStart());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
		String italicLatex = "";
		if(textArea1.getSelectionStart() != textArea1.getSelectionEnd())
			italicLatex = StringEscapeUtils.escapeJava("\textit{") + textArea1.getSelectedText() + "}";
		else
			italicLatex = StringEscapeUtils.escapeJava("\textit{}");
		String successivo = "";
		try {
			successivo = textArea1.getText(textArea1.getSelectionEnd(), textArea1.getText().length()-textArea1.getSelectionEnd());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
		textArea1.setText(precedente + italicLatex + successivo);
		aggiornaAnteprima();
	}
	
	public static void section() {
		String precedente = "";
		try {
			precedente = textArea1.getText(0, textArea1.getSelectionStart());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
		String sectionLatex = "";
		if(textArea1.getSelectionStart() != textArea1.getSelectionEnd())
			sectionLatex = StringEscapeUtils.escapeJava("\section{") + textArea1.getSelectedText() + "}";
		else
			sectionLatex = StringEscapeUtils.escapeJava("\section{}");
		String successivo = "";
		try {
			successivo = textArea1.getText(textArea1.getSelectionEnd(), textArea1.getText().length()-textArea1.getSelectionEnd());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
		textArea1.setText(precedente + sectionLatex + successivo);
		aggiornaAnteprima();
	}
	
	public static void subsection() {
		String precedente = "";
		try {
			precedente = textArea1.getText(0, textArea1.getSelectionStart());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
		String subsectionLatex = "";
		if(textArea1.getSelectionStart() != textArea1.getSelectionEnd())
			subsectionLatex = StringEscapeUtils.escapeJava("\subsection{") + textArea1.getSelectedText() + "}";
		else
			subsectionLatex = StringEscapeUtils.escapeJava("\subsection{}");
		String successivo = "";
		try {
			successivo = textArea1.getText(textArea1.getSelectionEnd(), textArea1.getText().length()-textArea1.getSelectionEnd());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
		textArea1.setText(precedente + subsectionLatex + successivo);
		aggiornaAnteprima();
	}
	
	public static void subsubsection() {
		String precedente = "";
		try {
			precedente = textArea1.getText(0, textArea1.getSelectionStart());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
		String subsubsectionLatex = "";
		if(textArea1.getSelectionStart() != textArea1.getSelectionEnd())
			subsubsectionLatex = StringEscapeUtils.escapeJava("\subsubsection{") + textArea1.getSelectedText() + "}";
		else
			subsubsectionLatex = StringEscapeUtils.escapeJava("\subsubsection{}");
		String successivo = "";
		try {
			successivo = textArea1.getText(textArea1.getSelectionEnd(), textArea1.getText().length()-textArea1.getSelectionEnd());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
		textArea1.setText(precedente + subsubsectionLatex + successivo);
		aggiornaAnteprima();
	}
	
	protected static void itemize() {
		String precedente = "";
		try {
			precedente = textArea1.getText(0, textArea1.getSelectionStart());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
		String itemizeLatex = "";
		itemizeLatex = StringEscapeUtils.escapeJava("\begin{itemize}") +
				"\n\t" + StringEscapeUtils.escapeJava("\\") + "item" + "\n"
				+ StringEscapeUtils.escapeJava("\\end{itemize}"); 
		String successivo = "";
		try {
			successivo = textArea1.getText(textArea1.getSelectionEnd(), textArea1.getText().length()-textArea1.getSelectionEnd());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
		textArea1.setText(precedente + itemizeLatex + successivo);
		aggiornaAnteprima();
	}
	
	protected static void enumerate() {
		String precedente = "";
		try {
			precedente = textArea1.getText(0, textArea1.getSelectionStart());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
		String enumerateLatex = "";
		enumerateLatex = StringEscapeUtils.escapeJava("\begin{enumerate}") +
				"\n\t" + StringEscapeUtils.escapeJava("\\") + "item" + "\n"
				+ StringEscapeUtils.escapeJava("\\end{enumerate}"); 
		String successivo = "";
		try {
			successivo = textArea1.getText(textArea1.getSelectionEnd(), textArea1.getText().length()-textArea1.getSelectionEnd());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
		textArea1.setText(precedente + enumerateLatex + successivo);
		aggiornaAnteprima();
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame("LaTeX Editor");
		JPanel sopra = new JPanel();
		JPanel sinistra = new JPanel();
		sinistra.setPreferredSize(new Dimension(50,0));
		JPanel destra = new JPanel();
		destra.setPreferredSize(new Dimension(50,0));
		JPanel sotto = new JPanel();
		
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem salva = new JMenuItem("Salva");
		JMenuItem salvaNome = new JMenuItem("Salva con nome...");
		JMenuItem chiudi = new JMenuItem("Chiudi");
		file.add(salva);
		file.add(salvaNome);
		file.add(new JSeparator());
		file.add(chiudi);
		menubar.add(file);
		JMenu modifica = new JMenu("Modifica");
		menubar.add(modifica);
		JMenu aiuto = new JMenu("Aiuto");
		menubar.add(aiuto);
		f.setJMenuBar(menubar);
		
		JButton bold = new JButton("Bold");
		JButton italic = new JButton("Italic");
		JButton section = new JButton("Section");
		JButton subsection = new JButton("S-Section");
		JButton subsubsection = new JButton("S-S-Section");
		JButton itemize = new JButton("Itemize");
		JButton enumerate = new JButton("Enumerate");
		sopra.add(bold);
		sopra.add(italic);
		sopra.add(new JSeparator());
		sopra.add(section);
		sopra.add(subsection);
		sopra.add(subsubsection);
		sopra.add(new JSeparator());
		sopra.add(itemize);
		sopra.add(enumerate);
		
		textArea1 = new JTextArea();
		textArea1.setLineWrap(true);
		Font font = new Font("Consolas", Font.PLAIN, 20);
        textArea1.setFont(font);
		JScrollPane scrollPane1 = new JScrollPane(textArea1);
		
		textArea2 = new JLabel("<html><body><i>Ciao</i></body></html>");
		JScrollPane scrollPane2 = new JScrollPane(textArea2);
		scrollPane2.setHorizontalScrollBar(null);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane1, scrollPane2);
		splitPane.setDividerLocation(380);
		splitPane.setDividerSize(20);
		scrollPane2.setMinimumSize(new Dimension(380,0));
		
		scrollPane2.setVisible(false);
		splitPane.setDividerSize(0);
		
		JLabel textCaratteri = new JLabel("Num. caratteri: ");
		caratteri = new JLabel("0 caratteri");
		sotto.add(textCaratteri);
		sotto.add(caratteri);
		
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
				aggiornaAnteprima();
				if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_B) bold();
				if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_I) italic();
				if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_1) section();
				if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_2) subsection();
				if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_3) subsubsection();
			}
			public void keyPressed(KeyEvent e) {}
		});
		
		bold.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { bold(); }
		});
		
		italic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { italic(); }
		});
		
		section.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { section(); }
		});
		
		subsection.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { subsection(); }
		});
		
		subsubsection.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { subsubsection(); }
		});
		
		itemize.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { itemize(); }
		});
		
		enumerate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { enumerate(); }
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
