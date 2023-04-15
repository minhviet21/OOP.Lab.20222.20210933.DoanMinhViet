import javax.swing.JOptionPane;
public class V2_2_3_HelloNameDialog {
	public static void main (String arg[]) {
		String result;
		result = JOptionPane.showInputDialog("Please enter yout name:");
		JOptionPane.showMessageDialog(null, "Hi " + result + "!");
		System.exit(0);
	}
}
