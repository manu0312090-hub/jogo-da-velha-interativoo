import java.util.Random;
import java.util.Scanner;

public class Jogador {
    private String nome;
    private char simbolo;
    private boolean ehHumano;

    public Jogador(String nome, char simbolo, boolean ehHumano) {
        this.nome = nome;
        this.simbolo = simbolo;
        this.ehHumano = ehHumano;
    }

    public String getNome() { 
        return nome; 
    }

    public char getSimbolo() { 
        return simbolo; 
    }

    public void jogar(Tabuleiro tabuleiro, Scanner sc) {
        if (ehHumano) {
            int l, c;
            while (true) {
                try {
                    System.out.print(nome + " (" + simbolo + "), digite linha e coluna (0 a 2): ");
                    l = sc.nextInt();
                    c = sc.nextInt();
                    if (tabuleiro.fazerJogada(l, c, simbolo)) {
                        break;
                    }
                    System.out.println("Posição ocupada ou inválida! Tente novamente.");
                } catch (Exception e) {
                    System.out.println("Entrada inválida! Digite números de 0 a 2.");
                    sc.nextLine(); 
                }
            }
        } else {
            Random rand = new Random();
            while (true) {
                int l = rand.nextInt(3);
                int c = rand.nextInt(3);
                if (tabuleiro.fazerJogada(l, c, simbolo)) {
                    System.out.println(nome + " (Máquina) jogou em: " + l + "," + c);
                    break;
                }
            }
        }
    }
}