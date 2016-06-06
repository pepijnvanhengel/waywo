package hour_registration;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hour_registration.Panel;
import hour_registration.Threads;

public class Launcher extends JFrame
{
	public static int frameWidth = 250;
	public static int frameHeight = 200;

	public Launcher()
	{
		setTitle("AM - Hours");
		setSize(frameWidth, frameHeight);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Panel());
		setResizable(false);
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) 
	{
		new Launcher();
	}

}