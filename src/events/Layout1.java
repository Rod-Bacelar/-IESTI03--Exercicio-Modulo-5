package events;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Layout1 extends JFrame implements ActionListener{
    private JPanel centerPanel = new JPanel();
    private JPanel northPanel = new JPanel();
    
    public Layout1() {
        setLayout(new BorderLayout());

        alterarCorDeFundo("Amarelo");

        JButton yellowButton = new JButton("Amarelo");
        yellowButton.addActionListener(this);
        northPanel.add(yellowButton);

        JButton grennButton = new JButton("Verde");
        grennButton.addActionListener(this);
        northPanel.add(grennButton);

        JButton blueButton = new JButton("Azul");
        blueButton.addActionListener(this);
        northPanel.add(blueButton);

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void alterarCorDeFundo(String cor) {
        if (cor.equals("Amarelo")) {
            centerPanel.setBackground(Color.YELLOW);
        } 
        
        if (cor.equals("Verde")) {
            centerPanel.setBackground(Color.GREEN);
        } 
        
        if (cor.equals("Azul")) {
            centerPanel.setBackground(Color.BLUE);
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();
        String buttonText = sourceButton.getText();

        alterarCorDeFundo(buttonText);
    }
       
}