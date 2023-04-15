import java.util.Scanner;
public class V6_3_TriangleOfStar {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please input the height of traingle");
		int n = keyboard.nextInt();
		String a = "";
		String b = "*";
		for (int i = 1; i <= n; i++) { 
			a = a + " ";
		}
		for (int j = 1; j <= n; j++) {
			a = a.substring(0,n-j);
			System.out.println(a+b);
			b = b + "**";
		}
	}
}