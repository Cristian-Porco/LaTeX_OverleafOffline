package old;

import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author ad474
 */

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
//import javafx.geometry.Orientation;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ankita
 */
public class teditor implements  ActionListener, MouseListener{
    JFrame f=new JFrame("Text Editor");
    JFrame f1=new JFrame();
    JFrame f2=new JFrame();
    JFrame f3=new JFrame();
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
      
    JTextPane ta=new JTextPane();
    JLabel l=new JLabel();
    int cc=0;
    int cw=0;
    String s="";
    int flag=0;
    JTextField tf1=new JTextField();
    JTextField tf2=new JTextField();
    JFrame fb=new JFrame("Replace");
    JFrame ftem=new JFrame("Find");
    String g="";
    JMenu menu4=new JMenu("Font Style");  
    JMenu menu5=new JMenu("Font Size"); 
    JMenu menu6=new JMenu("Font Case");
    int sflag=0;
    String fpath="";
    JFrame fclose=new JFrame();
    public teditor(){
        try { 
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); 
            MetalLookAndFeel.setCurrentTheme(new OceanTheme()); 
        } 
        catch (Exception e) { 
        } 
        f.setLayout(new GridLayout(1,2));
        p1.setLayout(new BorderLayout());
        p2.setLayout(new GridLayout(1,4));
        l.setText("Chars:    Words:");
        p1.add(p2,BorderLayout.NORTH);
        p1.add(ta,BorderLayout.CENTER);
        p1.add(l,BorderLayout.SOUTH);
        FigureCanvas dp=new FigureCanvas();
        p3.setLayout(new BorderLayout());
        p3.add(dp);
        f.add(p1);
        f.add(p3);   
        ta.addMouseListener(this);
        
        
        p1.setVisible(true);
        p2.setVisible(true);
        p3.setVisible(true);
        f.setVisible(true);
        f.setSize(700,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Making the menu bar
        JMenu menu1,menu2,menu3, submenu;  
        JMenuItem i1, i2, i3, i4, i5,i6,i7,i8,i9,i10,i11,i12,i13;  

        JMenuBar mb=new JMenuBar();  
        menu1=new JMenu("File");
        menu2=new JMenu("Edit"); 
        menu3=new JMenu("Find"); 
        
        i13=new JMenuItem("Save As");   
        i1=new JMenuItem("Save");  
        i2=new JMenuItem("Open");  
        i3=new JMenuItem("New");  
        i4=new JMenuItem("Cut");  
        i5=new JMenuItem("Copy");  
        i6=new JMenuItem("Paste");  
        i7=new JMenuItem("Find");  
        i8=new JMenuItem("Replace");  
        i9=new JMenuItem("Replace All");         
        i10=new JMenuItem("Uppercase");
        i11=new JMenuItem("Lowercase");
        i12=new JMenuItem("Remove Highlight");
        
        menu1.add(i13); menu1.add(i1); menu1.add(i2); menu1.add(i3);  
        menu2.add(i4); menu2.add(i5); menu2.add(i6);  
        menu3.add(i7); menu3.add(i12); menu3.add(i8); menu3.add(i9);  
        menu6.add(i10);
        menu6.add(i11);
        mb.add(menu1);  
        mb.add(menu2);  
        mb.add(menu3); 
        mb.add(menu4);  
        mb.add(menu5);
        mb.add(menu6);
          
        i1.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);
        i4.addActionListener(this);
        i5.addActionListener(this);
        i6.addActionListener(this);
        i7.addActionListener(this);
        i8.addActionListener(this);
        i9.addActionListener(this);
        i10.addActionListener(this);
        i11.addActionListener(this);
        i12.addActionListener(this);
        i13.addActionListener(this);
        
        f.setJMenuBar(mb);  
        //Setting font to selected text
        String fonts[]= GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for(int i=0;i<fonts.length;i++){
        JMenuItem mit=new JMenuItem(fonts[i]);
        mit.addActionListener(new StyledEditorKit.FontFamilyAction(fonts[i],fonts[i]));
        menu4.add(mit);
        }   
        
        
        
