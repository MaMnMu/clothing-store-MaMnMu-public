
public class Accesorio extends Articulo
{
	private final String PRE = "286";
	private final String SUF = "00";
	
	public Accesorio(String d, int s, double p)
	{
		super(d, s, p);
		ref = PRE + ref + SUF;
	}
	
	@Override
	public String toString()
	{
		return "ACCESORIO\n" + super.toString();
	}	
}
