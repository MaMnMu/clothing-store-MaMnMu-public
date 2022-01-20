
public abstract class Ropa extends Articulo implements ICambiable
{
	protected String talla;
	
	public Ropa(String d, int s, double p, String talla)
	{
		super(d, s, p);
		this.talla = talla;
	}
	
	public void devolver()
	{
		stock++;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + "\nTalla: " + talla;
	}
}
