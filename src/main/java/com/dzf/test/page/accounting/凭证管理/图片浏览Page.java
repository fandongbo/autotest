package com.dzf.test.page.accounting.凭证管理;

import org.testng.Reporter;

import com.dzf.test.model.Handler;
import com.dzf.test.model.Page;
import com.dzf.test.util.MyException;
import com.dzf.test.util.XMLUtil;

public class 图片浏览Page  extends Handler{
	
	public 图片浏览Page() throws Exception {
		super();
		page = XMLUtil.convert("./config/page/accounting/凭证管理/" + this.getClass().getSimpleName() + ".xml",
				Page.class.getName());
	}
	
	//图片查询
	public boolean searchPic(String company, String status, String begindate, String enddate, String startgroup, String endgroup) throws MyException{
		
		switchToDefaultContent();
		switchToFrame(getWebElement("图片浏览iframe"));
		mouseMoveTo("查询按钮");
		
		try {
			Reporter.log("输入查询条件");
			if(company != null && !"".equals(company)){
				//暂不实现
			}
			if(status != null && !"".equals(status)){
				switch(status){
					case "全部":
						click("状态选择按钮");
						click("状态全部");
						break;
					case "未处理":
						click("状态选择按钮");
						click("状态未处理");
						break;
					case "处理中":
						click("状态选择按钮");
						click("状态处理中");
						break;
					case "已退回":
						click("状态选择按钮");
						click("状态已退回");
						break;
					case "已制证":
						click("状态选择按钮");
						click("状态已制证");
						break;
					default:
						return false;
				}
			}
			if(begindate != null && !"".equals(begindate) && enddate != null && !"".equals(enddate)){
				input("开始日期", begindate);
				input("结束日期", enddate);
			}
			if(startgroup != null && !"".equals(startgroup) && endgroup != null && !"".equals(endgroup)){
				input("开始图片组", startgroup);
				input("结束图片组", enddate);
			}
			click("结束日期托盘按钮");
			click("查询面板确定按钮");
			return true;
		} catch (MyException e) {
			Reporter.log(e.getMessage());
			Reporter.log("查询失败");
			throw e;
		}
	}
}
