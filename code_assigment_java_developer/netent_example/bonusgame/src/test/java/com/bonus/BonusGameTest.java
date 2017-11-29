package com.bonus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

public class BonusGameTest {

	@Test
	public void testGameFor10Rounds() throws IOException {
		BonusGame game = new BonusGame();
		long actualWinCoins = game.game(10);
		
		String actualLogContent = getActualFileContent();
		Assert.assertTrue(actualLogContent.contains("Total   rounds : 10"));
		Assert.assertTrue(actualWinCoins >= 0 && actualWinCoins <= 300); // if player wins bonus in all rounds, win every normal rounds, get maximum coin in bonus round 
	}
	
	@Test
	public void testGameFor100Rounds() throws IOException {
		BonusGame game = new BonusGame();
		game.game(100);
		
		String actualLogContent = getActualFileContent();
		Assert.assertTrue(actualLogContent.contains("Total   rounds : 100"));
	}
	
	private String getActualFileContent() throws IOException {
		return new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/bonusgame.log")));
	}

}
