package com.slot;

import org.junit.Assert;
import org.junit.Test;


public class FreeGameTest {

	@Test
	public void testSinglePlayValueAlwaysEitherZeroOrTwenty() {
		FreeGame game = new FreeGame();
		int actualCoins = game.play();
		Assert.assertTrue(actualCoins == 0 || actualCoins == 20);
	}
	
	@Test
	public void testMultiplePlayValueAlwaysEitherZeroOrTwenty() {
		FreeGame game = new FreeGame();
		for(int i=0; i < 10; i++) {
			int actualCoins = game.play();
			Assert.assertTrue(actualCoins == 0 || actualCoins == 20);
		}
	}

}
