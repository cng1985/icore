/*
 * Java Base64 - A pure Java library for reading and writing Base64
 *               encoded streams.
 * 
 * Copyright (C) 2007-2009 Carlo Pelliccia (www.sauronsoftware.it)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License version
 * 2.1, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License version 2.1 along with this program.
 * If not, see <http://www.gnu.org/licenses/>.
 */
package it.sauronsoftware.base64;

/**
 * Package related utilities.
 * 
 * @author Carlo Pelliccia
 */
class Shared {

	static String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

	static char pad = '=';
	
	public static void main(String[] args) {
		System.out.println(Base64.encode("ada.young","utf-8"));
		System.out.println(Base64.decode("YWRhLnlvdW5n"));
		String a="刘德华a";
		byte[] bs=	a.getBytes();
		for (byte b : bs) {
			System.out.println(b);
		}
		System.out.println(new String(bs));
		
		byte[] bss=	{-27,-120,-104};
		System.out.println(new String(bss));
		for (int i = 0; i < 65526; i++) {
			System.out.println((char)i);
		}
	}

}
