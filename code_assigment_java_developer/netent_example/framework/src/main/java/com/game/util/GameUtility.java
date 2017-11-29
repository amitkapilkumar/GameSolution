package com.game.util;

public class GameUtility {
	public static boolean get10PrecentProbability() {
		int n = (int)(Math.random() * ((10 - 1) + 1)) + 1;
		if(n == 1) {
			return true;
		}
		return false;
	}
}
