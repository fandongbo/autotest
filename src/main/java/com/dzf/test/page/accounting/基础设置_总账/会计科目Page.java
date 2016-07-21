package com.dzf.test.page.accounting.基础设置_总账;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import com.dzf.test.model.Handler;
import com.dzf.test.model.Page;
import com.dzf.test.util.MyException;
import com.dzf.test.util.WebTableUtil;
import com.dzf.test.util.XMLUtil;
import com.sun.jna.platform.win32.OaIdl.EXCEPINFO;

public class 会计科目Page extends Handler {

	private final String xmlfile = "./config/page/accounting/基础设置_总账/" + this.getClass().getSimpleName() + ".xml";

	public 会计科目Page() throws Exception {
		super();
		page = XMLUtil.convert(xmlfile, Page.class);
	}
	
	public boolean add(String parentCode, String kmmc, String isfzhs, String kehu, String gonggyingshang,
			String zhiyuan, String xiangmu, String bumen, String cunhuo, String zidingyifzhsx, String isnum,
			String jldw, String iswhhs,String bizhong)throws MyException, InterruptedException{
		try {
			switchToDefaultContent();
			switchToFrame(getWebElement("会计科目iframe"));
			//选择父科目行并点击选中
			click(getSubjectTr(parentCode));
			// 点击增加按钮
			click("增加按钮");
			input("科目修改面板-科目名称输入框", kmmc);
			if("是".equals(isfzhs)){
				click("科目修改面板-是否辅助核算复选框");
			}
			if("是".equals(isfzhs) && isDisplayed("科目修改面板-辅助核算项")){
				if("是".equals(kehu)){
					click("科目修改面板-辅助核算项-客户");
				}
				if("是".equals(gonggyingshang)){
					click("科目修改面板-辅助核算项-供应商");
				}
				if("是".equals(zhiyuan)){
					click("科目修改面板-辅助核算项-职员");
				}
				if("是".equals(xiangmu)){
					click("科目修改面板-辅助核算项-项目");
				}
				if("是".equals(bumen)){
					click("科目修改面板-辅助核算项-部门");
				}
				if("是".equals(cunhuo)){
					click("科目修改面板-辅助核算项-存货");
				}
				if(zidingyifzhsx != null && !"".equals(zidingyifzhsx)){
					click("科目修改面板-辅助核算自定义项选择按钮");
					click(getWebElement(By.xpath("//div[text()='" + zidingyifzhsx + "']")));
				}
			}
			if("是".equals(isnum)){
				click("科目修改面板-是否数量核算复选框");
			}
			if("是".equals(isnum) && isDisplayed("科目修改面板-计量单位行")){
				input("修改科目面板-计量单位输入框", jldw);
			}
			if("是".equals(iswhhs)){
				click("修改科目面板-是否外汇核算复选框");
			}
			if("是".equals(iswhhs) && isDisplayed("科目修改面板-外汇核算行")){
				click("修改科目面板-外汇核算币种选择按钮");
				String[] bz = bizhong.split(",");
				for(int i = 0; i < bz.length; i++){
					String ele = bz[i].trim();
					click(getWebElement(By.xpath("//div[@id='whhsRefDlg']/div/div/div/div[2]/div[2]/table/tbody//td[@field='name']//div[text()='" + ele + "']")));
				}
				click("修改科目面板-外汇币种选择确认按钮");
			}
			click("修改科目面板-新增保存按钮");
			return true;
		} catch (MyException e) {
			Reporter.log("增加科目失败");
			throw e;
		}
	}
	
