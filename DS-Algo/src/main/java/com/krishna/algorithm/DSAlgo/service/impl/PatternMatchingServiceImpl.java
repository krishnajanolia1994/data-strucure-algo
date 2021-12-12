package com.krishna.algorithm.DSAlgo.service.impl;

import org.springframework.stereotype.Component;

import com.krishna.algorithm.DSAlgo.service.PatternService;


@Component
public class PatternMatchingServiceImpl implements PatternService{



	@Override
	public Integer findPositionPatternInStringIfAny(String pattern, String string) {
		int position = -1;
		if (pattern == null || string == null)
			return -1;
		if (pattern.isEmpty() || string.isEmpty())
			return -1;
		if (pattern.length() > string.length())
			return -1;
		int valueOfPattern = getWordCount(pattern);
		int valueOfFirstSubstring = getWordCount(string.substring(0, pattern.length()));
		if (valueOfPattern == valueOfFirstSubstring) {
			position = 1;
		} else {
			int firstIndex = 0;
			for (int lastIndex = pattern.length(); lastIndex < string.length(); lastIndex++) {
				int charToBeRemoved = string.charAt(firstIndex);
				int charToBeAdd = string.charAt(lastIndex);

				valueOfFirstSubstring = valueOfFirstSubstring - charToBeRemoved + charToBeAdd;
				if (valueOfPattern == valueOfFirstSubstring) {
					if (match(pattern, string.substring(firstIndex, lastIndex)))
						;
					position = firstIndex + 2;
					break;
				}
				firstIndex++;
			}
		}
		return position;
	}

	private boolean match(String pattern, String substring) {
		boolean match = true;
		for (int i = 0; i < pattern.length() - 1; i++) {
			if (pattern.charAt(i) != substring.charAt(i)) {
				match = false;
				break;
			}
		}
		return false;
	}

	private int getWordCount(String pattern) {
		int wordCount = 0;
		for (int i = 0; i < pattern.length(); i++) {
			int ch = pattern.charAt(i);
			wordCount += ch;
		}
		return wordCount;
	}

}