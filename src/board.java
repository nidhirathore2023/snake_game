import java.awt.event.KeyAdapter;              
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
public class board extends JPanel implements ActionListener
{
	private int d;
	private Image apple;
	private Image dot;
	private Image head;
	private int dots ;
	private int All_Dots=900;
	private int RANDOM_POSITION=20;
	private final int  DOT_SIZE=10;    //300*300=90000/10= 900 dots
	private final int x[]=new int[All_Dots];
	private final int y[]=new int[All_Dots];
	private int  apple_x;
	private  int apple_y;
	private Timer timer;
	private boolean right=true;
	private boolean left=false;
	private boolean up=false;
	private boolean down=false;
	private boolean ingame=true;
	board ()
	
	{
		
    addKeyListener(new TAdapter());
    setLayout(null);
   
	setBackground(Color.BLACK);

	setFocusable(true);
	loadimage();
	init();
	}
  
	


	public void loadimage()
	{
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("apple.png"));
		apple=i1.getImage();
		
		ImageIcon i2=new ImageIcon(ClassLoader.getSystemResource("dot.png"));
		dot=i2.getImage();
		
		ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("head.png"));
		head=i3.getImage();
	}
	public void init()
	{
		dots=3;
		for(int i=0;i<dots;i++)
		{
			x[i]=50-i*DOT_SIZE;
			y[i]=50;
		}
		locateapple();
		timer =new Timer(140,this);
		timer.start();
	}
	public void locateapple()
	{
		
		int r=(int )(Math.random()*RANDOM_POSITION);
		apple_x=(r*DOT_SIZE);
		
		int g=(int )(Math.random()*RANDOM_POSITION);
		
		apple_y=(g*DOT_SIZE);
	}
	public void checkapple()
	{
		if(x[0]==apple_x && y[0]==apple_y)
		{
			dots++;
			 d=dots*10;
			
			locateapple();
			
		}
	}
	
	
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		draw(g);
	}
	public void draw(Graphics g)
	{
		if (ingame)
		{
		g.drawImage(apple,apple_x,apple_y,this);
		for(int i=0;i<dots;i++)
		{
			if(i==0)
			{
				g.drawImage(head, x[i], y[i],this);
			}
			else
			{
				g.drawImage(dot, x[i],y[i],this);
			}
		}
		Toolkit.getDefaultToolkit().sync();
		}
		else
		{
			gameover(g);
		}
	}
	public void gameover(Graphics g)
	{
		String s="GAME OVER";
		Font font =new Font("SAMS_SERIF",Font.BOLD,14);
		FontMetrics j= getFontMetrics(font);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString(s,95,120);
		
	}
	public void checkcollision()
	{
		for(int i=dots;i>0;i--)
		{
			if(i>4 && x[0]==x[i] && y[0]==y[i])
			{
				ingame=false;
			}
		}
		if(y[0]>=300)
		{
			ingame=false;
		}
		if(x[0]>=300)
		{
			ingame=false;
		}
		if(y[0]<0)
		{
			ingame=false;
		}
		if(x[0]<0)
		{
			ingame=false;
		}
		if(!ingame)
		{
			timer.stop();
		}
	}
	
public void move()
{
	for(int i=dots ;i>0;i--)
	{
		x[i]=x[i-1];
		y[i]=y[i-1];
	}
	if(left)
	{
		x[0]=x[0]-DOT_SIZE;
	}
	if(right)
	{
		x[0]=x[0]+DOT_SIZE;
	}
	if(up)
	{
		y[0]=y[0]-DOT_SIZE;
	}
	if(down)
	{
		y[0]=y[0]+DOT_SIZE;
	}
}

	
	public void actionPerformed(ActionEvent e) {
		if(ingame)
		{
			checkapple();
			checkcollision();
			move();
		}
		repaint();
		
	}
	
	private class TAdapter extends KeyAdapter 
	{ 
		@Override
		 public void keyPressed(KeyEvent e)   
		{
			
			int key =e.getKeyCode();
			if(key==KeyEvent.VK_LEFT && (!right))
			{
				left=true;
				up=false;
				down=false;
			}
			if(key==KeyEvent.VK_RIGHT && (!left ))
			{
				
				up=false;
				right=true;
				down=false;
			}
			if(key==KeyEvent.VK_UP && (!down))
			{
				left=false;
				up=true;
				right=false;
				
			}
			if(key==KeyEvent.VK_DOWN && (!up))
			{
				left=false;
				right=false;
				down=true;
			}
		}
	}
}
