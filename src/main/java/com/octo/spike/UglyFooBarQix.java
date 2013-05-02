package com.octo.spike;

public class UglyFooBarQix {

	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			System.out.println(fooBarQix(i));
		}
	}

	private static String fooBarQix(int i) {
		String result = "";
		if(i %3 == 0)
			result += "FOO";
		if(i %5 == 0)
			result += "BAR";
		if(i %7 == 0)
			result += "QIX";
		String integer = String.valueOf(i);
		for (int j = 0; j < integer.length(); j++) {
			char element = integer.charAt(j);
			if(element == '3')
				result += "FOO";
			if(element == '5')
				result += "BAR";
			if(element == '7')
				result += "QIX";
			
		}
		return result.isEmpty() ? integer : result;
	}

}
