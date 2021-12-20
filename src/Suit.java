
/**
 * This is an enum class, essentially it is full of constants that can be called to
 * and has some methods implemented that can help with other classes/
 * 
 * @author Diego Cifuentes
 * @version 1
 */
public enum Suit 
{
	CLUBS("C"),
	DIAMONDS("D"),
	HEARTS("H"),
	SPADES("S");
	
	/** Where the symbol of the enum will be stored */
	private String symbol;
	
	/**
	 * Assigns the value of symbol to the private variable symbol
	 * 
	 * @param symbol		the passed in symbol to be assigned
	 */
	private Suit(String symbol)
	{
		this.symbol = symbol;
	}
	
	/**
	 * Prints out the object 
	 */
	public String toString()
	{
		return symbol;
	}
}
