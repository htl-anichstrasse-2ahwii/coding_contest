package genetic_drift;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import utils.Util;

public class GeneticDrift {

	static void level1(String in) {

		String[] p = in.split(" ");
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		// int cnt = Integer.parseInt(p[0]);
		for (int i = 1; i < p.length; i++) {
			int n1 = Integer.parseInt(p[i]);
			for (int j = i+1; j < p.length; j++) {
				int n2 = Integer.parseInt(p[j]);
				//System.out.printf("%d %d\n", n1, n2);
				if ((i != j) && Pair.isValidPair(n1, n2))
				{
					pairs.add(new Pair(n1,n2));
				}
			}
		}
		Collections.sort(pairs);
		System.out.print(pairs.size());
		for (Pair pair : pairs)
		{
			System.out.printf(" %s", pair);
		}
		System.out.println();
	}

	static void level1All() throws FileNotFoundException {
		ArrayList<String> strs = Util.readlines("data/genetic_drift/in1.txt");
		for (String str : strs) {
			//System.out.println();
			//System.out.println(str);
			level1(str.trim());
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		level1All();

	}

}
