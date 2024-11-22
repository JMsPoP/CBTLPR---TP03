/* 
 * CBTLPR2 (Java) - tp03
* @author: João Marcos Teles Silva CB3026787
* @author: Leandro Felix
Versão 03
Refaça o exercício anterior, porém agora usando um componente do tipo
“JRadioButton”.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPessoa3 extends JFrame {
    private JTextField nomeField;
    private JTextField idadeField;
    private JRadioButton masculinoRadioButton;  // JRadioButton para sexo masculino
    private JRadioButton femininoRadioButton;    // JRadioButton para sexo feminino
    private JTextField numeroField;
    private JButton okButton;
    private JButton mostrarButton;
    
    private Pessoa umaPessoa;  // Instância da classe Pessoa
    
    public FormPessoa3() {
        // Definir título da janela
        setTitle("Cadastro de Pessoa");

        // Definir layout
        setLayout(new GridLayout(6, 2, 10, 10));

        // Labels e campos
        add(new JLabel("Número:"));
        numeroField = new JTextField();
        numeroField.setEditable(false);
        add(numeroField);

        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Sexo:"));
        
        // Criando os JRadioButtons para Masculino e Feminino
        masculinoRadioButton = new JRadioButton("Masculino");
        femininoRadioButton = new JRadioButton("Feminino");

        // Agrupando os JRadioButtons para garantir que apenas um possa ser selecionado
        ButtonGroup sexoGroup = new ButtonGroup();
        sexoGroup.add(masculinoRadioButton);
        sexoGroup.add(femininoRadioButton);

        // Adicionando os JRadioButtons ao layout
        JPanel sexoPanel = new JPanel();
        sexoPanel.add(masculinoRadioButton);
        sexoPanel.add(femininoRadioButton);
        add(sexoPanel);

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
                
                // Verificando qual JRadioButton foi selecionado
                char sexo = ' ';
                if (masculinoRadioButton.isSelected()) {
                    sexo = 'M';
                } else if (femininoRadioButton.isSelected()) {
                    sexo = 'F';
                }

                if (sexo == ' ') {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione o sexo.", "Erro", JOptionPane.ERROR_MESSAGE);
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
                masculinoRadioButton.setSelected(false);
                femininoRadioButton.setSelected(false);  // Limpa a seleção
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
        setSize(300, 250);
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
