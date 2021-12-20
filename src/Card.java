import java.util.*;

/**
 * This class initializes the card object using the suit and rank enums
 * which will be used in the various other classes
 * 
 * @author Diego Cifuentes
 * @version 1
 */
public class Card implements Comparable<Card>
{
	private Rank rank;
	private Suit suit;
	
	/**
	 * Is the constructor method, initializes a new Card object
	 * 
	 * @param rank		the rank to be assigned to the card object
	 * @param suit		the suit to be assigned to the card object
	 */
	public Card(Rank rank, Suit suit)
	{
		//Checks if either of the passed in values are null
		if(rank == null || suit == null)
		{
			//If so then throw a NullPointerException
			throw new NullPointerException();
		}
		
		//Assigns the parameter to the private variables if the 
			//code above is false
		this.rank = rank;
		this.suit = suit;
	}
	
	//From office hours
	/**
	 * Sorts the list of cards first by Suit and then Rank
	 * 
	 * @param card		The card passed in to be compared 
	 */
	public int compareTo(Card card)
	{
		//Assigns the value of the compareTo() to the respective variables
			//Ex: if first is less than second then compareTo returns -1
		int suitCompare = this.suit.compareTo(card.suit);
		int rankCompare = this.rank.compareTo(card.rank);		
		
		if(suitCompare == 0)
		{
			return rankCompare;
		}
		else
		{
			return suitCompare;
		}
	}
	
	//From Office Hours
	@Override
	/**
	 * Overrides the Object equals method in order to help make the comparison between cards
	 * and find if they are equal based on their suit and rank
	 * 
	 * @param obj		the object passed in to be checked and then compared
	 */
	public boolean equals(Object obj)
	{
		//Checks if the passed in object is an instance of a Card object
		if(obj instanceof Card)
		{
			//Downcastes the object to a Card object
			Card cards = (Card) obj;
			
			//Compares the object
			int compare = this.compareTo(cards);
			
			//If it returns 0 (equal) then return true
			if(compare == 0)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns rank
	 * @return		the rank of the card
	 */
	public Rank getRank()
	{
		return rank;
	}
	
	/**
	 * Returns suit
	 * @return		the suit of the card
	 */
	public Suit getSuit()
	{
		return suit;
	}
	
	@Override
	/**
	 * Overrides the equals method and hashes the objects and returns a unique value
	 */
	public int hashCode()
	{
		return Objects.hash(rank, suit);
	}
	
	/**
	 * Prints out the Card object 
	 */
	public String toString()
	{
		String rank = this.rank.toString();
		String suit = this.suit.toString();
		String card = rank + suit;
		
		return card;
	}
	
}
