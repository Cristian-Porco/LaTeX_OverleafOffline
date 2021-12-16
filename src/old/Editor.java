package old;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.ToolBar;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.swt.widgets.List;

public class Editor {

	protected Shell shlLatexEditor;
	private Text text;
	private Label lblAnteprima;

	public void aggiornaAnteprima() {
		lblAnteprima.setText(text.getText());
	}
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Editor window = new Editor();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlLatexEditor.open();
		shlLatexEditor.layout();
		while (!shlLatexEditor.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlLatexEditor = new Shell();
		shlLatexEditor.setModified(true);
		shlLatexEditor.setMinimumSize(new Point(1280, 720));
		shlLatexEditor.setSize(453, 303);
		shlLatexEditor.setText("LaTeX Editor");
		shlLatexEditor.setLayout(new BorderLayout(0, 0));
		
		Composite compositeStrumenti = new Composite(shlLatexEditor, SWT.NONE);
		compositeStrumenti.setLayoutData(BorderLayout.NORTH);
		
		ToolBar toolBar = new ToolBar(compositeStrumenti, SWT.FLAT | SWT.RIGHT);
		toolBar.setBounds(10, 34, 1244, 23);
		
		ToolItem tltmBold = new ToolItem(toolBar, SWT.NONE);
		tltmBold.setText("Bold");
		
		ToolItem tltmItalic = new ToolItem(toolBar, SWT.NONE);
		tltmItalic.setText("Italic");
		
		ToolBar toolBar_1 = new ToolBar(compositeStrumenti, SWT.FLAT | SWT.RIGHT);
		toolBar_1.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		toolBar_1.setBounds(0, 0, 1264, 31);
		
		Composite compositeEditor = new Composite(shlLatexEditor, SWT.NONE);
		compositeEditor.setLayoutData(BorderLayout.CENTER);
		FillLayout fl_compositeEditor = new FillLayout(SWT.HORIZONTAL);
		fl_compositeEditor.spacing = 40;
		fl_compositeEditor.marginWidth = 10;
		fl_compositeEditor.marginHeight = 10;
		compositeEditor.setLayout(fl_compositeEditor);
		
		text = new Text(compositeEditor, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		
		Composite compositeAnteprima = new Composite(compositeEditor, SWT.NONE);
		compositeAnteprima.setLayout(new BorderLayout(0, 0));
		
		lblAnteprima = new Label(compositeAnteprima, SWT.BORDER | SWT.WRAP);
		lblAnteprima.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label label = new Label(compositeAnteprima, SWT.NONE);
		label.setLayoutData(BorderLayout.NORTH);
		label.setText("Anteprima:");
		
		tltmBold.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String precedente = text.getText(0, text.getSelection().x - 1);
				String boldLaTeX = StringEscapeUtils.escapeJava("\textbf{" + text.getSelectionText() + "}");
				String successivo = text.getText(text.getSelection().y, text.getText().length());
				text.setText(precedente + boldLaTeX + successivo);
				
				aggiornaAnteprima();
			}
		});
		
		tltmItalic.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String precedente = text.getText(0, text.getSelection().x - 1);
				String italicLaTeX = StringEscapeUtils.escapeJava("\textit{" + text.getSelectionText() + "}");
				String successivo = text.getText(text.getSelection().y, text.getText().length());
				text.setText(precedente + italicLaTeX + successivo);
				
				aggiornaAnteprima();
			}
		});
		
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				aggiornaAnteprima();
			}
		});
	}
}
