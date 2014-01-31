package assignment2;
import java.util.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//import oracle.spatial.geometry.JGeometry;

class LoginPanel extends JPanel{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public JTextField username;
	public JPasswordField password;
	public JButton login;
	public JButton signup;
	private String UserName;

        
       // public void enableButton(){
	//	login.setEnabled(true);
	//}
        
	public void disablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].disable();
		}
	}

	public void enablePanel(){
         //           enableButton();

		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].enable();
		}
	}

	LoginPanel(){
		this.setBounds(810, 30, 250, 100);
		this.setLayout(new GridLayout(3,2));
		this.add(new Label("UserName: "));
		username = new JTextField();
        this.add(username);
		this.add(new Label("Password: "));
		password = new JPasswordField();
        this.add(password);
        login = new JButton("Login");
        signup = new JButton("Signup");
        this.add(login);
        this.add(signup);
        enablePanel();
	}

        public String getUserName(){
            //System.out.println(username.getText());
	    
            return username.getText().toString();
	}
        
        public String getPassword(){
            //System.out.println(username.getText());
	    
            return password.getText().toString();
	}
        
        
        
	public void setUserName(String user){
		UserName=user;
	}
}

class SignupPanel extends JPanel{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JButton login;
	JButton signup;
	JPasswordField password;
	JPasswordField password2;

	JTextField country;
	JTextField state;
	JTextField city;
	JTextField email;
	JTextField birthday;
	JTextField fname;
	JTextField lname;
	JTextField str_no;
	JTextField str_address;
	JTextField zip;

	public void disablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].disable();
		}
		disableButton();
	}

	public void enablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].enable();
		}
		enableButton();
	}

	SignupPanel(){
		this.setBounds(810, 150, 250, 300);
		this.setLayout(new GridLayout(11,2));
		this.add(new Label("Email: "));
		email = new JTextField();
        this.add(email);
		this.add(new Label("Password: "));
		password = new JPasswordField();
        this.add(password);
		this.add(new Label("ReEnter Password: "));
		password2 = new JPasswordField();
        this.add(password2);
		this.add(new Label("First Name: "));
		fname = new JTextField();
        this.add(fname);
		this.add(new Label("Last Name: "));
		lname = new JTextField();
        this.add(lname);
		this.add(new Label("City: "));
		city = new JTextField();
        this.add(city);
		this.add(new Label("Birthday : "));
		birthday = new JTextField();
        this.add(birthday);
		this.add(new Label("strNo : "));
		str_no = new JTextField();
        this.add(str_no);
		this.add(new Label("strAdress : "));
		str_address = new JTextField();
        this.add(str_address);
        this.add(new Label("Zip : "));
		zip = new JTextField();
        this.add(zip);
        this.add(new Label(""));
        signup = new JButton("signup");
        this.add(signup);
        disablePanel();
	}

	public void disableButton(){
		signup.setEnabled(false);
	}
	public void enableButton(){
		signup.setEnabled(true);
	}
}

class SqlPanel extends JPanel{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextArea SQLArea = null;
	JScrollPane scrollPane = null;
	JLabel showLabel;
	SqlPanel(){
		setInputArea();
                
	}

	public void disablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].disable();
		}
	}

	public void enablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].enable();
		}
	}

	private void setInputArea(){
		setBounds(0, 495,810, 150);
		SQLArea = new JTextArea(6,68);
		SQLArea.setLineWrap(true);
		scrollPane = new JScrollPane(SQLArea);
		this.add(scrollPane);
	}
}

class Frame0 extends JFrame{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextField txtfield;
	JButton btn1;
	String lbltext;
	JLabel label;
	String FriendType[] = { "Normal Friend", "Close Friend", "Family" };
	JComboBox combo;

	Frame0(String text,int mode){
		this.lbltext = text;
		 this.setSize(300, 120);
		 this.setResizable(false);
		setLayout(new FlowLayout());
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((width-this.getWidth())/2,(height-this.getHeight())/2);
		label = new JLabel(text);
		add(label);
		txtfield = new JTextField(10);
        add(txtfield);
        combo= new JComboBox(FriendType);
        if(mode==1)
        	add(combo);
        btn1 = new JButton("OK");
        add(btn1);

	}
}

class Frame1 extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextField txtfield;
	JButton btn1;
	JButton btn2;
	String lbltext0;
	String lbltext1;
	JLabel lbl0;
	JLabel lbl1;
	JTextArea textArea = null;

	Frame1(String text0, String text1) {
		this.lbltext0 = text0;
		this.lbltext1 = text1;
		this.setResizable(false);
		setLayout(null);
		 this.setSize(300, 256);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((width-this.getWidth())/2,(height-this.getHeight())/2);
		lbl0 = new JLabel(text0);
		add(lbl0);
		lbl0.setBounds(10, 10, 70, 30);

		txtfield = new JTextField(10);
		add(txtfield);
		txtfield.setBounds(85, 10, 150, 30);

		lbl1 = new JLabel(text1);
		add(lbl1);
		lbl1.setBounds(10, 45, 70, 30);

		textArea = new JTextArea(8, 10);
		textArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		this.add(scrollPane);
		scrollPane.setBounds(85,55,180,90);

		btn1 = new JButton("OK");
		btn1.setBounds(90,165,90, 30);
		add(btn1);

	}
}


class Frame2 extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextField txtfield;
	JButton btn1;
	JButton btn2;
	String lbltext0;
	JLabel lbl0;

	Frame2(String text0) {
		this.setResizable(false);
		this.lbltext0 = text0;
        this.setSize(300, 150);
        this.setResizable(false);
		setLayout(null);

		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((width-this.getWidth())/2,(height-this.getHeight())/2);
		lbl0 = new JLabel(text0);
		add(lbl0);
		lbl0.setBounds(10, 10, 70, 30);

		txtfield = new JTextField(10);
		add(txtfield);
		txtfield.setBounds(85, 10, 100, 30);

		btn1 = new JButton("Decline");
		btn2 = new JButton("Accept ALL");

		btn1.setBounds(190,10,90, 30);
		btn2.setBounds(70,60,150, 30);
		add(btn1);
		add(btn2);

	}
}


class Frame3 extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextField []txtfield;
	JButton btn1;
	JLabel []lbl;
	Frame3(String text0) {
		this.setResizable(false);
		this.setTitle(text0);
        this.setSize(1000, 70);
        this.setResizable(false);
		setLayout(new GridLayout(1,9));

		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((width-this.getWidth())/2,(height-this.getHeight())/2);
		lbl = new JLabel[4];
		for(int i=0;i<4;i++)
			lbl[i] = new JLabel();
		lbl[0].setText("topleft x:");
		lbl[1].setText("topleft y:");
		lbl[2].setText("bottomright x:");
		lbl[3].setText("bottomright y:");

		txtfield = new JTextField[4];
		for(int i=0;i<4;i++)
			txtfield[i] = new JTextField();

		btn1 = new JButton("search");
		for(int i=0;i<4;i++)
		{
			add(lbl[i]);
			add(txtfield[i]);
		}
		add(btn1);
	}
}


class PostandSearchPanel extends JPanel{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextArea textArea = null;
	JScrollPane scrollPane = null;

	JTextField text;
	JLabel showLabel;
	JButton []buttons;

	public void disableButton(){
		for(int i=0;i<buttons.length;i++)
			buttons[i].setEnabled(false);
	}

	public void enableButton(){
		for(int i=0;i<buttons.length;i++)
			buttons[i].setEnabled(true);
	}

