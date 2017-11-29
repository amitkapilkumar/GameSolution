package com.slot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;


public class SlotGameTest {

	@Test
	public void testGameFor10Rounds() throws IOException {
		SlotGame game = new SlotGame();
		long actualWinCoins = game.game(10);
		
		String actualLogContent = getActualFileContent();
		Assert.assertTrue(actualLogContent.contains("Total   rounds : 10"));
		Assert.assertTrue(actualLogContent.contains("Normal  rounds")); // atLeast one Normal round
		Assert.assertTrue(actualWinCoins >= 0 && actualWinCoins <= 150); // if player wins every free round and win every normal round 
	}
	
	@Test
	public void testGameFor100Rounds() throws IOException {
		SlotGame game = new SlotGame();
		game.game(100);
		
		String actualLogContent = getActualFileContent();
		Assert.assertTrue(actualLogContent.contains("Total   rounds : 100"));
	}
	
	@Test
	public void testGameSingleRoundHasToBeNormal() throws IOException {
		SlotGame game = new SlotGame();
		game.game(1);
		
		String actualLogContent = getActualFileContent();
		Assert.assertTrue(actualLogContent.contains("Total   rounds : 1"));
		Assert.assertTrue(actualLogContent.contains("Normal  rounds : 1"));
		Assert.assertFalse(actualLogContent.contains("Free   rounds :"));
	}
	
	private String getActualFileContent() throws IOException {
		return new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/slotgame.log")));
	}

}
