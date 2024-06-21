package metodos;

public class Time {
		
		private String nome;
		private int notaDesing;
		private int numeroVitorias;
		
		
		
		public Time() {
			super();
		}


		public Time(String nome, int notaDesing) {
			super();
			this.nome = nome;
			this.notaDesing = notaDesing;
			this.numeroVitorias =0;
		}

		

		public String pegarNome() {
			return nome;
		}


		public void definirNome(String nome) {
			this.nome = nome;
		}


		public int pegarNotaDesing() {
			return notaDesing;
		}


		public void definirNotaDesing(int notaDesing) {
			this.notaDesing = notaDesing;
		}


		public int pegarNumeroVitorias() {
			return numeroVitorias;
		}


		public void definirNumeroVitorias(int numeroVitorias) {
			this.numeroVitorias = numeroVitorias;
		}


}
