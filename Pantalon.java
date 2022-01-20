
public class Pantalon extends Bottom
{
	private final String PRE = "614";
	
	public Pantalon(String d, int s, double p, String talla)
	{
		super(d, s, p, talla);
		ref = PRE + ref;
	}

	@Override
	public String toString()
	{
		return "PANTALON\n" + super.toString();
	}
}