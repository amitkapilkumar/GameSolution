package com.game;

public class NormalGame implements Game {
	public int play() {
		int n = (int)(Math.random() * ((10 - 1) + 1)) + 1;
		if(n <= 3) {
			return 20; // wining the play
		}
		return -10; // losing the play
	}
}
