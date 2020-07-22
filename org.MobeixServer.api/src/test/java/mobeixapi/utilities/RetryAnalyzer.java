package mobeixapi.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import mobeixapi.base.base;

public class RetryAnalyzer extends base implements IRetryAnalyzer{

	int counter=3, retryLimit=3;
	
	public boolean retry(ITestResult result) {
		
		if(counter<retryLimit)
		{
			counter++;
			return true;
		}
		else
		{
		return false;
		}
	}
}
