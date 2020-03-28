package game;

import java.awt.Color;

public class Move {
	static final int X = 0;
	static final int Y = 1;

	public void up(SNAKE snake, View view) {
		view.setColor(snake.ar.get(0)[X], snake.ar.get(0)[Y], Color.white);
		int[] buf = snake.ar.get(snake.ar.size() - 1).clone();
		buf[Y] += 1;
		view.setColor(buf[X], buf[Y], Color.orange);
		snake.ar.add(buf);
		snake.ar.remove(0);
	}

	public void down(SNAKE snake, View view) {
		view.setColor(snake.ar.get(0)[X], snake.ar.get(0)[Y], Color.white);
		int[] buf = snake.ar.get(snake.ar.size() - 1).clone();
		buf[Y] -= 1;
		view.setColor(buf[X], buf[Y], Color.orange);
		snake.ar.add(buf);
		snake.ar.remove(0);
	}

	public void left(SNAKE snake, View view) {
		view.setColor(snake.ar.get(0)[X], snake.ar.get(0)[Y], Color.white);
		int[] buf = snake.ar.get(snake.ar.size() - 1).clone();
		buf[X] -= 1;
		view.setColor(buf[X], buf[Y], Color.orange);
		snake.ar.add(buf);
		snake.ar.remove(0);
	}

	public void right(SNAKE snake, View view) {
		view.setColor(snake.ar.get(0)[X], snake.ar.get(0)[Y], Color.white);
		int[] buf = snake.ar.get(snake.ar.size() - 1).clone();
		buf[X] += 1;
		view.setColor(buf[X], buf[Y], Color.orange);
		snake.ar.add(buf);
		snake.ar.remove(0);
	}

	public void sizeUp(SNAKE snake, View view, String d) {
		int[] head = snake.ar.get(snake.ar.size() - 1).clone();
		switch (d) {
		case "상":
			head[Y] += 1;
			snake.ar.add(head);
			break;
		case "하":
			head[Y] -= 1;
			snake.ar.add(head);
			break;
		case "좌":
			head[X] -= 1;
			snake.ar.add(head);
			break;
		case "우":
			head[X] += 1;
			snake.ar.add(head);
			break;
		}
		view.setColor(head[X], head[Y], Color.orange);
	}

	public void apple(SNAKE snake, View view) {
		snake.apple[X] = (int) (Math.random() * 20);
		snake.apple[Y] = (int) (Math.random() * 20);
		Boolean tr = false;
		while(tr) {
			tr = false;
			for (int i = 0; i < snake.ar.size() - 1; i++) {
				if(snake.apple[X]==snake.ar.get(i)[X]&&snake.apple[Y]==snake.ar.get(i)[Y]) {
					snake.apple[X] = (int) (Math.random() * 20);
					snake.apple[Y] = (int) (Math.random() * 20);
					tr = true;
					break;
				}
			}
		}
		view.setColor(snake.apple[X], snake.apple[Y], Color.red);
	}
	
}
