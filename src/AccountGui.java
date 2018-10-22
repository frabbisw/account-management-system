package guiAcc;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class AccountGui 
{
	int choice = 0;
	String name, tmp;
	int ID = 100000,index;
	double v;
	LoadAndSave sal;
	public ArrayList <Account> info;
	
	public AccountGui()
	{
		info = new ArrayList <Account> ();
		sal = new LoadAndSave();		
		
		try
		{
			info = sal.load();
		}
		catch(Exception e)
		{
			new AllExceptions(e);
		}
		
		if(info.size()!=0)	ID = info.get(info.size()-1).getID();
		make();
		
		try
		{
			sal.save(info);
		}
		catch(Exception e)
		{
			new AllExceptions(e);
		}
	}
	
	public void make()
	{
		final JFrame frame = new JFrame("Account");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Choose an Option: ");
		panel.add(label);
		frame.add(panel);
		
		JButton newButton = new JButton("New Account");
		panel.add(newButton);
		JButton existedButton = new JButton("Existed Account");
		panel.add(existedButton);
		JButton exitAccount = new JButton("Exit");
		panel.add(exitAccount);		
		
		
		newButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame newFrame = new JFrame("New");
				newFrame.setSize(800, 600);
				newFrame.setVisible(true);
				newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				JPanel newPanel = new JPanel();
				newFrame.add(newPanel);
				
				JButton savingButton = new JButton("Savings Account");
				newPanel.add(savingButton);
				JButton currentButton = new JButton("Current Account");
				newPanel.add(currentButton);
				JButton exitNew = new JButton("exit");
				newPanel.add(exitNew);
				
				savingButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						final JFrame savingFrame = new JFrame("Saving Account");
						savingFrame.setSize(800, 600);
						savingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						savingFrame.setVisible(true);
						
						final JPanel namePanel = new JPanel();
						savingFrame.add(namePanel);
						
						JLabel savingLabel = new JLabel("Enter your name");
						final JTextField savingField = new JTextField("name", 20);
						JButton savingOkButton = new JButton("OK");
						
						namePanel.add(savingLabel);
						namePanel.add(savingField);
						namePanel.add(savingOkButton);
						
						savingOkButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								name = savingField.getText();
								namePanel.setVisible(false);
								
								ID++;
								final Account scc = new SavingAccount(name, ID, 0);				
								
								JPanel savingPanel = new JPanel();
								savingFrame.add(savingPanel);
								
								JButton withdrawButton = new JButton("Withdraw");
								savingPanel.add(withdrawButton);
								JButton depositButton = new JButton("Deposit");
								savingPanel.add(depositButton);
								final JButton seeButton = new JButton("See");
								savingPanel.add(seeButton);
								JButton exitSaving = new JButton("Exit");
								savingPanel.add(exitSaving);
								
								withdrawButton.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
										final JFrame withdrawFrame = new JFrame("Withdraw");
										withdrawFrame.setVisible(true);
										withdrawFrame.setSize(800,600);
										withdrawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
										
										JPanel withdrawPanel = new JPanel();
										withdrawFrame.add(withdrawPanel);
										
										JLabel withdrawLabel = new JLabel("Enter amount");
										final JTextField withdrawField = new JTextField("0",30);
										JButton okButton = new JButton("OK");
										
										withdrawPanel.add(withdrawLabel);
										withdrawPanel.add(withdrawField);
										withdrawPanel.add(okButton);
										
										okButton.addActionListener(new ActionListener()
										{
											public void actionPerformed(ActionEvent e) 
											{	
												double v = Double.parseDouble(withdrawField.getText());
												scc.withdraw(v);
												withdrawFrame.dispose();
											}								
										});
									}
								});
								
								depositButton.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
										final JFrame depositFrame = new JFrame("Deposit");
										depositFrame.setVisible(true);
										depositFrame.setSize(800,600);
										depositFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
										JPanel depositPanel = new JPanel();
										depositFrame.add(depositPanel);
													
										JLabel depositLabel = new JLabel("Enter amount");
										final JTextField depositField = new JTextField("0",30);
										JButton okButton = new JButton("OK");
													
										depositPanel.add(depositLabel);
										depositPanel.add(depositField);
										depositPanel.add(okButton);
												
										okButton.addActionListener(new ActionListener()
										{
											public void actionPerformed(ActionEvent e) 
											{
												double v = Double.parseDouble(depositField.getText());
												if(v<scc.getAmount())	scc.deposit(v);
												else
													JOptionPane.showMessageDialog(null, "Not enough value to deposit");
												depositFrame.dispose();
											}								
										});							
									}
								});
								
								seeButton.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
										final JFrame seeFrame = new JFrame("Amount");
										seeFrame.setVisible(true);
										seeFrame.setSize(800,400);
										seeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
										
										JPanel seePanel = new JPanel();
										JLabel seeLabel = new JLabel(scc.table());
										seePanel.add(seeLabel);
										
										JButton okButton = new JButton("OK");
										seePanel.add(okButton);
										
										seeFrame.add(seePanel);
										
										okButton.addActionListener(new ActionListener()
										{
											public void actionPerformed(ActionEvent e) 
											{	
												seeFrame.dispose();
											}								
										});
									}
								});
								
								exitSaving.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
										info.add(scc);
										savingFrame.dispose();
									}
								});
							}
						});			
					}
				});
				
				currentButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						final JFrame currentFrame = new JFrame("Current Account");
						currentFrame.setSize(800, 600);
						currentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						currentFrame.setVisible(true);
								
						final JPanel namePanel = new JPanel();
						currentFrame.add(namePanel);
								
						JLabel currentLabel = new JLabel("Enter your name");
						final JTextField currentField = new JTextField("name", 20);
						JButton currentOkButton = new JButton("OK");
								
						namePanel.add(currentLabel);
						namePanel.add(currentField);
						namePanel.add(currentOkButton);
								
						currentOkButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								name = currentField.getText();
								namePanel.setVisible(false);
										
								ID++;
								final Account ccc = new CurrentAccount(name, ID, 0);				
										
								JPanel currentPanel = new JPanel();
								currentFrame.add(currentPanel);
										
								JButton withdrawButton = new JButton("Withdraw");
								currentPanel.add(withdrawButton);
								JButton depositButton = new JButton("Deposit");
								currentPanel.add(depositButton);
								final JButton seeButton = new JButton("See");
								currentPanel.add(seeButton);
								JButton exitCurrent = new JButton("Exit");
								currentPanel.add(exitCurrent);
										
								withdrawButton.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
										final JFrame withdrawFrame = new JFrame("Withdraw");
										withdrawFrame.setVisible(true);
										withdrawFrame.setSize(800,600);
										withdrawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
												
										JPanel withdrawPanel = new JPanel();
										withdrawFrame.add(withdrawPanel);
												
										JLabel withdrawLabel = new JLabel("Enter amount");
										final JTextField withdrawField = new JTextField("0",30);
										JButton okButton = new JButton("OK");
												
										withdrawPanel.add(withdrawLabel);
										withdrawPanel.add(withdrawField);
										withdrawPanel.add(okButton);
												
										okButton.addActionListener(new ActionListener()
										{
											public void actionPerformed(ActionEvent e) 
											{	
												double v = Double.parseDouble(withdrawField.getText());
												ccc.withdraw(v);
												withdrawFrame.dispose();
											}								
										});
									}
								});
										
								depositButton.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
										final JFrame depositFrame = new JFrame("Deposit");
										depositFrame.setVisible(true);
										depositFrame.setSize(800,600);
										depositFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
										JPanel depositPanel = new JPanel();
										depositFrame.add(depositPanel);
															
										JLabel depositLabel = new JLabel("Enter amount");
										final JTextField depositField = new JTextField("0",30);
										JButton okButton = new JButton("OK");
															
										depositPanel.add(depositLabel);
										depositPanel.add(depositField);
										depositPanel.add(okButton);
														
										okButton.addActionListener(new ActionListener()
										{
											public void actionPerformed(ActionEvent e) 
											{
												double v = Double.parseDouble(depositField.getText());
												if(v<ccc.getAmount())	ccc.deposit(v);
												else
													JOptionPane.showMessageDialog(null, "Not enough value to deposit");
												depositFrame.dispose();
											}								
										});							
									}
								});
										
								seeButton.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
										final JFrame seeFrame = new JFrame("Amount");
										seeFrame.setVisible(true);
										seeFrame.setSize(800,400);
										seeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
												
										JPanel seePanel = new JPanel();
										JLabel seeLabel = new JLabel(ccc.table());
										seePanel.add(seeLabel);
												
										JButton okButton = new JButton("OK");
										seePanel.add(okButton);
												
										seeFrame.add(seePanel);
												
										okButton.addActionListener(new ActionListener()
										{
											public void actionPerformed(ActionEvent e) 
											{	
												seeFrame.dispose();
											}								
										});
									}
								});
										
								exitCurrent.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
										info.add(ccc);
										currentFrame.dispose();
									}
								});
							}
						});			
					}
				});
				exitNew.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						newFrame.dispose();
					}
				});
			}
		});
		
		
		existedButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				final JFrame existedFrame = new JFrame("Existed Account");
				existedFrame.setSize(800, 600);
				existedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				existedFrame.setVisible(true);
						
				final JPanel idPanel = new JPanel();
				existedFrame.add(idPanel);
						
				JLabel existedLabel = new JLabel("Enter your ID");
				final JTextField existedField = new JTextField("0", 20);
				JButton existedOkButton = new JButton("OK");
						
				idPanel.add(existedLabel);
				idPanel.add(existedField);
				idPanel.add(existedOkButton);
						
				existedOkButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						
						int tmpID = Integer.parseInt(existedField.getText());
						
						boolean f=false;
						for(int i=0; i<info.size(); i++)
						{
							if(tmpID == info.get(i).getID())
							{
								index=i;
								f=true;
							}						
						}
						if(f==false)	JOptionPane.showMessageDialog(null, "No match found");
						else
						{
							idPanel.setVisible(false);
							
							JPanel existedPanel = new JPanel();
							existedFrame.add(existedPanel);
								
							JButton withdrawButton = new JButton("Withdraw");
							existedPanel.add(withdrawButton);
							JButton depositButton = new JButton("Deposit");
							existedPanel.add(depositButton);
							final JButton seeButton = new JButton("See");
							existedPanel.add(seeButton);
							JButton exitExisted = new JButton("Exit");
							existedPanel.add(exitExisted);
								
							withdrawButton.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent e)
								{
									final JFrame withdrawFrame = new JFrame("Withdraw");
									withdrawFrame.setVisible(true);
									withdrawFrame.setSize(800,600);
									withdrawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
											
									JPanel withdrawPanel = new JPanel();
									withdrawFrame.add(withdrawPanel);
											
									JLabel withdrawLabel = new JLabel("Enter amount");
									final JTextField withdrawField = new JTextField("0",30);
									JButton okButton = new JButton("OK");
											
									withdrawPanel.add(withdrawLabel);
									withdrawPanel.add(withdrawField);
									withdrawPanel.add(okButton);
											
									okButton.addActionListener(new ActionListener()
									{
										public void actionPerformed(ActionEvent e) 
										{	
											double v = Double.parseDouble(withdrawField.getText());
											info.get(index).withdraw(v);
											withdrawFrame.dispose();
										}								
									});
								}
							});
									
							depositButton.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent e)
								{
									final JFrame depositFrame = new JFrame("Deposit");
									depositFrame.setVisible(true);
									depositFrame.setSize(800,600);
									depositFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									JPanel depositPanel = new JPanel();
									depositFrame.add(depositPanel);
														
									JLabel depositLabel = new JLabel("Enter amount");
									final JTextField depositField = new JTextField("0",30);
									JButton okButton = new JButton("OK");
														
									depositPanel.add(depositLabel);
									depositPanel.add(depositField);
									depositPanel.add(okButton);
													
									okButton.addActionListener(new ActionListener()
									{
										public void actionPerformed(ActionEvent e) 
										{
											double v = Double.parseDouble(depositField.getText());
											if(v<info.get(index).getAmount())	info.get(index).deposit(v);
											else
												JOptionPane.showMessageDialog(null, "Not enough value to deposit");
											depositFrame.dispose();
										}								
									});							
								}
							});
									
							seeButton.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent e)
								{
									final JFrame seeFrame = new JFrame("Amount");
									seeFrame.setVisible(true);
									seeFrame.setSize(800,400);
									seeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
											
									JPanel seePanel = new JPanel();
									JLabel seeLabel = new JLabel(info.get(index).table());
									seePanel.add(seeLabel);
											
									JButton okButton = new JButton("OK");
									seePanel.add(okButton);
											
									seeFrame.add(seePanel);
											
									okButton.addActionListener(new ActionListener()
									{
										public void actionPerformed(ActionEvent e) 
										{	
											seeFrame.dispose();
										}								
									});
								}
							});
							
							exitExisted.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent e)
								{	
									existedFrame.dispose();
								}
						});
						}
					}
				});			
			}
		});
		
		exitAccount.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				try {
					sal.save(info);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
