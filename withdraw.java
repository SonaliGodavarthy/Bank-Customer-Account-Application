
/* This program is for withdrawing ammount in bank application */

package project.withd;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import java.sql.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.*;
import java.util.Locale;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.embed.swing.JFXPanel;
import project.newaccount.*;

public class withdraw
{
	//declaration of frame, buttons, textfield, panels and labels
	JFrame frame_withdraw;
	JPanel p_accountnumber,p_withdrawamount,p_withdrawamount2,p_submitbtn;
	
	JTextField tf_accountnumber,tf_withdrawamount;
	
	JLabel lbl_dis_accountnumber,lbl_dis_name,lbl_dis_fathersname,lbl_dis_mothersname,lbl_dis_gender,lbl_dis_dob,lbl_dis_mobilenumber,lbl_dis_emailid,lbl_dis_address,lbl_dis_amount;
	JPanel p_dis_details,p_dis_account,p_dis_name,p_dis_fathersname,p_dis_mothersname,p_dis_gender,p_dis_dob,p_dis_mobilenumber,p_dis_emailid,p_dis_address,p_dis_amount;
	
	JLabel lbl_withdrawamount;
	
	JButton btn_submit,yes,no,ok;
	
	//declaration for connection and statemnet to connect to ojdbc
	Connection connection;
	Statement statement;
	
	Calendar calendar;
	
	Double amm;
	int len_after_float;
	int f;
	
	//constructor
	public withdraw()
	{
		try 
		{
		  //connecting to ojdbc using username and password
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sonali", "sonas123");
      		statement = connection.createStatement();
		} 
		//catching of sql exception when connection didn't happen
		catch (SQLException connectException) 
		{
		  System.out.println(connectException.getMessage());
		  System.out.println(connectException.getSQLState());
		  System.out.println(connectException.getErrorCode());
		  System.exit(1);
		}
		
		calendar = Calendar.getInstance();
		JPanel p_cal = new JPanel(); 
		p_cal.setLayout(new GridLayout(1,2));
		//to set the the date and day
		String day_of_week="";
		int cc=calendar.get(Calendar.DAY_OF_WEEK);
		if(cc==1)
			day_of_week="Sunday";
		else if(cc==2)
			day_of_week="Monday";
		else if(cc==3)
			day_of_week="Tuesday";
		else if(cc==4)
			day_of_week="Wednesday";
		else if(cc==5)
			day_of_week="Thursday";
		else if(cc==6)
			day_of_week="Friday";
		else if(cc==7)
			day_of_week="Saturday";

		String time=calendar.get(Calendar.DATE)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.YEAR)+"    "+day_of_week;
		JLabel cal=new JLabel(time);
		p_cal.add(cal);
		p_cal.setBounds(1700,75,750,20);
		
		//creation of panels to hold components
		p_dis_details=new JPanel();
		p_dis_account=new JPanel();
		p_dis_name=new JPanel();
		p_dis_fathersname=new JPanel();
		p_dis_mothersname=new JPanel();
		p_dis_gender=new JPanel();
		p_dis_dob=new JPanel();
		p_dis_mobilenumber=new JPanel();
		p_dis_emailid=new JPanel();
		p_dis_address=new JPanel();
		p_dis_amount=new JPanel();
		
		//setting layout to the panel
		p_dis_details.setLayout(new GridLayout(1,1));
		p_dis_account.setLayout(new GridLayout(1,1));
		p_dis_name.setLayout(new GridLayout(1,1));
		p_dis_fathersname.setLayout(new GridLayout(1,1));
		p_dis_mothersname.setLayout(new GridLayout(1,1));
		p_dis_gender.setLayout(new GridLayout(1,1));
		p_dis_dob.setLayout(new GridLayout(1,1));
		p_dis_mobilenumber.setLayout(new GridLayout(1,1));
		p_dis_emailid.setLayout(new GridLayout(1,1));
		p_dis_address.setLayout(new GridLayout(1,1));
		p_dis_amount.setLayout(new GridLayout(1,1));
		
