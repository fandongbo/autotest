package com.dzf.test.testcase.accounting.凭证管理;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import org.testng.Assert;

import com.dzf.test.page.accounting.AccountingLoginPage;
import com.dzf.test.page.accounting.AccountingMainPage;
import com.dzf.test.page.accounting.凭证管理.凭证管理Page;
import com.dzf.test.util.ILogUtil;
import com.dzf.test.util.MyException;

public class 凭证管理PageTest implements ILogUtil{
	private AccountingMainPage mainPage;
	private 凭证管理Page voucherManagePage;
	
	@BeforeClass
	public void setup() throws Exception {
		logger.info("【VoucherManagePageTest】开始运行");
		mainPage = new AccountingMainPage();
		voucherManagePage = new 凭证管理Page();
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
	
	/*@Parameters({"开始年月","结束年月"})
	@Test(groups={"logged-in"},enabled=true)
	public void testAuditVoucher(String beginDate,String endDate) throws InterruptedException, MyException{
		mainPage.open凭证管理();
		voucherManagePage.auditVoucher(beginDate,endDate);
		
		assertTrue(voucherManagePage.isDisplayed("操作提示"));
		
		Thread.sleep(3000);
		
	}
	
	@Parameters({"开始年月","结束年月"})
	@Test(groups={"logged-in"},enabled=true)
	public void testAccountVoucher(String beginDate,String endDate) throws InterruptedException, MyException{
		mainPage.open凭证管理();
//		voucherManagePage.accountVoucher(beginDate,endDate);
		
		assertTrue(voucherManagePage.isDisplayed("操作提示"));
		
		Thread.sleep(3000);
	}*/
	
	@Parameters({"查询方式","开始年月","结束年月","开始凭证号","结束凭证号","状态","科目","摘要","最小金额","最大金额","公司"})
	@Test(groups={"logged-in"},enabled=true)
	public void searchVoucher(String byDateOrPeriod, String beginDate, String endDate, String beginCode,
			String endCode, String status, String subject, String digest, String minMoney, String maxMoney,
			String company) throws InterruptedException, MyException{
		mainPage.open凭证管理();
		boolean result = voucherManagePage.searchVoucher(byDateOrPeriod,beginDate,endDate,beginCode,endCode,status,subject,digest,minMoney,maxMoney,company);
		assertTrue(result);
		Thread.sleep(3000);
	}
}
