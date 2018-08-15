package com.qtpselenium.rediff.hybrid.testcases.PortfolioSuite;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qtpselenium.hybrid.base.BaseTest;
import com.qtpselenium.hybrid.utils.Constants;
import com.qtpselenium.hybrid.utils.DataUtil;


public class LoginTest extends BaseTest {

	@Test(dataProvider="getData")
	public void logintest(Hashtable<String,String> data) throws Exception {
	
		test.log(Status.INFO, "Starting "+ testName);
		
		if(DataUtil.isSkip(testName, xls) ||data.get(Constants.RUNMODE_COL).equals(Constants.RUNMODE_NO)){
			test.log(Status.SKIP, "Runmode is set to NO");
			throw new SkipException("Runmode is set to NO");
		}		
		
		
		System.out.println("Login Test");
		System.out.println("From Dp"+ data);
		ds.executeKeywords(testName, xls, data);
	}
}
