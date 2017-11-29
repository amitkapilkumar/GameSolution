package com.game.logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

import com.game.factory.GameLoggerFactory;


public class GameLoggerTest {

	@Test
	public void testLogFileIsCreated() throws IOException {
		GameLogger logger = GameLoggerFactory.getGameLogger("test.log");
		File file = new File(System.getProperty("user.dir") + "/test.log");
		Assert.assertTrue(file.exists());
		logger.closeLogger();
	}
	
	@Test
	public void testLogResultForWin() throws IOException {
		GameLogger logger = GameLoggerFactory.getGameLogger("test.log");
		logger.logResult(10);
		String actualContent = getActualFileContent();
		Assert.assertEquals("Number of coins win in the game : 10\r\n", actualContent);
		logger.closeLogger();
	}
	
	@Test
	public void testLogResultForLose() throws IOException {
		GameLogger logger = GameLoggerFactory.getGameLogger("test.log");
		logger.logResult(-10);
		String actualContent = getActualFileContent();
		Assert.assertEquals("Number of coins lossed in the game : 10\r\n", actualContent);
		logger.closeLogger();
	}

	@Test
	public void testLog() throws IOException {
		GameLogger logger = GameLoggerFactory.getGameLogger("test.log");
		logger.log("Test content");
		String actualContent = getActualFileContent();
		Assert.assertEquals("Test content", actualContent);
		logger.closeLogger();
	}

	@Test
	public void testLogRTP() throws IOException {
		GameLogger logger = GameLoggerFactory.getGameLogger("test.log");
		logger.logRTP(900, 100);
		String actualContent = getActualFileContent();
		Assert.assertEquals("Number of coins bet in the game : 100\r\nRTP (win/bet) : 9.0\r\n", actualContent);
		logger.closeLogger();
	}
	
	private String getActualFileContent() throws IOException {
		return new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/test.log")));
	}
}
