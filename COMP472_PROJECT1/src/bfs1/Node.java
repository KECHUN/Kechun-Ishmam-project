package bfs1;

import java.util.ArrayList;

public class Node {
	
	private int[] puzzle; 
	private boolean hasChild;
	private int empty;
	private char movePosition;
	private int lastMove;
	private int h1; //heuristic value 1 Manhattan distance
	private final int[][] distance = {{0,1,2,3,1,1,2,3,2,2,2,3},{1,0,1,2,1,1,1,2,2,2,2,2},{2,1,0,1,2,1,1,1,2,2,2,2},
			{3,2,1,0,3,2,1,1,3,2,2,2},{1,1,2,3,0,1,2,3,1,1,2,3},{1,1,1,2,1,0,1,2,1,1,1,2},{2,1,1,1,2,1,0,1,2,1,1,1},{3,2,1,1,3,2,1,0,3,2,1,1},
			{2,2,2,3,1,1,2,3,0,1,2,3},{2,2,2,2,1,1,1,2,1,0,1,2},{2,2,2,2,2,1,1,1,2,1,0,1},{3,2,2,2,3,2,1,1,3,2,1,0}};; // matrix of distance of each tile with all others
	
	
	public Node(int[] initial) {
		puzzle = new int[12];
		lastMove = 0;
		for(int i = 0; i < initial.length; i++) {
			  this.puzzle[i] = initial[i];
			if (initial[i] == 0) {
				this.empty = i;
			}
		}
		movePosition =  (char) ('a' + this.empty);
		h1 = 0;
		hasChild = false;
		        
	}

	public int[] getPuzzle() {
		return puzzle;
	}

	public void moveEmpty(int empty, int tile) {
		int temps = this.puzzle[tile];
		this.puzzle[empty] = temps;
		this.puzzle[tile] = 0;
	}

	public int getEmpty() {
		return empty;
	}

	public void setEmpty(int empty) {
		this.empty = empty;
	}
	
	public boolean isGoal() {
		int[] goal = {1,2,3,4,5,6,7,8,9,10,11,0};
		for(int i = 0; i < goal.length; i++) {
			if(goal[i] != this.puzzle[i])
				return false;
		}
		return true;
	}
	public Node moveRight() {
		Node newNode = new Node(this.puzzle);
		if(this.empty != 3 & this.empty != 7 & this.empty != 11) {
			newNode.moveEmpty(newNode.empty, newNode.empty + 1);
			newNode.empty = newNode.empty + 1;
			newNode.movePosition =  (char) (newNode.movePosition + 1);
			newNode.lastMove = 3;
			return newNode;
		}
		else return null;
		
	}
	public Node moveLeft() {
		Node newNode = new Node(this.puzzle);
		if(this.empty != 0 & this.empty != 4 & this.empty != 8) {
			newNode.moveEmpty(newNode.empty, newNode.empty - 1);
			newNode.empty = newNode.empty - 1;
			newNode.movePosition =  (char) (newNode.movePosition -1);
			newNode.lastMove = -3;
			return newNode;
		}
		else return null;
		
	}
	public Node moveUp() {
		Node newNode = new Node(this.puzzle);
		if(this.empty != 0 & this.empty != 1 & this.empty != 2 & this.empty != 3) {
			newNode.moveEmpty(newNode.empty, newNode.empty - 4);
			newNode.empty = newNode.empty - 4;
			newNode.movePosition =  (char) (newNode.movePosition -4);
			newNode.lastMove = 1;
			return newNode;
		}
		else return null;
		
	}
	public Node moveDown() {
		Node newNode = new Node(this.puzzle);
		if(this.empty != 8 & this.empty != 9 & this.empty != 10 & this.empty != 11) {
			newNode.moveEmpty(newNode.empty, newNode.empty + 4);
			newNode.empty = newNode.empty + 4;
			newNode.movePosition =  (char) (newNode.movePosition + 4);
			newNode.lastMove = -1;
			return newNode;
		}
		else return null;
		
	}
	public Node moveUpright() {
		Node newNode = new Node(this.puzzle);
		if(this.empty == 4 || this.empty == 5 || this.empty == 6 || 
				this.empty == 8 || this.empty == 9 || this.empty == 10 ) {
			newNode.moveEmpty(newNode.empty, newNode.empty - 3);
			newNode.empty = newNode.empty - 3;
			newNode.movePosition =  (char) (newNode.movePosition -3);
			newNode.lastMove = 2;
			return newNode;
		}
		else return null;
		
	}
	public Node moveDownright() {
		Node newNode = new Node(this.puzzle);
		if(this.empty == 0 || this.empty == 1 || this.empty == 2 || 
				this.empty == 4 || this.empty == 5 || this.empty == 6 ) {
			newNode.moveEmpty(newNode.empty, newNode.empty + 5);
			newNode.empty = newNode.empty + 5;
			newNode.movePosition =  (char) (newNode.movePosition + 5);
			newNode.lastMove = 4;
			return newNode;
		}
		else return null;
		
	}
	
	public Node moveUpleft() {
		Node newNode = new Node(this.puzzle);
		if(this.empty == 5 || this.empty == 6 || this.empty == 7 || 
				this.empty == 9 || this.empty == 10 || this.empty == 11 ) {
			newNode.moveEmpty(newNode.empty, newNode.empty - 5);
			newNode.empty = newNode.empty - 5;
			newNode.movePosition =  (char) (newNode.movePosition -5);
			newNode.lastMove = -4;
			return newNode;
		}
		else return null;
		
	}
	public Node moveDownleft() {
		Node newNode = new Node(this.puzzle);
		if(this.empty == 1 || this.empty == 2 || this.empty == 3 || 
				this.empty == 5 || this.empty == 6 || this.empty == 7 ) {
			newNode.moveEmpty(newNode.empty, newNode.empty + 3);
			newNode.empty = newNode.empty + 3;
			newNode.movePosition =  (char) (newNode.movePosition + 3);
			newNode.lastMove = -2;
			return newNode;
		}
		else return null;
		
	}
	
	public char getmovePosition() {
		return movePosition;
	}

	public void setmovePosition(char position) {
		this.movePosition = position;
	}

	public void setPuzzle(int[] puzzle) {
		this.puzzle = puzzle;
	}

	public char getMovePosition() {
		return movePosition;
	}

	public void setMovePosition(char movePosition) {
		this.movePosition = movePosition;
	}

	public int getLastMove() {
		return lastMove;
	}

	public void setLastMove(int lastMove) {
		this.lastMove = lastMove;
	}

	public int getH1() {
		return h1;
	}

	public int evaluateH1() {
		int sum = 0;
		int[] goal = {1,2,3,4,5,6,7,8,9,10,11,0};
		for(int i = 0; i < goal.length; i++) {
			for(int j = 0; j < goal.length; j++) {
			if(this.puzzle[i] == 0) {
				break;
			}
			else if(this.puzzle[i] == goal[j]) {
				sum = sum + distance[i][j];
			}
			}
		}
		this.h1 = sum;
		return sum;
	}

	public boolean isHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

}