		//setting bounds to the panels
		p_dis_details.setBounds(400,200,1000,20);
		p_dis_account.setBounds(400,250,1000,20);
		p_dis_name.setBounds(400,300,1000,20);
		p_dis_fathersname.setBounds(400,350,1000,20);
		p_dis_mothersname.setBounds(400,400,1000,20);
		p_dis_gender.setBounds(400,450,1000,20);
		p_dis_dob.setBounds(400,500,1000,20);
		p_dis_mobilenumber.setBounds(400,550,1000,20);
		p_dis_emailid.setBounds(400,600,1000,20);
		p_dis_address.setBounds(400,650,1000,20);
		p_dis_amount.setBounds(400,700,1000,20);
		
		//creation a frame
		frame_withdraw = new JFrame();
		
		tf_accountnumber=new JTextField(35);
		tf_withdrawamount=new JTextField(35);
	
		//creation of button
		btn_submit=new JButton("submit");
		
		//creation of panels
		p_accountnumber = new JPanel();
		p_withdrawamount = new JPanel();
		p_withdrawamount2 = new JPanel();
		p_submitbtn = new JPanel();
		
		//creation of labels
		lbl_dis_accountnumber=new JLabel();
		lbl_dis_name=new JLabel();
		lbl_dis_fathersname=new JLabel();
		lbl_dis_mothersname=new JLabel();
		lbl_dis_gender=new JLabel();
		lbl_dis_dob=new JLabel();
		lbl_dis_mobilenumber=new JLabel();
		lbl_dis_emailid=new JLabel();
		lbl_dis_address=new JLabel();
		lbl_dis_amount=new JLabel();
		
		//adding labels to panels
		p_dis_details.add(new JLabel("Your Details:"));
		p_dis_account.add(new JLabel("Account Number"));
		p_dis_name.add(new JLabel("Name"));
		p_dis_fathersname.add(new JLabel("Father's Name"));
		p_dis_mothersname.add(new JLabel("Mother's Name"));
		p_dis_gender.add(new JLabel("Gender"));
		p_dis_dob.add(new JLabel("Date of Birth"));
		p_dis_mobilenumber.add(new JLabel("Mobile Number"));
		p_dis_emailid.add(new JLabel("Email ID"));
		p_dis_address.add(new JLabel("Address"));
		p_dis_amount.add(new JLabel("Balance"));
		
		p_dis_account.add(lbl_dis_accountnumber);
		p_dis_name.add(lbl_dis_name);
		p_dis_fathersname.add(lbl_dis_fathersname);
		p_dis_mothersname.add(lbl_dis_mothersname);
		p_dis_gender.add(lbl_dis_gender);
		p_dis_dob.add(lbl_dis_dob);
		p_dis_mobilenumber.add(lbl_dis_mobilenumber);
		p_dis_emailid.add(lbl_dis_emailid);
		p_dis_address.add(lbl_dis_address);
		p_dis_amount.add(lbl_dis_amount);
				
		//setting layout to panels
		p_accountnumber.setLayout(new GridLayout(1,1));
		p_accountnumber.add(new JLabel("Enter Account Number: "));
		p_accountnumber.add(tf_accountnumber);
		
		lbl_withdrawamount=new JLabel("Enter Amount to be withdrawn:");
		
		p_withdrawamount.setLayout(new GridLayout(1,1));
		p_withdrawamount2.setLayout(new GridLayout(1,1));
		p_withdrawamount.add(lbl_withdrawamount);
		p_withdrawamount2.add(tf_withdrawamount);
		
		lbl_withdrawamount.setVisible(false);
		tf_withdrawamount.setVisible(false);
		btn_submit.setVisible(false);
		
		p_submitbtn.setLayout(new GridLayout(1,1));
		p_submitbtn.add(btn_submit);
		
		//setting bounds to panels
		p_accountnumber.setBounds(400,100,1000,20);
		p_withdrawamount.setBounds(400,800,500,20);
		p_withdrawamount2.setBounds(900,800,200,20);
		p_submitbtn.setBounds(800,850,100,20);
		
