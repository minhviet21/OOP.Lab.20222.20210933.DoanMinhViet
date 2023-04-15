import java.util.Scanner;
public class V6_6_Matrix {
	public static void main(String arg[]) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the number of rows of each matrix");
	    int m = keyboard.nextInt(); 
		System.out.println("Please enter the number of columns of each matrix");
		int n = keyboard.nextInt(); 
		double first[][] = new double[m][n]; 
		double second[][] = new double[m][n]; 
		double third[][] = new double[m][n]; 
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; i++) {
				third[i][j] = first[i][j] + second[i][j];
				if (j < n-1) {
					System.out.print(third[i][j] + " ");
				}
				else {
					System.out.println(third[i][j]);
				}
			}
		}
	}
}