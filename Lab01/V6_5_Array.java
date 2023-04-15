import java.util.Scanner;
public class V6_5_Array {
	public static void main (String arg[]) {
	    Scanner keyboard = new Scanner(System.in);
	    System.out.println("Please input an array of numbers");
	    String s = keyboard.nextLine();
	    String arr0[] =  s.split(" ");
	    int n = arr0.length;
	    double arr[] = new double[n];
	    for (int i = 0; i < n; i++) {
	    	arr[i] = Double.parseDouble(arr0[i]);
	    }
	    for (int i = n-1; i >= 0; i-- ) {
	    	for (int j = 1; j <= i; j++) {
	    		if (arr[j-1] > arr[j]) {
	    			double term = arr[j-1];
	    			arr[j-1] = arr[j];
	    			arr[j] = term;
	    		}
	    	}
	    }
	    System.out.print("The sorted array is {");
	    double sum = 0;
	    for (int i = 0; i < n-1; i++) {
	    	System.out.print(arr[i] + ", ");
	    	sum += arr[i];
	    }
	    System.out.println(arr[n-1] + "}");
	    sum += arr[n-1];
	    System.out.println("The sum value of array elements is " + sum);
	    System.out.println("The average value of array elements is " + (sum/n));
	}
}