		//adding panels to frame
		frame_withdraw.add(p_cal);
		frame_withdraw.add(p_accountnumber);
		frame_withdraw.add(p_withdrawamount);
		frame_withdraw.add(p_withdrawamount2);
		frame_withdraw.add(p_submitbtn);
		
		frame_withdraw.add(p_dis_details);
		frame_withdraw.add(p_dis_account);
		frame_withdraw.add(p_dis_name);
		frame_withdraw.add(p_dis_fathersname);
		frame_withdraw.add(p_dis_mothersname);
		frame_withdraw.add(p_dis_gender);
		frame_withdraw.add(p_dis_dob);
		frame_withdraw.add(p_dis_mobilenumber);
		frame_withdraw.add(p_dis_emailid);
		frame_withdraw.add(p_dis_address);
		frame_withdraw.add(p_dis_amount);
		
		frame_withdraw.addWindowListener(new WindowAdapter(){
		  public void windowClosing(WindowEvent e) 
		  {
			frame_withdraw.dispose();                            //closing of frame
		  }
		});
		
		frame_withdraw.setExtendedState(frame_withdraw.getExtendedState() | frame_withdraw.MAXIMIZED_BOTH);    //for maximizing window
		
		//adding keylistener to account number textfield so that it doesn't take alphabets and length doesn't exceed 10
		tf_accountnumber.addKeyListener(new KeyAdapter() 
		{
         	public void keyPressed(KeyEvent ke) 
			{
            			int len_accountnumber = tf_accountnumber.getText().length();
            			if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' )  
						{
               				tf_accountnumber.setEditable(true);
            			} 
						else if( ke.getKeyChar()==8)
						{
									tf_accountnumber.setEditable(true);
						} 	
						else 
						{
									tf_accountnumber.setEditable(false);
						}
						if (len_accountnumber>9)
						{
									tf_accountnumber.setEditable(false);
						}
						if(len_accountnumber>9 && ke.getKeyChar()==8) 
						{
									tf_accountnumber.setEditable(true);
						}
						//when enter is pressed
						if(ke.getKeyChar()==10)
						{
							//if length is 0
							if(tf_accountnumber.getText().length()==0)
							{
														lbl_dis_accountnumber.setText("");
														lbl_dis_name.setText("");
														lbl_dis_fathersname.setText("");
														  lbl_dis_mothersname.setText("");
														  lbl_dis_gender.setText("");
														  lbl_dis_dob.setText("");
														  lbl_dis_mobilenumber.setText("");
														  lbl_dis_emailid.setText("");
														  lbl_dis_address.setText("");
														  lbl_dis_amount.setText("");
														  tf_withdrawamount.setText("");
														
														JDialog dg_error=new JDialog(frame_withdraw,"Error",true);
															dg_error.add(new JLabel("Please enter account number"));
															ok = new JButton ("ok");
															dg_error.add(ok);
															
															dg_error.setLayout( new FlowLayout() ); 
															ok.addActionListener ( new ActionListener()  
																{  
																		public void actionPerformed( ActionEvent e )  
																		{ 
																			dg_error.setVisible(false);
																 
																		}
																});
																dg_error.setSize(300,100);
																dg_error.setLocationRelativeTo(null);
															
															dg_error.setVisible(true);
															ok.requestFocus();
							}
							//if length > 0
							else
							{
								try
								{
									//extracting the data of the account number and displaying the details
									String accno=tf_accountnumber.getText().toString();
									String acc_status="";
										String sql = "select * from newaccount where accountnumber="+accno;
										ResultSet rs = statement.executeQuery(sql);
										  int count=0;
										  while(rs.next())
										  {
											  count++;
											  Long lng_accountnumber=rs.getLong("accountnumber");
											  String str_name=rs.getString("name");
											  String str_fathersname=rs.getString("fathersname");
											  String str_mothersname=rs.getString("mothersname");
											  String str_gender=rs.getString("gender");
											  String str_dob=rs.getString("dob").substring(0,11);
											  Long lng_mobilenumber=rs.getLong("mobilenumber");
											  String str_emailid=rs.getString("emailid");
											  String str_address=rs.getString("address");
											  acc_status=rs.getString("accountstatus");
											  amm=rs.getDouble("amount");
											  
											  lbl_dis_accountnumber.setText(lng_accountnumber.toString());
											  lbl_dis_name.setText(str_name);
											  lbl_dis_fathersname.setText(str_fathersname);
											  lbl_dis_mothersname.setText(str_mothersname);
											  lbl_dis_gender.setText(str_gender);
											  lbl_dis_dob.setText(str_dob);
											  lbl_dis_mobilenumber.setText(lng_mobilenumber.toString());
											  lbl_dis_emailid.setText(str_emailid);
											  lbl_dis_address.setText(str_address);
											  lbl_dis_amount.setText(amm.toString());
											  
											  tf_withdrawamount.requestFocus();
											  
										  }
										  rs.close();
										  //if account number is not valid
										  if(count==0)
											{
															lbl_dis_accountnumber.setText("");
														lbl_dis_name.setText("");
														lbl_dis_fathersname.setText("");
														  lbl_dis_mothersname.setText("");
														  lbl_dis_gender.setText("");
														  lbl_dis_dob.setText("");
														  lbl_dis_mobilenumber.setText("");
														  lbl_dis_emailid.setText("");
														  lbl_dis_address.setText("");
														  lbl_dis_amount.setText("");
														  tf_withdrawamount.setText("");
															
															JDialog dg_error=new JDialog(frame_withdraw,"Invalid account number",true);
																dg_error.add(new JLabel("Please enter valid account number"));
																ok = new JButton ("ok");
																dg_error.add(ok);
																
																dg_error.setLayout( new FlowLayout() ); 
																
																ok.addActionListener ( new ActionListener()  
																	{  
																			public void actionPerformed( ActionEvent e )  
																			{ 
																				dg_error.setVisible(false);
																	 
																			}
																	});
																	dg_error.setSize(300,100);
																	dg_error.setLocationRelativeTo(null);
																	
																dg_error.setVisible(true);
																ok.requestFocus();
							
											}
											//if account is closed
											else if(acc_status.equals("c"))
											{
												lbl_dis_accountnumber.setText("");
														lbl_dis_name.setText("");
														lbl_dis_fathersname.setText("");
														  lbl_dis_mothersname.setText("");
														  lbl_dis_gender.setText("");
														  lbl_dis_dob.setText("");
														  lbl_dis_mobilenumber.setText("");
														  lbl_dis_emailid.setText("");
														  lbl_dis_address.setText("");
														  lbl_dis_amount.setText("");
														  tf_withdrawamount.setText("");
															
															JDialog dg_accountclosed=new JDialog(frame_withdraw,"Account closed",true);
																dg_accountclosed.add(new JLabel("Your account is closed"));
																ok = new JButton ("ok");
																dg_accountclosed.add(ok);
																
																dg_accountclosed.setLayout( new FlowLayout() ); 
																
																ok.addActionListener ( new ActionListener()  
																	{  
																			public void actionPerformed( ActionEvent e )  
																			{ 
																				dg_accountclosed.setVisible(false);
																				tf_accountnumber.requestFocus();
																	 
																			}
																	});
																	dg_accountclosed.setSize(300,100);
																	dg_accountclosed.setLocationRelativeTo(null);
																	
																dg_accountclosed.setVisible(true);
																ok.requestFocus();
											}
											//if there is no balance in his account
											else if(amm==0)
											{
												lbl_dis_accountnumber.setText("");
														lbl_dis_name.setText("");
														lbl_dis_fathersname.setText("");
														  lbl_dis_mothersname.setText("");
														  lbl_dis_gender.setText("");
														  lbl_dis_dob.setText("");
														  lbl_dis_mobilenumber.setText("");
														  lbl_dis_emailid.setText("");
														  lbl_dis_address.setText("");
														  lbl_dis_amount.setText("");
														  tf_withdrawamount.setText("");
												
												JDialog dg_nobalance=new JDialog(frame_withdraw,"Error",true);
																dg_nobalance.add(new JLabel("Your balance is 0"));
																ok = new JButton ("ok");
																dg_nobalance.add(ok);
																
																dg_nobalance.setLayout( new FlowLayout() ); 
																
																ok.addActionListener ( new ActionListener()  
																	{  
																			public void actionPerformed( ActionEvent e )  
																			{ 
																				dg_nobalance.setVisible(false);
																				tf_accountnumber.requestFocus();
																	 
																			}
																	});
																	dg_nobalance.setSize(300,100);
																	dg_nobalance.setLocationRelativeTo(null);
																	
																dg_nobalance.setVisible(true);
																ok.requestFocus();
											}
											else
											{
												tf_withdrawamount.setVisible(true);
												lbl_withdrawamount.setVisible(true);
												btn_submit.setVisible(true);
												tf_withdrawamount.requestFocus();
											}
								}
								catch(Exception eeee)
								{
									
								}
							}
						}
					}
				});
												
