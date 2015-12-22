package com.ada.word.apps;

import com.ada.word.cage.IGenerator;
import com.ada.word.cage.RandomTokenGenerator;

public class IGeneratorApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IGenerator<String> g=new RandomTokenGenerator();
		
		System.out.println(g.next());
	}

}
