package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AsserationPractice 
{
	
	
	@Test
	public void sampleHardAssert() //hard -assert
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		Assert.assertEquals(1, 1);//actual,expected
		
		System.out.println("Step 4");
		System.out.println("Step 5");
	
	}
	
	
	@Test
	public void sampleSoftAssert() //soft-assert
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(1, 0);//actual,expected
		
		System.out.println("Step 4");
		System.out.println("Step 5");
		
		sa.assertAll();//log the failure 
	
	}


}
