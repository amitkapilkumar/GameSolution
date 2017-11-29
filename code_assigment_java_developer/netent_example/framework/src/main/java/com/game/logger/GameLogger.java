package com.game.logger;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class GameLogger {
	private BufferedWriter bufferedWriter;
	
	public GameLogger(String logfile) throws FileNotFoundException {
		bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(System.getProperty("user.dir") + "/" + logfile)));
	}
	
	public void logResult(long winCoins) throws IOException {
		if(winCoins < 0) {
			bufferedWriter.write("Number of coins lossed in the game : " + Math.abs(winCoins) + "\r\n");
		}
		else {
			bufferedWriter.write("Number of coins win in the game : " + winCoins + "\r\n");
		}
		bufferedWriter.flush();
	}
	
	public void log(String roundStr) throws IOException {
		bufferedWriter.write(roundStr);
		bufferedWriter.flush();
	}
	
	public void closeLogger() throws IOException {
		bufferedWriter.close();
	}
	
	public void logRTP(long winCoins, long betCoins) throws IOException {
		bufferedWriter.write("Number of coins bet in the game : " + betCoins + "\r\n");
		bufferedWriter.write("RTP (win/bet) : " + ((double) winCoins) / betCoins + "\r\n");
		bufferedWriter.flush();
	}
}