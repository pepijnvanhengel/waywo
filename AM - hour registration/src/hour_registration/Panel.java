package hour_registration;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Panel extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private JButton startThread;
	private JButton eindThread;
	private JLabel introText;
	private JLabel iamrunning, notrunning;
	private Threads panelThread, running;
	
	private String minutesInput;
	
	public static int minutesConverted;
	
	public Panel()
	{
		String idcare = Threads.s;
		
		startThread = new JButton("Start");
		startThread.addActionListener(this);
		//startThread.setSize(Launcher.frameWidth / 2, 50);
		
		eindThread = new JButton("Stop");
		eindThread.addActionListener(this);
		
		introText = new JLabel("AM - hour registration");
		introText.setFont(introText.getFont().deriveFont(22.0f));
		
		iamrunning = new JLabel(idcare);

		add(introText);
		add(iamrunning);
		add(startThread);
		add(eindThread);
		
		
		panelThread = new Threads("Running");
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if( ae.getSource() == startThread)
		{
			panelThread.pleaseStart();
		}
		else if( ae.getSource() == eindThread)
		{
			panelThread.pleaseStop();
		}
	}

}
