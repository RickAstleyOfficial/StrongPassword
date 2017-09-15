/*strongDemo.java
David Woelfel
Programming Fundamentals II
COSC 1337
Detect the relative strength of a list of passwords from a file and run requirement passes
 */


package StrongPasswords;
import java.io.*;

public class strongDemo {
	public static void main(String[] args) throws IOException {

		//Enclose in try block for exceptions
		try {
			File file = new File("strong.dat");
			BufferedReader data = new BufferedReader(new FileReader(file));
			int n = Integer.parseInt(data.readLine());
			for (int i = 0; i < n; i++){
				Strong instance = new Strong(data.readLine());
				instance.minimum();
				System.out.println(instance.output());
			}
			data.close();
		}
		//Catch block for handling exceptions better
		catch (Exception e) {
			System.out.println("Conversion error " + e.getMessage());
		}
	}
}