	PostandSearchPanel(){
		setLayout(null);
		this.setBounds(0, 10,780, 120);
        setInputArea();

		buttons = new JButton[2];
		buttons[0]= new JButton("Post");
		buttons[1]= new JButton("Search For Friend");

		text  = new JTextField(15);
		text.setLocation(10,3);
		text.setText("");
		text.setBounds(460, 40, 150, 25);
		buttons[0].setBounds(380,40,60,25);
		buttons[1].setBounds(620,40,130,25);

		
		this.add(buttons[0]);
		this.add(text);
		this.add(buttons[1]);

	}
	public void disablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].disable();
		}
		disableButton();
	}

	public void clearPanel(){
		text.setText("");
	    textArea.setText("");
	}

	public  void enablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].enable();
		}
		enableButton();
	}

	public void setInputArea(){
		textArea = new JTextArea(4,30);
		textArea.setLineWrap(true);
		textArea.setBounds(10, 10, 360, 90);
		this.add(textArea);
	}
 }

class ResultPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextArea resultArea = null;
	public JScrollPane scrollPane = null;
	ResultPanel(){
		setResultArea();
	}

        public void setallpost(String allpost)
        {
           resultArea.setText(allpost); 
        }
	public void setResultArea(){
		resultArea = new JTextArea(10,30);
                resultArea.setText("hope it goes on easy");
		resultArea.setLineWrap(true);
		resultArea.setBounds(10, 140,750, 250);
                //add(resultArea);
		scrollPane = new JScrollPane(resultArea);
		add(scrollPane);

	}
}

class ButtonPanel extends JPanel{
    /**
	 *
3	 */
	private static final long serialVersionUID = 1L;
	//JTextArea textArea = null;
	//JScrollPane scrollPane = null;
	JLabel showLabel;
	JButton []buttons;

	ButtonPanel(){
            
	  this.setBounds(10, 415, 770, 40);
	 	buttons = new JButton[8];
		this.setLayout(new GridLayout(2,4));
        for(int i=0;i<8;i++){
        	buttons[i]= new JButton();
        	this.add(buttons[i]);
        //enablePanel();
        }
        buttons[0].setText("Add Friend");
        buttons[1].setText("List all posts");
        buttons[2].setText("List all comments on a post");
        buttons[3].setText("Comment on A post");
        buttons[4].setText("List all events");
        buttons[5].setText("Friend request");   
        buttons[6].setText("Find nearest friend");
        buttons[7].setText("Range query");

	}

	public void disableButton(){
		for(int i=0;i<buttons.length;i++)
			buttons[i].setEnabled(false);
	}

	public void enableButton(){
		for(int i=0;i<buttons.length;i++)
			buttons[i].setEnabled(true);
	}

	public void disablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].disable();
		}
		disableButton();
	}

	public void enablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
			comps[i].enable();
		}
		enableButton();
	}
}


class MainFrame extends JFrame{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JLabel LogoLabel;
	JButton notifyButton;
	LoginPanel loginPanel;
	SignupPanel signUpPanel;
	SqlPanel sqlPanel;
	ButtonPanel buttonPanel;
	PostandSearchPanel postandsearch;
	ResultPanel resultPanel;
	Connection conn=null;
	ArrayList<String> requester = new ArrayList<String>();
	ArrayList<String> Relation= new ArrayList<String>();
	int countrequest=0;
	JTextArea resultArea = null;
	JScrollPane scrollPane = null;
	int trigger = 0;
	JLabel showLabel;
	int hasRequest = 0;
	StringBuffer SQLOut = new StringBuffer ();
	MainFrame(){
		setResizable(false);
		setLayout(null);
		setSize(1100, 700);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((width-1100)/2,(height-700)/2);
		setTitle("This is GUI for database homework");
		setNotifyLabel();
		SetLogo();
		setLoginPanel();
		setSignupPanel();
		setSqlPanel();
		setButtonPanel();
		setPostandSearchPanel();
		setResultPanel();
		postandsearch.disablePanel();
		buttonPanel.disablePanel();
                signUpPanel.disablePanel();
	}

	public void disableResult(){
    	resultArea.setText("");
    	resultArea.setEditable(false);
    	resultArea.setEnabled(false);
    	scrollPane.setEnabled(false);
	}

	public void setResultPanel(){
		resultArea = new JTextArea(10,30);
		resultArea.setLineWrap(true);
		scrollPane = new JScrollPane(resultArea);
		add(scrollPane);
		scrollPane.setBounds(10, 140,770, 250);
	}

	public void SetLogo(){
	Image image;
	try {
		image = ImageIO.read(new File("usc_viterbi_logo.jpg"));
		ImageIcon icon = new ImageIcon(image);
		LogoLabel = new JLabel();
		LogoLabel.setIcon(icon);
		LogoLabel.setBounds(830,480,300,150);

		add(LogoLabel);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  //this generates an image file

	}

	public void setNotifyLabel(){
		Image image;
		try {
			image = ImageIO.read(new File("notify.png"));
			ImageIcon icon = new ImageIcon(image);
			notifyButton = new JButton();
			notifyButton.setIcon(icon);
			notifyButton.setBounds(750,3,30,30);

			notifyButton.addActionListener(new ActionListener() {
	           
	            public void actionPerformed(ActionEvent e) {
	            	/*Fill this function*/
	            	/*Press this notification button, you should list all the friend request on the ResultPanel*/
	            	/*the output format is like "... wants to add you as 'friend type'." */
	                int flag=0;
                        try
                        {
                            String t="";
                            String all="";
                        
                        ConnectDB db12=new ConnectDB();
                        Connection conn=db12.openConnection();
                        String sqlquery="select email1 from requests where email2= '"+loginPanel.getUserName()+"'";
                        Statement stt=conn.createStatement();
                        ResultSet res=stt.executeQuery(sqlquery);
                        sqlPanel.SQLArea.setText(sqlquery);
                        while(res.next())
                        {
                            t=res.getString(1);
                            all=all+t+"wants to add you as a friend !!!\n\n";
                            flag=1;
                        }
                        
                        if(flag==1)
                            resultArea.setText(all);
                        else
                            JOptionPane.showMessageDialog(null,"No friend Requests");
                        }
                        catch(SQLException ex1)
                        {
                            JOptionPane.showMessageDialog(null,"Error occurred");
                        }
                        //JOptionPane.showMessageDialog(null,"notify button");
                    }
	        });

			add(notifyButton);
			notifyButton.setVisible(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //this generates an image file


	}

	public void setButtonPanel(){
		buttonPanel = new ButtonPanel();
		this.add(buttonPanel);

		buttonPanel.buttons[0].addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
            	final Frame0 frame=new Frame0("User Email",1);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);

                frame.btn1.addActionListener(new ActionListener() {
                    
                    public void actionPerformed(ActionEvent e) {
                    	/*Fill this function*/
    	            	/*Press this add friend button, input user Email information, press OK, you should be able to send friend request*/
    	            	/*After press ok, you should also pop up a standard dialog box to show the request send status <succeed or failed>*/
                    	String friendname=frame.txtfield.getText();
                        String type=(frame.combo.getSelectedItem()).toString();
                        int already=0;
                        String t="";
                        String t1="";
                        
                        System.out.println(friendname+loginPanel.getUserName());
                        try
                        {
                        String check="select userone from friendship where usertwo='"+loginPanel.getUserName()+"' ";
                        check=check+" UNION select usertwo from friendship where userone='"+loginPanel.getUserName()+"'";
                        ConnectDB db2=new ConnectDB();
                        Connection c=db2.openConnection();
                        Statement st=c.createStatement();
                        ResultSet re=st.executeQuery(check);
                        System.out.println(check);
                        while(re.next())
                        {
                         t=re.getString(1);
                         System.out.println(t);
                         if(t.equals(friendname))
                         {
                         ++already;
                         break;
                         }
                        //t1=re.getString(2);
                        //System.out.println(t+t1);
                        
                        }
                        //if(t.equals(""))
                        //{
                         //   already=0;
                        //}
                        //else
                        //{
                        //already=1;
                        //}
                        sqlPanel.SQLArea.setText(check);
                        if(already == 0)
                        {
                        
                        String q1="insert into requests values ('"+loginPanel.getUserName()+"','"+friendname+"','"+type+"')";
                        st.executeUpdate(q1);
                        check=check+"\n\n"+q1;
                        sqlPanel.SQLArea.setText(check);
                        JOptionPane.showMessageDialog(null,"Friend Request sent cuccessfully");
                        }
                        
                        else
                        {
                         JOptionPane.showMessageDialog(null,"Friend Request UNSUCCESSFUL");        
                        }
                        }
                        catch(SQLException ex1)
                        {
                         JOptionPane.showMessageDialog(null,"Friend Request UNSUCCESSFUL");         
                        }
                    }
                });

            }
        });
		buttonPanel.buttons[1].addActionListener(new ActionListener() {
          
            public void actionPerformed(ActionEvent e) {
            	
                JOptionPane.showMessageDialog(null,"hello");
                
            	/*Press this list all post button, you should be able to list all the post which are visible to you*/
            	/*You can define the output format*/

              //  LoginPanel lp=new LoginPanel();
                
                String temp=loginPanel.username.getText();
                String temp2="";
                String temp3="";
                //String temp4="";
                String temp5="";
                /*
                String query="(select * from post where privacy=2)"
                        +     " UNION (";
                */
                
                
                String query2="select * from post where privacy=2\n";
                query2=query2+"UNION \n";
                query2=query2+"select * from post where sender='"+temp+"'\n";
                query2=query2+"UNION\n";
                query2=query2+"select post.ID,post.note,post.sender,post.privacy,post.datetime from post,friendship"
                        + " where post.privacy=1 AND ((post.sender=friendship.userone AND friendship.usertwo='"+temp+"')OR(post.sender=friendship.usertwo AND friendship.userone='"+temp+"'))";
                sqlPanel.SQLArea.setText(query2);
                
            //    query2=query+""
                String allpost="";
                System.out.println(query2);
                Connection conn=null;   
                ConnectDB db2=new ConnectDB();
                conn=db2.openConnection();
                ResultSet res=null;
                Statement sttmt=null;
                try
                    
                {
                sttmt=conn.createStatement();
                res=sttmt.executeQuery(query2);
                
                while(res.next())
                {
                    Integer temp1=Integer.parseInt(res.getString(1));
                     temp2=res.getString(2);
                    
                     temp3=res.getString(3);
                    
                     Integer temp4=Integer.parseInt(res.getString(4));
                     
                     temp5=res.getString(5);
                     allpost=allpost+"\n"+temp1+temp2+temp3+temp4+temp5;
                    //System.out.println(temp1+temp2+temp3+temp4+temp5);
                     
                         }
                System.out.println(allpost);
               resultArea.setText(allpost);
                
                
                }
                catch(SQLException ex)
                {
                    System.out.println("Error in displaying the posts of the user");
                }
                
            
               
               // System.out.println("Text already present is :"+buttonPanel.textArea.getText());
            }
        });

