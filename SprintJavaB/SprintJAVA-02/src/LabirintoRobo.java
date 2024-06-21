import java.util.Scanner;

public class LabirintoRobo {

	public static void main(String[] args) {
		// Nessa versão do codigo agora temos a estrutura de repetição while onde o percurso so avança conforme as condições sejam validadas.
        // a bateria foi acrescentada onde além de ser gasta durante o percurso de forma tradicional,a cada erro no while é gasto 1 de bateria.
        // Cuidado com os erros, caso a bateria acabe o programa seja encerrado. Boa sorte

		int posicaoX=0;
        int posicaoY = 0;
        int bateria = 25;
		Scanner teclado = new Scanner(System.in);
		
		   System.out.println("Bem-vindo ao labirinto da morte!");
	        System.out.println("Analise o labirinto e tente fugir, pequeno robôzinho:");
		
	        
	     // Primeira etapa: andar 4 passos para a FRENTE
	        System.out.println("Etapa 1:");
	        String comando = "";
	        int distancia = 0;
	        while (!comando.equalsIgnoreCase("FRENTE") || distancia != 4) {
	            System.out.print("Digite o comando de direção (FRENTE): ");
	            comando = teclado.next().toUpperCase();
	            System.out.print("Digite a distância: ");
	            distancia = teclado.nextInt();
	       
	            if (comando.equalsIgnoreCase("FRENTE") && distancia == 4) {
	                posicaoX += distancia;
	                System.out.println("Você andou " + distancia + " passo(s) para a frente.");
	                bateria -= distancia;
	            } else {
	                System.out.println("Comando inválido. Tente novamente.");
	                bateria -= 1;
	                System.out.println("Bateria restante -->" + bateria);
	            }

	            if (bateria <= 0) {
	                System.out.println("Bateria esgotada. Você falhou.");
	                System.exit(0);
	            }
	        }
	        // Segunda etapa: andar 4 passos para a ESQUERDA
	        System.out.println("Etapa 2:");
	        comando = "";
	        distancia = 0;
	        while (!comando.equalsIgnoreCase("ESQUERDA") || distancia != 4) {
	            System.out.print("Digite o comando de direção (ESQUERDA): ");
	            comando = teclado.next().toUpperCase();
	            System.out.print("Digite a distância: ");
	            distancia = teclado.nextInt();

	            if (comando.equalsIgnoreCase("ESQUERDA") && distancia == 4) {
	                posicaoY -= distancia;
	                System.out.println("Você andou " + distancia + " passo(s) para a esquerda.");
	                bateria -= distancia;
	            } else {
	                System.out.println("Comando inválido. Tente novamente.");
	                bateria -= 1;
	                System.out.println("Bateria restante -->" + bateria);
	            }

	            if (bateria <= 0) {
	                System.out.println("Bateria esgotada. Você falhou.");
	                System.exit(0);
	            }
	        }
	        // Terceira etapa: andar 4 passos para a FRENTE
	        System.out.println("Etapa 3:");
	        comando = "";
	        distancia = 0;
	        while (!comando.equalsIgnoreCase("FRENTE") || distancia != 4) {
	            System.out.print("Digite o comando de direção (FRENTE): ");
	            comando = teclado.next().toUpperCase();
	            System.out.print("Digite a distância: ");
	            distancia = teclado.nextInt();

	            if (comando.equalsIgnoreCase("FRENTE") && distancia == 4) {
	                posicaoX += distancia;
	                System.out.println("Você andou " + distancia + " passo(s) para a frente.");
	                bateria -= distancia;
	            } else {
	                System.out.println("Comando inválido. Tente novamente.");
	                bateria -= 1;
	                System.out.println("Bateria restante -->" + bateria);
	            }

	            if (bateria <= 0) {
	                System.out.println("Bateria esgotada. Você falhou.");
	                System.exit(0);
	            }
	        }
	        // Quarta etapa: andar 4 passos para a DIREITA
	        System.out.println("Etapa 4:");
	        comando = "";
	        distancia = 0;
	        while (!comando.equalsIgnoreCase("DIREITA") || distancia != 4) {
	            System.out.print("Digite o comando de direção (DIREITA): ");
	            comando = teclado.next().toUpperCase();
	            System.out.print("Digite a distância: ");
	            distancia = teclado.nextInt();

	            if (comando.equalsIgnoreCase("DIREITA") && distancia == 4) {
	                posicaoY += distancia;
	                System.out.println("Você andou " + distancia + " passo(s) para a direita.");
	                bateria -= distancia;
	            } else {
	                System.out.println("Comando inválido. Tente novamente.");
	                bateria -= 1;
	                System.out.println("Bateria restante -->" + bateria);
	            }

	            if (bateria <= 0) {
	                System.out.println("Bateria esgotada. Você falhou.");
	                System.exit(0);
	            }
	        }
	        
	        //Quinta etapa : andar 4 passos para FRENTE
	        System.out.println("Etapa 5: Final");
	        comando="";
	        distancia=0;
	        while ( !comando.equalsIgnoreCase("FRENTE") || distancia!=4) {
	        	System.out.println("Digite o comando de direção (FRENTE):");
	        	comando=teclado.next().toUpperCase();
	        	System.out.println("Digite a distancia:");
	        	distancia=teclado.nextInt();
	        	
	        	if (comando.equalsIgnoreCase("FRENTE") && distancia ==4) {
					posicaoX += distancia;
					System.out.println("Voce andou " + distancia + "passo(s) para frente.");
					bateria-=distancia;
				} else {
					System.out.println("Comando invalido. Tente novamente.");
					bateria-=1;
					System.out.println("Bateria restante " + bateria);
				} if (bateria<=0) {
					System.out.println("Bateria esgotada. Voce falhou ");
					System.exit(0);
				}
	        	
	        }
	     // Exibindo a posição final
	        System.out.println("Parabéns! Você escapou do labirinto.");
	        System.out.println("Posição final: (" + posicaoX + ", " + posicaoY + ")");
	        System.out.println("Bateria restante: " + bateria);
	    
	


}
}
