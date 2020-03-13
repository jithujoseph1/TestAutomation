package TestNGPractice;

import org.testng.annotations.Test;

public class testNgTest {
	
	@Test(groups= {"Regression"})
	public void tc1()
	{
		System.out.println("Test case 1 exceuted");
	}
	
	@Test
	public void tc2()
	{
		System.out.println("Test case 2 exceuted");
	}

	@Test(groups= {"Regression"})
	public void tc3()
	{
		System.out.println("Test case 3 exceuted");
	}
	

}
