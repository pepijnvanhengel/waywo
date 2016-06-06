package hour_registration;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Threads implements Runnable
{
	public static String s;
	private boolean doorgaan;
	
	private int minuten = 1;
	
	PrintWriter writer = null;
	
	// get current date
	DateFormat datumdoc = new SimpleDateFormat("dd.MM.yyyy");
	Date datum = new Date();
	
	Threads(String s)
	{
		this.s = s;
	}
	
	public void run() 
	{
		// create new file according to date
		try {
			writer = new PrintWriter("hour-registration-" + datumdoc.format(datum) + ".csv", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (doorgaan){	
					
			System.out.print( s );
			
			    	// variables for dropdown 
			      String[] choices = { "Research", "New site", "Support", "Meeting", "Break", "Training", "Else" };
			      
			      // create dropdown 
			      JComboBox<String> opties = new JComboBox(choices);
			      
			      // textfield for specification
			      JTextField taak = new JTextField(10);
			      JPanel panel = new JPanel(new GridLayout(0, 1));
			     		      
			      // add to the panel
			      panel.add(new JLabel("What are you working on?"));
			      panel.add(opties);
			      
			      panel.add(new JLabel("Current task"));
			      panel.add(taak);
			      
			      // if (ok == pressed) set in csv file
			      int result = JOptionPane.showConfirmDialog(null, panel, 
			        "Hour registration", 2);
			      
			      if (result == 0)
			      {
			    	// Haal op datum
			    	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			        Date date = new Date();
			        
			        // Haal op tijd
			        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
			        Date time = new Date();
			        
			        // Haal op datum
			        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
			        Date d = new Date(); 
			        
			        Calendar cal = Calendar.getInstance();
			        cal.setTime(d);
			        cal.add(Calendar.MINUTE, 15);
			        String newTime = df.format(cal.getTime());
			        
			        // datum
			        writer.print(dateFormat.format(date) + ",");
			        // begintijd
			        writer.print(timeFormat.format(time) + ",");
			        // eindtijd
			        writer.print(newTime + ",");
			        // tijd gespendeerd
			        writer.print(",");
			        // onderdeel
			        writer.print(opties.getSelectedItem() + ",");
			        // taak (gespecificeerd
			        writer.print(taak.getText() + "," + "\n");
			      }
			      else
			      {
			        writer.close();
			        doorgaan = false;
			      }
			      slaap(6000 * minuten);
			}
	}
	
	public void slaap(int millisec)
	{
		try
		{
			Thread.sleep(millisec);
		}
		catch (InterruptedException e)
		{
			System.out.println(e);
		}
	}

	public void pleaseStart()
	{
		doorgaan = true;
		Thread panel = new Thread( this );
		panel.start();
	}
	
	public void pleaseStop()
	{
		doorgaan = false;
		writer.close();
	}
}