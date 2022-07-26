package com.fis.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("txtEdtr")
public class TextEditor {

	@Autowired //DI
	private SpellChecker sp;
	
	public void loadDocument(String document) {
		System.out.println("text editor loading " + document);
		//from here i want to call checkSpellingMistakes function
		//SpellChecker sp = new SpellChecker();
		sp.checkSpellingMistakes(document);
	}
}