	public boolean modify(String code, String kmmc, String isfzhs, String kehu, String gonggyingshang,
			String zhiyuan, String xiangmu, String bumen, String cunhuo, String zidingyifzhsx, String isnum,
			String jldw, String iswhhs,String bizhong) throws MyException, InterruptedException{
		try {
			switchToDefaultContent();
			switchToFrame(getWebElement("会计科目iframe"));
			//选择父科目行并点击选中
			click(getSubjectTr(code));
			click("修改按钮");
			if(code != null && !"".equals(code)){
				input("科目修改面板-科目名称输入框", kmmc);
			}
			if("是".equals(isfzhs) && !isSelected("科目修改面板-是否辅助核算复选框")){
				click("科目修改面板-是否辅助核算复选框");
				if("是".equals(kehu)){
					click("科目修改面板-辅助核算项-客户");
				}
				if("是".equals(gonggyingshang)){
					click("科目修改面板-辅助核算项-供应商");
				}
				if("是".equals(zhiyuan)){
					click("科目修改面板-辅助核算项-职员");
				}
				if("是".equals(xiangmu)){
					click("科目修改面板-辅助核算项-项目");
				}
				if("是".equals(bumen)){
					click("科目修改面板-辅助核算项-部门");
				}
				if("是".equals(cunhuo)){
					click("科目修改面板-辅助核算项-存货");
				}
				if(zidingyifzhsx != null && "".equals(zidingyifzhsx)){
					click("科目修改面板-辅助核算自定义项选择按钮");
					click(getWebElement(By.xpath("//div[@class='panel combo-p']/div/div[text()='" + zidingyifzhsx + "']")));
				}
			}
			if("是".equals(isfzhs) && isSelected("科目修改面板-是否辅助核算复选框")){
				//清除原辅助核算项
				if(isSelected("科目修改面板-辅助核算项-客户")){
					click("科目修改面板-辅助核算项-客户");
				}
				if(isSelected("科目修改面板-辅助核算项-供应商")){
					click("科目修改面板-辅助核算项-供应商");
				}
				if(isSelected("科目修改面板-辅助核算项-职员")){
					click("科目修改面板-辅助核算项-职员");
				}
				if(isSelected("科目修改面板-辅助核算项-项目")){
					click("科目修改面板-辅助核算项-项目");
				}
				if(isSelected("科目修改面板-辅助核算项-部门")){
					click("科目修改面板-辅助核算项-部门");
				}
				if(isSelected("科目修改面板-辅助核算项-存货")){
					click("科目修改面板-辅助核算项-存货");
				}
				//重新选择辅助核算项
				if("是".equals(kehu)){
					click("科目修改面板-辅助核算项-客户");
				}
				if("是".equals(gonggyingshang)){
					click("科目修改面板-辅助核算项-供应商");
				}
				if("是".equals(zhiyuan)){
					click("科目修改面板-辅助核算项-职员");
				}
				if("是".equals(xiangmu)){
					click("科目修改面板-辅助核算项-项目");
				}
				if("是".equals(bumen)){
					click("科目修改面板-辅助核算项-部门");
				}
				if("是".equals(cunhuo)){
					click("科目修改面板-辅助核算项-存货");
				}
				if(zidingyifzhsx != null && !"".equals(zidingyifzhsx)){
					click("科目修改面板-辅助核算自定义项选择按钮");
					click(getWebElement(By.xpath("//div[@class='panel combo-p']/div/div[text()='" + zidingyifzhsx + "']")));
				}
			}
			if(("否".equals(isfzhs) || "".equals(isfzhs) || isfzhs == null) && isSelected("科目修改面板-是否辅助核算复选框")){
				click("科目修改面板-是否辅助核算复选框");
			}
			if("是".equals(isnum) && !isSelected("科目修改面板-是否数量核算复选框")){
				click("科目修改面板-是否数量核算复选框");
				if(isDisplayed("科目修改面板-计量单位行")){
					input("修改科目面板-计量单位输入框", jldw);
				}
			}
			if(("否".equals(isnum) || "".equals(isnum) || isnum == null) && isSelected("科目修改面板-是否数量核算复选框")){
				click("科目修改面板-是否数量核算复选框");
			}
			if("是".equals(iswhhs) && !isSelected("修改科目面板-是否外汇核算复选框")){
				click("修改科目面板-是否外汇核算复选框");
				click("修改科目面板-外汇核算币种选择按钮");
				String[] bz = bizhong.split(",");
				for(int i = 0; i < bz.length; i++){
					String ele = bz[i].trim();
					click(getWebElement(By.xpath("//div[@id='whhsRefDlg']/div/div/div/div[2]/div[2]/table/tbody//td[@field='name']//div[text()='" + ele + "']")));
				}
				click("修改科目面板-外汇币种选择确认按钮");
			}
			if("是".equals(iswhhs) && isSelected("修改科目面板-是否外汇核算复选框")){
				click("修改科目面板-外汇核算币种选择按钮");
				//清除原币种
				click("科目修改面板-外汇币种窗口全选按钮");
				click("科目修改面板-外汇币种窗口全选按钮");
				//重新选择币种
				String[] bz = bizhong.split(",");
				for(int i = 0; i < bz.length; i++){
					String ele = bz[i].trim();
					click(getWebElement(By.xpath("//div[@id='whhsRefDlg']/div/div/div/div[2]/div[2]/table/tbody//td[@field='name']//div[text()='" + ele + "']")));
				}
				click("修改科目面板-外汇币种选择确认按钮");
			}
			if(("否".equals(iswhhs) || "".equals(iswhhs) || iswhhs ==null) && isSelected("修改科目面板-是否外汇核算复选框")){
				click("修改科目面板-是否外汇核算复选框");
			}
			click("修改科目面板-保存按钮");
			return true;
		} catch (MyException e) {
			Reporter.log("修改科目失败");
			throw e;
		}
	}

