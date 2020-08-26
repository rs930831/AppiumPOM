package com.qa.util;

import java.util.HashMap;
import java.util.Map;

import io.appium.java_client.android.nativekey.AndroidKey;

public class AndroidKeyUtil {
	@SuppressWarnings("serial")
	public final static Map<String, AndroidKey> keyPadDigits = new HashMap<String, AndroidKey>() {{
	    put("0", AndroidKey.DIGIT_0);
	    put("1", AndroidKey.DIGIT_1);
	    put("2", AndroidKey.DIGIT_2);
	    put("3", AndroidKey.DIGIT_3);
	    put("4", AndroidKey.DIGIT_4);
	    put("5", AndroidKey.DIGIT_5);
	    put("6", AndroidKey.DIGIT_6);
	    put("7", AndroidKey.DIGIT_7);
	    put("8", AndroidKey.DIGIT_8);
	    put("9", AndroidKey.DIGIT_9);
	}}; 
}
