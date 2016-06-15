package com.PageObjects;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.calltest.Calltest;
import com.extent.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class ParallelClass1 extends BaseClass {
    @Test
    public void parallelClass1TestResultMustEqualPass() {
        ExtentTestManager.getTest().log(LogStatus.PASS, "Log from threadId: " + Thread.currentThread().getId());
        ExtentTestManager.getTest().log(LogStatus.INFO, "Log from threadId: " + Thread.currentThread().getId());
        Calltest ct=new Calltest();
        ct.testCall();
        Assert.assertEquals(ExtentTestManager.getTest().getRunStatus(), LogStatus.PASS);
    }
}