package com.ada.word.apps;

import com.ada.word.patchca.AdaptiveRandomWordFactory;

public class WordFactoryApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdaptiveRandomWordFactory f=new AdaptiveRandomWordFactory();
		f.setMinLength(4);
		f.setMaxLength(4);
		f.setCharacters("1234567890");
		System.out.println(f.getNextWord());
	}

}
