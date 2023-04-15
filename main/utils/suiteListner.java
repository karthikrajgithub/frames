package utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import TestPackage1.BaseTest;

public class suiteListner implements ITestListener,IAnnotationTransformer  {
	
	
@Override
public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	ITestListener.super.onStart(context);
}

@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}

@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

@Override
	public void onTestFailure(ITestResult iTestResult) {
		String shotfile=System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+iTestResult.getMethod().getMethodName();//path should be checked
		TakesScreenshot shot=((TakesScreenshot)BaseTest.driver);
		File f1= shot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(f1, new File(shotfile+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}


@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
	annotation.setRetryAnalyzer(RetryAnalyser.class);
	
	}
}
