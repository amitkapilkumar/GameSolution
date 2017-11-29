package com.bonus;

import org.junit.Assert;
import org.junit.Test;

public class BoxPickingGameTest {

	@Test
	public void testSinglePlayValueAlwaysBetweenZeroToTwenty() {
		BoxPickingGame game = new BoxPickingGame();
		int actualCoins = game.play();
		Assert.assertTrue(actualCoins >= 0);
		Assert.assertTrue(actualCoins <= 20);
	}
	
	@Test
	public void testMultiplePlayValueAlwaysBetweenZeroToTwenty() {
		BoxPickingGame game = new BoxPickingGame();
		for(int i=0; i < 10; i++) {
			int actualCoins = game.play();
			Assert.assertTrue(actualCoins >= 0);
			Assert.assertTrue(actualCoins <= 20);
		}
	}
}
