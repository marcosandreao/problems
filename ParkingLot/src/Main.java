import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int C = 0,N = 0,P,Q, price=0;
		//int[] arrayVehicle = new int[3];
		int[][] arrayVehicle; 
		String e; //e=type of event
		 /*C = Length in meters of Parking Lot
		 * N= Number of events (Arrivals or Departures)
		 * P = Vehicle Plate
		 * Q = Vehicle Length*/
		  
		Scanner read = new Scanner(System.in);
		System.out.printf("Enter [Length in Meters] and [Number of events] separated by a blank space, and HIT ENTER :\n");
				
		while ((C < 1) || (C>1000))  {
			C = read.nextInt();
			N = read.nextInt();	
			
		}
		
		//System.out.println(C + " "+ N);
		arrayVehicle= new int[N][3];
		for (int i=1;i<=N;i++){
			
				e= read.next(); //e=type of event
				//P=read.nextInt(); //License Plate
				//Q=read.nextInt(); // Car Length
			
				if (e.equals("C")){
					P=read.nextInt(); //License Plate
					Q=read.nextInt(); // Car Length
					if (Q <= C){
						C=C-Q;
						
						arrayVehicle[i-1][0] = i ; 
						arrayVehicle[i-1][1] = P ;
						arrayVehicle[i-1][2] = Q ;
						price += 10; //a car arrives and total price is incremented
						
					}	
				}
				if (e.equals("S")){ 
					P=read.nextInt(); //License Plate
					for (int x = 1; x < arrayVehicle.length; x++) {
						
							if (arrayVehicle[x][1] == P){
								C= C+ arrayVehicle[x][2];
							}
							
					}
					
				
				}	
			}
		System.out.println("Total price is R$ "+price);
		}
		
		
	
}
