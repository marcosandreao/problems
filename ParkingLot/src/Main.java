import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static final int PRECO_POR_CARRO = 10;

	public static void main(String[] args) {

		final List<Car> carrosEstacionados = new ArrayList<Main.Car>();
		
		int espacoTotal = 0;
		
		int quantidadeDeEvento = 0;
		
		boolean configurarEstacionamento = true;
		
		final Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			String line = in.nextLine();
			if (configurarEstacionamento) {
				final String values[] = line.split(" ");
				espacoTotal = Integer.parseInt(values[0]);
				quantidadeDeEvento = Integer.parseInt(values[1]);
				configurarEstacionamento = false;
			} else {
				quantidadeDeEvento --;
				final String values[] = line.split(" ");
				final String operacao = values[0];
				final String placa = values[1];
				boolean entrada = operacao.equalsIgnoreCase("C");
				
				int metro = entrada? Integer.parseInt(values[2]) : 0;

				final Car car = new Car(placa, metro);
				
				if ( entrada ) {
					if ( podeEntrar(espacoTotal, carrosEstacionados, car) ){
						carrosEstacionados.add(car);
					} 
				} else {
					carrosEstacionados.remove(car);
				}
				
				if ( quantidadeDeEvento == 0 ) {
					configurarEstacionamento = true;
					System.out.println(carrosEstacionados.size() * PRECO_POR_CARRO);
					carrosEstacionados.clear();
				}
			}
		}
		in.close();
	}

	private static boolean podeEntrar(int espacoTotal, final List<Car> carrosEstacionados,
			final Car car) {
		if ( !carrosEstacionados.contains(car) ) {
			int totalVagasOcupadas = 0;
			for ( Car carroEstacionado : carrosEstacionados ) {
				totalVagasOcupadas += carroEstacionado.comprimento;
			}
			if ( ( totalVagasOcupadas + car.comprimento ) <= espacoTotal ) {
				return true;
			}
		}
		return false;
	}

	private static class Car {

		private String placa;
		private int comprimento;

		public Car(String placa, int comprimento) {
			this.placa = placa;
			this.comprimento = comprimento;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((placa == null) ? 0 : placa.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Car other = (Car) obj;
			if (placa == null) {
				if (other.placa != null)
					return false;
			} else if (!placa.equals(other.placa))
				return false;
			return true;
		}

	}

}
