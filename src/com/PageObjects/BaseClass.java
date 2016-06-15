package com.PageObjects;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import org.testng.annotations.Parameters;

import com.extent.ExtentManager;
import com.extent.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass {
	
    @BeforeMethod
    public void beforeMethod(final ITestContext testContext) {
        ExtentTestManager.startTest(testContext.getName());
    }
    
    @AfterMethod
    protected void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
        } else {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
        }
        
        ExtentManager.getReporter().endTest(ExtentTestManager.getTest());        
        ExtentManager.getReporter().flush();
    }
    
    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

}
