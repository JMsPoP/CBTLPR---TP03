/* 
 * CBTLPR2 (Java) - tp03
* @author: João Marcos Teles Silva CB3026787
* @author: Leandro Felix
Versão 02
Refaça o exercício anterior, porém agora o sexo não deve ser digitado através de
um TextField e sim escolhido através de um componente do tipo “JComboBox”.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPessoa2 extends JFrame {
    private JTextField nomeField;
    private JTextField idadeField;
    private JComboBox<String> sexoComboBox;  // Usando JComboBox para sexo
    private JTextField numeroField;
    private JButton okButton;
    private JButton mostrarButton;
    
    private Pessoa umaPessoa;  // Instância da classe Pessoa
    
    public FormPessoa2() {
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
        sexoComboBox = new JComboBox<>(new String[]{"M", "F"});  // Opções de sexo
        add(sexoComboBox);

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
                // Obtém o valor selecionado no JComboBox
                char sexo = (char) sexoComboBox.getSelectedItem();
                
                // Se necessário, verifique se a opção é válida
                if (sexo != 'M' && sexo != 'F') {
                    JOptionPane.showMessageDialog(null, "Sexo inválido. Use 'M' ou 'F'.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int idade = 0;
                try {
                    idade = Integer.parseInt(idadeField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Idade inválida. Digite um número.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Criação de uma nova instância de Pessoa
                umaPessoa = new Pessoa(nome, sexo, idade);
                numeroField.setText(String.valueOf(umaPessoa.getKp()));

                nomeField.setText("");
                idadeField.setText("");
                sexoComboBox.setSelectedIndex(0);  // Reseta o ComboBox para a primeira opção
            }
        });

        // Ação do botão Mostrar
        mostrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (umaPessoa == null) {
                    JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, 
                        "Número: " + umaPessoa.getKp() + "\n" +
                        "Nome: " + umaPessoa.getNome() + "\n" +
                        "Sexo: " + umaPessoa.getSexo() + "\n" +
                        "Idade: " + umaPessoa.getIdade(),
                        "Dados da Pessoa", JOptionPane.INFORMATION_MESSAGE);
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
