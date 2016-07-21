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
import com.dzf.test.page.accounting.基础设置_总账.会计科目Page;
import com.dzf.test.util.ILogUtil;
import com.dzf.test.util.MyException;

public class 会计科目PageTest implements ILogUtil{
	private AccountingMainPage mainPage;
	private 会计科目Page 会计科目;
	
	@BeforeClass
	public void setUp() throws Exception{
		logger.info("【AccountingSubjectSetPageTest】开始运行");
		mainPage = new AccountingMainPage();
		会计科目 = new 会计科目Page();
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
	@Parameters({"父科目编码","科目名称","是否辅助核算","辅助项-客户","辅助项-供应商","辅助项-职员","辅助项-项目","辅助项-部门","辅助项-存货","辅助项-自定义","是否数量核算","计量单位","是否外汇核算","币种"})
	public void addKm(String parentCode, String kmmc, String isfzhs, String kehu, String gonggyingshang,
			String zhiyuan, String xiangmu, String bumen, String cunhuo, String zidingyifzhsx, String isnum,
			String jldw, String iswhhs,String bizhong) throws MyException, InterruptedException{
		try {
			mainPage.open会计科目();
			boolean result = 会计科目.add(parentCode, kmmc, isfzhs, kehu, gonggyingshang,zhiyuan, xiangmu, bumen, cunhuo, zidingyifzhsx, isnum,
					jldw, iswhhs, bizhong);
			assertTrue(result);
			Thread.sleep(2000);
		} catch (MyException e) {
			Reporter.log("添加失败！");
			Reporter.log(e.getMessage());
			throw e;
		}
	}
	
	@Test(priority = 2)
	@Parameters({"科目编码","科目名称","是否辅助核算","辅助项-客户","辅助项-供应商","辅助项-职员","辅助项-项目","辅助项-部门","辅助项-存货","辅助项-自定义","是否数量核算","计量单位","是否外汇核算","币种"})
	public void modifyKm(String code, String kmmc, String isfzhs, String kehu, String gonggyingshang,
			String zhiyuan, String xiangmu, String bumen, String cunhuo, String zidingyifzhsx, String isnum,
			String jldw, String iswhhs, String bizhong) throws MyException, InterruptedException{
		try{
			mainPage.open会计科目();
			boolean result = 会计科目.modify(code, kmmc, isfzhs, kehu, gonggyingshang,zhiyuan, xiangmu, bumen, cunhuo, zidingyifzhsx, isnum,
					jldw, iswhhs, bizhong);
			assertTrue(result);
			Thread.sleep(2000);
		}catch(MyException e){
			Reporter.log("修改失败！");
			Reporter.log(e.getMessage());
			throw e;
		}
	}
	
	@Test(priority = 6)
	@Parameters({"科目编码"})
	public void delete(String code) throws MyException, InterruptedException{
		try {
			mainPage.open会计科目();
			boolean result = 会计科目.delete(code);
			assertTrue(result);
			Thread.sleep(2000);
		} catch (MyException e) {
			Reporter.log("删除失败！");
			Reporter.log(e.getMessage());
			throw e;
		}
	}
	
	@Test(priority = 3)
	public void refresh() throws MyException, InterruptedException{
		try {
			mainPage.open会计科目();
			boolean result = 会计科目.refresh();
			assertTrue(result);
			Thread.sleep(2000);
		} catch (MyException e) {
			Reporter.log("刷新失败！");
			Reporter.log(e.getMessage());
			throw e;
		}
	}
	
	@Test(priority = 4)
	@Parameters({"科目编码"})
	public void fengcun(String code) throws MyException, InterruptedException{
		try {
			mainPage.open会计科目();
			boolean result = 会计科目.fengcun(code);
			assertTrue(result);
			Thread.sleep(2000);
		} catch (MyException e) {
			Reporter.log("封存失败！");
			Reporter.log(e.getMessage());
			throw e;
		}
	}
	
	@Test(priority = 5)
	@Parameters({"科目编码"})
	public void quxiaofengcun(String code) throws MyException, InterruptedException{
		try {
			mainPage.open会计科目();
			boolean result = 会计科目.quxiaofengcun(code);
			assertTrue(result);
			Thread.sleep(2000);
		} catch (MyException e) {
			Reporter.log("取消封存失败！");
			Reporter.log(e.getMessage());
			throw e;
		}
	}
}
