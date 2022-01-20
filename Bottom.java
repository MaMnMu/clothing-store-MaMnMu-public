
public abstract class Bottom extends Ropa
{
	private String suf;
	
	public Bottom(String d, int s, double p, String talla)
	{
		super(d, s, p, talla);
		suf = talla;
		ref = ref + suf;	
	}
	
	public static String tallaValida(String t)
	{
		if (t.equals("32") || t.equals("34") || t.equals("36") || t.equals("38") || t.equals("40") || t.equals("42") || t.equals("44")) 
				return t;
		else			
			return null;
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