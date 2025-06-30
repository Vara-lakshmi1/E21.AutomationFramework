package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice
{        @Test(dataProvider="customerinfo")
		 public void createCustomer(String name,int id)
		 {
			 //name id -5 -run multiple times -different data
			 //multiple customer in single exeution 
				System.out.println("The customer name is ->"+name);
				System.out.println("The customer id is ->"+id);
		 }
		 
		 //stock your data
		 @DataProvider(name="customerinfo")//row and column
		 public Object[][] getData()//4 sets of data and each set has 2 info
		  {
			Object[][]data=new Object[4][2];
			  //First data set
			   data[0][0]="venki";
			    data[0][1]=120;
			
			 //second data set
				data[1][0]="vara";
				data[1][1]=14;
				
		     //third data set
				data[2][0]="priya";
				data[2][1]=17;
			
			 //Four data set
				data[3][0]="paru";
				data[3][1]=19;
				
				return data;
		   }	
}
