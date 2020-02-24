package txt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Read_From_TXT_Write_Into_Excel {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(
					new File("C:\\Users\\NARESH\\git\\repository2\\Maven_Framework\\src\\txt\\data.txt"));
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
