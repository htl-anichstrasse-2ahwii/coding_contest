package bakery;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import utils.Util;

public class Bakery {

	static void level1(String in)
	{
		ArrayList<Integer> f = new ArrayList<Integer>(Collections.nCopies(366, 0)); //fill with 1000 zeros
		ArrayList<Integer> b = new ArrayList<Integer>(Collections.nCopies(366, 0));
		String[] ep = in.split(" ");
		for (int i = 0; i< ep.length;i =i+3)
		{
			String type = ep[i];
			int day = Integer.parseInt(ep[i+1]);
			int amount = Integer.parseInt(ep[i+2]);
			if (type.equals("F"))
			{
				f.set(day,amount);
			} else
			{
				b.set(day, amount);
			}
		}
			
		ArrayList<Integer> erg = new ArrayList<Integer>();
		for (int i = 0; i < f.size(); i++) 
		{
			if (f.get(i) > b.get(i))
			{
				erg.add(i); 
			}
		}
		
		Collections.sort(erg);
		for (int e : erg)
		{
			if (e != 0)
			{
				System.out.printf("%d ", e);
			}
		}
		System.out.println();
	}
	
	static void level1All() throws FileNotFoundException
	{
		ArrayList<String> strs = Util.readlines("data/bakery/in1.txt");
		for (String str : strs)
		{
			level1(str.trim());
		}
	}
	
	static void level2All() throws FileNotFoundException
	{
		ArrayList<String> strs = Util.readlines("data/bakery/in2.txt");
		for (String str : strs)
		{
			level1(str.trim()); //same as level 1 with longer input
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		//level1All();
		level2All(); 
	}

}
