package game;

import java.awt.Color;
import java.util.ArrayList;

public class SNAKE {
	ArrayList<int[]> ar = new ArrayList<int[]>();
	int[] apple = new int[2];
	
	SNAKE() {
		int[] start = {10,5};
		int[] start1 = {10,6};
		int[] start2 = {10,7};
		int[] start3 = {10,8};
		ar.add(start);
		ar.add(start1);
		ar.add(start2);
		ar.add(start3);
	}
}
