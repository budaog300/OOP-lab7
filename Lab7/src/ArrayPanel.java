import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ArrayPanel extends JPanel {
	
	private int[][] arr;
	private int w, h;
	private int px, py;
	private int lvl = 1;
	
	
	public void moveLeft() {
		if(arr[px - 1][py] == 0 | arr[px - 1][py] == 2) {
			px--;
			if(arr[px][py] == 2) {
				lvl++;
				lvlUp();
				JFrame jFrame = new JFrame();
		        JOptionPane.showMessageDialog(jFrame, "Отлично! Уровень пройден!");
		        if(arr[px][py] == 2) {
		        	JFrame jFrame1 = new JFrame();
			        JOptionPane.showMessageDialog(jFrame1, "Отлично! Игра пройдена!");
		        }
			}
		}
		repaint();
	}
	
	public void moveRight() {
		if(arr[px + 1][py] == 0 | arr[px + 1][py] == 2) {
			px++;
			if(arr[px][py] == 2) {
				lvl++;
				lvlUp();
				JFrame jFrame = new JFrame();
		        JOptionPane.showMessageDialog(jFrame, "Отлично! Уровень пройден!");
		        if(arr[px][py] == 2) {
		        	JFrame jFrame1 = new JFrame();
			        JOptionPane.showMessageDialog(jFrame1, "Отлично! Игра пройдена!");
		        }
			}
		}
		repaint();
	}
	
	public void moveUp() {
		if(arr[px][py - 1] == 0 | arr[px][py - 1] == 2) {
			py--;
			if(arr[px][py] == 2) {
				lvl++;
				lvlUp();
				JFrame jFrame = new JFrame();
		        JOptionPane.showMessageDialog(jFrame, "Отлично! Уровень пройден!");
		        if(arr[px][py] == 2) {
		        	JFrame jFrame1 = new JFrame();
			        JOptionPane.showMessageDialog(jFrame1, "Отлично! Игра пройдена!");
		        }
			}
		}
		repaint();
		
	}
	
	public void moveDown() {
		if(arr[px][py + 1] == 0 | arr[px][py + 1] == 2) {
			py++;
			if(arr[px][py] == 2) {
				lvl++; 
				lvlUp();
				JFrame jFrame = new JFrame();
		        JOptionPane.showMessageDialog(jFrame, "Отлично! Уровень пройден!");
		        if(arr[px][py] == 2) {
		        	JFrame jFrame1 = new JFrame();
			        JOptionPane.showMessageDialog(jFrame1, "Отлично! Игра пройдена!");
		        }
			}
			
		}
		repaint();
	}
	
	
	public ArrayPanel() {	 
		try {
			Scanner sc = new Scanner(new File("input_lvl_1.txt"));
			
			h = sc.nextInt();
			w = sc.nextInt();
			px = sc.nextInt();
			py = sc.nextInt();
			arr = new int[w][h];
			for(int y = 0; y < w; y++) {
				for(int x = 0; x < h; x++) {
					arr[x][y] = sc.nextInt(); 
				}			
			}
			sc.close();	
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	public void lvlUp() {
		
		try {
			switch(lvl) {
			case 2:
				Scanner sc = new Scanner(new File("input_lvl_2.txt"));
				
				h = sc.nextInt();
				w = sc.nextInt();
				px = sc.nextInt();
				py = sc.nextInt();
				arr = new int[w][h];
				for(int y = 0; y < w; y++) {
					for(int x = 0; x < h; x++) {
						arr[x][y] = sc.nextInt(); 
					}			
				}
				sc.close();	
				break;
			
			case 3:
			Scanner sc_1 = new Scanner(new File("input_lvl_3.txt"));
			h = sc_1.nextInt();
			w = sc_1.nextInt();
			px = sc_1.nextInt();
			py = sc_1.nextInt();
			arr = new int[w][h];
			for(int y = 0; y < w; y++) {
				for(int x = 0; x < h; x++) {
					arr[x][y] = sc_1.nextInt(); 
				}			
			}
			sc_1.close();	
			
			
			break;
			
	}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}	
		
		
	}
	
	public void gameRestart() {
		
		lvl = 1;
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(int y = 0; y < h; y++) {
			for(int x = 0; x < w; x++) {
				switch(arr[x][y]) {
					case 0:
						g.setColor(Color.GRAY);
						break;
					case 1:
						g.setColor(Color.BLACK);
						break;
					case 2:
						g.setColor(Color.GREEN);
						break;
					
				}
				
				g.fillRect(10 + x * 20, 10 + y * 20, 20, 20);
			}
		}
		g.setColor(Color.YELLOW);
		g.fillRect(12 + px * 20, 12 + py *20, 16, 16);
	}
	
}