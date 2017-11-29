package com.game.factory;

import com.game.NormalGame;

public class GameFactory {
	public static NormalGame getNormalGameInstance() {
		return new NormalGame();
	}
}
