package Practice;

public class GenericMethodsPractice {

	public static void main(String[] args) // Calling function/Caller function
	{
	int sum = add(200,400);	
	System.out.println(sum);
	
	System.out.println(add(sum,800));
	System.out.println(add(sum,500));

	}
	public static int add(int a, int b) //Called function
	{
		int c=a+b;// logic
		//System.out.println(c);
		return c;
		
	}
}
