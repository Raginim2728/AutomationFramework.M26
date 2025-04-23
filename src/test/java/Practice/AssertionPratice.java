package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPratice
{
	@Test
	public void sample()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		 Assert.assertEquals('a', 'a');
		System.out.println("Step 4");
		System.out.println("Step 5");
		
	}
	@Test
	public void sample1()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		 sa.assertTrue(false);
		System.out.println("Step 4");
		System.out.println("Step 5");
		sa.assertAll();
	}

}