		buttonPanel.buttons[2].addActionListener(new ActionListener() {
          
            public void actionPerformed(ActionEvent e) {
            	final Frame0 frame=new Frame0("Post ID: ",2);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
                frame.btn1.addActionListener(new ActionListener() {
                 
                    public void actionPerformed(ActionEvent e) {
                        
                        System.out.println(frame.txtfield.getText());
                        String query2="select text from post_comment where pid="+frame.txtfield.getText();
                        System.out.println(query2);
                        sqlPanel.SQLArea.setText(query2);
                        ConnectDB db1=new ConnectDB();
                        Connection tempconnection=db1.openConnection();
                         String allcomment="";
                        try
                        {
                         Statement sttmt=tempconnection.createStatement();
                         ResultSet res=sttmt.executeQuery(query2);
                         
                         while(res.next())
                         {
                         String tempo=res.getString(1);
                             allcomment=allcomment+"\n "+tempo;
                         }
                         System.out.println(allcomment);
                                                 
                         resultArea.setText(allcomment);
                        }
                        catch(SQLException ex)
                        {
                            System.out.println("Some error has occurred");
                            //ex.printStackTrace();
                        }
                    	/*Fill this function*/
    	            	/*Press this List Comments Button, input Post ID, press OK, you should be able to list all the comment about this post*/
                        
                    }
                        
                    
                });
            }
        });
		
