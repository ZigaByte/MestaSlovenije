import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CoordinateTest extends Canvas {

	final int width = 1600, height = 900;
	final float scale = 1;

	JFrame frame;

	public CoordinateTest() {
		setPreferredSize(new Dimension((int) (width / scale), (int) (height / scale)));

		frame = new JFrame();
		frame.setResizable(false);
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

		repaint();
	}

	@Override
	public void paint(Graphics gr) {
		super.paint(gr);
		Graphics2D g = (Graphics2D) gr;

		BufferedImage background = null;
		try {
			background = ImageIO.read(new File("karta_sized.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		g.scale(1 / scale, 1 / scale);

		g.drawImage(background, 0, 0, width, height, null);

		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("coordinates.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] components = line.split(",");
			double n = Double.parseDouble(components[3]);
			double e = Double.parseDouble(components[4]);

			coordinates.add(new Coordinate(components[1], n, e));
		}

		for (Coordinate c : coordinates) {
			g.fillRect(c.imageX - 5, c.imageY - 5, 10, 10);
			g.drawString(c.name, c.imageX + 3, c.imageY);
		}
	}

	public static void main(String[] args) {
		new CoordinateTest();
	}
}
