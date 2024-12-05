package events;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Layout2 extends JFrame implements ActionListener{
    private JPanel centerPanel = new JPanel();
    private JPanel northPanel = new JPanel();
    private JLabel display = new JLabel();
    
    public Layout2() {
        setLayout(new BorderLayout());

        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));

        alterarLabel("Java");
        
        centerPanel.add(criarBotao("Java"));
        centerPanel.add(criarBotao("JavaScript"));
        centerPanel.add(criarBotao("Python"));
        centerPanel.add(criarBotao("C++"));
        centerPanel.add(criarBotao("C#"));
        centerPanel.add(criarBotao("C"));
        
        northPanel.add(display);

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JButton criarBotao(String texto) {
        JButton button = new JButton(texto);
        button.addActionListener(this);

        return button;
    }

    private void alterarLabel(String text) {
        display.setText(text);
    }

    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();
        String buttonText = sourceButton.getText();

        alterarLabel(buttonText);
    }
}