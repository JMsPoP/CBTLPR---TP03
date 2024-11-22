/* 
 * CBTLPR2 (Java) - tp03
* @author: João Marcos Teles Silva CB3026787
* @author: Leandro Felix

O campo “Sexo” só deve aceitar “M” ou “F”.
Quando se pressionar o botão “OK” os dados digitados deverão ser transferidos
ao objeto “UmaPessoa”, uma instância da classe Pessoa.
Quando se pressionar o botão “Mostrar” descarregar os dados do objeto
“UmaPessoa” inclusive o contador “kp”.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPessoa extends JFrame {
    private JTextField nomeField;
    private JTextField idadeField;
    private JTextField sexoField;
    private JTextField numeroField;
    private JButton okButton;
    private JButton mostrarButton;
    
    private Pessoa umaPessoa;  // Instância da classe Pessoa
    
    public FormPessoa() {
        // Definir título da janela
        setTitle("Cadastro de Pessoa");

        // Definir layout
        setLayout(new GridLayout(5, 2, 10, 10));

        // Labels e campos
        add(new JLabel("Número:"));
        numeroField = new JTextField();
        numeroField.setEditable(false);
        add(numeroField);

        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Sexo (M/F):"));
        sexoField = new JTextField();
        add(sexoField);

        add(new JLabel("Idade:"));
        idadeField = new JTextField();
        add(idadeField);

        // Botões
        okButton = new JButton("OK");
        mostrarButton = new JButton("Mostrar");

        add(okButton);
        add(mostrarButton);

        // Ação do botão OK
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                char sexo = sexoField.getText().charAt(0);  // Assumindo que o sexo está em um único caractere
                int idade = Integer.parseInt(idadeField.getText());

                // Criação de uma nova instância de Pessoa com os dados preenchidos
                umaPessoa = new Pessoa(nome, sexo, idade);

                // Atualiza o número (kp) na interface
                numeroField.setText(String.valueOf(umaPessoa.getKp()));

                // Limpar os campos para uma nova entrada
                nomeField.setText("");
                sexoField.setText("");
                idadeField.setText("");
            }
        });

        // Ação do botão Mostrar
        mostrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (umaPessoa != null) {
                    // Exibe os dados da pessoa
                    JOptionPane.showMessageDialog(null, 
                        "Número: " + umaPessoa.getKp() + "\n" +
                        "Nome: " + umaPessoa.getNome() + "\n" +
                        "Sexo: " + umaPessoa.getSexo() + "\n" +
                        "Idade: " + umaPessoa.getIdade(),
                        "Dados da Pessoa", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Configurações da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);  // Centraliza a janela
    }

    public static void main(String[] args) {
        // Iniciar a interface gráfica
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FormPessoa().setVisible(true);
            }
        });
    }
}
