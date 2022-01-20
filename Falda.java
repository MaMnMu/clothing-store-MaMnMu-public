
public class Falda extends Bottom
{
	private final String PRE = "612";
	
	public Falda(String d, int s, double p, String talla)
	{
		super(d, s, p, talla);
		ref = PRE + ref;
	}

	@Override
	public String toString()
	{
		return "FALDA\n" + super.toString();
	} 
}