package smoodleWar;

import java.util.ArrayList;
import java.awt.*;

public class GameData {
	private ArrayList<String> wordBank;
	private String winner;
	private Graphics drawing;
	private String loser;
	private String roomCode;
	private String scores;
	
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
	public String getScores(String scores) {
		return scores;
	}
	public void setScores(String scores) {
		this.scores = scores;
	}
	
	public GameData(ArrayList<String> wordBank, String winner, Graphics drawing, String loser, String roomCode, String scores) {
		setWordBank(wordBank);
		setWinner(winner);
		setDrawing(drawing);
		setLoser(loser);
		setRoomCode(roomCode);
		setScores(scores);
	}
}
