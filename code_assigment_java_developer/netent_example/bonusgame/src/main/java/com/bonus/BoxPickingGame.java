package com.bonus;

import com.game.Game;

public class BoxPickingGame implements Game {

	public int play() {
		int coins = 0;
		int[] boxes = initBoxes();
		for(int coin : boxes) {
			if(coin == 0) {
				break;
			}
			coins += coin;
		}
		return coins;
	}
	
	private int[] initBoxes() {
		int n = (int)(Math.random() * ((5 - 1) + 1)) + 1;
		int[] boxes = new int[] {5, 5, 5, 5, 5};
		boxes[n-1] = 0;
		return boxes;
	}

}
