package com.dzf.test.page.accounting.基础设置_总账;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.dzf.test.model.Handler;
import com.dzf.test.model.Page;
import com.dzf.test.util.MyException;
import com.dzf.test.util.XMLUtil;

public class 汇兑损益结转模版Page extends Handler {

	private final String xmlfile = "./config/page/accounting/基础设置_总账/" + this.getClass().getSimpleName() + ".xml";

	public 汇兑损益结转模版Page() throws Exception {
		super();

		page = XMLUtil.convert(xmlfile, Page.class);
	}

	public boolean modify() throws InterruptedException, MyException {

		switchToDefaultContent();

		switchToFrame("");
		
		return false;
	}

}
