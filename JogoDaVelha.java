import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        Tabuleiro tabuleiro = new Tabuleiro();
        
        System.out.println("--- JOGO DA VELHA INTERATIVO ---");
        System.out.print("Escolha seu símbolo (X ou O): ");
        char simboloHumano = sc.next().toUpperCase().charAt(0);
        char simboloMaquina = (simboloHumano == 'X') ? 'O' : 'X';

        Jogador j1 = new Jogador("Jogador 1", simboloHumano, true);
        Jogador j2 = new Jogador("Jogador 2", simboloMaquina, false);

        Jogador atual = j1;
        boolean jogoAtivo = true;

        tabuleiro.exibir();

        while (jogoAtivo) {
            System.out.println("\nVez de: " + atual.getNome());
            atual.jogar(tabuleiro, sc); 
            tabuleiro.exibir();

            if (tabuleiro.verificarVencedor(atual.getSimbolo())) {
                System.out.println("\nO " + atual.getNome() + " ganhou");
                jogoAtivo = false;
            } else if (tabuleiro.estaCheio()) {
                System.out.println("\nO jogo terminou empatado.");
                jogoAtivo = false;
            }

    
            atual = (atual == j1) ? j2 : j1;
        }

        System.out.println("\nCriado por Emanuelle Donato");
        
        sc.close();
    }
}