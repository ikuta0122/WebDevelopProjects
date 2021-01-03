package com.ikuta.decorators;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.util.*;

//定义请求的具体装饰者
public class CustomRequest extends HttpServletRequestWrapper {

	public CustomRequest(HttpServletRequest request) {
		super(request);
	}

	/**
	 * 将originalMap替换为newMap 原因1:originalMap中的数据是乱码
	 * 原因:newMap中的数据来源于originalMap中的数据解决了乱码问题后放入的
	 */
	@Override
	public Map<String, String[]> getParameterMap() {
		// 新建一个Map,其中数据是解决乱码问题的,用户获取的Map也是这个Map
		Map<String, String[]> newMap = new HashMap<>();
		// 获取原始的Map,其中的数据是具有乱码问题的
		Map<String, String[]> originalMap = super.getParameterMap();

		// 将原始Map中的数据解决乱码问题,写入到新建的Map
		try {
			// 遍历原始Map
			for (String key : originalMap.keySet()) {
				// 获取当前遍历key的所有value
				String[] values = originalMap.get(key);

				// 遍历values数组,对每一个value进行中文乱码问题解决
				for (int i = 0; i < values.length; i++) {
					// 按照字符当前的编码进行打散,即进行编码
					byte[] bytes = values[i].getBytes("ISO8859-1");
					// 按照目标的编码进行组装,即进行解码
					values[i] = new String(bytes, "UTF-8");
				}
				// 将解决了乱码问题的数据放入到新建Map
				newMap.put(key, values);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 返回新Map
		return newMap;
	}

	@Override
	public Enumeration<String> getParameterNames() {
		// 获取自定义的ParameterMap
		Map<String, String[]> map = this.getParameterMap();
		// 将Set转换为Vector
		Set<String> keySet = map.keySet();
		Vector keyVector = (Vector) keySet;
		// 将Vector转换为Enumeration
		return keyVector.elements();
	}

	@Override
	public String getParameter(String name) {
		return this.getParameterValues(name)[0];
	}

	@Override
	public String[] getParameterValues(String name) {
		// 获取自定义的ParameterMap
		Map<String, String[]> map = this.getParameterMap();
		return map.get(name);
	}
}
