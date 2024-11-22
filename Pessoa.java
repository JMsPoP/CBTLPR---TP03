/* 
 * CBTLPR2 (Java) - tp03
* @author: João Marcos Teles Silva CB3026787
* @author: Leandro Felix
Crie a estrutura de classes indicada abaixo
Pessoa
From default
# kp: static int
# nome: String
# sexo: char
# idade: int
+ Pessoa()
+ Pessoa(String, char, int)
+ setKp()
+ setNome(String)
+ setSexo(char)
+ setIdade(int)
+ getKp() : int
+ getNome() : String
+ getSexo() : char
+ getIdade() : int
*/
public class Pessoa {
    // A propriedade kp é estática e conta o número de instâncias criadas
    private static int kp = 0;

    private String nome;
    private char sexo;
    private int idade;

    // Construtor padrão
    public Pessoa() {
        kp++;  // Incrementa o contador sempre que uma nova instância é criada
    }

    // Construtor com parâmetros
    public Pessoa(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        kp++;  // Incrementa o contador sempre que uma nova instância é criada
    }

    // Métodos set
    public void setKp() {
        kp++;  // Método para incrementar manualmente o contador (se necessário)
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(char sexo) {
        // Verifica se o sexo é válido (M ou F)
        if (sexo == 'M' || sexo == 'F') {
            this.sexo = sexo;
        } else {
            System.out.println("Sexo inválido. Use 'M' ou 'F'.");
        }
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Métodos get
    public int getKp() {
        return kp;  // Retorna o contador de pessoas criadas
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }
}
