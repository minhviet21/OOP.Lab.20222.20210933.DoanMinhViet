import java.util.Scanner;
public class V2_2_6_First_Deg_One_Var {
	public static void main (String arg[]) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please input a");
		double a = keyboard.nextDouble();
		System.out.println("Please input b");
		double b = keyboard.nextDouble();
		if (a!= 0) {
			System.out.println("The equation has only 1 root x = " + (-b/a));
		}
		else {
			if (b == 0) {
				System.out.println("The equation has infinitive many roots");
			}
			else {
				System.out.println("The equation has no root");
			}
		}
	}
}
