
import java.util.Scanner;

public class Tienda 
{
	public static Articulo[] lista = new Articulo[50];
	
	public static int menu()
	{
		Scanner sc = new Scanner(System.in);
		int op = 0;
		while(op < 1 || op > 6)
		{
			System.out.println("1. Nuevo artículo");
			System.out.println("2. Listar artículos");
			System.out.println("3. Vender");
			System.out.println("4. Reponer");
			System.out.println("5. Cambiar talla");
			System.out.println("6. Salir");
			op = sc.nextInt();
		}
		return op;
	}
	
	public static int menuArticulo()
	{
		Scanner sc = new Scanner(System.in);
		int op = 0;
		while(op < 1 || op > 4)
		{
			System.out.println("1. Accesorio");
			System.out.println("2. Top");
			System.out.println("3. Pantalón");
			System.out.println("4. Falda");
			op = sc.nextInt();
		}
		return op;
	}
	
	public static int posLibre()
	{
		for (int i = 0; i < lista.length; i++)
			if (lista[i] == null) 
				return i;
		return -1;
	}
	
	public static void nuevoArticulo()
	{
		Scanner sc = new Scanner(System.in);
		if (lista[lista.length-1] != null)
			System.out.println("La lista está llena");
		else
		{
			int pos = posLibre();
			int op = menuArticulo();
			System.out.println("Escribe la descripción");
			String desc = sc.nextLine();
			System.out.println("Escribe el stock");
			int stock = sc.nextInt();
			System.out.println("Escribe el precio");
			double precio = sc.nextDouble();
			sc.nextLine();
			
			switch (op)
			{
			case 1: lista[pos] = new Accesorio(desc, stock, precio); break;
			case 2: System.out.println("Escribe la talla");
					String t = sc.nextLine();
					while (Top.tallaValida(t) == null)
					{
						System.out.println("Talla no válida, vuelve a escribirla");
						t = sc.nextLine();
					}
					lista[pos] = new Top(desc, stock, precio, t); break;
			case 3: System.out.println("Escribe la talla");
					t = sc.nextLine();
					while (Bottom.tallaValida(t) == null)
					{
						System.out.println("Talla no válida, vuelve a escribirla");
						t = sc.nextLine();
					}
					lista[pos] = new Pantalon(desc, stock, precio, t); break;
			case 4: System.out.println("Escribe la talla");
					t = sc.nextLine();
					while (Bottom.tallaValida(t) == null)
					{
						System.out.println("Talla no válida, vuelve a escribirla");
						t = sc.nextLine();
					}
					lista[pos] = new Falda(desc, stock, precio, t); break;
			}
		}
	}

	public static void listarArticulos()
	{
		for (int i = 0; i < lista.length; i++)
			if (lista[i] != null)
				System.out.println(lista[i]);
	}
	
	public static int buscar(String r)
	{
		for (int i = 0; i < lista.length; i++)
			if (lista[i] != null && lista[i].getRef().equals(r))
				return i;
		return -1;
	}
	
	public static void vender()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe la referencia del artículo");
		String r = sc.nextLine();
		int pos = buscar(r);
		
		if (pos == -1)
			System.out.println("Artículo no encontrado");
		else if (lista[pos].getStock() == 0)
			System.out.println("No hay stock");
		else
			lista[pos].vender();
	}
	
	public static void reponer()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe la referencia del artículo");
		String r = sc.nextLine();
		int pos = buscar(r);
		
		if (pos == -1)
			System.out.println("Artículo no encontrado");
		else
		{
			System.out.println("Escribe la cantidad a reponer");
			int c = sc.nextInt();
			lista[pos].reponer(c);
		}
	}
	
	public static void cambiarTalla()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe la referencia del artículo");
		String r = sc.nextLine();
		int pos = buscar(r);
		
		if (pos == -1)
			System.out.println("Artículo no encontrado");
		else if (lista[pos] instanceof Top)
		{
			System.out.println("Escribe la talla nueva");
			String t = sc.nextLine();
			String nRef = Top.cambioTalla(r, t);
			int nPos = buscar(nRef);
			
			if (nPos == -1) 
				System.out.println("No hay artículos de la nueva talla");
			else if (lista[nPos].getStock() == 0)
				System.out.println("No hay stock de la nueva talla");
			else
			{
				((Ropa)lista[pos]).devolver();
				lista[nPos].vender();
			}
		}
		
		else if (lista[pos] instanceof Bottom)
		{
			System.out.println("Escribe la talla nueva");
			String t = sc.nextLine();
			String nRef = Bottom.cambioTalla(r, t);
			int nPos = buscar(nRef);
			
			if (nPos == -1) 
				System.out.println("No hay artículos de la nueva talla");
			else if (lista[nPos].getStock() == 0)
				System.out.println("No hay stock de la nueva talla");
			else
			{
				((Ropa)lista[pos]).devolver();
				lista[nPos].vender();
			}		
		}
	}
	
	public static void main (String[] args)
	{
		int op = menu();
		while (op != 6)
		{
			switch (op)
			{
			case 1: nuevoArticulo(); break;
			case 2: listarArticulos(); break;
			case 3: vender(); break;
			case 4: reponer(); break;
			case 5: cambiarTalla(); break;
			}
			op = menu();
		}
	}
}
