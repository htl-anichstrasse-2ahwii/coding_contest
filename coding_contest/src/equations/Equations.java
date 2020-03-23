package equations;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import utils.Util;

public class Equations {

	static int[][] tab = {{6,9}, {}, {3},{2,5},{},{3},{0,9},{},{},{0,6}};
	
	
	static int check(int n, int erg)
	{
		int[] alts = tab[n];
		for (int a : alts)
		{
			if (a == erg) return a;
		}
		return -1;
	}
	
	static void level1(String in)
	{
		String[] p = in.split("=");
		int z0 = Integer.parseInt(p[0]);
		int z1 = Integer.parseInt(p[1]);
		
		int erg0 = check(z0, z1);
		if (erg0 != -1) 
		{
			System.out.printf("%d=%d ", erg0, erg0);
		}
		int erg1 = check(z1, z0);
		if (erg1 != -1) 
		{
			System.out.printf("%d=%d", erg1, erg1);
		}
		System.out.println();
	}
	
	static void level1All() throws FileNotFoundException
	{
		ArrayList<String> strs = Util.readlines("in1.txt");
		for (String str : strs)
		{
			level1(str);
		}
	}
	
	
	static int solveTerm(String s)
	{
		if (s.length() == 1 )
		{
			return Integer.parseInt(s);
		}
		
		String[] p = s.split("\\+|-");
		int z0 = Integer.parseInt(p[0]);
		int z1 = Integer.parseInt(p[1]);
		if (s.charAt(1) == '+')
			return z0 + z1;
		return  z0 - z1;
	}
	
	static ArrayList<String> getPermsAndSelf(String t)
	{
		ArrayList<String> perms = new ArrayList<String>();
		perms.add(t);
		
		if (t.length() == 1 )
		{
			int n = Integer.parseInt(t);
			for (int a : tab[n])
			{
				perms.add(a + "");
			}
			return perms;
		}

		int z0 = Integer.parseInt(t.charAt(0) + "");
		int z1 = Integer.parseInt(t.charAt(2) + "");
		int[] alt0 = tab[z0];
		int[] alt1 = tab[z1];
		for (int a0 : alt0)
		{
			perms.add("" + a0 + t.charAt(1) + z1);
			for (int a1 : alt1) 
			{
				perms.add("" + z0 + t.charAt(1) + a1);
				perms.add("" + a0 + t.charAt(1) + a1);
			}
		}
		return perms;
	}
	static void checkPerm(String t0, String t1)
	{
		ArrayList<String> p0 = getPermsAndSelf(t0);
		ArrayList<String> p1 = getPermsAndSelf(t1);
		for (String alt0 : p0 )
		{
			for (String alt1 : p1)
			{
				System.out.printf("%s=%s ", alt0, alt1);
				if (solveTerm(alt0) == solveTerm(alt1))
				{
					System.out.printf("ERG:%s=%s ", alt0, alt1);
				}
			}
		}
		System.out.println();
	}
	
	static void level2(String in)
	{
		String[] p = in.split("=");
		String p0 = p[0];
		String p1 = p[1];
		checkPerm(p0, p1);
		System.out.println();
	}
	
	static void level2All() throws FileNotFoundException
	{
		ArrayList<String> strs = Util.readlines("in2.txt");
		for (String str : strs)
		{
			level2(str);
		}
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		//level1All();
		level2All();
	}

}
