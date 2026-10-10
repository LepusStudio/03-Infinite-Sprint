package br.edu.principal;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class JogoPainel extends JPanel {

	//Configurações de tela
	final int originalTitleSize = 16; //16x16
	final int scale = 3;
	
	final int tittleSize = originalTitleSize * scale;//48x48
	final int maxScreenCol = 16;//horizontal
	final int maxScreenRow = 12;//vertical
	final int screenWidth = tittleSize * maxScreenCol;//768 pixels
	final int screenHeight = tittleSize * maxScreenRow;//576 pixels
	
	public JogoPainel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
	}
}
