package br.edu.principal;

import javax.swing.JFrame;

public class Principal {

    public static void main(String[] args) {

    	JFrame window = new JFrame();
    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	window.setResizable(false);
    	window.setTitle("Infinite Sprint");
    	
    	JogoPainel gamePanel = new JogoPainel();
    	window.add(gamePanel);
    	
    	window.pack();
    	
    	window.setLocationRelativeTo(null);
    	window.setVisible(true);
    	
    }
}