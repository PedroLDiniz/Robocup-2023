package Resolucao;

import java.util.Random;
import java.util.Scanner;

import metodos.Time;

public class Programa {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		Random rd = new Random();
		String nome; 
		int qtdEquipes, nota, notaRandom1,notaRandom2,notaRandom3,notaRandom4;
		int z=0;
		
		System.out.println("Informe quantas equipes vao participar da disputa ");
		qtdEquipes=teclado.nextInt();
		
		Time times[] = new Time [qtdEquipes];
		
		
		// pegar nome e nota de design de cada equipe e robo --> 
		for(int i =0 ; i<qtdEquipes ; i++) {
			System.out.println("Informe o nome da equipe ");
			nome=teclado.next();
			do {
				System.out.println("Digite a nota de design do robo");
				nota= teclado.nextInt();
				if (nota <0 || nota >10) {
					System.out.println("Nota invalida");
				}
			}while (nota <0 || nota >10);
			Time time = new Time(nome, nota );
			times[i] = time ;
		}
		
		// Batalha de todos contra todos --> vitoria para o vencedor ->
		for (int i = 0 ; i<qtdEquipes ; i++) {
			for(int j = i +1 ;j<qtdEquipes ;j++) {
				System.out.println("Luta --> " +z+ " : ");
				
				//nota robo 01 --> 
				notaRandom1 = rd.nextInt(10);
				System.out.println("Nome da equipe : " + times[j].pegarNome());
				System.out.println(" Nota : " + notaRandom1);
				
				// nota robo 02 --> 
				notaRandom2 = rd.nextInt(10);
				System.out.println("Nome da equipe : " + times[j].pegarNome());
				System.out.println("Nota : " + notaRandom2);
				
				
				if (notaRandom1 ==notaRandom2 ) {
					System.out.println("LUTA DE DESEMPATE --> ");
					// nota desempate robo 01 --> 
					notaRandom3 = rd.nextInt(10);
					System.out.println("Nome da equipe : " + times[i].pegarNome());
					System.out.println("Nota : " + notaRandom3);
					
					// nota desempate robo 02 --> 
					notaRandom4 = rd.nextInt(10);
					System.out.println("Nome da equipe : " + times[j].pegarNome());
					System.out.println("Nota : " + notaRandom4);
					
					if (notaRandom3>notaRandom4) {
						System.out.println("Equipe vencedora é :" + times[i].pegarNome());
						times[i].definirNumeroVitorias(times[i].pegarNumeroVitorias()+1);
					}else {
						System.out.println("Equipe vencedora é :" + times[j].pegarNome());
						times[j].definirNumeroVitorias(times[j].pegarNumeroVitorias()+1);
					}
				}
				if (notaRandom1>notaRandom2) {
					System.out.println("Equipe vencedora é :" + times[i].pegarNome());
					times[i].definirNumeroVitorias(times[i].pegarNumeroVitorias()+1);
				}if (notaRandom1<notaRandom2) {
					System.out.println("Equipe vencedora é :" + times[j].pegarNome());
					times[j].definirNumeroVitorias(times[j].pegarNumeroVitorias()+1);
				}
				z++;
			}
		}
		
		//ordenando os times --> 
		Time aux = new Time();
		for(int i = 0 ; i<qtdEquipes - 1 ; i++) {
			for(int j = 0 ; j<qtdEquipes - 1 ;j++) {
				if (times[j].pegarNumeroVitorias()<times[j+1].pegarNumeroVitorias()) {
					aux.definirNome(times[j].pegarNome());
					aux.definirNotaDesing(times[j].pegarNotaDesing());
					aux.definirNumeroVitorias(times[j].pegarNumeroVitorias());
					
					
					times[j].definirNome(times[j+1].pegarNome());
					times[j].definirNumeroVitorias(times[j+1].pegarNumeroVitorias());
					times[j].definirNotaDesing(times[j+1].pegarNotaDesing());
					
					times[j+1].definirNome(aux.pegarNome());
					times[j+1].definirNumeroVitorias(aux.pegarNumeroVitorias());
					times[j+1].definirNotaDesing(aux.pegarNotaDesing());
					
				}else if (times[j].pegarNumeroVitorias()== times[j+1].pegarNumeroVitorias()) {
					if (times[j].pegarNotaDesing()<times[j+1].pegarNotaDesing()) {
						aux.definirNome(times[j].pegarNome());
						aux.definirNotaDesing(times[j].pegarNotaDesing());
						aux.definirNumeroVitorias(times[j].pegarNumeroVitorias());
						
						
						times[j].definirNome(times[j+1].pegarNome());
						times[j].definirNumeroVitorias(times[j+1].pegarNumeroVitorias());
						times[j].definirNotaDesing(times[j+1].pegarNotaDesing());
						
						
						times[j+1].definirNome(aux.pegarNome());
						times[j+1].definirNumeroVitorias(aux.pegarNumeroVitorias());
						times[j+1].definirNotaDesing(aux.pegarNotaDesing());
					}
					
				}
			}
		}
		
		System.out.println("Classificacao dos robos --> ");
		for(int i = 0 ; i<qtdEquipes ; i++) {
			System.out.println(times[i].pegarNome());
			System.out.println(times[i].pegarNumeroVitorias());
			System.out.println(times[i].pegarNotaDesing());
		}
		
		// Top 03 robos --> 
		
		Time timesfinalistas[] = new Time [3];
		for(int i = 0 ; i<3;i++) {
			timesfinalistas[i]= times[i];
			timesfinalistas[i].definirNumeroVitorias(0);
		}
		
