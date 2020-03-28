package game;

import java.awt.Color;

public class test {
	
	static final int X = 0;
	static final int Y = 1;
	
	public static void main(String[] args) {
		View view = new View();
		SNAKE snake = new SNAKE();
		view.setColor(snake.ar.get(0)[X], snake.ar.get(0)[Y], Color.orange);
		view.setColor(snake.ar.get(1)[X], snake.ar.get(1)[Y], Color.orange);
		view.setColor(snake.ar.get(2)[X], snake.ar.get(2)[Y], Color.orange);
		view.setColor(snake.ar.get(3)[X], snake.ar.get(3)[Y], Color.orange);
		
		view.setVisible(true);
		int[] buf;
		while(true) {
			view.setColor(snake.ar.get(0)[X], snake.ar.get(0)[Y], Color.white);
			buf = snake.ar.get(snake.ar.size() - 1).clone();
			buf[Y] += 1;
			view.setColor(buf[X], buf[Y], Color.orange);
			snake.ar.add(buf);
			snake.ar.remove(0);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
