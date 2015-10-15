package com.ada.security;

import com.ada.security.helper.DESedeHelper;
import com.ada.security.helper.RSAHelper;
import com.ada.security.helper.SignatureHelper;
import com.ada.security.utils.Hex;

/**
 * HEX,AES,DESede,RSA,MD5等总测试
 * 
 * @author steven-pan
 * 
 */
public class Test {

	/**
	 * @param args
	 * 
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		SignatureHelper.main(args);
		System.out.println("------------------------------------\n");

		Hex.main(args);
		System.out.println("------------------------------------\n");

		//AESHelper.main(args);
		System.out.println("------------------------------------\n");
		
		DESedeHelper.main(args);
		System.out.println("------------------------------------\n");

		RSAHelper.main(args);
		System.out.println("------------------------------------\n");
	}

}
