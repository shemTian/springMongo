package com.tsq.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class ClassUtil {
	private static Logger logger = Logger.getLogger(ClassUtil.class);

	/**
	 * 判断是否有指定名字的属性
	 * 
	 * @param clazz
	 * @param methodName
	 * @return
	 * @author tsq
	 */
	public static boolean hasField(Class clazz, String fieldName) {
		try {
			clazz.getDeclaredField(fieldName);
			return true;
		} catch (Exception e) {
			if (e instanceof NoSuchFieldException)
				return false;
			else {
				logger.error("ClassUtil.hasField error:" + clazz.getName()
						+ "," + fieldName);
				throw new RuntimeException(e);
			}
		}
	}

	public static Field getField(Class clazz, String fieldName) {
		if (hasField(clazz, fieldName)) {
			try {
				return clazz.getDeclaredField(fieldName);
			} catch (Exception e) {
				logger.error("ClassUtil.getField error:" + clazz.getName()
						+ "," + fieldName + e);
				throw new RuntimeException(e);
			}
		} else
			return null;
	}

	public static Object getFieldValue(Object object, String fieldName) {
		if (hasField(object.getClass(), fieldName)) {
			try {
				Field field = getField(object.getClass(), fieldName);
				return field.get(object);
			} catch (IllegalAccessException accessE) {
				// 若为私有属性，调用默认set方法
				try {
					Method method = object.getClass().getMethod(
							"get" + fieldName.substring(0, 1).toUpperCase()
									+ fieldName.substring(1));
					return method.invoke(object);
				} catch (Exception e) {
					logger.error("ClassUtil.getFieldValue error:" + object
							+ ",fieldName:" + fieldName + e);
					throw new RuntimeException(e);
				}
			} catch (Exception e) {
				logger.error("ClassUtil.getFieldValue error:" + object
						+ ",fieldName:" + fieldName + e);
				throw new RuntimeException(e);
			}
		} else
			return null;
	}

	public static void setFieldValue(Object object, String fieldName,
			Object fieldValue) {
		if (hasField(object.getClass(), fieldName)) {
			Field field = null;
			try {
				field = getField(object.getClass(), fieldName);
				field.set(object, fieldValue);
			} catch (IllegalAccessException accessE) {
				// 若为私有属性，调用默认set方法
				Method method = null;
				try {
					method = object.getClass().getMethod(
							"set" + fieldName.substring(0, 1).toUpperCase()
									+ fieldName.substring(1), field.getType());
					method.invoke(object, fieldValue);
				} catch (IllegalArgumentException ileg) {
					if (field.getType().equals(BigDecimal.class)) {
						try {
							method.invoke(object,
									NumberUtil.parseBigDecimal(fieldValue));
						} catch (Exception e) {
							throw new RuntimeException(e);
						}
					} else if (field.getType().equals(Long.class)) {
						try {
							method.invoke(object,
									NumberUtil.parseLong(fieldValue));
						} catch (Exception e) {
							throw new RuntimeException(e);
						}
					}
				} catch (Exception e) {
					logger.error("ClassUtil.getFieldValue error:" + object
							+ ",fieldName:" + fieldName + e);
					throw new RuntimeException(e);
				}
			} catch (Exception e) {
				logger.error("ClassUtil.getFieldValue error:" + object
						+ ",fieldName:" + fieldName + e);
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * 判断类是否有指定的方法
	 * 
	 * @param clazz
	 * @param methodName
	 *            方法名
	 * @return
	 */
	public static boolean hasMethod(Class clazz, String methodName) {
		try {

			clazz.getMethod(methodName, null);
			return true;
		} catch (NoSuchMethodException ex) {
			return false;
		}
	}

	/**
	 * 判断类是否有指定名称和参数类型的方法
	 * 
	 * @param clazz
	 * @param methodName
	 * @param paramTypes
	 * @return
	 */
	public static boolean hasMethod(Class clazz, String methodName,
			Class[] paramTypes) {
		try {
			clazz.getMethod(methodName, paramTypes);
			return true;
		} catch (NoSuchMethodException ex) {
			return false;
		}
	}

	/**
	 * 调用对象的指定方法
	 * 
	 * @param objs
	 * @param methodName
	 * @param paramaterTypes
	 * @param parameters
	 * @return
	 * @throws Exception
	 */
	public static Object invokeMethod(Object objs, String methodName,
			Class[] paramaterTypes, Object[] parameters) throws Exception {
		Method method = objs.getClass().getMethod(methodName, paramaterTypes);
		return method.invoke(objs, parameters);
	}

	/**
	 * 获取参数类型
	 * 
	 * @param para
	 * @return
	 */
	public static Class[] getParameterTypes(Object[] para) {
		Class[] clazz = new Class[para.length];
		try {
			int i = 0;
			for (Object obj : para) {
				if (obj.getClass() == HashMap.class)
					clazz[i] = Map.class;
				else if (obj.getClass() == ArrayList.class)
					clazz[i] = List.class;
				else
					clazz[i] = obj.getClass();
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clazz;
	}
	/**
	 *  对象深度copy
	 * @param oldValue
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @author tsq
	 */
	public static Object deepCopy(Object oldValue) throws IOException,
			ClassNotFoundException {
		Serializable newValue = null;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			oos = new ObjectOutputStream(bout);
			oos.writeObject(oldValue);
			ByteArrayInputStream bin = new ByteArrayInputStream(
					bout.toByteArray());
			ois = new ObjectInputStream(bin);
			newValue = (Serializable) ois.readObject();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
				if (ois != null) {
					ois.close();
				}
			} catch (Exception e) {
				logger.error("Error closing Stream");
			}
		}
		return newValue;
	}
}
