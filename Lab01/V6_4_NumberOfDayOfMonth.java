import java.util.Scanner;
public class V6_4_NumberOfDayOfMonth {
	public static void main (String arg[]) {
		Scanner keyboard = new Scanner(System.in);
		String[] month = {"January", "February", "March", "April", "May",  "June", "July", "August", "September", "October", "November", "December",
				          "Jan.",    "Feb.",     "Mar.",  "Apr.",  "May",  "Jun",  "Jul",  "Aug.",   "Sep.",      "Oct.",    "Nov.",     "Dec.",
				          "Jan",     "Feb",      "Mar",   "Apr",   "May",  "Jun",  "Jul",  "Aug",    "Sep",       "Oct",     "Nov",      "Dec",
				          "1",       "2",        "3",     "4",     "5",    "6",    "7",    "8",      "9",         "10",      "11",       "12"};
		System.out.println("Please input a month");
		String m = keyboard.nextLine();
		int a = 0;
		for (int i = 0; i < 48; i++) {
			if (m.equals(month[i])) {
				a += 1;
				break;
			}
		}
		while (a == 0) {
			System.out.println("Invalid month, please input a month again");
			m = keyboard.nextLine();
			for (int i = 0; i < 48; i++) {
				if (m.equals(month[i])) {
					a += 1;
					break;
				}
			}
		}
		System.out.println("Please input a year");
		int y = keyboard.nextInt();
		int d;
		if (m.length() <= 2) {
			if (m.equals("4") || m.equals("6") || m.equals("9") || m.equals("11")) {
				d = 30;
			}
			else if (m.equals("2")) {
				if (y % 4 != 0 || (y % 100 == 0 && y % 400 != 0)) {
					d = 29;
				}
				else {
					d = 28;
				}
			}
			else {
				d = 31;
			}
		}
		else {
			String v = m.substring(0,3);
			if (v.equals("Apr") || m.equals("Jun") || m.equals("Sep") || m.equals("Nov")) {
				d = 30;
			}
			else if (m.equals("Feb")) {
				if (y % 4 != 0 || (y % 100 == 0 && y % 400 != 0)) {
					d = 29;
				}
				else {
					d = 28;
				}
			}
			else {
				d = 31;
			}
		}
		System.out.println("The number of days is " + d);
	}
}
