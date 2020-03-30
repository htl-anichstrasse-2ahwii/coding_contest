package bakery;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import utils.Util;

public class Bakery {

	static void level1(String in) {
		ArrayList<Integer> f = new ArrayList<Integer>(Collections.nCopies(366, 0)); // fill with 1000 zeros
		ArrayList<Integer> b = new ArrayList<Integer>(Collections.nCopies(366, 0));
		String[] ep = in.split(" ");
		for (int i = 0; i < ep.length; i = i + 3) {
			String type = ep[i];
			int day = Integer.parseInt(ep[i + 1]);
			int amount = Integer.parseInt(ep[i + 2]);
			if (type.equals("F")) {
				f.set(day, amount);
			} else {
				b.set(day, b.get(day) + amount); //sum up the dayly payments
			}
		}

		ArrayList<Integer> erg = new ArrayList<Integer>();
		for (int i = 0; i < f.size(); i++) {
			if (f.get(i) > b.get(i)) {
				erg.add(i);
			}
		}

		Collections.sort(erg);
		for (int e : erg) {
			if (e != 0) {
				System.out.printf("%d ", e);
			}
		}
		System.out.println();
	}

	static void level3(String in) {
		ArrayList<Integer> f = new ArrayList<Integer>(Collections.nCopies(366, 0)); // fill with 1000 zeros
		//ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<ArrayList<Integer>>>(Collections.nCopies(366, 0));
		List<ArrayList<Integer>> b = Stream.generate(ArrayList<Integer>::new).limit(366).collect(Collectors.toList());
		
		String[] ep = in.split(" ");
		for (int i = 0; i < ep.length; i = i + 3) {
			String type = ep[i];
			int day = Integer.parseInt(ep[i + 1]);
			int amount = Integer.parseInt(ep[i + 2]);
			if (type.equals("F")) {
				f.set(day, amount);
			} else {
				ArrayList<Integer> bSub = b.get(day);
				bSub.add(amount);
				b.set(day, bSub);
			}
		}

		int idx = 0;
		for (ArrayList<Integer> bp : b)
		{
			if (bp.size() > 0)
			{
				System.out.printf("%d :  %d  %s\n", idx, f.get(idx), bp.toString());
			}
			idx++;

		}
		System.out.println();
			
		ArrayList<Integer> erg = new ArrayList<Integer>();
		for (int i = 0; i < f.size(); i++) {
			ArrayList<Integer> bParts = b.get(i);
			if (bParts.size() == 0 || f.get(i) == 0) continue;
			int bLast = bParts.get(bParts.size() - 1);
			if (f.get(i) > bLast) {
				int missing = f.get(i) - bLast;
				boolean ok = false;
				for (int j = 1; j <= 4 && !ok && missing > 0;j++)
				{
					ArrayList<Integer> nextL = b.get(i +j);
					if (nextL.size() > 1 || f.get(i+j) == 0 )
					{
						if (nextL.size() == 0) continue;
						int next = nextL.get(0);
						if (next == missing)
						{
							nextL.remove(0);
							b.set(i +j, nextL);
							ok = true;
							break;	
						} 
					}
					
				}
				
				if (!ok)
				{
					erg.add(i);
				}
			}
		}

		Collections.sort(erg);
		for (int e : erg) {

			System.out.printf("%d ", e);
		}
		System.out.println();
	}

	static void level1All() throws FileNotFoundException {
		ArrayList<String> strs = Util.readlines("data/bakery/in1.txt");
		for (String str : strs) {
			level1(str.trim());
		}
	}

	static void level2All() throws FileNotFoundException {
		ArrayList<String> strs = Util.readlines("data/bakery/in2.txt");
		for (String str : strs) {
			level1(str.trim()); // same as level 1 with longer input
		}
	}

	static void level3All() throws FileNotFoundException {
		ArrayList<String> strs = Util.readlines("data/bakery/in3.txt");
		for (String str : strs) {
			level3(str.trim()); // same as level 1 with longer input
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		// level1All();
		//level2All();
		level3All();
	}

}
