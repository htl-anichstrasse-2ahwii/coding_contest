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

	static void level1All() throws FileNotFoundException
	{
		ArrayList<String> strs = Util.readlines("data/auction_bidding/in1.txt");
		for (String str : strs)
		{
			level1(str);
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		level1All();

	}

}
