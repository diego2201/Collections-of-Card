
/**
 * This is an enum class, essentially it is full of constants that can be called to
 * and has some methods implemented that can help with other classes/
 * 
 * @author Diego Cifuentes
 * @version 1
 */
public enum Rank 
{
	TWO("2"),
	THREE("3"),
	FOUR("4"),
	FIVE("5"),
	SIX("6"),
	SEVEN("7"),
	EIGHT("8"),
	NINE("9"),
	TEN("10"),
	JACK("J"),
	QUEEN("Q"),
	KING("K"),
	ACE("A");
	
	/** Where the symbol of the enum will be stored */
	private String symbol;
	
	/**
	 * Assigns the value of symbol to the private variable symbol
	 * 
	 * @param symbol		the passed in symbol to be assigned
	 */
	private Rank(String symbol)
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
