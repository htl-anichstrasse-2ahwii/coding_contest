package genetic_drift;

public class Pair implements Comparable<Pair> {
	private int x;
	private int y;

	public Pair(int x, int y) {
		if (x > y)
		{
			this.x = x;
			this.y = y;
		} else
		{
			this.y = x;
			this.x = y;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public static boolean isValidPair(int n1, int n2)
	{
		return (Math.abs((Math.abs(n1) - Math.abs(n2)))) == 1 && (n1 >= 0 && n2 < 0 || n2 >= 0 && n1 < 0);
	}
	
	@Override
	public int compareTo(Pair p) {
		return x - p.getX();
	}

	@Override
	public String toString() {
		return String.format("%d %d", x, y);
	}
}
