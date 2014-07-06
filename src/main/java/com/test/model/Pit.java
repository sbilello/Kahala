package com.test.model;

public class Pit {
	private int stones;

	Pit() {
		this.stones = 0;
	}

	public void addStones(int stones) {
		this.stones += stones;
	}

	public int getStones() {
		return stones;
	}

	public boolean isEmpty() {
		return stones == 0;
	}

	public int removeStones() {
		int stones = this.stones;
		this.stones = 0;
		return stones;
	}

	public void setStones(int stones) {
		this.stones = stones;
	}
}
