import java.util.*;

/**
 * Initializes a BlackjackHand Object which is representative of the game of Blackjack
 * 
 * @author Diego Cifuentes
 * @version 1
 */
public class BlackjackHand 
{
	private static Map<Rank, Integer> CARD_VALUES = intialize();
	private static final int MAX_VALUE = 21;
	private List<Card> cards = new ArrayList<Card>();
	private int value = 0;
	private int numAcesAs11 = 0;
	
	/**
	 * Method to help initialize the private Map variable CARD_VALUES
	 * 
	 * @return CARD_VALUES
	 */
	private static Map<Rank, Integer> intialize()
	{
		Map<Rank, Integer> CARD_VALUES = new HashMap<Rank, Integer>();
		List<Rank> ranks = Arrays.asList(Rank.values());
		
		int cardInt = 2;
		
		for(int i = 0; i < ranks.size(); i++)
		{
			if(ranks.get(i) == Rank.JACK || ranks.get(i) == Rank.QUEEN || ranks.get(i) == Rank.KING) 
			{
				CARD_VALUES.put(ranks.get(i), 10);
			}
			else
			{
				CARD_VALUES.put(ranks.get(i), cardInt);
				cardInt++;
			}
		}
		return CARD_VALUES;
	}
	
	/**
	 * Constructor method for the object. Adds the passed in card values to the hand
	 * 
	 * @param c1		One of the card values to be added
	 * @param c2		One of the card values to be added
	 */
	public BlackjackHand(Card c1, Card c2)
	{
		cards.add(c1);
		cards.add(c2);
	}
	
	/**
	 * Adds the passed in card to the hand, if the passed in card is not null
	 * 
	 * @param card		the card to be added
	 */
	public void addCard(Card card)
	{
		//Checks if the card is null
		if(card == null)
		{
			//If so then it throws a NullPointerException
			throw new NullPointerException();
		}
		//Checks if the hand is less than MAX_VALUE
		else if(getValue() < MAX_VALUE)
		{
			//Updates the value of the private variable numAcesAs11
			if(card.getRank() == Rank.ACE)
			{
				cards.add(card);
				
				value = value + 11;
				numAcesAs11++;
			}
			else
			{
				cards.add(card);
				value = CARD_VALUES.get(card.getRank()) + getValue();
			}
		}
	}
	
	/**
	 * Returns the size of the card list
	 * 
	 * @return the size of the card list
	 */
	public int size()
	{
		return cards.size();
	}
	
	/**
	 * Returns a copy of the CARD_VALUE map
	 * 
	 * @return copy of the CARD_VALUE map
	 */
	public static Map<Rank, Integer> getCardValues()
	{
		Map<Rank, Integer> copyOfValues = new HashMap<Rank, Integer>(CARD_VALUES);
		
		return copyOfValues;
	}
	
	/**
	 * Return a copy of the cards List
	 * 
	 * @return copy of the cards List
	 */
	public List<Card> getCards()
	{
		List<Card> copyOfCards = new ArrayList<Card>(cards);
		
		return copyOfCards;
	}
	
	//Help from Braden
	/**
	 * Returns the value of the hand, and assigns the ACE card to its repsective value
	 * depending on if the hand is more or less than the MAX_VALUE
	 * 
	 * @return the value of the hand
	 */
	public int getValue()
	{
		int totalValue = 0;
		int numOfAces = 0;
		
		for(int i = 0; i < cards.size(); i++)
		{
			for(Rank rank : CARD_VALUES.keySet())
			{
				if(cards.get(i).getRank() == Rank.ACE && cards.get(i).getRank() == rank)
				{
					totalValue = totalValue + 11;
					numOfAces++;
				}
				else if(cards.get(i).getRank() == rank)
				{
					totalValue = totalValue + CARD_VALUES.get(rank);
				}
			}
		}
		
		if(totalValue > MAX_VALUE && numOfAces != 0)
		{
			while(totalValue > MAX_VALUE && numOfAces != 0)
			{
				//Advice from Mohammed
				totalValue = totalValue - 10;
				
				numOfAces--;
			}
		}
		
		return totalValue;
	}
	
	/**
	 * Returns the string representation of the list
	 * @return the list
	 */
	public String toString()
	{
		return cards.toString();
	}
}
