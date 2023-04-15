import java.util.Scanner;
public class V2_2_5_CalculateTwoNumber {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please input first number:");
		double num1 = keyboard.nextDouble();
		System.out.println("Please input first number:");
		double num2 = keyboard.nextDouble();
		System.out.println("Sum of two number is " + (num1 + num2));
		System.out.println("Difference of two number is " + (num1 - num2));
		System.out.println("Product of two number is " + (num1 * num2));
		if (num2 != 0) 
				System.out.println("Quotient two number is " + (num1 / num2));
	}
}
