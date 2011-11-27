package com.logansrings.booklibrary;

public class ApplicationUtilities {

	/**
	 * @param strings
	 * @return true if any strings are null or zero length
	 */
	public static boolean isEmpty(String ... strings) {
		for (String value : strings) {
			if (value == null || value.length() == 0) {
				return true;
			}
		}
		return false;
	}

}
