package com.slot;

import com.game.Game;

public class FreeGame implements Game {
	public int play() {
		int n = (int)(Math.random() * ((10 - 1) + 1)) + 1;
		if(n <= 3) {
			return 20; // wining the free play
		}
		return 0; // losing the free play
	}
}
