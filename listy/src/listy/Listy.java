
package listy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Listy extends JFrame {

    public Listy()
    {
        initComponents();
    }
    public void initComponents()
    {
        this.setTitle("Lista");
        this.setBounds(400, 400, 400, 300);
        
        listaPrzedmiotow.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaPrzedmiotow.setVisibleRowCount(5);
        listaPrzedmiotow.setFixedCellHeight(30);
        listaPrzedmiotow.setBackground(Color.PINK);
        listaPrzedmiotow.setSelectionBackground(Color.LIGHT_GRAY);
        
        listaPrzedmiotow.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                System.out.println("Zmieniłem się " + (++i));
                
                if(lse.getValueIsAdjusting())
                {
                    System.out.println("Trzymam button myszy");
                }
                else 
                {
                    System.out.println("Puściłem button myszy");
                }
//                if(!lse.getValueIsAdjusting())
//                {
//                    Object[] wartosciWLiscie = (Object[]) ((JList)lse.getSource()).getSelectedValue();
//                    String przedmioty = "";
//                    
//                    for(int i = 0; i < wartosciWLiscie.length; i++)
//                    {
//                        przedmioty += (String)wartosciWLiscie[i];
//                    }
//                    System.out.println(przedmioty);
//                }
            }
        });
        
        
        panelListy.add(scrollListy);
        
        panelKomunikatu.add(komunikat);
        
        this.getContentPane().add(panelListy, BorderLayout.NORTH);
        this.getContentPane().add(panelKomunikatu, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private int i = 0;
    private JList listaPrzedmiotow = new JList(new String[]{"Matematyka", "Fizyka", "Infromatyka", "Biologia", "Chemia", "WOS", "Historia"});
    private JScrollPane scrollListy = new JScrollPane(listaPrzedmiotow);
    private JPanel panelListy = new JPanel();
    private JPanel panelKomunikatu = new JPanel();
    private JLabel komunikat = new JLabel("Nauka to potęgi klucz");
    public static void main(String[] args) {
        
        new Listy().setVisible(true);
    }
    
    
}
