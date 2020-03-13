package TestWebDriver;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerMain implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result)
	{
	System.out.println("Test case "+result.getName()+" is passed");	
	System.out.println(result.getTestClass()+result.getTestName());
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
	System.out.println("Test case "+result.getName()+" is failed");	
	System.out.println("Error is "+result.getThrowable());
	}
}