				//when submit button is pressed
				btn_submit.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ett) 
					{
						//length of amount to bewithdrawn is 0
						if(tf_withdrawamount.getText().length()==0)
						{
														lbl_dis_accountnumber.setText("");
														lbl_dis_name.setText("");
														lbl_dis_fathersname.setText("");
														  lbl_dis_mothersname.setText("");
														  lbl_dis_gender.setText("");
														  lbl_dis_dob.setText("");
														  lbl_dis_mobilenumber.setText("");
														  lbl_dis_emailid.setText("");
														  lbl_dis_address.setText("");
														  lbl_dis_amount.setText("");
														  tf_withdrawamount.setText("");
															
															JDialog dg_error=new JDialog(frame_withdraw,"Error",true);
																dg_error.add(new JLabel("Please enter amount to be withdrawn"));
																ok = new JButton ("ok");
																dg_error.add(ok);
																
																dg_error.setLayout( new FlowLayout() ); 
																
																ok.addActionListener ( new ActionListener()  
																	{  
																			public void actionPerformed( ActionEvent e )  
																			{ 
																				dg_error.setVisible(false);
																	 
																			}
																	});
																	dg_error.setSize(300,100);
																	dg_error.setLocationRelativeTo(null);
																	
																dg_error.setVisible(true);
																ok.requestFocus();
						}
						//if length of amount to be withdrawn > 0
						else
						{
							//getting amount to be withdrawn
							double da=Double.parseDouble(tf_withdrawamount.getText());
							//if amount to be withdrawn is less than amount in account
							if(amm-da<0)
							{
								JDialog dg_error=new JDialog(frame_withdraw,"Error",true);
																dg_error.add(new JLabel("Insuffient amount"));
																ok = new JButton ("ok");
																dg_error.add(ok);
																
																dg_error.setLayout( new FlowLayout() ); 
																
																ok.addActionListener ( new ActionListener()  
																	{  
																			public void actionPerformed( ActionEvent e )  
																			{ 
																				dg_error.setVisible(false);
																				tf_withdrawamount.requestFocus();
																	 
																			}
																	});
																	dg_error.setSize(300,100);
																	dg_error.setLocationRelativeTo(null);
																	
																dg_error.setVisible(true);
																ok.requestFocus();
							}
							//if there is amount in account
							else
							{
								//confirmation dialog box
								JDialog dg_confirmation=new JDialog(frame_withdraw,"Confirmation",true);
								dg_confirmation.add(new JLabel("Are you sure you want to withdraw amount?"));
								yes = new JButton ("YES");
								no = new JButton ("NO");
								dg_confirmation.add(yes);
								dg_confirmation.add(no);
								
								dg_confirmation.setLayout( new FlowLayout() );  
								
								yes.addActionListener ( new ActionListener()  
						        	{  
								            public void actionPerformed( ActionEvent e )  
							        	    {  
											
												try{
													
													//getting amount to be withdrawn and subtracting it
													double da=Double.parseDouble(tf_withdrawamount.getText());
													amm=amm-da;
													
													String accno=tf_accountnumber.getText().toString();
													//upadating data of the accountumber
														String sql1 = "UPDATE newaccount set amount="+amm+" where accountnumber="+accno;
														statement.executeUpdate(sql1);
														
														//updating data into transactions table
														PreparedStatement pst = connection.prepareStatement("insert into transactions(transactiondate,accountnumber,depositedamount,withdrawnamount) values(?,?,?,?)",statement.RETURN_GENERATED_KEYS);
														
														Date today=new Date();
														
														pst.setTimestamp(1,new Timestamp(today.getTime()));
														pst.setLong(2,Long.parseLong(accno));
														pst.setDouble(3,0);
														pst.setDouble(4,da);
														
														int rowAffected = pst.executeUpdate();
			
														//if there is a row
													if(rowAffected==1)
													{
													
														tf_accountnumber.setText("");
															  lbl_dis_accountnumber.setText("");
															lbl_dis_name.setText("");
															lbl_dis_fathersname.setText("");
															  lbl_dis_mothersname.setText("");
															  lbl_dis_gender.setText("");
															  lbl_dis_dob.setText("");
															  lbl_dis_mobilenumber.setText("");
															  lbl_dis_emailid.setText("");
															  lbl_dis_address.setText("");
															  lbl_dis_amount.setText("");
															  tf_withdrawamount.setText("");
															
															dg_confirmation.setVisible(false);
														len_after_float=0;
														tf_accountnumber.requestFocus();
														
														tf_withdrawamount.setVisible(false);
														lbl_withdrawamount.setVisible(false);
														btn_submit.setVisible(false);
													}
												
												}
												catch(Exception eeee)
													{
														eeee.printStackTrace();
													}
													try
													{
														connection.commit();
													}
													catch(Exception t)
													{
													}
        								    }  
       								 });   
									 //when no button is pressed
									no.addActionListener ( new ActionListener()  
						        	{  
								            public void actionPerformed( ActionEvent e )  
							        	    { 
												dg_confirmation.setVisible(false);
									 
											}
									});
    	    							
        							dg_confirmation.setSize(300,100);
									dg_confirmation.setLocationRelativeTo(null);
   								dg_confirmation.setVisible(true);
								yes.requestFocus();
						}
						}
					}
				});
				
		
		//adding key listener so that it doesn't take alphabets
		tf_withdrawamount.addKeyListener(new KeyAdapter()
		{
         	public void keyPressed(KeyEvent ke) 
			{
				if(ke.getKeyChar()==10)
				{
					btn_submit.requestFocus();
				}
            			int len_amount = tf_withdrawamount.getText().length();
						if(tf_withdrawamount.getText().toString().contains("."))
						{
							f=1;
						}
						else
						{
							f=0;
						}
            			if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' ) )//|| ke.getKeyChar()=='.')  
						{
							if(len_after_float!=2)
							{
								tf_withdrawamount.setEditable(true);
								if(f==1)
								{
									len_after_float++;
								}
							}
							else
								tf_withdrawamount.setEditable(false);
            			} 
						else if(ke.getKeyChar()=='.' && f==0)
						{
							f=1;
							tf_withdrawamount.setEditable(true);
						}
						else if(ke.getKeyChar()==8)
						{
									tf_withdrawamount.setEditable(true);
						} 
						else 
						{
									tf_withdrawamount.setEditable(false);
						}
						if(len_after_float<=2 && ke.getKeyChar()==8)
						{
							tf_withdrawamount.setEditable(true);
							len_after_float--;
							if(len_after_float<=0)
								len_after_float=0;
						}
						if (len_amount>8)
						{
									tf_withdrawamount.setEditable(false);
						}
						if(len_amount>8 && ke.getKeyChar()==8) 
						{
									tf_withdrawamount.setEditable(true);
						}
					}
     		 });
			 
			 //setting title to frame and making the frame visible
		 frame_withdraw.setLayout(null);
		 frame_withdraw.setTitle("Withdraw Ammount");
		frame_withdraw.setVisible(true);
		
	}
}