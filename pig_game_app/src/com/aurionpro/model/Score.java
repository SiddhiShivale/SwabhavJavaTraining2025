package com.aurionpro.model;

public class Score {
	private int value;

	public Score(int initial) {
		this.value = initial;
	}

	public int getValue() {
		return value;
	}

	public void reset() {
		this.value = 0;
	}

	public void addInPlace(Score other) {
		this.value += other.value;
	}

	public Score add(int points) {
		return new Score(this.value + points);
	}
}
