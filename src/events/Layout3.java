package events;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Layout3 extends JFrame implements ActionListener{
    
    JTextField text = new JTextField(15);
    JButton button = new JButton("Enviar");

    public Layout3() {
        setLayout(new FlowLayout());
        button.addActionListener(this);

        add(text);
        add(button);
        
        setSize(500, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String dialogString = text.getText();

        JOptionPane.showMessageDialog(null, dialogString, "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}