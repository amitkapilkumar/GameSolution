package com.game;

import org.junit.Assert;
import org.junit.Test;


public class NormalGameTest {

	@Test
	public void testSinglePlayValueAlwaysEitherNegativeTenOrTwenty() {
		NormalGame game = new NormalGame();
		int actualCoins = game.play();
		Assert.assertTrue(actualCoins == -10 || actualCoins == 20);
	}
	
	@Test
	public void testMultiplePlayValueAlwaysEitherNegativeTenOrTwenty() {
		NormalGame game = new NormalGame();
		for(int i=0; i < 10; i++) {
			int actualCoins = game.play();
			Assert.assertTrue(actualCoins == -10 || actualCoins == 20);
		}
	}
}