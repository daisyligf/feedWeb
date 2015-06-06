package com.mofang.feedweb.util;

import java.net.InetAddress;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

/**
 * 
 * @author zhaodx
 *
 */
public class StringUtil 
{
	
	/**
	 * 判断字符串是否为空或者为null
	 * @param value
	 * @return
	 */
	public static boolean isNullOrEmpty(String value)
	{
		return value == null || value.isEmpty();
	}
	
	/**
	 * 判断字符串是否为整型
	 * @param value
	 * @return
	 */
	public static boolean isInteger(String value)
	{
		try 
		{
			Integer.parseInt(value);
			return true;
			
		} catch (Exception e) 
		{
			return false;
		}
	}
	
	/**
	 * 判断字符串是否为长整型
	 * @param value
	 * @return
	 */
	public static boolean isLong(String value)
	{
		try 
		{
			Long.parseLong(value);
			return true;
			
		} catch (Exception e) 
		{
			return false;
		}
	}
	
	/**
	 * 判断字符串是否为短整型
	 * @param value
	 * @return
	 */
	public static boolean isShort(String value)
	{
		try 
		{
			Short.parseShort(value);
			return true;
			
		} catch (Exception e) 
		{
			return false;
		}
	}

	/**
	 * 判断字符串是否为单精度浮点型
	 * @param value
	 * @return
	 */
	public static boolean isFloat(String value)
	{
		try 
		{
			Float.parseFloat(value);
			return true;
			
		} catch (Exception e) 
		{
			return false;
		}
	}

	/**
	 * 判断字符串是否为双精度浮点型
	 * @param value
	 * @return
	 */
	public static boolean isDouble(String value)
	{
		try 
		{
			Double.parseDouble(value);
			return true;
			
		} catch (Exception e) 
		{
			return false;
		}
	}
	
	/**
	 * 判断字符串是否为布尔型
	 * @param value
	 * @return
	 */
	public static boolean isBoolean(String value)
	{
		try 
		{
			Boolean.parseBoolean(value);
			return true;
			
		} catch (Exception e) 
		{
			return false;
		}
	}
	
	/**
	 * 判断字符串是否为字节型
	 * @param value
	 * @return
	 */
	public static boolean isByte(String value)
	{
		try 
		{
			Byte.parseByte(value);
			return true;
			
		} catch (Exception e) 
		{
			return false;
		}
	}

	/**
	 * 判断字符串是否为短日期类型(yyyy-MM-dd)
	 * @param value
	 * @return
	 */
	public static boolean isShortDate(String value)
	{
		return isDate(value, "yyyy-MM-dd");
	}

	/**
	 * 判断字符串是否为长日期类型(yyyy-MM-dd HH:mm:ss)
	 * @param value
	 * @return
	 */
	public static boolean isLongDate(String value)
	{
		return isDate(value, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 判断字符串是否为指定格式的日期类型
	 * @param value
	 * @param format
	 * @return
	 */
	public static boolean isDate(String value, String format)
	{
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		try 
		{
			formatter.parse(value);
			return true;
		} catch (Exception e) 
		{
			return false;
		}
	}

	/**
	 * 判断字符串是否由数字组成
	 * @param value
	 * @return
	 */
	public static boolean isNumeric(String value)
	{
		if(isNullOrEmpty(value))
			return false;
		
		for(int i = 0; i < value.length(); i++)
			if(!Character.isDigit(value.charAt(i)))
				return false;
		
		return true;
	}
	
	/**
	 * 判断字符串是否由字母组成
	 * @param value
	 * @return
	 */
	public static boolean isLetter(String value)
	{
		if(isNullOrEmpty(value))
			return false;
		
		for(int i = 0; i < value.length(); i++)
			if(!Character.isLetter(value.charAt(i)))
				return false;
		
		return true;
	}

	/**
	 * 判断字符串是否由汉字组成
	 * @param value
	 * @return
	 */
	public static boolean isChinese(String value)
	{
		if(isNullOrEmpty(value))
			return false;
		
		for(int i = 0; i < value.length(); i++)
			if(value.charAt(i) < 19968 || value.charAt(i) > 40869)
				return false;
		
		return true;
	}

	/**
	 * 对URL参数进行编码
	 * @param value
	 * @param encode
	 * @return
	 */
	public static String urlEncode(String value, String encode)
	{
		try 
		{
			return URLEncoder.encode(value, encode);
		}
		catch (Exception e) 
		{
			return null;
		}
	}
	
	/**
	 * 对URL参数进行解码
	 * @param value
	 * @param encode
	 * @return
	 */
	public static String urlDecode(String value, String encode)
	{
		try 
		{
			return URLDecoder.decode(value, encode);
		} 
		catch (Exception e) 
		{
			return null;
		}
	}

	/**
	 * 获取指定地址的Host
	 * @param url
	 * @return
	 */
	public static String getUrlHost(String url)
	{
		URI uri = URI.create(url);
		if(uri == null)
			return null;
		return uri.getHost();
	}
	
	/**
	 * 获取指定地址的IP
	 * @param url
	 * @return
	 */
	public static String getUrlIp(String url)
	{
		String host = getUrlHost(url);
		if(isNullOrEmpty(host))
			return null;
		
		try 
		{
			InetAddress addr = InetAddress.getByName(host);
			return addr.getHostAddress();
		}
		catch (Exception e) 
		{
			return null;
		}
	}
}
