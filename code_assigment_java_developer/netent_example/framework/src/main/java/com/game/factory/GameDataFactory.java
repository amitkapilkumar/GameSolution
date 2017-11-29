package com.game.factory;

import com.game.model.GameData;

public class GameDataFactory {
	public static GameData getGameData() {
		return new GameData();
	}
}