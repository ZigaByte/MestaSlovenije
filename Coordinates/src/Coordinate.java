
public class Coordinate {

	static Coordinate fixed1;
	static Coordinate fixed2;

	static {
		fixed1 = new Coordinate("P1",45.6324383f, 13.9185683f, 326, 763);
		fixed2 = new Coordinate("P2",46.6560877f, 16.0380562f, 1249, 139);
	}

	final int imageX;
	final int imageY;
	final String name;
	final double n, e;

	public Coordinate(String name, double n, double e) {
		this.name = name;
		this.n = n;
		this.e = e;
		double sX = (fixed2.imageX - fixed1.imageX) / (fixed2.e - fixed1.e);
		imageX = (int) (fixed1.imageX + sX * (e - fixed1.e));

		double sY = (fixed2.imageY - fixed1.imageY) / (fixed2.n - fixed1.n);
		imageY = (int) (fixed1.imageY + sY * (n - fixed1.n));
	}

	public Coordinate(String name, double n, double e, int x, int y) {
		this.name = name;
		this.n = n;
		this.e = e;
		imageX = x;
		imageY = y;
	}
}
