package br.edu.principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class JogoPainel extends JPanel implements Runnable {

	//Configurações de tela
	final int originalTitleSize = 16; //16x16
	final int scale = 3;
	
	final int tittleSize = originalTitleSize * scale;//48x48
	final int maxScreenCol = 16;//horizontal
	final int maxScreenRow = 12;//vertical
	final int screenWidth = tittleSize * maxScreenCol;//768 pixels
	final int screenHeight = tittleSize * maxScreenRow;//576 pixels
	
	//FPS
	int FPS = 60;
	
	Teclado keyH = new Teclado();
	static Thread gameThread;
	
	//definir a posição padrão do jogador
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	public JogoPainel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while(gameThread != null) {
			
			//Atualização 1: atualizar informações como a posição dos personagens
			update();
			
			//Atualização 2: desenhar a tela com as informações atualizadas
			repaint();
			
			try {
				
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void update() {
		
		if(keyH.upPressed == true) {
			playerY -= playerSpeed;
		}
		else if (keyH.downPressed == true) {
			playerY += playerSpeed;
		}
		else if (keyH.leftPressed == true) {
			playerX -= playerSpeed;
		}
		else if (keyH.rightPressed == true) {
			playerX += playerSpeed;
		}
		
	}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics g2 = (Graphics2D)g;
		
		g2.setColor(Color.white);
		
		g2.fillRect(playerX, playerY, tittleSize, tittleSize);
		
		g2.dispose();
		
	}
}
