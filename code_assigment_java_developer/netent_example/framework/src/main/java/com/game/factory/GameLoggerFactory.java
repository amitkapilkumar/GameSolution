package com.game.factory;

import java.io.FileNotFoundException;

import com.game.logger.GameLogger;

public class GameLoggerFactory {
	public static GameLogger getGameLogger(String logfile) throws FileNotFoundException {
		return new GameLogger(logfile);
	}
}
