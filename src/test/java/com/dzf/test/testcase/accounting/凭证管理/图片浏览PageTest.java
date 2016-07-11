package com.dzf.test.testcase.accounting.凭证管理;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dzf.test.page.accounting.AccountingLoginPage;
import com.dzf.test.page.accounting.AccountingMainPage;
import com.dzf.test.page.accounting.凭证管理.图片浏览Page;
import com.dzf.test.util.ILogUtil;
import com.dzf.test.util.MyException;

public class 图片浏览PageTest implements ILogUtil{
	
	private AccountingMainPage mainPage;
	private 图片浏览Page pictureLook;
	
	@BeforeClass
	public void setup() throws Exception {
		logger.info("【VoucherManagePageTest】开始运行");
		mainPage = new AccountingMainPage();
		pictureLook = new 图片浏览Page();
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
	
	@Parameters({"公司","状态","开始日期","结束日期","开始组","结束组"})
	@Test(groups={"logged-in"},enabled=true)
	public void searchPic(String company, String status, String begindate, String enddate, String startgroup, String endgroup) throws InterruptedException, MyException{
		mainPage.open图片浏览();
		Thread.sleep(3000);
		boolean result = pictureLook.searchPic(company, status, begindate, enddate, startgroup, endgroup);
		assertTrue(result);
		Thread.sleep(10000);
	}
}
