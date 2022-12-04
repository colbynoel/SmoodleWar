package smoodleWar;

import java.util.ArrayList;
import java.awt.*;

public class GameData {
	
	private String roomCode;
	private int currentScore;
	private String[] wordList;
	
	public GameData(){
		currentScore = 0;
		roomCode = "";
	}
	
	public int getCurrentScore() {
		return currentScore;
	}
	
	public void setCurrentScore(int score) {
		this.currentScore = score;
	}
	
	public String getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	
	public String[] getWordList() {
		return wordList;
	}
	
	public void setWordList(String[] WordList) {
		this.wordList = WordList;
	}
	
}