	public boolean delete(String kmcode) throws MyException, InterruptedException{
		try {
			switchToDefaultContent();
			switchToFrame(getWebElement("会计科目iframe"));
			//选择父科目行并点击选中
			click(getSubjectTr(kmcode));
			click("删除按钮");
			if(isDisplayed("询问删除对话框")){
				click("删除确认");
			}else{
				throw new MyException("数据或规则限制，删除该科目失败。");
			}
			return true;
		} catch (MyException e) {
			Reporter.log("删除科目失败");
			throw e;
		}
	}
	
	public boolean refresh() throws MyException, InterruptedException{
		try {
			switchToDefaultContent();
			switchToFrame(getWebElement("会计科目iframe"));
			click("刷新按钮");
			return true;
		} catch (MyException e) {
			Reporter.log("刷新失败");
			throw e;
		}
	}
	
	public boolean fengcun(String kmcode) throws MyException, InterruptedException{
		try {
			switchToDefaultContent();
			switchToFrame(getWebElement("会计科目iframe"));
			click(getSubjectTr(kmcode));
			click("封存按钮");
			return true;
		} catch (MyException e) {
			Reporter.log("封存科目失败");
			throw e;
		}
	}
	
	public boolean quxiaofengcun(String kmcode) throws MyException, InterruptedException{
		try {
			switchToDefaultContent();
			switchToFrame(getWebElement("会计科目iframe"));
			click(getSubjectTr(kmcode));
			click("取消封存按钮");
			return true;
		} catch (MyException e) {
			Reporter.log("取消封存科目失败");
			throw e;
		}
	}
	
	//前期使用
	public boolean add( /*上级科目编码*/ String parentSubjectCode,  /*科目编码*/ String subjectCode,
			 /*科目名称*/  String subjectName, String 是否数量核算, String 计量单位, String 是否外汇核算,  /*币种名称*/ String currency)
					throws InterruptedException, MyException {
		try {
			switchToDefaultContent();
			switchToFrame(getWebElement("会计科目iframe"));

			// 选择父资产所在的行 并点击
			click(getSubjectTr(parentSubjectCode));
			// 点击增加按钮
			click("增加按钮");

			editSubject(subjectCode, subjectName, 是否数量核算, 计量单位, 是否外汇核算, currency);

			return isDisplayed(getSubjectTr(subjectCode));

		} catch (MyException e) {
			Reporter.log("增加会计科目失败！");
			throw e;
		}
	}

	//前期使用
	public boolean modify( /*原科目编码*/ String originSubjectCode, /* 新科目编码*/ String subjectCode,
			 /*科目名称*/  String subjectName, String 是否数量核算, String 计量单位, String 是否外汇核算,  /*币种名称*/ String currency)
					throws InterruptedException, MyException {

		try {
			switchToDefaultContent();

			switchToFrame(getWebElement("会计科目iframe"));

			click(getSubjectTr(originSubjectCode));

			click("修改按钮");

			return editSubject(subjectCode, subjectName, 是否数量核算, 计量单位, 是否外汇核算, currency);

		} catch (MyException e) {
			Reporter.log(e.getMessage());
			Reporter.log("修改失败！");
			throw e;
		}

	}

	/*
	 * 参数：会计科目、币别 功能：只修改会计科目的币别
	 */
	public boolean modify( /*科目编码*/ String subjectCode, String currency) throws InterruptedException, MyException {
		return modify(subjectCode, null, null, null, null, "是", currency);
	}

	/*
	 * 参数：会计科目、币别 功能：只修改会计科目的币别
	 */
	public boolean modify原始(/* 科目编码 */String subjectCode, String currency) throws InterruptedException, MyException {

		switchToDefaultContent();

		switchToFrame(getWebElement("会计科目iframe"));

		click(getSubjectTr(subjectCode));

		click("修改按钮");

		editSubject(null, null, null, null, "是", currency);

		Thread.sleep(500);

		// Reporter.log("点击刷新");
		click("刷新按钮");

		// Reporter.log("点击科目所在行");
		click(getSubjectTr(subjectCode));

		// Reporter.log("点击修改按钮");
		click("修改按钮");

		Thread.sleep(500);

		if (getWebElement("科目修改面板-外汇核算币种输入框").getAttribute("value").contains(currency)) {
			// Reporter.log("科目：" + subject + "已启用:" + currency);
			click("修改科目面板-取消按钮");
			return true;
		} else {
			// Reporter.log("科目：" + subject + "启用:" + currency+"失败！");
			click("科目修改面板-取消按钮");
			return false;
		}

	}

