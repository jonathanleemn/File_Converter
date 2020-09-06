import java.io.*;
import java.util.Scanner;

public class FileConverter {
	static BufferedWriter output;
	static BufferedReader input;
	static String line;

	public static void main(String[] args) throws IOException {

		// user manually enters the file name
		try {
			System.out.print("Enter file name: ");
			Scanner scan = new Scanner(System.in);
			String fileName = scan.nextLine();
			//reads user input for file name
			input = new BufferedReader(new FileReader(fileName));
			//trims the extension at the end of file name
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
			
			//reads user input for file conversion
			System.out.print("Type file output you wish to convert to (include file extension): ");
			String conversionType = scan.nextLine().toLowerCase();

			switch (conversionType) {
			case ("python"):
				System.out.print("Converting to Python... ");
				output = new BufferedWriter(new FileWriter(fileName + ".py"));
				convertTxtToPy();
				System.out.print("Finished!");
				break;
			default:
				System.out.println("File type not supported.");
			}
			
			scan.close();
		} 
		
		//error catching if user inputs invalid file name
		catch (Exception e) {
			System.out.println("File name invalid");
		}

		// basic version, file name and type are already preselected
		// input = new BufferedReader(new FileReader("text.py"));
		// output = new BufferedWriter(new FileWriter("text.txt"));
		// convertTxtToPy();
	}

	private static void convertTxtToPy() throws IOException {
		while ((line = input.readLine()) != null) {
			output.write(line);
			output.newLine();
		}
		input.close();
		output.close();
	}
}
