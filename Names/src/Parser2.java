import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser2 {
	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("mesta.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int count = 0;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			// System.out.println(line);
			if (line.length() < 2)
				continue;

			// 001019 Križna Gora 8
			String[] parts1 = line.split(" ");
			String parts2[] = parts1[parts1.length - 1].split("\t");
			parts1[parts1.length - 1] = parts2[0];

			int id = Integer.parseInt(parts1[0]);
			
			// Get rid of the parents
			if (id < 1000)
				continue;
	
			String name = "";

			for (int i = 1; i < parts1.length; i++) {
				name += parts1[i] + " ";
			}
			if (parts2[1].equals("-"))
				continue;
			int population = Integer.parseInt(parts2[1]);

			if (population > 1000) {
				count++;
				// System.out.printf("ID: %6d, Name: %26s, Population: %6d\n",
				// id, name, population);
				//System.out.printf("%d,%s,%d\n", id, name.trim(), population);
				System.out.printf("%d,%s,%d,", id, name.trim(), population);
			}
		}
		System.out.println(count);

	}
}
