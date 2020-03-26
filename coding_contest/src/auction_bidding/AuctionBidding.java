package auction_bidding;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import utils.Util;

public class AuctionBidding {

	static void level1(String in) {

		String[] p = in.split(",");
		
		int highestBid = Integer.parseInt(p[0]); //start
		int actPrice = highestBid;
		String highestBidder = p[1];
		for (int i = 1; i < p.length; i = i + 2) {
			
			String bidder = p[i];
			int bid = Integer.parseInt(p[i+1]);
			if (bidder.equals(highestBidder) )
			{
				//do nothing
			}
			else if (bid > highestBid)
			{
				actPrice = highestBid + 1;
				highestBid = bid;
				highestBidder = bidder;
				
			} else if (bid == highestBid)
			{
				actPrice = highestBid;
			} else
			{
				actPrice = bid + 1;
			}
		}
		System.out.printf("%s,%d\n", highestBidder, actPrice);
	}

	static void level2(String in) {

		String[] p = in.split(",");
		
		int highestBid = Integer.parseInt(p[0]); //start
		int actPrice = highestBid;
		String highestBidder = p[1];
		for (int i = 1; i < p.length; i = i + 2) {
			
			String bidder = p[i];
			int bid = Integer.parseInt(p[i+1]);
			if (bidder.equals(highestBidder) )
			{
				highestBid = bid;
			}
			else if (bid > highestBid)
			{
				actPrice = highestBid + 1;
				highestBid = bid;
				highestBidder = bidder;
				
			} else if (bid == highestBid)
			{
				actPrice = highestBid;
			} else
			{
				actPrice = bid + 1;
			}
		}
		System.out.printf("%s,%d\n", highestBidder, actPrice);
	}
	
	static void level3(String in) {	
		String[] p = in.split(",");
		
		int highestBid = Integer.parseInt(p[0]); //start
		int actPrice = highestBid;
		String highestBidder = p[1];
		String result = String.format("-,%d,%s,%d,", highestBid, highestBidder,highestBid);
		for (int i = 1; i < p.length; i = i + 2) {
			
			String bidder = p[i];
			int bid = Integer.parseInt(p[i+1]);
			if (bidder.equals(highestBidder) )
			{
				highestBid = bid;
			}
			else if (bid > highestBid)
			{
				actPrice = highestBid + 1;
				highestBid = bid;
				highestBidder = bidder;
				result += String.format("%s,%d,", highestBidder, actPrice);
				
			} else if (bid == highestBid)
			{
				actPrice = highestBid;
				result += String.format("%s,%d,", highestBidder, actPrice);
			} else
			{
				actPrice = bid + 1;
				result += String.format("%s,%d,", highestBidder, actPrice);
			}
		}
		if (result.length() > 1)
		{
			result = Util.removeLastChar(result);
		}
		System.out.println(result);
	}
	
	static void level4(String in) {	
		String[] p = in.split(",");
		
		int highestBid = Integer.parseInt(p[0]); //start
		int buyNow = Integer.parseInt(p[1]);
		int actPrice = highestBid;
		String highestBidder = p[2];
		String result = String.format("-,%d,%s,%d,", highestBid, highestBidder,highestBid);
		for (int i = 2; i < p.length; i = i + 2) {
			
			String bidder = p[i];
			int bid = Integer.parseInt(p[i+1]);
			
			if (bidder.equals(highestBidder) )
			{
				highestBid = bid;
			}
			else if (bid > highestBid)
			{
				actPrice = highestBid + 1;
				highestBid = bid;
				highestBidder = bidder;
				result += String.format("%s,%d,", highestBidder, actPrice);
				
			} else if (bid == highestBid)
			{
				actPrice = highestBid;
				result += String.format("%s,%d,", highestBidder, actPrice);
			} else
			{
				actPrice = bid + 1;
				result += String.format("%s,%d,", highestBidder, actPrice);
			}
			if (bid >= buyNow && buyNow != 0)
			{
				highestBid = buyNow;
				actPrice = buyNow;
				result += String.format("%s,%d,", highestBidder, actPrice);
				break;
			}
		}
		if (result.length() > 1)
		{
			result = Util.removeLastChar(result);
		}
		System.out.println(result);
	}
	
	static void level1All() throws FileNotFoundException
	{
		ArrayList<String> strs = Util.readlines("data/auction_bidding/in1.txt");
		for (String str : strs)
		{
			level1(str.trim());
		}
	}
	
	static void level2All() throws FileNotFoundException
	{
		ArrayList<String> strs = Util.readlines("data/auction_bidding/in2.txt");
		for (String str : strs)
		{
			level2(str.trim());
		}
	}
	
	static void level3All() throws FileNotFoundException
	{
		ArrayList<String> strs = Util.readlines("data/auction_bidding/in3.txt");
		for (String str : strs)
		{
			level3(str.trim());
		}
	}
	
	static void level4All() throws FileNotFoundException
	{
		ArrayList<String> strs = Util.readlines("data/auction_bidding/in4.txt");
		for (String str : strs)
		{
			level4(str.trim());
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		//level1All();
		//level2All();
		//level3All();
		level4All();
	}

}
