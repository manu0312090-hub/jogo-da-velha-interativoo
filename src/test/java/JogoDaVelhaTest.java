import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class JogoDaVelhaTest {
    
    @Test
    void verificarJogador() {
        // Seu Jogador pede 3 coisas: Nome, Simbolo, ehHumano
        Jogador jogador = new Jogador("Teste", 'X', true);
        assertEquals('X', jogador.getSimbolo());
    }

    @Test
    void verificarTabuleiro() {
        Tabuleiro tabuleiro = new Tabuleiro();
        // O método no seu Tabuleiro.java se chama estaCheio()
        assertFalse(tabuleiro.estaCheio());
    }
}