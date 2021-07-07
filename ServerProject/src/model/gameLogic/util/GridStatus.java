package model.gameLogic.util;

import model.gameLogic.TokenColor;

public class GridStatus {
	
	private int lastX;
	private int lastY;
	private static TokenColor lastColor;
	public static GridStatus status = null;
	
	private GridStatus() {
		this.lastX=0;
		this.lastY=0;
		this.lastColor=null;
	}
	
	public static GridStatus getGameStatus() {
		if(status==null) {
			status = new GridStatus();
		}
		return status;
	}

	public void updateGameStatus(int x,int y, TokenColor c) {
		
		this.lastX = x;
		this.lastY = y;
		this.lastColor = c;
		
	}

	public int getLastX() {
		return lastX;
	}

	public int getLastY() {
		return lastY;
	}

	public static TokenColor getLastColor() {
		return lastColor;
	}

	public static GridStatus getStatus() {
		return status;
	}
	
}
