package com.mofang.feedweb.config;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class PrivilegesConfig {

	private static final Set<Integer> AllPrivileges = new HashSet<Integer>();

	static {
		try {
			Class<?> clz = Class
					.forName("com.mofang.feedweb.global.SysPrivilege");
			// 获取实体类的所有属性，返回Field数组
			Field[] fields = clz.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				String name = field.getName();
				AllPrivileges.add(field.getInt(name));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static final Set<Integer> getAllPrivileges() {
		return AllPrivileges;
	}
}
