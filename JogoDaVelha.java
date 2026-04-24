import java.util.Scanner;

public class JogoDaVelha {
    private Jogador jogador1;
    private Jogador jogador2;
    private Tabuleiro tabuleiro;

    public JogoDaVelha(Jogador jogador1, Jogador jogador2, Tabuleiro tabuleiro) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tabuleiro = tabuleiro;
    }

    private void iniciar() {
        Scanner leitor = new Scanner(System.in);
        Jogador jogadorAtual = jogador1;
        boolean continuar = true;

        while (continuar) {
            tabuleiro.exibir();
            
            jogadorAtual.jogar(tabuleiro, leitor);

            if (tabuleiro.verificarVencedor(jogadorAtual.getSimbolo())) {
                tabuleiro.exibir();
                System.out.println("\nFim de jogo! " + jogadorAtual.getNome() + " venceu!");
                continuar = false;
            } else if (tabuleiro.estaCheio()) {
                tabuleiro.exibir();
                System.out.println("\nEmpate! O jogo deu velha.");
                continuar = false;
            } else {
                jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
            }
        }
        leitor.close();
    }

        public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o nome do Jogador 1 (X): ");
        String n1 = entrada.nextLine();
        Jogador j1 = new Jogador(n1, 'X', true); 

        System.out.print("Digite o nome do Jogador 2 (O): ");
        String n2 = entrada.nextLine();
        Jogador j2 = new Jogador(n2, 'O', true); 

        Tabuleiro tab = new Tabuleiro();

        JogoDaVelha jogoDaVelha = new JogoDaVelha(j1, j2, tab);
        jogoDaVelha.iniciar();

        entrada.close(); 
    }
}
