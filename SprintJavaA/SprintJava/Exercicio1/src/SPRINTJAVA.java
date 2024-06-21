import java.util.Scanner;

public class SPRINTJAVA {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int distancia = 0;
        String comando = "";
        int posicaoX = 0;
        int posicaoY = 0;
        
        
        
        
        System.out.println("Bem-vindo ao labirinto da morte!");
        System.out.println("Analise o labirinto e tente fugir, Pequeno robozinho:");

        // Primeira etapa: andar 4 passos para a FRENTE
        System.out.print("Digite o comando de direção: ");
        comando = teclado.next();
        if (comando.equals("frente")) {
            System.out.print("Digite a quantidade de passos: ");
            distancia = teclado.nextInt();
            if (distancia == 4) {
                posicaoX += distancia;
                System.out.println("Você andou " + distancia + " passos para a frente.");
            } else {
                System.out.println("Você falhou");
                System.exit(0);
            }
        } else {
            System.out.println("tente novamente");
            System.exit(0);
        }

        // Segunda etapa: andar 4 passos para ESQUERDA
        System.out.print("Digite o comando de direção ");
        comando = teclado.next();
        if (comando.equals("esquerda")) {
            System.out.print("Digite a quantidade de passos: ");
            distancia = teclado.nextInt();
            if (distancia == 4) {
                posicaoY += distancia;
                System.out.println("Você andou " + distancia + " passos para Esquerda.");
            } else {
                System.out.println("Você falhou");
                System.exit(0);
            }
        } else {
            System.out.println("tente novamente");
            System.exit(0);
        }

        // Terceira etapa: andar 4 passos para a FRENTE
        System.out.print("Digite o comando de direção ");
        comando = teclado.next();
        if (comando.equals("frente")) {
            System.out.print("Digite a quantidade de passos: ");
            distancia = teclado.nextInt();
            if (distancia == 4) {
                posicaoX += distancia;
                System.out.println("Você andou " + distancia + " passos para a Frente.");
            } else {
                System.out.println("Você falhou");
                System.exit(0);
            }
        } else {
            System.out.println("Tente novamente");
            System.exit(0);
        }

        // Quarta etapa: andar 4 passos para Direita
        System.out.print("Digite o comando de direção");
        comando = teclado.next();
        if (comando.equals("direita")) {
            System.out.print("Digite a quantidade de passos: ");
            distancia = teclado.nextInt();
            if (distancia == 4) {
                posicaoY -= distancia;
                System.out.println("Você andou " + distancia + " passos para direita" );
            } else {
            	System.out.println("Voce chegou perto mas falhou");
            	
            }
            // Quinta etapa: andar 4 passos para frente
            System.out.print("Digite o comando de direção");
            comando = teclado.next();
            if (comando.equals("frente")) {
                System.out.print("Digite a quantidade de passos: ");
                distancia = teclado.nextInt();
                if (distancia == 4) {
                    posicaoY -= distancia;
                    System.out.println("Parabens pequeno robô, você escapou" );
                } else {
                	System.out.println("Você quase chegou, mas falhou");
                }
            
        }
    }
}
}