	public WebElement getSubjectTr(String subjectCode) throws InterruptedException, MyException {
		WebElement webElement = null;

		String tableList[] = { "资产左table", "负债左table", "共同左table", "所有者权益左table", "成本左table", "损益左table" };
		for (String table : tableList) {

			switch (table) {
			case "资产左table":
				// Reporter.log("点击资产");
				click("资产按钮");
				break;
			case "负债左table":
				// Reporter.log("点击负债");
				click("负债按钮");
				break;
			case "共同左table":
				// Reporter.log("点击共同");
				click("共同按钮");
				break;
			case "所有者权益左table":
				// Reporter.log("点击所有者权益");
				click("所有者权益按钮");
				break;
			case "成本左table":
				// Reporter.log("点击成本");
				click("成本按钮");
				break;
			case "损益左table":
				// Reporter.log("点击损益");
				click("损益按钮");
				break;
			}

			Thread.sleep(800);

			webElement = new WebTableUtil(getWebElement(table)).getTr(subjectCode);
			if (webElement != null) {
				return webElement;
			}

		}

		return null;
	}

	/*
	 * 
	 */
	public boolean editSubject(/* 科目编码 */String subjectCode, /* 科目名称 */ String subjectName, String 是否数量核算, String 计量单位,
			String 是否外汇核算, /* 币种名称 */String currency) throws InterruptedException, MyException {
		try {
			switchToDefaultContent();
			switchToFrame(getWebElement("会计科目iframe"));

			if (subjectCode != null && !subjectCode.equals("")) {
				input("科目修改面板-科目编码输入框", subjectCode);
			}

			if (subjectName != null && !subjectName.equals("")) {
				input("科目修改面板-科目名称输入框", subjectName);
			}

			if (是否数量核算 != null && !是否数量核算.equals("")) {

				if (是否数量核算.equals("否")) {
					click("修改科目面板-是否数量核算选择按钮");

					if (!isDisplayed("是否数量核算选项-否")) {
						System.out.println("数量核算已经被使用，无法修改！");
						// throw new MyException("数量核算已经被使用，无法修改！");
					} else {
						click("是否数量核算选项-否");
					}

				} else if (是否数量核算.equals("是")) {

					if (/* 数量核算输入框-是 */!getWebElement("修改科目面板-是否数量核算输入框").getAttribute("value").equals("是")) {
						click("修改科目面板-是否数量核算输入框");

////						if (!isDisplayed("是否数量核算选项-是")) {
////							System.out.println("数量核算已经被使用，无法修改！");
////							// throw new MyException("数量核算已经被使用，无法修改！");
//						} else {
//							click("是否数量核算选项-是");
//						}
					}

					if (计量单位 != null && !计量单位.equals("")) {
						// *[@id='sfsz']/following-sibling::span/span/a

						input("修改科目面板-计量单位输入框", 计量单位);

					} else {

						// throw new MyException("请设置具体的计量单位！");
					}
				}
			}

			if (是否外汇核算 != null && !是否外汇核算.equals("")) {

				if (是否外汇核算.equals("否")) {

					new Actions(driver).sendKeys(getWebElement("修改科目面板-否数量核算标签"), Keys.PAGE_DOWN).perform();

					click("修改科目面板-是否外汇核算选择按钮");

					click("修改科目面板-是否外汇核算选项-否");

				} else if (是否外汇核算.equals("是")) {

					if (currency != null && !currency.equals("")) {

						if (!getWebElement("修改科目面板-外汇核算币种输入框").getAttribute("value").contains(currency)) {

							// new
							// Actions(driver).sendKeys(getWebElement("是修改科目面板-否数量核算标签"),
							// Keys.DOWN).perform();

							if (getWebElement("修改科目面板-是否外汇核算复选框").isSelected()) {
								Reporter.log("外汇核算已启用，无需修改！");
							} else {
								click("修改科目面板-是否外汇核算复选框");
							}
							if (!getWebElement("修改科目面板-是否外汇核算复选框").isSelected()) {
								throw new MyException("启用会计科目：" + subjectCode + subjectName + "的外汇核算时失败！");
							}
							
							scrollTo(getWebElement("修改科目面板-外汇核算币种选择按钮"));
							
							click("修改科目面板-外汇核算币种选择按钮");

							click(new WebTableUtil(getWebElement("外汇核算币种面板table")).getTr(currency));

							click("外汇核算币种选择面板-确定按钮");
						} else {
							Reporter.log("已启用外币：" + currency + "!未做更改。");
						}
					}
				}
			}

			click("修改科目面板-保存按钮");

			return !isDisplayed("修改科目面板-保存按钮");

		} catch (MyException e) {
			Reporter.log(e.getMessage());
			Reporter.log("编辑会计科目失败！");
			throw e;
		}

	}

}
