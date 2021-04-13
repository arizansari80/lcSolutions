package com.ariz.lcsolutions;

public class StringToInteger {
	private static int returnMinMax(final long d) {
		if (d >= Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (d <= Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return (int)d;
	}
	
	private static int returnMinMax(final double d) {
		if (d >= Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (d <= Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return (int)d;
	}
	
	private static int returnMinMax(final int signIncluded) {
		if (signIncluded == 0 || signIncluded == 2)
			return Integer.MAX_VALUE;
		else
			return Integer.MIN_VALUE;
	}
    
    private static String preProcess(final String val, final int signIncluded) {
		int i = signIncluded == 0 ? 0 : 1;
		for (; i < val.length(); i++)
			if (val.charAt(i) != '0')
				break;
		String substring = val.substring(i, val.length());
		if (signIncluded == 2)
			substring = "+" + substring;
		else if (signIncluded == 1)
			substring = "-" + substring;
		return substring;
	}
	
	public static int myAtoi(String s) {
		s = s.trim();
		String modInteger = "";
		boolean decimalIncluded = false;
		int signIncluded = 0;
		int i = 0;
		for (char ch : s.toCharArray()) {
			if (i == 0) {
				if (ch == '+') {
					modInteger += ch;
					signIncluded = 2;
					i++;
					continue;
				}
				else if (ch == '-') {
					modInteger += ch;
					signIncluded = 1;
					i++;
					continue;
				}
			}
			if (i == 0 && ch == '.') {
				modInteger += ch;
				decimalIncluded = true;
				i++;
				continue;
			}
			if (ch == '.' && !decimalIncluded) {
				modInteger += ch;
				decimalIncluded = true;
				i++;
				continue;
			}
			if (ch == '+' || ch == '-') {
				i++;
				break;
			}
			if (Character.isDigit(ch))
				modInteger += ch;
			else
				break;
			i++;
		}
        modInteger = preProcess(modInteger, signIncluded);
		if (modInteger.isEmpty())
			return 0;
		if (modInteger.length() == 1 && !Character.isDigit(modInteger.charAt(0)))
			return 0;
		int offset = signIncluded > 0 ? 12 : 11;
		if (decimalIncluded) {
			if (modInteger.indexOf('.') >= offset)
				return returnMinMax(signIncluded);
			double d = Double.parseDouble(modInteger);
			return returnMinMax(d);
		}
		else {
			if (modInteger.length() > offset)
				return returnMinMax(signIncluded);
			long d = Long.parseLong(modInteger);
			return returnMinMax(d);
		}
	}
}