		buttonPanel.buttons[3].addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
            	final Frame1 frame=new Frame1("Post ID: ","Content: ");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
                frame.btn1.addActionListener(new ActionListener() {
                    
              
                       
                      public void actionPerformed(ActionEvent e) {
                    	
                          String todaysdate="";
                          String monthname="";
                          Integer maxid;
                          Date d=null;
                          
                           d=new Date();
                           switch(d.getMonth())
                          {
                     case 0:monthname="JAN";
                            break;   
                     case 1:monthname="FEB";break;   
                     case 2:monthname="MAR";break;   
                     case 3:monthname="APR";break;   
                     case 4:monthname="MAY";break;   
                     case 5:monthname="JUN";break;
                     case 6:monthname="JUL";break;   
                     case 7:monthname="AUG";break;   
                     case 8:monthname="SEP";break;    
                     case 9:monthname="OCT";break;   
                     case 10:monthname="NOV";break;   
                     case 11:monthname="DEC";break;   
                         
                           }
                        
                        
                        
                          int sumtotal=d.getYear()+1900;
                          todaysdate=d.getDate()+"-"+monthname+"-"+sumtotal;
                       //  d = dfn.parse(dfn.format(new Date()));
                     //   }
                  
                        //catch(java.text.ParseException ex)
                        //{
                          //  System.out.println("Exception has occurred ");
                        //}
                          int caninsert=0;
                        Integer privacylevel=0;
                        int pvclevel=0;
                        String tempsender="";
                        Integer postid=Integer.parseInt(frame.txtfield.getText());
                        String comments=frame.textArea.getText();
                        String uname=loginPanel.username.getText();
                        
                        String query2="insert into post_comment(pid,text,mid,datetime) values("+postid+",'"+comments+"','"+uname+"','"+todaysdate+"')";
                        String q5="select sender,privacy from post where id="+postid; 
                        sqlPanel.SQLArea.setText(q5);
                         ConnectDB db2=new ConnectDB();
                        Connection conn=null;
                       System.out.println(q5);
                        try
                       {
                        conn=db2.openConnection();
                        
                        Statement sttmt=conn.createStatement();
                        ResultSet res1=sttmt.executeQuery(q5);                 
            
                        while(res1.next())
                        {
                            tempsender=res1.getString(1);
                            privacylevel=Integer.parseInt(res1.getString(2));
                            System.out.println(tempsender+privacylevel);
                            
                        }
                        System.out.println("tempsender"+tempsender+"uname"+uname);
                        if( tempsender.equals(uname) )
                        caninsert=1;
                        
                        pvclevel=privacylevel.intValue();
                       
                        System.out.println(tempsender+pvclevel);
                        
                        
                        if(pvclevel == 2)
                        {
                            System.out.println("privacy level 2");
                            caninsert=1;
                        }
                        if(pvclevel == 0)
                        {
                            //sqlPanel.SQLArea.setText(q1);
                          String q4="select id from post where id="+postid+"AND sender='"+uname+"'";  
                          q5=q5+q4;
                          sqlPanel.SQLArea.setText(q5);
                          System.out.println(q4);
                          ResultSet r2=sttmt.executeQuery(q4);
                          String temp1=" ";
                          while(r2.next())
                          {
                              temp1=r2.getString(1);
                              System.out.println(temp1);
                          } 
                            
                          System.out.println("privacy level 0");
                          System.out.println(tempsender+uname);
                          if(temp1.equals(" "))
                          {
                              caninsert=0;
                          }
                          else
                          {
                          caninsert=1;
                          }
                        }
                        if(pvclevel ==1 && caninsert==0)
                        {
                            System.out.println("privacy level 1");
                            String checkquery="select userone from friendship where (userone='"+tempsender+"'AND usertwo='"+uname+"')or(userone='"+uname+"' AND usertwo='"+tempsender+"')";
                            System.out.println(checkquery);
                            q5=q5+checkquery;
                            sqlPanel.SQLArea.setText(q5);
                            ResultSet r=sttmt.executeQuery(checkquery);
                            String t=" ";
                             while(r.next())
                             {
                               t=r.getString(1);       
                               System.out.println(t);
                               
                             } 
                             if(t.equals(" "))
                             {
                             }
                             else 
                             {   
                            caninsert=1; 
                              }
                             
                            // String q4="select id from post where id="+postid+"AND sender='"+uname+"'";  
                          //System.out.println(q4);
                          //ResultSet r2=sttmt.executeQuery(q4);
                          //String temp1=" ";
                          //while(r2.next())
                         // {
                           //   temp1=r2.getString(1);
                             // System.out.println(temp1);
                          //} 
                             
                             
                             
                       }
                        
                            if(caninsert ==1)
                            {
                            sttmt.executeUpdate(query2);
                            q5=q5+query2;
                            sqlPanel.SQLArea.setText(q5);
                             JOptionPane.showMessageDialog(null,"Successfully commented on Post!!!! ");
                            }
                            else
                            JOptionPane.showMessageDialog(null, "Failed :Sorry cannot comment");
                       
                        
                        
                       }
                       catch(SQLException ex)
                       {
                           System.out.println("Failed due to some weird reason ");
                       }
                        /*Fill this function*/
    	            	/*Press this Comment Button, input Post ID, and comment, press OK, you should be able to comment on this post*/
                    	/*After press ok, you should also pop up a standard dialog box to show the comment's status <succeed or failed>*/	

                    }
                });
            }
        });
		
	buttonPanel.buttons[4].addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	/*Fill this function*/
            	/*Press this List all event Button, you should be able to list all available event*/
                String allevents="";

               String query3="select * from event";
               sqlPanel.SQLArea.setText(query3);
               try
               {
               ConnectDB db3=new ConnectDB();
                Connection conn1=db3.openConnection();
                Statement sttmt=conn1.createStatement();
                ResultSet res=sttmt.executeQuery(query3);
                
                while(res.next())
                {
                    String temp1=res.getString(1);
                    String temp2=res.getString(2);
                    Integer temp3=Integer.parseInt(res.getString(3));
                    String temp4=res.getString(4);
                    String temp5=res.getString(5);
                    
                    String splitval[]=temp4.split("-");
                    Integer yearw=Integer.parseInt(splitval[0]);
                  if(  ( splitval[1].equals("12") &&(splitval[0].equals("2013")))  || yearw >2013  )
                    allevents=allevents+"\n\n"+temp1+temp2+temp3+temp4+temp5;
                }
                System.out.println(allevents);
                resultArea.setText(allevents);
               }
               catch(SQLException ex)
               {
                  // ex.printStackace();
               }
               
            }
        });


		buttonPanel.buttons[5].addActionListener(new ActionListener() {
           
        public void actionPerformed(ActionEvent e) {
        	final Frame2 frame=new Frame2("Decline: ");
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true);

            frame.btn1.addActionListener(new ActionListener() {
               
                public void actionPerformed(ActionEvent e) {
                	/*Fill this function*/
                	/*Press this decline Button, you should be able to decline friend request*/
                	/*You could decline one at a time, or decline many at a time. e.g. using comma to separate each request*/
                	/*pop up a standard dialog box to show <succeed or failed>*/
                         String declinelist=frame.txtfield.getText();	
                         String list[]=declinelist.split(",");
                        int i;
                        String q5all="";
                        try
                        {
                        ConnectDB db3=new ConnectDB();
                Connection conn1=db3.openConnection();
                Statement sttmt=conn1.createStatement();
                         for(i=0;i<list.length;i++)
                         {
                             String q="delete from requests where email2='"+loginPanel.getUserName()+"' AND email1='"+list[i]+"'";
                             sttmt.executeUpdate(q);     
                             q5all=q5all+"\n"+q;
                              JOptionPane.showMessageDialog(null,"SUCCEEDED ");
                         }
                         sqlPanel.SQLArea.setText(q5all);
                        }
                        catch(SQLException ex)
                        {
                        JOptionPane.showMessageDialog(null,"FAILED Some error has occurred");
                        }
                }
            });


            frame.btn2.addActionListener(new ActionListener() {
           
                public void actionPerformed(ActionEvent e) {
                	/*Fill this function*/
                	/*Press this accept all Button, you should be able to accept all friend request and add this information into friend relationship table*/
                	/*pop up a standard dialog box to show <succeed or failed>*/
                
                    String allc="";
                    String alla="";
                    String a="";
                    String b="";
                    String c="";
                  //  String l[50];
                  
                    int i=0;
                 try
                        {
                        ConnectDB db3=new ConnectDB();
                        Connection conn1=db3.openConnection();
                        Statement sttmt=conn1.createStatement();
                         String q="select email1,email2,type from requests where email2='"+loginPanel.getUserName()+"'";
                         ResultSet res=sttmt.executeQuery(q);
                         System.out.println(q);
                         sqlPanel.SQLArea.setText(q);
                            while(res.next())
                            {
                               a=res.getString(1);
                               b=res.getString(2);
                               c=res.getString(3);
                               
                               alla=alla+a+"," ;
                               allc=allc+c+"," ;
                               
                              // String q1="insert into friendship values('"+a+"','"+b+"','"+c+"')";
                               //sttmt.executeUpdate(q1);
                            }
                            String q4all="";
                            String bsplit[]=alla.split(",");
                            String csplit[]=allc.split(",");
                            System.out.println(alla+"  "+allc);
                            for(i=0;i<(bsplit.length);i++)
                            {
                                String q4="insert into friendship values('"+loginPanel.getUserName()+"','"+bsplit[i]+"','"+csplit[i]+"')";
                                sttmt.executeUpdate(q4);
                                System.out.println(q4);
                                q4all=q4all+"\n"+q4;
                                 JOptionPane.showMessageDialog(null,"success");
                            }
                            
                            String q3="delete from requests where email2='"+loginPanel.getUserName()+"'";
                               sttmt.executeUpdate(q3);
                               System.out.println(q3);
                               sqlPanel.SQLArea.setText(q+q4all+q3);
                                JOptionPane.showMessageDialog(null,"success ");
                        }
                        catch(SQLException ex)
                        {
                        JOptionPane.showMessageDialog(null,"failed : Some error has occurred");
                        ex.printStackTrace();
                        }
                
                
                
                
                
                }
            });

        }
		});

		buttonPanel.buttons[6].addActionListener(new ActionListener() {
         
            public void actionPerformed(ActionEvent e) {
            	/*Fill this function*/
            	/*Press this Button, you should be able list the information(including address information) about your friend who live nearest to you*/
            	/*This is a spatial query*/
        
                ConnectDB db5=new ConnectDB();
                Connection con=db5.openConnection();
                String sum="select id from member where email='"+loginPanel.getUserName()+"'";
                String ss=loginPanel.getUserName();
                try
                {
               
                
                Statement s=con.createStatement();
                ResultSet r2=s.executeQuery(sum);
                r2.next();
                int idno=Integer.parseInt(r2.getString(1));
                System.out.println(idno);
                int store12[]=new int[100];
                int j=0;
                int frcount=0;
                
                String q5="select id from adrr a where sdo_nn ( a.coord, ( select a1.coord from adrr a1 where a1.id="+idno+")  )='TRUE'";
                Statement s1=con.createStatement();
                ResultSet r4=s1.executeQuery(q5);
                while( r4.next() )
                {
                  store12[j]=Integer.parseInt(r4.getString(1));    
                     
                  System.out.println(store12[j]);
                  ++j;
                }
                frcount=j;
                String s6="";
                for(j=0;j<frcount;j++)
                {
                    
                 s6="select email,streetnumber,streetaddress,city,state,country,zip from member,addr,friendship where (userone=email and usertwo='"+loginPanel.getUserName()+"') or (usertwo=email AND userone='"+loginPanel.getUserName()+"')  AND member.id=addr.id AND addr.id="+store12[j]+" AND email NOT IN('"+loginPanel.getUserName()+"')"; 
                 System.out.println(s6);
                 Statement friendsttmt=con.createStatement();
           //ResultSet frs=friendsttmt.executeQuery(q7);
                
                
                
                
                 Statement s11=con.createStatement();
                 ResultSet r7=s11.executeQuery(s6);
                 String aggre="";
                 r7.next();
                 
                  String f1=r7.getString(1);
                  String f2=r7.getString(2);
                  String f3=r7.getString(3);
                  String f4=r7.getString(4);String f5=r7.getString(5);
                  String f6=r7.getString(6);
                  String f7=r7.getString(7);
                  
                  aggre=aggre+"\n\n"+f1+f2+f3+f4+f5+f6+f7;
                   resultArea.setText(aggre);
                 if(f1.equals(""))
                 {
                 
                 }
                 else break;
                 // resultArea.setText(aggre);            
                
                }
                
                
                
               // int tt1=
                //System.out.println(tt1);
             //   String q7="select userone from friendship where usertwo='"+loginPanel.getUserName()+"'"+"\n UNION \n"+"select usertwo from friendship where userone='"+loginPanel.getUserName()+"'";
             //   String q6="select email,streetno,streetaddress,city,state,country,zip from member,adrr where email NOT IN('"+loginPanel.getUserName()+"') AND member.id=adrr.id AND member.id="+tt1;
                
                           
             //   Statement friendsttmt=con.createStatement();
           //     ResultSet frs=friendsttmt.executeQuery(q7);
                
                
                
                /*
                Statement s11=con.createStatement();
                ResultSet r7=s11.executeQuery(q6);
                 String aggre="";
                 while(r7.next())
                 {
                  String f1=r7.getString(1);
                  String f2=r7.getString(2);
                  String f3=r7.getString(3);
                  String f4=r7.getString(4);String f5=r7.getString(5);
                  String f6=r7.getString(6);
                  String f7=r7.getString(7);
                  
                  aggre=aggre+"\n\n"+f1+f2+f3+f4+f5+f6+f7;
                  
                  }
                resultArea.setText(aggre);
                 sqlPanel.SQLArea.setText(q5+q6);
                */
                }
                catch(SQLException e3)
                {
                    e3.printStackTrace();
                 JOptionPane.showMessageDialog(null,"error occurred");   
                }
            /*
                String temp1="";
                String temp2="";
                String query5="select email,coord from member,addr where member.ID=addr.ID AND email NOT IN ('"+loginPanel.getUserName()+"')";
                String query6="select coord from addr,member where email='"+loginPanel.getUserName()+"' AND member.ID=addr.ID";
                String basecoord="";
               // String splitone;
                String splittwo="";
               // System.out.println(query6);
                //Double min=0.0;
                int i=0;
                Integer a[]=new Integer[100];
                String namestore[]=new String[100];
                ConnectDB db10=new ConnectDB();
                Connection connnn=db10.openConnection();
                try
                {
                    Statement st=connnn.createStatement();
                    ResultSet r=st.executeQuery(query6);
                    while(r.next())
                    {
                    basecoord=r.getString(1);
                    
                    }
                    
                System.out.println(basecoord);
                
                  
                    
                }
                catch(SQLException exceptt)
                {
                    System.out.println("Error has occurred in retrieving users coordinates");
                }
                String t[]=basecoord.split(",");
                Double firstone=Double.parseDouble(t[0].substring(1,t[0].length()));
                double d3=firstone.doubleValue();
                Double secondone=Double.parseDouble(t[1].substring(0,3));
                double d4=secondone.doubleValue();
                
                System.out.println(firstone+"  "+secondone);
                String cname="";
                try
                {
                Statement stt=con.createStatement();
                ResultSet res=stt.executeQuery(query5);
                
                while(res.next())
                {
                       temp1=res.getString(1);
                       temp2=res.getString(2);
                       
                       
                String t1[]=temp2.split(",");
                Double first1=Double.parseDouble(t1[0].substring(1,t1[0].length()));
                double d1=first1.doubleValue();
                Double second2=Double.parseDouble(t1[1].substring(0,3));
                double d2=second2.doubleValue();
                
                System.out.println(first1+"  "+second2);
                       
                //if(i==0)
                double dx=(d1-d3);
                
                double dy=(d2-d4);
                

                //double result=Math.pow(dx*dx+dy*dy,0.5);
                 //int temporary=(int)result;
                //namestore[i]=temp1;       
                //a[i]=temporary;
                //System.out.println((i+1)+"   "+a[i]+"   "+namestore[i]);
               if(dx ==0 && dy ==0)
                 cname=cname+temp1;
                 
      //           ++i;
  
                }
                
      
        /*        int min=a[0];
                 cname="";
                for(i=1;i<30;i++)
                {
                    if(a[i] < min)
                    {
                    min=a[i];
                    cname=cname+namestore[i];
                    }
                }
          
                System.out.println("Nearest user is "+cname);
                
                }
                
                catch(SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, "Error has occurred");
                 }   
            */
            }
        });
		buttonPanel.buttons[7].addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
            	
                final Frame3 frame=new Frame3("Please input coordinate: ");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);

                frame.btn1.addActionListener(new ActionListener() {
                  
                    public void actionPerformed(ActionEvent e) {
                    	/*Fill this function*/
                    	/*Press this Button, input left top corner coordinate and right down corner coordinate*/
                    	/*press ok, you should be able list the information(including address information) about your friend who lives in this area. Close query window*/
                    	/*This is a spatial query*/
                           String uname=loginPanel.getUserName();
                          String friendslist="";
                         System.out.println(frame.txtfield[0].getText());   
                         System.out.println(frame.txtfield[1].getText());   
                         System.out.println(frame.txtfield[2].getText());   
                         System.out.println(frame.txtfield[3].getText());   
                        
                         int tx,ty,bx,by;
                         tx=Integer.parseInt(frame.txtfield[0].getText());
                          ty=Integer.parseInt(frame.txtfield[1].getText());
                           bx=Integer.parseInt(frame.txtfield[2].getText());
                            by=Integer.parseInt(frame.txtfield[3].getText());
                   
                        String qsd="select a.id from adrr a where SDO_INSIDE(a.coord,SDO_GEOMETRY(2001,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,3),SDO_ORDINATE_ARRAY("+tx+","+ty+","+bx+","+by+") )) = 'TRUE' ";
                          sqlPanel.SQLArea.setText(qsd);
                        
                        //System.out.print 
                  
                          /*  try
                          { 
                       //   String qsd="select a.id from adrr a where SDO_INSIDE(a.coord,SDO_GEOMETRY(2001,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,3),SDO_ORDINATE_ARRAY("+tx+","+ty+","+bx+","+by+") )) ";
                          ConnectDB d123=new ConnectDB();
                          Connection c23=d123.openConnection(); 
                          Statement sttt=c23.createStatement();
                          ResultSet rrr1=sttt.executeQuery(qsd);
                          System.out.println(rrr1.next());
                          
                          while(rrr1.next())
                          {
                              String hhh=rrr1.getString(1);
                              System.out.println(hhh);
                          }
                          }
                          catch(SQLException ef)
                          {
                       //   System.out.println(ef.printStackTrace());
                  
                          }
                          
                         // ln(tx+ty+bx+by);
                
                  */
                            try
                         {
                             int i=0;
                             String storehouse[]=new String[100];
                         ConnectDB db12=new ConnectDB();
                        Connection con1=db12.openConnection();
                        String querycheck="select userone from friendship where usertwo='"+uname+"'\nUNION\n select usertwo from friendship where userone='"+uname+"'";
                        Statement frstt=con1.createStatement();
                        ResultSet rs=frstt.executeQuery(querycheck);
                        System.out.println("___________________________________");
                        while(rs.next())
                        {
                            String fr=rs.getString(1);
                            storehouse[i]=fr;
                            ++i;
                            System.out.println(fr);
                        }
                        int totalcount=i;
                        System.out.println("____________________________________");
                        
                        
                        String query5="select email,coord from member,addr,friendship where addr.ID=member.ID AND ((friendship.userone=member.email AND friendship.usertwo='"+uname+"') OR (friendship.usertwo=member.email AND friendship.userone='"+uname+"'))";
                        System.out.println(query5);                         
                        Statement stt=con1.createStatement();
                        ResultSet res1=stt.executeQuery(query5);
                                                
                        while(res1.next())
                        {
                         String n=res1.getString(1);
                         String co=res1.getString(2);
                         //System.out.println(n+co); 
                         
                                 
                                String t1[]=co.split(",");
                                System.out.println(t1[0]+t1[1]);
                                int d1=Integer.parseInt(t1[0].substring(1,4));
                                int d2=Integer.parseInt(t1[1].substring(0,3));
                                   System.out.println(d1+d2);
                                     if( d1<=bx && d1>=tx && d2>=by && d2<=ty)
                                     {
                                     //       System.out.println(n+"  "+tx+"  "+d1+"  "+bx+"           "+by+"   "+d2+"   "+ty);
                                 //             System.out.println(n);                    
                     //                       for(int z=0;z<totalcount;z++)
                       //                     {
                         //                       if((storehouse[z].equals(n)))
                           //                     {
                                                    friendslist=friendslist+"\n"+n;
                                                    System.out.println(n);
                             //                   }
                               //                 }
                                        //    friendslist=friendslist+"\n"+n;
                                      }
                
                                                       //System.out.println(friendslist);
                        }
                             System.out.println(friendslist);
                             resultArea.setText(friendslist);
                         }
                         catch(SQLException ex2)
                         {
                             JOptionPane.showMessageDialog(null,"Error in retrieving range query");
                         }
           
                         
          }
                });
            }
        });
		
	}

	public void setPostandSearchPanel(){
		postandsearch = new PostandSearchPanel();
		this.add(postandsearch);
		StringBuffer result= new StringBuffer();


		postandsearch.buttons[0].addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) { 
            	/*Fill this function*/
            	/*Press this Button, you should be able post the information written in the textArea*/
            	/*pop up a standard dialog box to show <succeed or failed>*/
                String getpost=postandsearch.textArea.getText();
                String getname=loginPanel.getUserName();
                String query4="select max(ID) from post";
                Integer privacyset=2;
                Integer idset=0;
                Date d=null;
                 String monthname="";
                 String todaysdate="";
                           d=new Date();
                           switch(d.getMonth())
                          {
                     case 0:monthname="JAN";
                            break;   
                     case 1:monthname="FEB";break;   
                     case 2:monthname="MAR";break;   
                     case 3:monthname="APR";break;   
                     case 4:monthname="MAY";break;   
                     case 5:monthname="JUN";break;
                     case 6:monthname="JUL";break;   
                     case 7:monthname="AUG";break;   
                     case 8:monthname="SEP";break;    
                     case 9:monthname="OCT";break;   
                     case 10:monthname="NOV";break;   
                     case 11:monthname="DEC";break;   
                         
                           }
                         int sumtotal=d.getYear()+1900;
                          todaysdate=d.getDate()+"-"+monthname+"-"+sumtotal;
                
                          try
                          {
                       ConnectDB db4=new ConnectDB();
                       Connection conn2=db4.openConnection();
                       
                       Statement sttmt1=conn2.createStatement();
                       ResultSet res=sttmt1.executeQuery(query4);
                       
                       while(res.next())
                       {
                       idset=Integer.parseInt(res.getString(1));
                       }
                       idset=idset+1;
                       String query5="insert into post values("+idset+",'"+getpost+"','"+getname+"',"+privacyset+",'"+todaysdate+"')";
                       sqlPanel.SQLArea.setText(query4+query5);
                       sttmt1.executeUpdate(query5);
                        JOptionPane.showMessageDialog(null,"SUCESSFULLY POSTED");
                          }
                          catch(SQLException ex)
                          {
                               JOptionPane.showMessageDialog(null,"FAILED TO POST ");
                          }
            }
        });


		postandsearch.buttons[1].addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {  
            	/*Fill this function*/
            	/*Press this Button, you should be able search user information, list the information on the result panel*/
            	/*The search should based on email, first name or last name*/

           
                
                
                String getinfo=postandsearch.text.getText();
                if(getinfo.equals(""))
                    JOptionPane.showMessageDialog(null, "CANT BE EMPTY");
                else
                {
                String splitstr[]=getinfo.split(",");
                
                System.out.println(splitstr[0]+"   "+splitstr[1]);
                try
                {
                String q1="select email,firstname,lastname,birthdate,streetnumber,streetaddress,city,state,country,zip from member,addr where member.ID=addr.ID AND member.email='"+splitstr[0]+"'";
                q1=q1+"AND member.firstname='"+splitstr[1]+"' OR member.lastname='"+splitstr[1]+"'";
                ConnectDB db3=new ConnectDB();
                Connection conn=db3.openConnection();
                Statement smt=conn.createStatement();
                ResultSet rs=smt.executeQuery(q1);
                System.out.println(q1);
                String t1="";
                String t2="";
                String t3="";
                String t4="";
                String t5="";String t10="";
                String t6="";
                String t7="";
                String t8="";
                String t9="";
                
                sqlPanel.SQLArea.setText(q1);
                
                while(rs.next())
                {
                        t1=rs.getString(1);
                       t2=rs.getString(2);
                       t3=rs.getString(3);
                       t4=rs.getString(4); 
                       t5=rs.getString(5);
                       t6=rs.getString(6);
                       
                       t7=rs.getString(7);
                       t8=rs.getString(8);
                       t9=rs.getString(9);
                       t10=rs.getString(10);
                    
                       System.out.println(t1+"\n"+t2+"\n"+t3+"\n"+t4+"\n"+t5+"\n"+t6+"\n"+t7+"\n"+t8+"\n"+t9+"\n"+t10+"\n");
                }
                resultArea.setText(t1+"\n"+t2+"\n"+t3+"\n"+t4+"\n"+t5+"\n"+t6+"\n"+t7+"\n"+t8+"\n"+t9+"\n"+t10+"\n");
            
                }
                catch(SQLException ex)
                        {
                            JOptionPane.showMessageDialog(null,"Exception occurred");        
                        }
                      
                }
            }
        });
	}
	public void setSQLOutput(StringBuffer sb)
	{
		sqlPanel.SQLArea.setText(sb.toString());
		sqlPanel.SQLArea.setEnabled(true);
	}
	public void setSqlPanel(){
		sqlPanel = new SqlPanel();
		this.add(sqlPanel);
		showLabel = new JLabel("The corresponding SQL :");
		showLabel.setBounds(20, 470, 200, 20);
		this.add(showLabel);
	}

	public void setLoginPanel(){
		loginPanel = new LoginPanel();
		this.add(loginPanel);

		loginPanel.signup.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		        signUpPanel.enablePanel();
			}
        });
                
                
        loginPanel.login.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {  
            	/*Fill this function*/
            	/*Press this Button, you should be able match the user information. If valid, keep the user email information(but can't modified) and clear the password*/
            	/*at the same time, you should scan the friend request table, to determine whether current logged in user has friend request, if has, set notification icon*/
            	/*If invalid, you should pop up a dialog box to notify user, then enable signup panel for user to register*/
            	/*After logged in, you should change this button's function as logout which means disable all the panel, return to the original state*/
            ResultSet rs=null;
            Connection conn=null;
            ConnectDB db=new ConnectDB();
            conn=db.openConnection();   
            /*
            String q1="select c.v.SDO_POINT.X,c.v.SDO_POINT.Y from address1  c";
           try
           {
            Statement stt=conn.createStatement();
            ResultSet r=stt.executeQuery(q1);
            System.out.println(q1+r.next());
            while(r.next())
            {
                System.out.println("");
                String sss=r.getString(1);
                String ssss=r.getString(2);
                System.out.println("hhh"+sss+ssss);
            
            }
           }
           catch(SQLException ex)
           {
               System.out.println(ex.getMessage());
           }
           
            */Statement psmt;    
            String temp1="";
            String temp2="";
            String temp3="";
            String temp4="";
            String temp5="";    
            String uname="";
            String pwd="";
            String user1="";
            String pass1="";
            String query;
            Integer flag=0;
            uname = loginPanel.getUserName();
            pwd=loginPanel.getPassword();
            ResultSet r1=null;
            System.out.println("Matching username : "+uname+"  Password  :"+pwd);
            query="select email,password,firstname,lastname,birthdate,ID from member where email='"+uname+"' AND password ='"+pwd+"'";
            //String queryc="select * from requests where email1='"+uname+"' or email2='"+uname+"'";
            sqlPanel.SQLArea.setText(query);
            try
            {
           psmt=conn.createStatement();
           rs=psmt.executeQuery(query);
           //r1=psmt.executeQuery(queryc);
            System.out.println("Output1"+query); 
            flag=0;
            //boolean b=rs.next();
            //System.out.println(b);
            
            while(rs.next())
            {
              flag=1;
             temp1=rs.getString(1);
             temp2=rs.getString(2);
              temp3=(rs.getString(3));
              temp4=(rs.getString(4));
              temp5=(rs.getString(5));
             Integer temp6=Integer.parseInt(rs.getString(6));
                
             System.out.println(temp1+temp2);
            }
            
            }
            catch(SQLException ex)
            {
                System.out.println("Retrieval Failed due to some reason");
                ex.printStackTrace();
            }
            System.out.println(flag);
            System.out.println(pwd.equals(temp2));
                
            if(flag ==1)
            {
                JOptionPane.showMessageDialog(null,"LOGIN SUCCESSFUL");
                System.out.println("Matching entry has been found");
                loginPanel.password.setText(null);
                postandsearch.enablePanel();
		buttonPanel.enablePanel();
                loginPanel.login.setText("LOGOUT");
                //signUpPanel.disablePanel();
                try
                {
                Connection c=null;
                ConnectDB d1=new ConnectDB();
                c=d1.openConnection();
                Statement st1=c.createStatement();
                String qc="select * from requests where email1='"+uname+"' or email2 ='"+uname+"'";  
                r1=st1.executeQuery(qc);
                sqlPanel.SQLArea.setText(query+qc);
                if(r1.next())
                notifyButton.setVisible(true);
                else
                    notifyButton.setVisible(false);
                }
                catch(SQLException e1)
                {
                }
            }
                else
            {
                //postandsearch.disablePanel();
		//buttonPanel.disablePanel();
                signUpPanel.enablePanel();
                JOptionPane.showMessageDialog(null,"UNSUCCESSFUL LOGIN");
              System.out.println("Matching entry not found");
              loginPanel.password.setText(null);
              loginPanel.username.setText(null);
            }
           
       }
            
            
           });
   

	}

	public void setSignupPanel(){

		signUpPanel = new SignupPanel();
		this.add(signUpPanel);
		signUpPanel.signup.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {  
            	/*Fill this function*/
            	/*Press this signup button, you should be able check whether current account is existed. If existed, pop up an error, if not check input validation(You can design this part according to your database table's restriction) create the new account information*/
            	/*pop up a standard dialog box to show <succeed or failed>*/
            	String m=signUpPanel.email.getText();
                String pass=signUpPanel.password.getText();
                String repass=signUpPanel.password2.getText();
                String fname=signUpPanel.fname.getText(); 
                String lname=signUpPanel.lname.getText();
                String city=signUpPanel.city.getText();
                String bday=signUpPanel.birthday.getText();
                String sno=signUpPanel.str_no.getText();
                String saddr=signUpPanel.str_address.getText();
                String zip=signUpPanel.zip.getText();
                int check=0;
                int flag=0;
                Integer idv=0;
                Integer t1=0;
                int idtemp;
                String t2="";
                String t3="";
                String t4="";
                String t5=""; 
                String temp1="";
                if(m.equals("") || pass.equals("")|| repass.equals("") || fname.equals("") || lname.equals("") || city.equals("") || bday.equals("") || sno.equals("") || saddr.equals("") ||zip.equals("") )
                {   
                 signUpPanel.email.setText(null);
                 signUpPanel.password.setText(null);
                 signUpPanel.password2.setText(null);
                 signUpPanel.fname.setText(null);
                 signUpPanel.lname.setText(null);
                 signUpPanel.city.setText(null);signUpPanel.zip.setText(null);
                 signUpPanel.birthday.setText(null);
                 signUpPanel.str_no.setText(null);
                 signUpPanel.str_address.setText(null);
                 JOptionPane.showMessageDialog(null,"FAILED :Fields cannot be empty");
                 check=1;
                }
                
               if(!(pass.equals(repass)))
               {
               check=1; 
               JOptionPane.showMessageDialog(null,"FAILED :PASSWORDS DO NOT MATCH");
               
               }
                //int snocheck=0;
                for(int i=0;i<sno.length();i++)
                {
                    char c=sno.charAt(i);
                    if(c <'0' || c >'9' )
                    {
                    check=1;
                    JOptionPane.showMessageDialog(null,"FAILED :Street Number should be in numbers");
                    //break;
                    }
                }   
                    
                 for(int i=0;i<bday.length();i++)
                {
                    char c=bday.charAt(i);
                    if(c <'0' || c >'9'&& i != 2 && i!=5  )
                    {
                    check=1;
                    JOptionPane.showMessageDialog(null,"FAILED :Birthday format different from specified format");
                    //break;
                    }
                }   
                    
                
                    
                //int saddrcheck=0;
                for(int i=0;i<zip.length();i++)
                {
                    char c=zip.charAt(i);
                    if(c <'0' || c >'9' )
                    {
                        check=1;
                        JOptionPane.showMessageDialog(null,"FAILED :ZIP code has to numbers only");
                      //  break;
                    }
                }       
               
                
                
                if(check == 0)
                {    
                   try
                    {
                               String query="select email from member where email='"+m+"'";
                               sqlPanel.SQLArea.setText(query);
                               ConnectDB db=new ConnectDB();
                               Connection con=db.openConnection();
                               Statement stt=con.createStatement();
                               ResultSet r=stt.executeQuery(query);
                               flag=0;
                               while(r.next())
                               {
                                      temp1=r.getString(1);
                                      System.out.println(temp1+m);
                               
                               }
                               
                               if(temp1.equals(""))
                               {
                                   flag=0;
                               }
                               else
                               {
                                   flag=1;
                               }
                               
                               System.out.println(flag);
                               if(flag == 0)
                               {
                                  
                               String q="select id,streetnumber,streetaddress,city,zip from addr where city='"+city+"' AND streetaddress='"+saddr+"' AND streetnumber="+sno+" AND zip="+zip;
                               sqlPanel.SQLArea.setText(query+"\n\n"+q);
                               ResultSet res=stt.executeQuery(q);
                               System.out.println(q);
                             
                                               while( res.next() )
                                                 {
                                                          System.out.println("It is here");
                                                          t1=Integer.parseInt(res.getString(1));
                                                          t2=res.getString(2);
                                                          t3=res.getString(3); 
                                                          t4=res.getString(4);
                                                          t5=res.getString(5);
                                                         System.out.println(t1+t2+t3+t4+t5);
                                                  } 
                  
                                                 if(t5.equals("") || t3.equals("") || t4.equals("")|| (t2.equals("")) )
                                                   {
                                                            String q6="select max(ID) from addr";
                                                            System.out.println(q6);
                                                            ResultSet r1=stt.executeQuery(q6);
                                                            //sqlPanel.SQLArea.setText(query+"\n\n"+q+"\n\n"+q6);
                                                            while(r1.next())
                                                            {
                                                                 idv=Integer.parseInt(r1.getString(1));
                                       
                                                             }                
                                                             
                                                             idtemp=idv.intValue();
                                                             idtemp=idtemp+1;
                                                             String qi="Insert into addr(id,streetnumber,streetaddress,city,state,country,zip) values("+idtemp+","+sno+",'"+saddr+"','"+city+"','CA','United States',"+zip+")";
                                                              String qii="Insert into adrr(id,streetno,streetaddress,city,state,country,zip) values("+idtemp+","+sno+",'"+saddr+"','"+city+"','CA','United States',"+zip+")";
                                                            sqlPanel.SQLArea.setText(query+"\n\n"+q6+"\n"+qi);
                                                             System.out.println(qi);
                                                             stt.executeUpdate(qi);
                                                             stt.executeUpdate(qii);
                                                             System.out.println("here i have reached");
                                                             
                                                   }
                
                                                    else
                                                      {
                                                        idv=t1;
                                                        idtemp=idv.intValue();
                                                      } 
                
                                    String f1="";
                                    String f2="";
                                    String f3="";
                                    
                                    f1=bday.substring(0,2);
                                    f2=bday.substring(2,4);
                                    int f22=Integer.parseInt(f2);
                                    
                                    f3=bday.substring(4,6);
                                    System.out.println(f1+f22);             
                                    
                                    switch(f22)
                                    {
                                        case 01:f2="JAN";
                                                  break;
                                            case 02:f2="FEB";
                                                  break;
                                                case 03:f2="MAR";
                                                  break;
                                                case 04:f2="APR";
                                                  break;
                                                case 05:f2="MAY";
                                                  break;
                                                      case 06:f2="JUN";
                                                  break;
                                                      case 07:f2="JUL";
                                                  break;
                                                  case 8:f2="AUG";
                                                  break;
                                                  case 9:f2="SEP";
                                                  break;
                                                  case 10:f2="OCT";
                                                  break;
                                                  case 11:f2="NOV";
                                                  break;
                                                      case 12:f2="DEC";
                                                  break;
                                                      
                                                      
                                                      
                                                      
                                                          
                                                      
                                                    
                                            
                                    }
                                    bday=f1+"-"+f2+"-"+f3;
                                    
                                    String q2="insert into member values('"+m+"','"+pass+"','"+fname+"','"+lname+"','"+bday+"',"+idtemp+")";
                                    System.out.println(q2);
                                    stt.executeUpdate(q2);
                                      JOptionPane.showMessageDialog(null,"SUCCEEDED IN CREATING A NEW USER");
                                                signUpPanel.email.setText(null);
                          signUpPanel.password.setText(null);
                          signUpPanel.password2.setText(null);
                          signUpPanel.fname.setText(null);
                          signUpPanel.lname.setText(null);
                          signUpPanel.city.setText(null);signUpPanel.zip.setText(null);
                          signUpPanel.birthday.setText(null);
                          signUpPanel.str_no.setText(null);
                          signUpPanel.str_address.setText(null);
       postandsearch.enablePanel();
		buttonPanel.enablePanel();                                         
                            
                       }
                         else if(flag == 1)
                          {
                          signUpPanel.email.setText(null);
                          signUpPanel.password.setText(null);
                          signUpPanel.password2.setText(null);
                          signUpPanel.fname.setText(null);
                          signUpPanel.lname.setText(null);
                          signUpPanel.city.setText(null);signUpPanel.zip.setText(null);
                          signUpPanel.birthday.setText(null);
                          signUpPanel.str_no.setText(null);
                          signUpPanel.str_address.setText(null);
                          JOptionPane.showMessageDialog(null,"FAILED : USER EMAIL ALREADY EXISTS !! SELECT A NEW ONE ");
                          }
                
                              
                              
                              
                }
                catch(SQLException ex1)
                {
                
                 JOptionPane.showMessageDialog(null,"FAILED : An Error has occurred");
                  ex1.printStackTrace();
                }
                
                
        }
                
                
                
                else
                {
                 signUpPanel.email.setText(null);
                 signUpPanel.password.setText(null);
                 signUpPanel.password2.setText(null);
                 signUpPanel.fname.setText(null);
                 signUpPanel.lname.setText(null);
                 signUpPanel.city.setText(null);signUpPanel.zip.setText(null);
                 signUpPanel.birthday.setText(null);
                 signUpPanel.str_no.setText(null);
                 signUpPanel.str_address.setText(null);
                 //JOptionPane.showMessageDialog(null,"One or more fields in error");                }
                
                }
                
                
            }
        });

		signUpPanel.enablePanel();

	}


}


