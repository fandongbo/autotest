package com.dzf.test.testcase.accounting.基础设置_总账;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dzf.test.page.accounting.AccountingLoginPage;
import com.dzf.test.page.accounting.AccountingMainPage;
import com.dzf.test.page.accounting.基础设置_总账.汇率档案Page;
import com.dzf.test.util.ILogUtil;
import com.dzf.test.util.MyException;

public class 汇率档案PageTest  implements ILogUtil{
	private AccountingMainPage mainPage;
	private 汇率档案Page 汇率档案;

	@BeforeClass
	public void setUp() throws Exception{
		logger.info("【AccountingSubjectSetPageTest】开始运行");
		mainPage = new AccountingMainPage();
		汇率档案 = new 汇率档案Page();
	}
	
	@BeforeTest
	@Parameters({ "用户名", "密码", "公司名称" })
	public void login(String username, String password, String company) throws Exception {

		Assert.assertTrue(new AccountingLoginPage().login(username, password, company));

	}

	@AfterTest
	public void logout() throws InterruptedException, MyException {
		mainPage.logout();
	}
	
	@Test(priority = 1)
	@Parameters({"币种","汇率","折算模式","是否浮动","备注"})
	public void add(String currency, String rate, String translationMode, String isFloateRate, 
			String comment) throws MyException, InterruptedException{
		try {
			mainPage.open汇率档案();
			boolean result = 汇率档案.add(currency, rate, translationMode, isFloateRate, comment);
			assertTrue(result);
			Thread.sleep(2000);
		} catch (MyException e) {
			Reporter.log("添加失败！");
			Reporter.log(e.getMessage());
			throw e;
		}
	}
	
	@Test(priority = 2)
	@Parameters({"币种","汇率","折算模式","是否浮动","备注"})
	public void modify(String currency, String rate, String translationMode, String isFloateRate, 
			String comment) throws MyException, InterruptedException{
		try {
			mainPage.open汇率档案();
			boolean result = 汇率档案.modify(currency, rate, translationMode, isFloateRate, comment);
			assertTrue(result);
			Thread.sleep(2000);
		} catch (MyException e) {
			Reporter.log("添加失败！");
			Reporter.log(e.getMessage());
			throw e;
		}
	}
	
	@Test(priority = 3)
	@Parameters({"币种"})
	public void delete(String currency) throws MyException, InterruptedException{
		try {
			mainPage.open汇率档案();
			boolean result = 汇率档案.delete(currency);
			assertTrue(result);
			Thread.sleep(2000);
		} catch (MyException e) {
			Reporter.log("添加失败！");
			Reporter.log(e.getMessage());
			throw e;
		}
	}
}