		// lutas finais dos robos finalistas 
		
		for(int i = 0 ; i<timesfinalistas.length;i++) {
			for(int j = i+1 ; j<timesfinalistas.length;j++) {
				System.out.println("Luta : " + z+ "--> ");
				
				// nota robo 01 --> 
				notaRandom1=rd.nextInt(10);
				System.out.println("Nome da Equipe : " + timesfinalistas[i].pegarNome());
				System.out.println("Nota " + notaRandom1);
				
				
				// nota robo 02 --> 
				notaRandom2=rd.nextInt(10);
				System.out.println("Nome da Equipe : " + timesfinalistas[j].pegarNome());
				System.out.println("Nota " + notaRandom2);
				
				if (notaRandom1 == notaRandom2) {
					System.out.println("LUTA DE DESEMPATE --> ");
					
					// nota de desempate robo 01 --> 
					notaRandom3=rd.nextInt(10);
					System.out.println("Nome da Equipe : " + timesfinalistas[i].pegarNome());
					System.out.println("Nota: " + notaRandom3);
					
					
					// nota de desempate robo 02 --> 
					notaRandom4=rd.nextInt(10);
					System.out.println("Nome da Equipe : " + timesfinalistas[j].pegarNome());
					System.out.println("Nota: " + notaRandom4);
					
					
					if (notaRandom3==notaRandom4) {
						System.out.println("empate ");
						timesfinalistas[i].definirNumeroVitorias(timesfinalistas[i].pegarNumeroVitorias()+1);
						timesfinalistas[j].definirNumeroVitorias(timesfinalistas[j].pegarNumeroVitorias()+1);
					}else if (notaRandom3>notaRandom4) {
						System.out.println("Equipe vencedora:" + timesfinalistas[i].pegarNome());
						timesfinalistas[i].definirNumeroVitorias(timesfinalistas[i].pegarNumeroVitorias()+2);
					}else {
						System.out.println("Equipe vencedora : " + timesfinalistas[j].pegarNome());
						timesfinalistas[j].definirNumeroVitorias(timesfinalistas[j].pegarNumeroVitorias()+2);
					}
				}
				if (notaRandom1>notaRandom2) {
					System.out.println("Equipe vencedora :" + timesfinalistas[i].pegarNome());
					timesfinalistas[i].definirNumeroVitorias(timesfinalistas[i].pegarNumeroVitorias()+2);
				}if (notaRandom1<notaRandom2) {
					System.out.println("Equipe vencedora :" + timesfinalistas[j].pegarNome());
					timesfinalistas[j].definirNumeroVitorias(timesfinalistas[j].pegarNumeroVitorias()+2);
				}
				z++;
			}
		}
		// Ordenando os times --> 
		for(int i = 0 ; i<timesfinalistas.length -1;i++) {
			for(int j = 0 ; j<timesfinalistas.length - 1;j++) {
				if (timesfinalistas[j].pegarNumeroVitorias()< timesfinalistas[j+1].pegarNumeroVitorias()) {
					aux.definirNome(timesfinalistas[j].pegarNome());
					aux.definirNotaDesing(timesfinalistas[j].pegarNotaDesing());
					aux.definirNumeroVitorias(timesfinalistas[j].pegarNumeroVitorias());
					
					
					timesfinalistas[j].definirNome(timesfinalistas[j+1].pegarNome());
					timesfinalistas[j].definirNumeroVitorias(timesfinalistas[j+1].pegarNumeroVitorias());
					timesfinalistas[j].definirNotaDesing(timesfinalistas[j+1].pegarNotaDesing());
					
					
					
					timesfinalistas[j+1].definirNome(aux.pegarNome());
					timesfinalistas[j+1].definirNumeroVitorias(aux.pegarNumeroVitorias());
					timesfinalistas[j+1].definirNotaDesing(aux.pegarNotaDesing());
					
				}else if (timesfinalistas[j].pegarNumeroVitorias()==timesfinalistas[j+1].pegarNumeroVitorias()) {
					if (timesfinalistas[j].pegarNotaDesing()<timesfinalistas[j+1].pegarNotaDesing()) {
						aux.definirNome(timesfinalistas[j].pegarNome());
						aux.definirNotaDesing(timesfinalistas[j].pegarNotaDesing());
						aux.definirNumeroVitorias(timesfinalistas[j].pegarNumeroVitorias());
						
						
						timesfinalistas[j].definirNome(timesfinalistas[j+1].pegarNome());
						timesfinalistas[j].definirNotaDesing(timesfinalistas[j+1].pegarNotaDesing());
						timesfinalistas[j].definirNumeroVitorias(timesfinalistas[j+1].pegarNumeroVitorias());
						
						timesfinalistas[j+1].definirNome(aux.pegarNome());
						timesfinalistas[j+1].definirNumeroVitorias(aux.pegarNumeroVitorias());
						timesfinalistas[j+1].definirNotaDesing(aux.pegarNotaDesing());
					}
				}
			}
		}
		int j = 1;
		System.out.println("Classificação --> ");
		for ( int i = 0 ; i<timesfinalistas.length;i++) {
			System.out.println(j + " : " + timesfinalistas[i].pegarNome()+ ". com : " + timesfinalistas[i].pegarNumeroVitorias()+ "vitorias, e sua nota de design é " + timesfinalistas[i].pegarNotaDesing());
			j++;
		}
		System.out.println("O time vencedor do torneio " + timesfinalistas[0].pegarNome() );
		
	}

}
