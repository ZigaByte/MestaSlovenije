import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser1 {
	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("mesta.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<String> out = new ArrayList<String>();

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			// System.out.println(line);
			if (line.length() < 2)
				continue;

			String[] mesta = line.split("|");
			//mesta[0] = mesta[0].substring(1);

			for (String m : mesta) {
				System.out.println(m);
				out.add(m.trim().replaceAll(".", ""));
			}
		}

		for (String m : out)
			System.out.println(m);
	}
}
