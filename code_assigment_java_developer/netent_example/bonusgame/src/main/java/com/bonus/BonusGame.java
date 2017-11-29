package com.bonus;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.game.Game;
import com.game.factory.GameDataFactory;
import com.game.factory.GameFactory;
import com.game.factory.GameLoggerFactory;
import com.game.logger.GameLogger;
import com.game.model.GameData;
import com.game.util.GameUtility;

public class BonusGame {
	public long game(long round) throws IOException {
		GameData data = GameDataFactory.getGameData();
		long bonusRound = 0;
		Game normalGame = GameFactory.getNormalGameInstance();
		Game boxPickingGame = new BoxPickingGame();
		
		for(long l = 1; l <= round; l++) {
			data.addBetCoins(10); // bet 10 coins
			if(triggerBonusGame()) {
				data.addWinCoins(boxPickingGame.play());
				bonusRound++;
			}
				
			int coins = normalGame.play();
			if(coins > 0) {
				data.addWinCoins(coins-10); // subtracting bet coins from win coins
				data.addBetCoins(-10); // reducing original bet count by 10
				data.incrementWinningRound();
			}
		}
		log(round, data, bonusRound);
		return data.getWinCoins();
	}

	private void log(long round, GameData data, long bonusRound) throws FileNotFoundException, IOException {
		GameLogger bonusLogger = GameLoggerFactory.getGameLogger("bonusgame.log");
		bonusLogger.logResult(data.getWinCoins());
		bonusLogger.log("Total   rounds : " + round + "\r\n");
		bonusLogger.log("Bonus   rounds : " + bonusRound + "\r\n");
		bonusLogger.log("Winning rounds : " + data.getWinningRound() + "\r\n");
		bonusLogger.logRTP(data.getWinCoins(), data.getBetCoins());
		bonusLogger.closeLogger();
	}
	
	private boolean triggerBonusGame() {
		return GameUtility.get10PrecentProbability();
	}
}