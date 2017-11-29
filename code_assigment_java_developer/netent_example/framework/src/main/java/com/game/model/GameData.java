package com.game.model;

public class GameData {
	private long winCoins;
	private long betCoins;
	private long normalRound;
	private long winningRound;
	
	public long getWinCoins() {
		return winCoins;
	}
	public void setWinCoins(long winCoins) {
		this.winCoins = winCoins;
	}
	public long getBetCoins() {
		return betCoins;
	}
	public void setBetCoins(long betCoins) {
		this.betCoins = betCoins;
	}
	public long getNormalRound() {
		return normalRound;
	}
	public void setNormalRound(long normalRound) {
		this.normalRound = normalRound;
	}
	public long getWinningRound() {
		return winningRound;
	}
	public void setWinningRound(long winningRound) {
		this.winningRound = winningRound;
	}
	
	public void incrementNormalRound() {
		normalRound++;
	}
	
	public void incrementWinningRound() {
		winningRound++;
	}
	
	public void addWinCoins(long coin) {
		winCoins = winCoins + coin;
	}
	
	public void addBetCoins(long coin) {
		betCoins = betCoins + coin;
	}
}