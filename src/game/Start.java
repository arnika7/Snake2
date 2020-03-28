package game;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

public class Start {
	static final int X = 0;
	static final int Y = 1;
	static String way = "상";
	static int tri = 0;

	public static void main(String[] args) {
		Move move = new Move();
		View view = new View();
		SNAKE snake = new SNAKE();
		view.setVisible(true);

		class Key extends KeyAdapter {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (tri == 0) {
					switch (key) {
					case (KeyEvent.VK_RIGHT):
						way = "우";
						tri = 1;
						break;
					case (KeyEvent.VK_LEFT):
						way = "좌";
						tri = 1;
						break;
					case (KeyEvent.VK_DOWN):
						way = "하";
						tri = 1;
						break;
					case (KeyEvent.VK_UP):
						way = "상";
						tri = 1;
						break;
					}
				}
				view.contentPane.requestFocus();
			}
		}
		Key k = new Key();
		view.contentPane.addKeyListener(k);
		Boolean game = true;
		move.apple(snake, view);

		view.setColor(snake.ar.get(0)[X], snake.ar.get(0)[Y], Color.orange);
		view.setColor(snake.ar.get(1)[X], snake.ar.get(1)[Y], Color.orange);
		view.setColor(snake.ar.get(2)[X], snake.ar.get(2)[Y], Color.orange);
		view.setColor(snake.ar.get(3)[X], snake.ar.get(3)[Y], Color.orange);

		while (game) {
			view.contentPane.requestFocus();
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			switch (way) {
			case "상":
				if (snake.ar.get(snake.ar.size() - 1)[Y] == 19) {
					JOptionPane.showMessageDialog(null, "            GAME OVER");
					game = false;
				} else if (view.getC(snake.ar.get(snake.ar.size() - 1)[X],
						snake.ar.get(snake.ar.size() - 1)[Y] + 1) != Color.white) {
					if (view.getC(snake.ar.get(snake.ar.size() - 1)[X], snake.ar.get(snake.ar.size() - 1)[Y] + 1)
							.equals(Color.red)) {
						move.sizeUp(snake, view, "상");
						move.apple(snake, view);
					} else {
						JOptionPane.showMessageDialog(null, "            GAME OVER");
						game = false;
					}
				} else
					move.up(snake, view);
				break;
			case "하":
				if (snake.ar.get(snake.ar.size() - 1)[Y] == 0) {
					JOptionPane.showMessageDialog(null, "            GAME OVER");
					game = false;
				} else if (view.getC(snake.ar.get(snake.ar.size() - 1)[X],
						snake.ar.get(snake.ar.size() - 1)[Y] - 1) != Color.white) {
					if (view.getC(snake.ar.get(snake.ar.size() - 1)[X], snake.ar.get(snake.ar.size() - 1)[Y] - 1)
							.equals(Color.red)) {
						move.sizeUp(snake, view, "하");
						move.apple(snake, view);
					} else {
						JOptionPane.showMessageDialog(null, "            GAME OVER");
						game = false;
					}
				} else
					move.down(snake, view);
				break;
			case "좌":
				if (snake.ar.get(snake.ar.size() - 1)[X] == 0) {
					JOptionPane.showMessageDialog(null, "            GAME OVER");
					game = false;
				} else if (view.getC(snake.ar.get(snake.ar.size() - 1)[X] - 1,
						snake.ar.get(snake.ar.size() - 1)[Y]) != Color.white) {
					if (view.getC(snake.ar.get(snake.ar.size() - 1)[X] - 1, snake.ar.get(snake.ar.size() - 1)[Y])
							.equals(Color.red)) {
						move.sizeUp(snake, view, "좌");
						move.apple(snake, view);
					} else {
						JOptionPane.showMessageDialog(null, "            GAME OVER");
						game = false;
					}
				} else
					move.left(snake, view);
				break;
			case "우":
				if (snake.ar.get(snake.ar.size() - 1)[X] == 19) {
					JOptionPane.showMessageDialog(null, "            GAME OVER");
					game = false;
				} else if (view.getC(snake.ar.get(snake.ar.size() - 1)[X] + 1,
						snake.ar.get(snake.ar.size() - 1)[Y]) != Color.white) {
					if (view.getC(snake.ar.get(snake.ar.size() - 1)[X] + 1, snake.ar.get(snake.ar.size() - 1)[Y])
							.equals(Color.red)) {
						move.sizeUp(snake, view, "우");
						move.apple(snake, view);
					} else {
						JOptionPane.showMessageDialog(null, "            GAME OVER");
						game = false;
					}
				} else
					move.right(snake, view);
				break;
			default:
				break;
			}
			tri = 0;
		}
	}
}
