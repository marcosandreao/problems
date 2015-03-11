import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int C,N,P,Q;
		String I,O; //I=In, O=Out
		 /*C = Length in meters of Parking Lot
		 * N= Number of events (Arrivals or Departures)
		 * P = Vehicle Plate
		 * Q = Vehicle Length*/
		  
		Scanner read = new Scanner(System.in);
		System.out.printf("Enter [Length in Meters] and [Number of events] separated by a blank space, and HIT ENTER :");
		C = read.nextInt();
		N = read.nextInt();
		System.out.println(C + " "+ N);
		//System.exit(0);
	}

}
