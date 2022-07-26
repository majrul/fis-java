package com.fis.component;

import org.springframework.stereotype.Component;

@Component("splChkr")
public class SpellChecker {

	public void checkSpellingMistakes(String document) {
		System.out.println("spell checker executed for " + document);
	}
}
