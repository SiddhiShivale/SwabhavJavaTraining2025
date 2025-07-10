package com.aurionpro.test;

import java.util.Scanner;
import com.aurionpro.model.PigGame;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PigGame game = new PigGame(scanner);
		game.play();
	}
}
