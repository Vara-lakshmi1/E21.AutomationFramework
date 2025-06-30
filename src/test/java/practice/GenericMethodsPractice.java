package practice;

public class GenericMethodsPractice// example of addition .sub.mul.div
{

	public static void main(String[] args) 
	{
		int sum=add(10,30);
		System.out.println(sum);
		System.out.println(add(24,sum));
		System.out.println(add(199,276));
		System.out.println(add(434,sum));
		System.out.println(add(1441,4144));
		System.out.println(add(44,sum));
		
		int sum2=add(sum,70);
		System.out.println(sum2);
		
		int sub=subt(40,34);
		System.out.println(sub);
		
		int mul=mult(21,23);
		System.out.println(mul);
	}
	public static int add(int a,int b)
	{
		int c=a+b;
		return c;
	}
	public static int subt(int e,int f)
	{
		int d=e-f;
		return d;
	}
	public static int mult(int p,int q)
	{
		int r=p*q;
		return r;
	}
}
