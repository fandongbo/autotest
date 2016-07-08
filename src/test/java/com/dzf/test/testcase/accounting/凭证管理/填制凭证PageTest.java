package com.dzf.test.testcase.accounting.凭证管理;

import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.*;

import com.dzf.test.page.accounting.AccountingLoginPage;
import com.dzf.test.page.accounting.AccountingMainPage;
import com.dzf.test.page.accounting.PrintVoucherPage;
import com.dzf.test.page.accounting.凭证管理.填制凭证Page;
import com.dzf.test.util.ILogUtil;
import com.dzf.test.util.MyException;

public class 填制凭证PageTest implements ILogUtil {

	private AccountingMainPage mainPage;
	private 填制凭证Page fillVoucherPage;
	private PrintVoucherPage printVoucherPage;

	@BeforeClass
	public void setup() throws Exception {
		logger.info("【FillVoucherPageTest】开始运行");
		mainPage = new AccountingMainPage();
		fillVoucherPage = new 填制凭证Page();
		printVoucherPage = new PrintVoucherPage();
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
	
	//@Parameters({ "科目名称", "汇率", "原币金额", "本位币金额" })
	@Parameters({ "摘要一", "科目一", "金额一", "摘要二", "科目二", "金额二", "数量", "单价", "汇率", "原币" })
	@Test
	public void test填制凭证1(String summary1, String subject1, String money1, String summary2, String subject2, String money2, String num, String unitprice, String rate, String original)
			throws InterruptedException, MyException {
		// 打开填制凭证
		mainPage.open填制凭证();

		boolean result = fillVoucherPage.saveVoucherNoNumNoCur(summary1, subject1, money1, summary2, subject2, money2, num, unitprice, rate, original);

		assertTrue(result);

	}

	@Test(groups = { "logged-in" }, enabled = false)
	public void testCommonTemplet() throws InterruptedException, MyException {
		// 填制凭证
		mainPage.open填制凭证();
//		try {
//			fillVoucherPage.commonTemplet();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		if (fillVoucherPage.isDisplayed("打印按钮")) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}

	@Test(groups = { "logged-in" }, enabled = false)
	public void testBillImage() throws InterruptedException, MyException {
		// 填制凭证
		mainPage.open填制凭证();
		fillVoucherPage.billImage();

	}

	@Test(groups = { "logged-in" }, enabled = false)
	public void testCopyByMonthOnFill() throws InterruptedException, MyException {
		// 填制凭证
		mainPage.open填制凭证();
//		fillVoucherPage.copyByMonthOnFill();

	}

	@Test(groups = "handleSaved", dependsOnGroups = "saveVoucher", enabled = false)
	public void testPrintVoucher() throws MyException {
//		fillVoucherPage.print();

		printVoucherPage.printVoucher();

		// System.out.println(Handle.driver.getCurrentUrl());
		// System.out.println(Handle.driver.getTitle());
	}

	@AfterClass
	public void teardown() throws Exception {
		logger.info("【FillVoucherPageTest】运行完毕！");
	}

}
