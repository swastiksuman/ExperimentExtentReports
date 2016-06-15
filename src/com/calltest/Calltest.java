package com.calltest;

import com.extent.ExtentTestManager;
import com.relevantcodes.extentreports.LogLevel;
import com.relevantcodes.extentreports.LogStatus;

public class Calltest {
	public void testCall(){
		ExtentTestManager.getTest().log(LogStatus.PASS, "KuchBHI");
	}
}
