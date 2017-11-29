package com.slot;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.game.Game;
import com.game.factory.GameDataFactory;
import com.game.factory.GameFactory;
import com.game.factory.GameLoggerFactory;
import com.game.logger.GameLogger;
import com.game.model.GameData;
import com.game.util.GameUtility;

public class SlotGame {
	public long game(long round) throws IOException {
		long freeRound = 0;
		GameData data = GameDataFactory.getGameData();
		boolean isPrevRoundNormal = false;
		Game freeGame = new FreeGame();
		Game normalGame = GameFactory.getNormalGameInstance();
		for(long l = 1; l <= round; l++) {
			if(l == 1) { // first round
				play(data, normalGame);
				isPrevRoundNormal = true;
				continue;
			}
			
			if(isPrevRoundNormal && triggerFreeGame()) {
				int coins = freeGame.play();
				if(coins > 0) {
					data.addWinCoins(coins); 
					data.incrementWinningRound();
				}
				freeRound++;
				isPrevRoundNormal = false;
				continue;
			}
			
			play(data, normalGame);
			isPrevRoundNormal = true;
		}
		log(round, freeRound, data);
		return data.getWinCoins();
	}

	private void log(long round, long freeRound, GameData data) throws FileNotFoundException, IOException {
		GameLogger slotLogger = GameLoggerFactory.getGameLogger("slotgame.log");
		slotLogger.logResult(data.getWinCoins());
		slotLogger.log("Total   rounds : " + round + "\r\n");
		slotLogger.log("Free    rounds : " + freeRound + "\r\n");
		slotLogger.log("Normal  rounds : " + data.getNormalRound() + "\r\n");
		slotLogger.log("Winning rounds : " + data.getWinningRound() + "\r\n");
		slotLogger.logRTP(data.getWinCoins(), data.getBetCoins());
		slotLogger.closeLogger();
	}

	private void play(GameData data, Game normalGame) {
		data.addBetCoins(10); // bet 10 coins
		int coins = normalGame.play();
		data.incrementNormalRound();
		if(coins > 0) {
			data.addWinCoins(coins - 10); // subtracting bet coins from win coins
			data.addBetCoins(-10); // reducing original bet count by 10
			data.incrementWinningRound();
		}
	}
	
	private boolean triggerFreeGame() {
		return GameUtility.get10PrecentProbability();
	}
}
