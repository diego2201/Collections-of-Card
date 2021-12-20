import java.util.*;

/**
 * This class initializes a Deck object using the Cards object and then storing them 
 * in a list
 * 
 * @author Diego Cifuentes
 * @version 1
 */
public class Deck 
{
	private List<Card> cards;
	
	//From Office Hours
	/**
	 * The constructor method for the Deck object
	 */
	public Deck()
	{
		//Creates a new list where the cards will be stored
		cards = new ArrayList<Card>();
		
		//Goes through a nested enchanced for loop in order to go through
			//all instances of cards
		for(Suit suit : Suit.values())
		{
			for(Rank rank : Rank.values())
			{
				//Makes a new Card object with the given rank and suit
					//and then adds it to the list
				Card theCard = new Card(rank, suit);
				cards.add(theCard);
				
			}
		}
		Collections.sort(cards);
	}
	
	/**
	 * Returns the size of the list
	 * @return size of the list
	 */
	public int size()
	{
		return cards.size();
	}
	
	/**
	 * Prints out the card list
	 * 
	 * @return the list
	 */
	public String toString()
	{
		
		return cards.toString();
	}
	
	/**
	 * Removes and returns the first Card in the list, if the list is empty
	 * then it returns null 
	 * 
	 * 	@return null if list is empty else the removed cards from the list
	 */
	public Card draw()
	{
		if(cards.size() == 0)
		{
			return null;
		}
		else
		{
			Card removedCard = cards.get(0);
			cards.remove(0);
			return removedCard;
		}
	}
	
	/**
	 * Removes and returns the given number (count) of Cards from the front of the list.
	 * If the passed in the number is larger than the size, remove and then return all 
	 * the Cards. If the number is less than zero, return an empty List
	 * 
	 * @param count		the amount to be removed from the front of the list
	 * @return the list with the removed cards from the deck
	 */
	public List<Card> draw(int count)
	{
		//Checks if the count is zero or less
		if(count <= 0)
		{
			List<Card> emptyList = new ArrayList<Card>();
			//if so then return and empty list
			return emptyList;
		}
		//Checks if the count is more than the size of the deck
		else if(count >= cards.size())
		{
			List<Card> newList = new ArrayList<Card>(cards);
			cards.removeAll(cards);
			//if so then remove all of the cards from the list
			return newList;
		}
		//Else remove the given amount from the front of the list
		else
		{
			List<Card> newerList = new ArrayList<Card>();

			for(int i = 0; i < count; i++)
			{
				int a = 0;
				newerList.add(cards.get(a));
				
				cards.remove(a);
			}
			return newerList;
		}
	}
	
	/**
	 * Shuffles the deck using the Collections.shuffle() method
	 */
	public void shuffle()
	{
		Collections.shuffle(cards);
	}
	
	/**
	 * Returns a list of the cards in the deck with their respective
	 * ranks 
	 * 
	 * @param rank		the rank of the card to he returned
	 * @return a list with the cards with the given rank
	 */
	public List<Card> getCardsByRank(Rank rank)
	{
		//Makes a new List where these cards will be stored
		List<Card> rankCards = new ArrayList<Card>();
		
		//For loop to go through the deck 
		for(int i = 0; i < cards.size(); i++)
		{
			//If the rank is the same as the passed in rank 
			if(cards.get(i).getRank() == rank)
			{
				//Then add to the new list
				rankCards.add(cards.get(i));
			}
		}
		return rankCards;
	}
}
