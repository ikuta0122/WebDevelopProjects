package com.ikuta.demo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ForEachTag_one extends SimpleTagSupport {
	private Object items;
	private String var;

	public void setItems(Object items) {
		this.items = items;
	}

	public void setVar(String var) {
		this.var = var;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void doTag() throws JspException, IOException {
		if (items instanceof List) {
			List itemsList = (List) items;
			for (Object obj : itemsList) {
				this.getJspContext().setAttribute(var, obj);
				this.getJspBody().invoke(null);
			}
		} else if (items instanceof Set) {
			Set itemsSet = (Set) items;
			for (Object obj : itemsSet) {
				this.getJspContext().setAttribute(var, obj);
				this.getJspBody().invoke(null);
			}
		} else if (items instanceof Map) {
			Map itemsMap = (Map) items;
			for (Object obj : itemsMap.entrySet()) {
				this.getJspContext().setAttribute(var, obj);
				this.getJspBody().invoke(null);
			}
		} else if (items instanceof Object[]) {
			Object[] itemsArray = (Object[]) items;
			for (Object obj : itemsArray) {
				this.getJspContext().setAttribute(var, obj);
				this.getJspBody().invoke(null);
			}
		}
	}
}
