package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Util {
	/**
	 * Helper Class for reading the content of a file line by line
	 * @param fName name of the file to be read
	 * @return an ArrayList with all lines
	 * @throws FileNotFoundException
	 */
	public static ArrayList<String> readlines(String fName) throws FileNotFoundException
	{
		ArrayList<String> erg  = new ArrayList<String>();
		Scanner s = new Scanner(new File(fName));
		while (s.hasNextLine())
		{
			erg.add(s.nextLine());
		}
		s.close();
		return erg;
	}
}
