import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Assignment2 {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		int length = getIntLoop(scanner);// get the array length
		double density = getDoubleTryCatch(scanner);// get density of the array
		// 2.create dense array
		long startTime1 = System.nanoTime();
		int[] densearray = new int[length];
		for (int i = 0; i < length; ++i) {
			if (random.nextDouble() < density) {
				// Randomness says this shouldn't be 0, so make it a
				// number between 1 (inclusive) and 10000001 (exclusive).
				densearray[i]=random.nextInt(1000000) + 1;
			} else {
				densearray[i] = 0;
			}
		}
		long endTime1 = System.nanoTime();
	
		// 3.create sparse array
		long startTime2 = System.nanoTime();
		ArrayList<int[]> sparsearray = new ArrayList<>(length);
		for (int i = 1; i < length; ++i) {
			if (random.nextDouble() < density) {
				int[] index = new int[2];
				index[0] = i;
				index[1] = random.nextInt(1000000) + 1;
				sparsearray.add(index);

			}

		}
		long endTime2 = System.nanoTime();

		// 4.convert to sparse array
		long startTime3 = System.nanoTime();
		ArrayList<int[]> NewSparsearray = new ArrayList<>();
		for (int i = 0; i < length; ++i) {
			int[] index = new int[2];
			if (densearray[i] == 0) {
			}else{
				index[0] = i;
				index[1] = densearray[i];
				NewSparsearray.add(index);

			}
		}
		long endTime3 = System.nanoTime();
		
		
		// 5.convert to dense array
		long startTime6 = System.nanoTime();
		
		int[] Newdensearray = new int[sparsearray.get(sparsearray.size()-1)[0]+1];// the size of the new dense array is the index of last element
		//of the sparsearray plus 1.
		
		for (int i = 0; i < sparsearray.size(); ++i) {
			int[] index = new int[2];
			index = sparsearray.get(i);
			Newdensearray[i]=index[1];
			
			
		}
		long endTime6 = System.nanoTime();
		
		
		
		
		// 6.get dense array max
		long startTime4 = System.nanoTime();
		int dmax = 0;
		int at = 0;
		for(int i = 0; i<length;i++){
			if(dmax<densearray[i]){
				dmax = densearray[i];
				at= i;
			}
		}
		long endTime4 = System.nanoTime();
		
		
		// 7.get sparse array max
		long startTime5 = System.nanoTime();
		int smax = 0;
		int indexmax = 0;
		int n = 0;
		for(int i = 0; i<length;i++){
			int[] index = new int[2];
			index = sparsearray.get(n);
			if(smax<index[1]){
				smax = index[1];
				indexmax = index[0];
				n++;
			}
					
		}
		long endTime5 = System.nanoTime();
		
		
		
		//final display:
		System.out.println("create dense length: " + length + "   time: "+ (endTime1 - startTime1)/1000000.0);
		System.out.println("convert to sparse length: " + NewSparsearray.size() + "  time: "+ (endTime3 - startTime3)/1000000.0);
		System.out.println("create sparse length " + sparsearray.size() + " time: "+ (endTime2 - startTime2)/1000000.0);
		System.out.println("convert to dense length: " + sparsearray.get(sparsearray.size()-1)[0]+1 + "   time: "+ (endTime6 - startTime6)/1000000.0);
		System.out.println("find max (dense): " + dmax+ "    at: " + at);
		System.out.println("dense find time :" +(endTime4 - startTime4)/1000000.0);
		System.out.println("find max (sparse): " + smax+ "     at: " + indexmax);
		System.out.println("sparse find time :" +(endTime5 - startTime5)/1000000.0);
		
		scanner.close();
		
	}

	// set a length of array
	private static int getIntLoop(Scanner sc) {
		int input = -1;
		System.out.println("please array length:");
		while (!sc.hasNextInt()) {// if not an integer, will continue loop
			sc.next();
			System.out.println("That's not an integer,retry:");
		}
		input = sc.nextInt();
		return input;
	}

	// set a density of array
	private static double getDoubleTryCatch(Scanner sc) {
		double input = -1;
		boolean done = false;
		while (!done) {
			try {
				System.out.println("Enter density:");
				input = sc.nextDouble();
				done = true;
			} catch (Exception e) {// if not a double try again
				sc.nextDouble();
			}
		}
		return input;
	}

}
