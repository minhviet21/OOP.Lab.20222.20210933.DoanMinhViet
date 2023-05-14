package hust.soict.dsai.lab01;
import java.util.Scanner;
public class V2_2_6_First_Deg_Two_Var {
	public static void main (String arg[]) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please input a11");
		double a11 = keyboard.nextDouble();
		System.out.println("Please input a12");
		double a12 = keyboard.nextDouble();
		System.out.println("Please input b1");
		double b1 = keyboard.nextDouble();
		System.out.println("Please input a21");
		double a21 = keyboard.nextDouble();
		System.out.println("Please input a22");
		double a22 = keyboard.nextDouble();
		System.out.println("Please input b2");
		double b2 = keyboard.nextDouble();
		
		double D = a11*a22 - a12*a21;
		double D1 = b1*a22 - b2*a12;
		double D2 = a11*b2 - a21*b1;
		
		if (D != 0) {
			System.out.println("The system of equations has 1 root (x1,x2) = (" + (D1/D) + "," + (D2/D) + ")" );
		}
		else {
			if (Math.pow(D1,2) + Math.pow(D2,2) == 0) {
				System.out.println("The system of equations has infinitive many roots satified that " 
			+ a11 + "*x1 + " + a12 +"*x2 = " + b1);
			}
			else {
				System.out.println("The system of equation has no root");
			}
		}
	}
}