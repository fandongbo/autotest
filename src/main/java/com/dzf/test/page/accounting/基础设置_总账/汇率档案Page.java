package com.dzf.test.page.accounting.基础设置_总账;

import org.openqa.selenium.By;
import org.testng.Reporter;

import com.dzf.test.model.Handler;
import com.dzf.test.model.Page;
import com.dzf.test.util.MyException;
import com.dzf.test.util.WebTableUtil;
import com.dzf.test.util.XMLUtil;

public class 汇率档案Page extends Handler {

	private final String xmlfile = "./config/page/accounting/基础设置_总账/" + this.getClass().getSimpleName() + ".xml";

	public 汇率档案Page() throws Exception {
		super();

		page = XMLUtil.convert(xmlfile, Page.class);
	}

	public boolean add(String currency, String rate, String translationMode, String isFloateRate, String comment)
			throws InterruptedException, MyException {
		try {
			boolean result = false;
			switchToDefaultContent();
			switchToFrame(getWebElement("汇率档案iframe"));

			WebTableUtil 汇率档案表格 = new WebTableUtil(getWebElement("汇率档案表格"));
			for (int i = 0; i < 汇率档案表格.getRowCount(); i++) {
				String 币种 = 汇率档案表格.getCell(i, 4).findElement(By.tagName("div")).getText();
				if (币种.equals(currency)) {
					Reporter.log(currency + "已存在！增加失败！");
					return result;
				}
			}

			click("增加按钮");
			click("币种选择按钮");

			Thread.sleep(500);
			// 点击币种名称
			WebTableUtil 选择币种表格 = new WebTableUtil(getWebElement("选择币种表格"));

			boolean found = false;

			for (int j = 0; j < 选择币种表格.getRowCount(); j++) {
				String 币种 = getWebElement(选择币种表格.getCell(j, 2), By.tagName("div")).getText();

				if (币种.equals(currency)) {
					found = true;
					Reporter.log("点击" + currency + "所在的行");
					选择币种表格.getCell(j, 2).click();
				}
			}

			if (found == false) {
				Reporter.log("没有找到该币种：" + currency + "！修改失败！");
				click("选择币种面板-取消按钮");
				click("增加汇率信息面板-取消按钮");
				return result;
			}

			click("选择币种面板-保存按钮");

			input("汇率输入框", rate);

			click("汇率折算模式选择按钮");

			switch (translationMode) {
			case "乘":
				click("折算模式-乘");
				break;
			case "除":
				click("折算模式-除");
				break;
			default:
				click("折算模式-乘");
				break;
			}

			click("是否浮动汇率选择按钮");

			switch (isFloateRate) {
			case "是":
				click("浮动汇率选项-是");
				break;
			case "否":
				click("浮动汇率选项-否");
				break;
			default:
				click("浮动汇率选项-否");
				break;
			}

			input("备注输入框", comment);
			click("增加汇率信息面板-保存按钮");

			Thread.sleep(1500);

			WebTableUtil 汇率档案表格2 = new WebTableUtil(getWebElement("汇率档案表格"));

			for (int i = 0; i < 汇率档案表格2.getRowCount(); i++) {
				String 币种 = 汇率档案表格2.getCell(i, 4).findElement(By.tagName("div")).getText();

				if (币种.equals(currency)) {
					result = true;
				}
			}

			return result;
		} catch (MyException e) {
			Reporter.log("汇率添加失败！");
			throw e;
		}
	}

	public boolean modify(String currency, String rate, String translationMode, String isFloateRate, String comment)
			throws InterruptedException, MyException {
		try {
			boolean result = false;
			switchToDefaultContent();
			switchToFrame(getWebElement("汇率档案iframe"));

			WebTableUtil 汇率档案表格 = new WebTableUtil(getWebElement("汇率档案表格"));
			boolean currencyExist = false;
			for (int i = 0; i < 汇率档案表格.getRowCount(); i++) {
				String 币种 = getText(getWebElement(汇率档案表格.getCell(i, 4), By.tagName("div")));

				if (币种.equals(currency)) {
					currencyExist = true;
					click(getWebElement(汇率档案表格.getCell(i, 4), By.tagName("div")));
				}
			}

			if (!currencyExist) {
				Reporter.log(currency + "不存在！修改失败！");
				return result;
			}
			click("修改按钮");
			click("币种选择按钮");
			Thread.sleep(500);
			
			WebTableUtil 选择币种表格 = new WebTableUtil(getWebElement("选择币种表格"));
			boolean found = false;
			for (int j = 0; j < 选择币种表格.getRowCount(); j++) {
				String 币种 = 选择币种表格.getCell(j, 2).findElement(By.tagName("div")).getText();

				if (币种.equals(currency)) {
					found = true;
					click(选择币种表格.getCell(j, 2));
				}
			}

			if (found == false) {
				Reporter.log("没有找到该币种：" + currency);
				click("选择币种面板-取消按钮");
				click("增加汇率信息面板-取消按钮");
				return result;
			}
			click("选择币种面板-保存按钮");
			input("汇率输入框", rate);
			click("汇率折算模式选择按钮");
			switch (translationMode) {
			case "乘":
				click("折算模式-乘");
				break;
			case "除":
				click("折算模式-除");
				break;
			default:
				click("折算模式-乘");
				break;
			}
			
			click("是否浮动汇率选择按钮");
			switch (isFloateRate) {
			case "是":
				click("浮动汇率选项-是");
				break;
			case "否":
				click("浮动汇率选项-否");
				break;
			default:
				click("浮动汇率选项-否");
				break;
			}

			input("备注输入框", comment);
			click("增加汇率信息面板-保存按钮");

			Thread.sleep(1500);

			WebTableUtil 汇率档案表格2 = new WebTableUtil(getWebElement("汇率档案表格"));

			for (int i = 0; i < 汇率档案表格2.getRowCount(); i++) {
				String 币种 = 汇率档案表格2.getCell(i, 4).findElement(By.tagName("div")).getText();

				if (币种.equals(currency)) {
					result = true;
				}
			}

			return result;
		} catch (MyException e) {
			Reporter.log("汇率修改失败！");
			throw e;
		}
	}

	public boolean delete(String currency) throws InterruptedException, MyException{
		try {
			switchToDefaultContent();
			switchToFrame(getWebElement("汇率档案iframe"));
			WebTableUtil 汇率档案表格 = new WebTableUtil(getWebElement("汇率档案表格"));
			boolean currencyExist = false;
			for (int i = 0; i < 汇率档案表格.getRowCount(); i++) {
				String 币种 = getText(getWebElement(汇率档案表格.getCell(i, 4), By.tagName("div")));
				if (币种.equals(currency)) {
					currencyExist = true;
					click(getWebElement(汇率档案表格.getCell(i, 4), By.tagName("div")));
				}
			}
			if (!currencyExist) {
				Reporter.log(currency + "不存在！删除失败！");
				return false;
			}
			click("删除按钮");
			if(isDisplayed("删除提示对话框")){
				click("删除提示对话框-确定");
				return true;
			}else{
				Reporter.log(currency + "删除失败。被数据引用或系统预制不可删除。");
				return false;
			}
		} catch (MyException e) {
			Reporter.log("删除失败");
			throw e;
		}
	}
}
