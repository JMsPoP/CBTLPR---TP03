/*
 * CBTLPR2 (Java) - tp03
* 1. Construir o Form abaixo e possibilitar o cálculo das operações de
* divisão, multiplicação, subtração e adição.
* @author: João Marcos Teles Silva CB3026787
* @author: Leandro Felix
* OBS:
* • O botão C = Clear e limpa a memória da calculadora e também zera o text field
* de resultado.
* • Colocar tratamento de erros (try, catch, finally)
*/


import javax.swing.*; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//  Leandro Felix e João Marcos

public class Calculadora extends JFrame {
    private JTextField txtResultado; 
    private double num1, num2, resultado;
    private String operador;

    public Calculadora() {
        // Configurações da janela da calculadora
        setTitle("Calculadora"); 
        setSize(300, 400); // Tamanho
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o aplicativo ao fechar a janela
        setLayout(new BorderLayout()); // Layout com a área de resultados no topo e botões abaixo

        // Campo de resultado
        txtResultado = new JTextField();
        txtResultado.setEditable(false); 
        add(txtResultado, BorderLayout.NORTH); 


        // Painel de botões
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 5)); 

        // Definindo os textos dos botões
        String[] botoes = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"
        };

        // Criando e adicionando os botões ao painel
        for (String texto : botoes) {
            JButton botao = new JButton(texto); 
            botao.addActionListener(new BotaoClickListener()); 
            painel.add(botao); 
        }

        
        add(painel, BorderLayout.CENTER);
    }

    // Classe que trata o clique dos botões
    private class BotaoClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand(); 

            try {
                switch (comando) {
                    case "C": 
                        txtResultado.setText(""); 
                        num1 = num2 = resultado = 0; 
                        operador = "";
                        break;
                    case "=": 
                        num2 = Double.parseDouble(txtResultado.getText()); 
                        calcular();
                        txtResultado.setText(String.valueOf(resultado));
                        break;
                    case "+": 
                    case "-":
                    case "*":
                    case "/": 
                        num1 = Double.parseDouble(txtResultado.getText()); 
                        operador = comando; 
                        txtResultado.setText("");
                        break;
                    default: 
                        txtResultado.setText(txtResultado.getText() + comando);
                        break;
                }
            } catch (NumberFormatException ex) {
                // Caso o texto não seja um número válido
                JOptionPane.showMessageDialog(null, "Entrada inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                // Captura qualquer outra exceção não prevista
                JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } finally {
                System.out.println("Execução do cálculo finalizada.");
            }
        }
    }

    
    private void calcular() {
        switch (operador) {
            case "+":
                resultado = num1 + num2; 
                break;
            case "-":
                resultado = num1 - num2; 
                break;
            case "*":
                resultado = num1 * num2; 
                break;
            case "/":
                // Verifica se o divisor é zero
                if (num2 == 0) {
                    resultado = 0; // Se for zero, o resultado será 0
                } else {
                    resultado = num1 / num2;
                }
                break;
            default:
                throw new UnsupportedOperationException("Operação desconhecida."); // Caso o operador não seja reconhecido
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculadora calc = new Calculadora();
            calc.setVisible(true); 
        });
    }
}
