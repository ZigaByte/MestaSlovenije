package com.zigabyte.mestaslovenije.math;

public class Coordinate {

	static Coordinate fixed1;
	static Coordinate fixed2;

	static {
		fixed1 = new Coordinate(45.528319, 13.568289499999992, 178, 72);
		fixed2 = new Coordinate(46.6560877, 16.0380562, 1249, 759);
	}

	public final int IMAGE_X;
	public final int IMAGE_Y;
	final double n, e;

	public Coordinate(double n, double e) {
		this.n = n;
		this.e = e;
		double sX = (fixed2.IMAGE_X - fixed1.IMAGE_X) / (fixed2.e - fixed1.e);
		IMAGE_X = (int) (fixed1.IMAGE_X + sX * (e - fixed1.e));
		
		double sY = (fixed2.IMAGE_Y - fixed1.IMAGE_Y) / (fixed2.n - fixed1.n);
		IMAGE_Y = (int) (fixed1.IMAGE_Y + sY * (n - fixed1.n));
	}

	public Coordinate(double n, double e, int x, int y) {
		this.n = n;
		this.e = e;
		IMAGE_X = x;
		IMAGE_Y = y;
	}
}
