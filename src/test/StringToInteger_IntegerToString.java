package test;

public class StringToInteger_IntegerToString {

	public static void main(String[] args) 
	{
		String str1 = "4561";
		String str2 = "43";
		int x = Integer.parseInt(str1);
		int y = Integer.parseInt(str2);
		
		System.out.println(x+y);
		System.out.println(x-y);
		System.out.println(x*y);
		System.out.println(x%y);
		
		
		int a = 5555;
		int b = 4213;
		String St1 = String.valueOf(a);
		String st2 = String.valueOf(b);
		
		System.out.println(St1.concat(st2));
		

	}

}
