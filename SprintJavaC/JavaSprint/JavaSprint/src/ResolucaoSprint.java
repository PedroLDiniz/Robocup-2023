import java.util.Random;
import java.util.Scanner;

public class ResolucaoSprint {

	public static void main(String[] args) {
		
		
		Random rm = new Random();
        Scanner teclado = new Scanner(System.in);

        // Declaração das variaveis 
        int qtdEquipe;
        boolean achei;

        System.out.println("Bem-Vindos à competição RoboCup: Vença e seja melhor robô");

        // usuário digita a quantidade de equipes que participarão do campeonato
        System.out.println("Informe o número de equipes que participarão do campeonato ");
        qtdEquipe = teclado.nextInt();
        
        // A quantidade de equipes define o tamanho do vetor
        int[] numeroEquipe = new int[qtdEquipe];
        int[] notaDesign = new int[qtdEquipe];
        int[] pontuacao = new int[qtdEquipe];

        // pequena validação, pois a quantidade de equipes não pode ser menor ou igual a duas
        if (qtdEquipe <= 1) {
            System.out.println("Precisa haver mais de 1 equipe para ocorrer a competição!");
        } else {
            // Gerando números aleatórios para as equipes e solicitando notas de design
            for (int i = 0; i < qtdEquipe; ) {
            	numeroEquipe[i] = rm.nextInt(89) + 11; // Temos o mais 11 para que o intervalo comece em 11 e va ate 99
            	
            	
            	//	Abaixo fazemos uma verificação para que não se repitam os numeros da euipe
                achei = false;
                for (int j = 0; j < i; j++) {
                    if (numeroEquipe[j] == numeroEquipe[i]) {
                        achei = true;
                        break;
                    }
                }
                if (!achei) {
                    System.out.println("Equipe #" + numeroEquipe[i]);
                    System.out.println("Digite a nota de Design da equipe (0 - 10): ");
                    notaDesign[i] = teclado.nextInt();
                    i++;
                }
            }

            // Solicita a quantidade de batalhas que o robô lutou
            int qtdBatalha;

            System.out.println("Informe quantas batalhas seu robô lutou ");
            qtdBatalha = teclado.nextInt();

            // Calcula pontuações 
            for (int i = 0; i < qtdEquipe; i++) {
                int somaPonto = 0;
                for (int j = 0; j < qtdBatalha; j++) {
                    System.out.println("Informe o resultado da equipe #" + numeroEquipe[i] + " na batalha " + (j + 1) + " (V/D/E): ");
                    String resultado = teclado.next();
                    // vitoria vale 5/ derrota vale 0 / empate vale 3 pontos
                    if (resultado.equalsIgnoreCase("V")) {
                        somaPonto += 5;
                    } else if (resultado.equalsIgnoreCase("D")) {
                        somaPonto += 0;
                    } else if (resultado.equalsIgnoreCase("E")) {
                        somaPonto += 3;
                    }
                }
                // o vetor armazena a pontuação
                pontuacao[i] = somaPonto;
            }

            // Ordenação da lista de classificação com base na pontuação e no critério de desempate
            for (int i = 0; i < qtdEquipe - 1; i++) {
                for (int j = i + 1; j < qtdEquipe; j++) {
                    if (pontuacao[i] < pontuacao[j] || (pontuacao[i] == pontuacao[j] && notaDesign[i] < notaDesign[j])) {
                        // Troca de posição
                    	
                    	// A variavel tempPontuação é auxiliar para salvar os valores 
                        int tempPontuacao = pontuacao[i];
                        // aqui salvamos o valor armazenado na Variavel auxiliar  e atualizamos ela
                        pontuacao[i] = pontuacao[j];
                        
                        
                        
                        // Define a pontuação da outra equipe com a pontuação armazenada temporariamente
                        
                        pontuacao[j] = tempPontuacao;
                        //abaixo fazemos o mesmo processo para o  numero da equipe e da nota de design
                        int tempNumeroEquipe = numeroEquipe[i];
                        numeroEquipe[i] = numeroEquipe[j];
                        numeroEquipe[j] = tempNumeroEquipe;

                        int tempNotaDesign = notaDesign[i];
                        notaDesign[i] = notaDesign[j];
                        notaDesign[j] = tempNotaDesign;
                    }
                }
            }

            // Impressão da lista de classificação
            System.out.println("Classificação da maior pontuação até a menor:");
            for (int i = 0; i < qtdEquipe; i++) {
                System.out.println("Equipe #" + numeroEquipe[i] + " - Pontuação: " + pontuacao[i] + " - Nota de Design: " + notaDesign[i]);
            }
        }

	}

}
