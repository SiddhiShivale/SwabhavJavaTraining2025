package com.aurionpro.model;

public class Player {

	private char mark;
	public String name;
	
	public char getMark() {
		return mark;
	}

	public void setMark(char mark) {
		this.mark = mark;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player(char mark, String name) {
		this.mark = mark;
		this.name = name;
	}

}
