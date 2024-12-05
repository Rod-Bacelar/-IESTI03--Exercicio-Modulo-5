package events;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Layout4 extends JFrame implements ActionListener{
    List<Integer> numeros = new ArrayList<>();
    
    JTextField text = new JTextField(15);
    JTextField maiorLabel = new JTextField(10); 
    JTextField menorLabel = new JTextField(10); 
    JTextField mediaLabel = new JTextField(10); 

    public Layout4() {
        setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        JPanel eastPanel = new JPanel();

        JLabel labelDigitar = new JLabel("Digite o Número: ");
        
        JButton buttonOK = new JButton("OK");
        buttonOK.addActionListener(this);

        JPanel input = new JPanel();
        input.add(text);
        input.add(buttonOK);

        centerPanel.add(labelDigitar);
        centerPanel.add(input);
        centerPanel.add(criarResultado("Maior >>>>", maiorLabel));
        centerPanel.add(criarResultado("Menor >>>>", menorLabel));
        centerPanel.add(criarResultado("Média >>>>", mediaLabel));

        alterarResultados();
        
        add(centerPanel, BorderLayout.CENTER);
        
        JButton buttonExibir = new JButton("Exibir");
        buttonExibir.addActionListener(this);

        
        eastPanel.add(buttonExibir);
        add(eastPanel, BorderLayout.EAST);

        
        setSize(500, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    private void alterarResultados() {
        int maior = 0;
        int menor = 0;
        int soma = 0;
        int media = 0;

        if (numeros.size() > 0) {
            maior = numeros.get(0);
            menor = numeros.get(0);

            for (int num : numeros) {
                if (num > maior) {
                    maior = num;
                }
                if (num < menor) {
                    menor = num;
                }
                soma += num;
            }

            media = soma / numeros.size();
        }


        maiorLabel.setText(String.valueOf(maior));
        menorLabel.setText(String.valueOf(menor));
        mediaLabel.setText(String.valueOf(media));
    }

    private JPanel criarResultado(String text, JTextField textField) {
        JPanel painel = new JPanel();

        painel.add(new JLabel(text));
        textField.setEditable(false);
        painel.add(textField);

        return painel;
    }

    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();
        String buttonPressed = sourceButton.getText();

        if (buttonPressed.equals("OK")) {
            int numero = Integer.parseInt(text.getText());
            numeros.add(numero);

            text.setText("");
            System.out.println("Lista de números: " + numeros);
        }

        if (buttonPressed.equals("Exibir")) {
            alterarResultados();
        }
    }
}