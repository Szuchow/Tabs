package zakladki;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Zakladki extends JFrame
{
    public Zakladki()
    {
        initComponents();
    }
    public void initComponents()
    {
        this.setTitle("Zakładki");
        this.setBounds(300, 300, 300, 200);
        
        zakladki.addTab("tab 1", new JLabel("to jest pierwszy"));
        zakladki.setMnemonicAt(0, KeyEvent.VK_T);     
        
        JPanel panel = new JPanel();
        panel.add(new JButton("tescior"));
        zakladki.addTab("to jest drugi tab", new ImageIcon("videokurs.jpg"), panel, "Testowy test");
        
        
        zakladki.addTab("Video Kurs", panelTworzenia);
        panelTworzenia.add(new JLabel("Stwórz nowy plik o nazwie: "));
        final JTextField nazwaNowejZakladki = new JTextField(7);
        panelTworzenia.add(nazwaNowejZakladki);
        JButton stworzZakladke = new JButton("Stwórz");
        panelTworzenia.add(stworzZakladke);
        
        stworzZakladke.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) 
            {
                JPanel panelTekstowy = new JPanel();
                panelTekstowy.setLayout(new GridLayout(1, 1));
                JTextArea obszarTekstowy = new JTextArea();
                panelTekstowy.add(new JScrollPane(obszarTekstowy));
                
                zakladki.addTab(nazwaNowejZakladki.getText()+".txt", panelTekstowy);
                zakladki.setSelectedIndex(zakladki.getTabCount()-1);
                
                obszarTekstowy.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent e)
                    {
                        if (!(tytulZakladki+e.getKeyChar()).equals(przedZmianaObszaruTekstowego) && czyToAscii(e.getKeyChar()) && flagaZapisu)
                        {
                            przedZmianaObszaruTekstowego = tytulZakladki+e.getKeyChar();                          
                            zakladki.setTitleAt(indeksZakladki, tytulZakladki+"*");
                            flagaZapisu = false;
                            System.out.println("test");
                        }
                        else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S && !flagaZapisu)
                        {
                            zakladki.setTitleAt(indeksZakladki, tytulZakladki);
                            System.out.println("Zapisujemy");
                            flagaZapisu = true;
                        }
                    
                    }
                    private boolean czyToAscii(char zn)
                    {
                        for (int i = 0; i < 255; i++)
                            if (zn == i)
                                return true;

                        return false;
                    }
                    String przedZmianaObszaruTekstowego = "";
                    int indeksZakladki = zakladki.getSelectedIndex();
                    String tytulZakladki = zakladki.getTitleAt(indeksZakladki);
                    boolean flagaZapisu = true;
                    
                });
                        
            }
        });
        
         zakladki.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        this.getContentPane().add(zakladki);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
   
    private JTabbedPane zakladki = new JTabbedPane();
    private JPanel panelTworzenia = new JPanel();
    public static void main(String[] args)
    {
        new Zakladki().setVisible(true);
    }
    

}
