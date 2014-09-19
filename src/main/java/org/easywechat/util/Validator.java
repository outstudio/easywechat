package org.easywechat.util;

public class Validator {

	/**
	 * 判断传入的参数是否含有null
	 */
	public static boolean hasNull(Object... params) {
		for (int i = 0; i < params.length; i++) {
			if (params[i] == null) {
				return true;
			}
		}
		return false;
	}
}
