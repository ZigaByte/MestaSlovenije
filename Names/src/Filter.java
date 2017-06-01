import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Cooridnate {
	int id;
	String name;
	int pop;
	float n;
	float e;

	public Cooridnate(int id, String name, int pop, float n, float e) {
		this.id = id;
		this.name = name;
		this.pop = pop;
		this.n = n;
		this.e = e;
	}

	@Override
	public String toString() {
		return String.format("%03d, %s, %d, %s, %s", id, name, pop, (n + "").replaceAll(",", "."),
				(e + "").replaceAll(",", "."));
	}

}

public class Filter {

	public static void main(String[] args) {

		ArrayList<Cooridnate> coords = new ArrayList<Cooridnate>();

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("coordinates.txt"));
		} catch (FileNotFoundException e) {
		}

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] parts = line.split(",");
			coords.add(new Cooridnate(Integer.parseInt(parts[0].trim()), parts[1].trim(),
					Integer.parseInt(parts[2].trim()), Float.parseFloat(parts[3].trim()),
					Float.parseFloat(parts[4].trim())));
		}

		coords.sort(new Comparator<Cooridnate>() {
			@Override
			public int compare(Cooridnate o1, Cooridnate o2) {
				return o2.pop - o1.pop;
			}
		});

		int i = 0;
		for (Cooridnate c : coords) {
			c.id = i++;
			System.out.println(c);
		}
	}

}
