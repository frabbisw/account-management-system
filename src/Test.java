import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test {
	public static void main(String [] args)
	{
		final JFrame frame = new JFrame("Account");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Choose an Option: ");
		panel.add(label);
		frame.add(panel);
		
		JButton savingButton = new JButton("Savings Account");
		panel.add(savingButton);
		JButton CurrentButton = new JButton("Current Account");
		panel.add(CurrentButton);
		JButton existedButton = new JButton("Existed Account");
		panel.add(existedButton);
		JButton exitAccount = new JButton("Exit");
		panel.add(exitAccount);		
		
		savingButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				final JFrame frame = new JFrame("Saving Account");
				frame.setVisible(true);
				frame.setSize(800, 600);
				JPanel panel = new JPanel();
				frame.add(panel);
				
				JLabel label = new JLabel("Welcome to Saving Account");
				panel.add(label);
				
				JButton exitSaving = new JButton("Exit");
				panel.add(exitSaving);
				
				exitSaving.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						frame.dispose();
					}
				});		
			}
		});
		
		CurrentButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				final JFrame frame = new JFrame("Current Account");
				frame.setVisible(true);
				frame.setSize(800, 600);
				JPanel panel = new JPanel();
				frame.add(panel);
				
				JLabel label = new JLabel("Welcome to Current Account");
				panel.add(label);
				
				JButton exitCurrent = new JButton("Exit");
				panel.add(exitCurrent);
				
				exitCurrent.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						frame.dispose();
					}
				});		
			}
		});
		
		existedButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				final JFrame frame = new JFrame("Existed Account");
				frame.setVisible(true);
				frame.setSize(800, 600);
				JPanel panel = new JPanel();
				frame.add(panel);
				
				JLabel label = new JLabel("Welcome to Existed Account");
				panel.add(label);
				
				JButton exitExisted = new JButton("Exit");
				panel.add(exitExisted);
					
				exitExisted.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						frame.dispose();
					}
				});		
			}
		});
		
		exitAccount.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
	}
}
