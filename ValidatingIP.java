package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Class ValidatingIP.
 * On this class we use the Regular Expression to validate the IP address provided as input
 */
public class ValidatingIP {

	/** The Constant PATTERN. */
	private static final Pattern PATTERN = Pattern
			.compile("(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

	/**
	 * Validate.
	 * 
	 * @param values
	 *            the ip address
	 * @return true, if successful
	 */
	public static boolean validate(final String values) {

		Matcher match = PATTERN.matcher(values);
		while (match.find()) {
			return PATTERN.matcher(values).matches();
		}
		return PATTERN.matcher(values).matches();
	}
}