class ConnectDB{

     public static Statement sttmt=null;
     public static Connection connection=null;
     
	public static Connection openConnection(){
       
            
               try {
 
			Class.forName("oracle.jdbc.OracleDriver");
                        System.out.println("Successful");
 
                        
		} 
                catch (ClassNotFoundException e) 
                                {
 
                        	e.printStackTrace();
				}
 
		System.out.println("Oracle JDBC Driver Registered!");
 
		
 
		try {
                       String firstone="jdbc:oracle:thin:@localhost:1521:xe";
                       String secondone="SYSTEM";
                       String thirdone="test";
			connection = DriverManager.getConnection(firstone,secondone,thirdone);
 
		} catch (SQLException ex) {
 
			System.out.println("Connection not established");
			ex.printStackTrace();
	
 
		}
 
		if (connection != null) {
			System.out.println("Database Connection established succesfully !!!!!");
		} else {
			System.out.println("Failed to make connection!");
		}
            
               
                
                /* TEST CODE for connection
                try
                {
                    sttmt=connection.createStatement();
                String insertquery="Insert into a values(3)";
                sttmt.executeUpdate(insertquery);
                }
                catch(Exception ex)
                {
                    
                }
                */
                
		/*Fill this function*/
    	/*implement open  connection */
		return connection;
	}
	public static void closeConnection(Connection conn)
	{
		/*Fill this function*/
    	/*implement close connection */
	}
}
public class Assignment2 {
	/**
	 * @param args
	 */
	public static void main(String[] args) 
        {
		// TODO Auto-generated method stub
           
    	
        MainFrame frame = new MainFrame();
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