        //setting font size to selected text
        for(int i=12;i<=48;i+=2){
            JMenuItem mit=new JMenuItem(""+i);
            mit.addActionListener(new StyledEditorKit.FontSizeAction("size", i));
            menu5.add(mit);
        }
    }
    
    public static void main(String[] args){
        new teditor();
    }

    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getActionCommand().equals("Save As")||ae.getActionCommand().equals("Save")) { 
            //If the file has not been saved before clicking save, it redirects to Save As
            if(ae.getActionCommand().equals("Save As")||sflag==0){
            JFileChooser j = new JFileChooser("f:"); 
            int r = j.showSaveDialog(null);            
            fpath=j.getSelectedFile().getAbsolutePath();
            sflag=1;
            }
            File fi = new File(fpath); 
            try { 
                FileWriter wr = new FileWriter(fi, false); 
                BufferedWriter w = new BufferedWriter(wr); 
                w.write(ta.getText()); 
                w.flush(); 
                w.close(); 
            } 
            catch (Exception evt) { 
                JOptionPane.showMessageDialog(f, evt.getMessage()); 
            } 
            
            
        } 

        if (ae.getActionCommand().equals("Open")) { 
            JFileChooser j = new JFileChooser("f:"); 
            int r = j.showOpenDialog(null); 
                File fi = new File(j.getSelectedFile().getAbsolutePath());  
                try { 
                    String s1 = "", sl = ""; 
                    FileReader fr = new FileReader(fi); 
                    BufferedReader br = new BufferedReader(fr); 
                    sl = br.readLine(); 
                    while ((s1 = br.readLine()) != null) { 
                        sl = sl + "\n" + s1; 
                    } 
                    ta.setText(sl); 
                } 
                catch (Exception evt) { 
                    JOptionPane.showMessageDialog(f, evt.getMessage()); 
                } 
        } 
        if(ae.getActionCommand().equals("New")){
            ta.setText("");
        }
         if (ae.getActionCommand().equals("Cut")) { 
            ta.cut(); 
        } 
        else if (ae.getActionCommand().equals("Copy")) { 
            ta.copy(); 
        } 
        else if (ae.getActionCommand().equals("Paste")) { 
            ta.paste(); 
        } 

        if ((ae.getActionCommand().equalsIgnoreCase("Uppercase"))||(ae.getActionCommand().equals("Lowercase"))){
            
            String changedcase="";
            if(ae.getActionCommand().equals("Lowercase"))
                changedcase=ta.getSelectedText().toLowerCase();
            else
                changedcase=ta.getSelectedText().toUpperCase();
            changedcase=ta.getText().replace(ta.getSelectedText(), changedcase);
            ta.setText(changedcase);
        }

        
        if(ae.getActionCommand().equalsIgnoreCase("Find")){
            //Making JPanel to appear when button clicked
            JPanel p=new JPanel();
            JPanel p2=new JPanel();
            p.setLayout(new GridLayout(1,2));
            ftem.setLayout(new BorderLayout());
            JLabel lt=new JLabel("Find word");
            p.add(lt);
            p.add(tf1);
            JButton btemp=new JButton("ok");
            p2.add(btemp);
            btemp.addActionListener(this);
            ftem.add(p,BorderLayout.NORTH);
            ftem.add(p2, BorderLayout.SOUTH);
            p.setVisible(true);
            p2.setVisible(true);
            ftem.setVisible(true);
            ftem.setSize(300,110);
            ftem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            tf1.setText("");
        }
        if(ae.getActionCommand().equals("Replace")||ae.getActionCommand().equals("Replace All")){
            //Making JPanel to appear when respective buttons are pressed
            if(ae.getActionCommand().equals("Replace")){
                flag=1;
            }
            else
                flag=2;
            String g=ta.getText();
            JPanel p2=new JPanel();
            p2.setLayout(new GridLayout(2,2));
            JPanel p=new JPanel();
            JButton b=new JButton("OK");
            p.add(b);
            fb.setLayout(new BorderLayout());
            JLabel lt=new JLabel("Replace word ");
            JLabel lt1=new JLabel("with ");
            p2.add(lt);
            p2.add(tf1);
            p2.add(lt1);
            p2.add(tf2);
            fb.add(p2,BorderLayout.NORTH);
            fb.add(p,BorderLayout.SOUTH);
            b.addActionListener(this);
            fb.setVisible(true);
            fb.setSize(300,110);
            fb.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            tf1.setText("");
            tf2.setText("");
        }
        if(ae.getActionCommand().equals("OK")){
            //where actual replacing takes place
            String g1=tf1.getText();
            String g2=tf2.getText();
            String r=ta.getText();
            if (flag==1)
                r=r.replaceFirst(g1, g2);
            else
                r=r.replaceAll(g1, g2);
            ta.setText(r);
            fb.setVisible(false);
        }
        if(ae.getActionCommand().equals("ok")||ae.getActionCommand().equals("Remove Highlight")){
            //Where actual highlighting takes place
            Highlighter highlighter = ta.getHighlighter();
            HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
            if (ae.getActionCommand().equals("ok")) {
                String word = tf1.getText();
                int pi = ta.getText().indexOf(word);
                while (pi >= 0) {
                    int pf = pi + word.length();
                    try {
                        highlighter.addHighlight(pi, pf, painter);
                    } catch (BadLocationException ex) {
                        Logger.getLogger(teditor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    pi = ta.getText().indexOf(word, pi + 1);
                    ftem.setVisible(false);
                }
            }
            else{
                ta.getHighlighter().removeAllHighlights();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
       //counting characters and words
        System.out.println(me.getSource());
        cc=0;
        cw=0;
         if (ta.getSelectedText() != null) { // See if they selected something 
        
        String sw=ta.getSelectedText();
        int i;
        for(i=0;i<sw.length();i++){
            if(sw.charAt(i)!='\n')
            cc++;
            if(sw.charAt(i)==' '||sw.charAt(i)=='\n')
                cw++;
        }
        if(sw.charAt(sw.length()-1)!=' ')
            cw++;
        l.setText("Words: "+cw+" Characters: "+cc);
    }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    class FigureCanvas extends JPanel implements ActionListener, MouseMotionListener{
    
        //Shapes portion of the question
        JPanel shapes = new JPanel();
        String set = "";
        
        int[] ox={75,75,200,200};
        int[] oy={150,100,100,150};
        
        int[] tx={75,100,125};
        int[] ty={150,100,150};
        
        int[] rx={100,100,200,200};
        int[] ry={150,100,100,150};
        
        int[] px = {150,150,200,250,250};
        int[] py = {300,200,100,200,300};
        
        int[] hx={100,150,200,150,100,50};
        int[] hy={200,200,150,100,100,150};
        
        
    public FigureCanvas(){
        JMenuBar m = new JMenuBar();
        JMenu ms = new JMenu("Shapes");
        JMenu msc= new JMenu("Clear"); 
        JMenuItem bOval = new JMenuItem("Oval");
        JMenuItem bRectangle = new JMenuItem("Rectangle");
        JMenuItem bTriangle = new JMenuItem("Triangle");
        JMenuItem bPentagon = new JMenuItem("Pentagon");
        JMenuItem bHexagon = new JMenuItem("Hexagon");
        JMenuItem bClear=new JMenuItem("Clear");
        ms.add(bOval);
        ms.add(bTriangle);
        ms.add(bRectangle);
        ms.add(bPentagon);
        ms.add(bHexagon);
        msc.add(bClear);
        
        m.add(ms);
        m.add(msc);
        (this).setLayout(new BorderLayout());
        add(m, BorderLayout.NORTH);
        //add(clr, BorderLayout.SOUTH);
        
        bOval.addActionListener(this);
        bRectangle.addActionListener(this);
        bTriangle.addActionListener(this);
        bPentagon.addActionListener(this);
        bHexagon.addActionListener(this);
        //clr.addActionListener(this);
        bClear.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("Oval")){
                drawing("Oval");   
            }
        else if(ae.getActionCommand().equals("Triangle")){
                drawing("Triangle");   
            }
        else if((ae.getActionCommand()).equals("Rectangle")){
                drawing("Rectangle");                           
            }
        else if((ae.getActionCommand()).equals("Pentagon")){
                drawing("Pentagon");                   
            }
        else if((ae.getActionCommand()).equals("Hexagon")){
                drawing("Hexagon");                   
            }
        addMouseMotionListener(this);
        if(ae.getActionCommand().equals("Clear")){
            (this).updateUI();
            drawing("Clear");
        }
    }
    
    public void drawing(String x){
        repaint();
        set = x;
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(set.equals("Oval")){
            g.setColor(Color.LIGHT_GRAY);
            double w = Math.sqrt(Math.pow(ox[1]-ox[2],2)+Math.pow(oy[1]-oy[2],2));
            double h = Math.sqrt(Math.pow(ox[1]-ox[0],2)+Math.pow(oy[1]-oy[0],2));
            g.fillOval(ox[1], oy[1], (int)w, (int)h);
        }
        else if(set.equals("Triangle")){
            g.setColor(Color.CYAN);
            g.fillPolygon(tx, ty, 3);
        }
        else if(set.equals("Rectangle")){
            g.setColor(Color.MAGENTA);
            g.fillPolygon(rx, ry, 4);
        }
        else if(set.equals("Pentagon")){
            g.setColor(Color.PINK);
            g.fillPolygon(px, py, 5);
        }
        else if(set.equals("Hexagon")){
            g.setColor(Color.YELLOW);
            g.fillPolygon(hx, hy, 6);
        }
        
    }
   

        @Override
    public void mouseDragged(MouseEvent me) {
        int i;
        if(set.equals("Oval")){
            if(me.getX()>=(ox[0]-15)&&me.getY()>=(oy[0]-15)){
                ox[0]=me.getX();
                oy[0]=me.getY();
                repaint();
            }
            else if(me.getX()>=(ox[1]-15)&&me.getY()<=(oy[1]+15)){
                ox[1]=me.getX();
                oy[1]=me.getY();
                repaint();
            }
            else if(me.getX()>=(ox[2]-15)&&me.getY()<=(oy[2]+15)){
                ox[2]=me.getX();
                oy[2]=me.getY();
                repaint();
            }
        
            else if(me.getX()>=(ox[3]-15)&&me.getY()<=(oy[3]+15)){
                ox[3]=me.getX();
                oy[3]=me.getY();
                repaint();
            }
        }
        if(set.equals("Triangle")){
            if(me.getX()>=(tx[0]-15)&&me.getY()<=(ty[0]+15)){
                tx[0]=me.getX();
                ty[0]=me.getY();
                repaint();
            }
            else if(me.getX()>=(tx[1]-15)&&me.getY()<=(ty[1]+15)){
                tx[1]=me.getX();
                ty[1]=me.getY();
                repaint();
            }
            else if(me.getX()>=(tx[2]-15)&&me.getY()<=(ty[2]+15)){
                tx[2]=me.getX();
                ty[2]=me.getY();
                repaint();
            }
        }
        if(set.equals("Rectangle")){
            if(me.getX()>=(rx[0]-15)&&me.getY()<=(ry[0]+15)){
                rx[0]=me.getX();
                ry[0]=me.getY();
                rx[1]=me.getX();
                ry[3]=me.getY();
                repaint();
            }
            else if(me.getX()>=(rx[1]-15)&&me.getY()<=(ry[1]+15)){
                rx[1]=me.getX();
                ry[1]=me.getY();
                rx[0]=me.getX();
                ry[2]=me.getY();
                repaint();
            }
            else if(me.getX()>=(rx[2]-15)&&me.getY()<=(ry[2]+15)){
                rx[2]=me.getX();
                ry[2]=me.getY();
                rx[3]=me.getX();
                ry[1]=me.getY();
                repaint();
            }
            else if(me.getX()>=(rx[3]-15)&&me.getY()<=(ry[3]+15)){
                rx[3]=me.getX();
                ry[3]=me.getY();
                rx[2]=me.getX();
                ry[1]=me.getY();
                repaint();
            }
        }
        if(set.equals("Pentagon")){
            if((me.getX()>=(px[0]-15)&&me.getX()<=(px[0]+15))&&(me.getY()<=(py[0]+15)&&me.getY()>=(py[0]-15))){
                px[0]=me.getX();
                py[0]=me.getY();
                repaint();
            }  
            if((me.getX()>=(px[1]-15)&&me.getX()<=(px[1]+15))&&(me.getY()<=(py[1]+15)&&me.getY()>=(py[1]-15))){
                px[1]=me.getX();
                py[1]=me.getY();
                repaint();
            }  
            if((me.getX()>=(px[2]-15)&&me.getX()<=(px[2]+15))&&(me.getY()<=(py[2]+15)&&me.getY()>=(py[2]-15))){
                px[2]=me.getX();
                py[2]=me.getY();
                repaint();
            }  
            if((me.getX()>=(px[3]-15)&&me.getX()<=(px[3]+15))&&(me.getY()<=(py[3]+15)&&me.getY()>=(py[3]-15))){
                px[3]=me.getX();
                py[3]=me.getY();
                repaint();
            }  
            if((me.getX()>=(px[4]-15)&&me.getX()<=(px[4]+15))&&(me.getY()<=(py[4]+15)&&me.getY()>=(py[4]-15))){
                px[4]=me.getX();
                py[4]=me.getY();
                repaint();
            }  
        }
        if(set.equals("Hexagon")){
            if((me.getX()>=(hx[0]-15)&&me.getX()<=(hx[0]+15))&&(me.getY()<=(hy[0]+15)&&me.getY()>=(hy[0]-15))){
                hx[0]=me.getX();
                hy[0]=me.getY();
                repaint();
            }  
            if((me.getX()>=(hx[1]-15)&&me.getX()<=(hx[1]+15))&&(me.getY()<=(hy[1]+15)&&me.getY()>=(hy[1]-15))){
                hx[1]=me.getX();
                hy[1]=me.getY();
                repaint();
            }  
            if((me.getX()>=(hx[2]-15)&&me.getX()<=(hx[2]+15))&&(me.getY()<=(hy[2]+15)&&me.getY()>=(hy[2]-15))){
                hx[2]=me.getX();
                hy[2]=me.getY();
                repaint();
            }  
            if((me.getX()>=(hx[3]-15)&&me.getX()<=(hx[3]+15))&&(me.getY()<=(hy[3]+15)&&me.getY()>=(hy[3]-15))){
                hx[3]=me.getX();
                hy[3]=me.getY();
                repaint();
            }  
            if((me.getX()>=(hx[4]-15)&&me.getX()<=(hx[4]+15))&&(me.getY()<=(hy[4]+15)&&me.getY()>=(hy[4]-15))){
                hx[4]=me.getX();
                hy[4]=me.getY();
                repaint();
            }  
            if((me.getX()>=(hx[5]-15)&&me.getX()<=(hx[5]+15))&&(me.getY()<=(hy[5]+15)&&me.getY()>=(hy[5]-15))){
                hx[5]=me.getX();
                hy[5]=me.getY();
                repaint();
            }  
        }
        
    }

        @Override
    public void mouseMoved(MouseEvent me) {
        
    }
}
}