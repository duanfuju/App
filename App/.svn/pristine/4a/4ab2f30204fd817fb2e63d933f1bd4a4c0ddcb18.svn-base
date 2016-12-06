package com.junl.frame.tools.string;

/**
 * 
 * @author LEON
 * @date 2015年12月22日 下午5:22:57
 * @description 
 *     HTML转译
 *     copy spring
 */
public class HtmlUtils {
	
	public static final String DEFAULT_CHARACTER_ENCODING = "ISO-8859-1";
	
	/**
	 * Shared instance of pre-parsed HTML character entity references.
	 */
	private static final HtmlCharacterEntityReferences characterEntityReferences =
			new HtmlCharacterEntityReferences();
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月22日 下午5:47:35
	 * @description 
	 *     将html标签转译
	 * @param input 输入源
	 * @return
	 *
	 */
	public static String htmlEscape(String input) {
		return htmlEscape(input, DEFAULT_CHARACTER_ENCODING);
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月22日 下午5:48:05
	 * @description 
	 *     将html标签转译
	 * @param input 输入源
	 * @param encoding 编码
	 * @return
	 *
	 */
	private static String htmlEscape(String input, String encoding) {
		if (input == null) {
			return null;
		}
		StringBuilder escaped = new StringBuilder(input.length() * 2);
		for (int i = 0; i < input.length(); i++) {
			char character = input.charAt(i);
			String reference = characterEntityReferences.convertToReference(character, encoding);
			if (reference != null) {
				escaped.append(reference);
			}
			else {
				escaped.append(character);
			}
		}
		return escaped.toString();
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月22日 下午5:48:35
	 * @description 
	 *     将html标签转十进制
	 * @param input
	 * @return
	 *
	 */
	public static String htmlEscapeDecimal(String input) {
		return htmlEscapeDecimal(input, DEFAULT_CHARACTER_ENCODING);
	}
	
	private static String htmlEscapeDecimal(String input, String encoding) {
		if (input == null) {
			return null;
		}
		StringBuilder escaped = new StringBuilder(input.length() * 2);
		for (int i = 0; i < input.length(); i++) {
			char character = input.charAt(i);
			if (characterEntityReferences.isMappedToReference(character, encoding)) {
				escaped.append(HtmlCharacterEntityReferences.DECIMAL_REFERENCE_START);
				escaped.append((int) character);
				escaped.append(HtmlCharacterEntityReferences.REFERENCE_END);
			}
			else {
				escaped.append(character);
			}
		}
		return escaped.toString();
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月22日 下午5:50:03
	 * @description 
	 *     TODO
	 * @param input
	 * @return
	 *
	 */
	public static String htmlEscapeHex(String input) {
		return htmlEscapeHex(input, DEFAULT_CHARACTER_ENCODING);
	}
	
	private static String htmlEscapeHex(String input, String encoding) {
		if (input == null) {
			return null;
		}
		StringBuilder escaped = new StringBuilder(input.length() * 2);
		for (int i = 0; i < input.length(); i++) {
			char character = input.charAt(i);
			if (characterEntityReferences.isMappedToReference(character, encoding)) {
				escaped.append(HtmlCharacterEntityReferences.HEX_REFERENCE_START);
				escaped.append(Integer.toString(character, 16));
				escaped.append(HtmlCharacterEntityReferences.REFERENCE_END);
			}
			else {
				escaped.append(character);
			}
		}
		return escaped.toString();
	}
	
	/**
	 * 
	 * @author LEON
	 * @date 2015年12月22日 下午5:50:07
	 * @description 
	 *     html标签转译解码
	 * @param input
	 * @return
	 *
	 */
	public static String htmlUnescape(String input) {
		if (input == null) {
			return null;
		}
		return new HtmlCharacterEntityDecoder(characterEntityReferences, input).decode();
	}
}
