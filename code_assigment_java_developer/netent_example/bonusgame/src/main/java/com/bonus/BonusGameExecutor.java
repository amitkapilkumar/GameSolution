package com.bonus;

import java.io.IOException;

public class BonusGameExecutor {
	public static void main(String... args) {
		long round = 1000000;
		if(args.length > 0) {
			round = Long.parseLong(args[0]);
		}
		BonusGame bg = new BonusGame();
		try {
			System.out.println("Executing " + round + " rounds for Bonus Game...");
			bg.game(round);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
