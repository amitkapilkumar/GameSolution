package com.slot;

import java.io.IOException;

public class SlotGameExecutor {
	public static void main(String... args) {
		long round = 1000000;
		if(args.length > 0) {
			round = Long.parseLong(args[0]);
		}
		SlotGame sg = new SlotGame();
		try {
			System.out.println("Executing " + round + " rounds for Slot Game...");
			sg.game(round);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}