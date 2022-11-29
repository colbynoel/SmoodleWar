package smoodleWar;

import java.util.ArrayList;
import java.awt.*;

public class GameData {
	private ArrayList<String> wordBank;
	private String winner;
	private Graphics drawing;
	private String loser;
	private String roomCode;
	private String Scores;
	public ArrayList<String> getWordBank() {
		return wordBank;
	}
	public void setWordBank(ArrayList<String> wordBank) {
		this.wordBank = wordBank;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public Graphics getDrawing() {
		return drawing;
	}
	public void setDrawing(Graphics drawing) {
		this.drawing = drawing;
	}
	public String getLoser() {
		return loser;
	}
	public void setLoser(String loser) {
		this.loser = loser;
	}
	public String getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	public String getScores() {
		return Scores;
	}
	public void setScores(String scores) {
		Scores = scores;
	}
	
}
