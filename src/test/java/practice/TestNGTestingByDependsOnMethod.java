package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGTestingByDependsOnMethod 
{
	@Test(priority=-1)//first negative -3,-2,-1 order priority get excuted
	public void create()//create a customer
	    {
		Assert.fail();//fail
		System.out.println("create");
		}

	@Test(dependsOnMethods = "create")  //second "0" priority get excuted
	public void modify()//update a customer
	    {
		System.out.println("modify");
		}

	@Test(invocationCount=2,priority=3)//last positive from 1,2,3 order priority get excuted
	public void delete()// delete a customer
	    {
		System.out.println("delete");
}
}