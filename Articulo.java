
public abstract class Articulo 
{	
	protected String ref;
	protected String desc;
	protected int stock;
	protected double precio;

	protected static int contador = 1;
	
	public Articulo(String d, int s, double p)
	{
		desc = d;
		stock = s;
		precio = p;
		ref = "" + contador;
		while (ref.length() < 3) 
			ref = "0" + ref;
		ref = "-" + ref + "-";
		contador++;
	}
	
	public boolean vender()
	{
		if (stock > 0) 
		{
			stock--;
			return true;
		}
		else
		{
			System.out.println("No hay stock disponible");
			return false;
		}
	}
	
	public void reponer(int c)
	{
		stock += c;
	}
	
	public String getRef()
	{
		return ref;
	}
	
	public int getStock()
	{
		return stock;
	}
	
	@Override
	public String toString()
	{
		return "Referencia: " + ref + "\nDescripción: " + desc + "\nStock: " + stock + "\nPrecio: " + precio;
	}
}
