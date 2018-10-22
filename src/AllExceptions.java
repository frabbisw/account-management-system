import java.util.*;
import java.lang.*;

class AllExceptions
{
	Exception e;
	public AllExceptions(Exception e)
	{
		this.e = e;
		handler();
	}
	
	private void handler()
	{
		if(e instanceof ArithmeticException)
		{
			System.out.println("Divided by zero.");
		}
		else if(e instanceof InputMismatchException)
		{
			System.out.println("Input Mismatched.");
		}
		else if(e instanceof ArrayIndexOutOfBoundsException)
		{
			System.out.println("Array index is out Of bounds.");
		}
		else if(e instanceof ArrayStoreException)
		{
			System.out.println("ArrayStoreExceptions");
		}
		else if(e instanceof ClassCastException)
		{
			System.out.println("Invalid cast");
		}
		else if(e instanceof IllegalArgumentException)
		{
			System.out.println("Illegal argument used to invoke a method.");
		}
		else if(e instanceof IllegalMonitorStateException)
		{
			System.out.println("Illegal monitor operation.");
		}
		else if(e instanceof IllegalStateException)
		{
			System.out.println("Environment or application is in incorrect state.");
		}
		else if(e instanceof IllegalThreadStateException)
		{
			System.out.println("Requested operation not compatible with current thread state.");
		}
		else if(e instanceof IndexOutOfBoundsException)
		{
			System.out.println("Some type of index is out-of-bounds.");
		}
		else if(e instanceof NegativeArraySizeException)
		{
			System.out.println("Array created with a negative size.");
		}
		else if(e instanceof NullPointerException)
		{
			System.out.println("Invalid use of a null reference.");
		}
		else if(e instanceof NumberFormatException)
		{
			System.out.println("Invalid conversion of a string to a numeric format.");
		}
		else if(e instanceof SecurityException)
		{
			System.out.println("Attempt to violate security.");
		}
		else if(e instanceof StringIndexOutOfBoundsException)
		{
			System.out.println("Attempt to index outside the bounds of a string.");
		}
		else if(e instanceof UnsupportedOperationException)
		{
			System.out.println("An unsupported operation was encountered.");
		}
		else if(e instanceof ClassNotFoundException)
		{
			System.out.println("Class not found.");
		}
		else if(e instanceof CloneNotSupportedException)
		{
			System.out.println("Attempt to clone an object that does not implement the Cloneable interface.");
		}
		else if(e instanceof IllegalAccessException)
		{
			System.out.println("Access to a class is denied.");
		}
		else if(e instanceof InstantiationException)
		{
			System.out.println("Attempt to create an object of an abstract class or interface.");
		}
		else if(e instanceof InterruptedException)
		{
			System.out.println("One thread has been interrupted by another thread.");
		}
		else if(e instanceof NoSuchFieldException)
		{
			System.out.println("A requested field does not exist.");
		}
		else if(e instanceof NoSuchMethodException)
		{
			System.out.println("A requested method does not exist.");
		}		
	}
}
