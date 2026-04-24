import java.util.Arrays;

public class Tabuleiro {
    private char[][] grade;

    public Tabuleiro() {
        grade = new char[3][3];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(grade[i], ' '); 
        }
    }

    public void exibir() {
        System.out.println("\n   0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grade[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("   -----");
        }
    }

    public boolean fazerJogada(int linha, int coluna, char simbolo) {
        if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && grade[linha][coluna] == ' ') {
            grade[linha][coluna] = simbolo;
            return true;
        }
        return false;
    }

    public boolean verificarVencedor(char s) {
        for (int i = 0; i < 3; i++) {
            if ((grade[i][0] == s && grade[i][1] == s && grade[i][2] == s) ||
                (grade[0][i] == s && grade[1][i] == s && grade[2][i] == s)) {
                return true;
            }
        }
        return (grade[0][0] == s && grade[1][1] == s && grade[2][2] == s) ||
               (grade[0][2] == s && grade[1][1] == s && grade[2][0] == s);
    }

    public boolean estaCheio() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grade[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
