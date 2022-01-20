
public class Top extends Ropa
{
	private final String PRE = "412";
	private String suf;
	
	public Top(String d, int s, double p, String talla)
	{
		super(d, s, p, talla);
		suf = tallaValida(talla);
		ref = PRE + ref + suf;	
	}
	
	public static String tallaValida(String t)
	{
		if (t.equals("XS")) return "01";
		if (t.equals("S")) return "02";
		if (t.equals("M")) return "03";
		if (t.equals("L")) return "04";
		if (t.equals("XL")) return "05";
		return null;
	}
	
	@Override
	public String toString()
	{
		return "TOP\n" + super.toString();
	}
	
	public static String cambioTalla(String ref, String t)
	{
		String nt = tallaValida(t);
		if (nt != null)
			return ref.substring(0, 8) + nt;
		else
			return null;
	}
}
