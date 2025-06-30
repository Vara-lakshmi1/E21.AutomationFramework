package practice;

import org.testng.annotations.Test;

public class TestNGTestingByEnable
{
	@Test(priority=-1)//first negative -3,-2,-1 order priority get excuted
	public void create()
	    {
		System.out.println("create");
		}

	@Test(enabled=false)  //second "0" priority get excuted
	public void modify()
	    {
		System.out.println("modify");
		}
	
	@Test(invocationCount=2,priority=-2)//last positive from 1,2,3 order priority get excuted
	public void delete()
	    {
		System.out.println("delete");
}
}