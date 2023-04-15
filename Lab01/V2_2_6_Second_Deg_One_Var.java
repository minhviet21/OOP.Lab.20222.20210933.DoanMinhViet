import java.util.Scanner;
public class V2_2_6_Second_Deg_One_Var {
	public static void main (String arg[]) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please input a");
		double a = keyboard.nextDouble();
		System.out.println("Please input b");
		double b = keyboard.nextDouble();
		System.out.println("Please input c");
		double c = keyboard.nextDouble();
		
		double delta = Math.pow(b, 2) - 4*a*c;
		if (delta < 0) {
			System.out.println("The equation has no root");
		}
		else if (delta == 0) {
			System.out.println("The equation has only 1 root x = " + (-b/(2*a)));
		}
		else {
			double x1 = (-b + Math.sqrt(delta))/(2*a);
			double x2 = (-b - Math.sqrt(delta))/(2*a);
			System.out.println("The equation has 2 roots: x1 = " + x1 + " and x2 = " + x2);
		}
	}
}
