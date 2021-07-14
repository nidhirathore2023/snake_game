import javax.swing.JFrame;
import java.awt.*;
public class snake extends JFrame{
	
	snake()
	{
		board b=new board();
		add(b);
		setVisible(true);
		setSize(300,320);
		setLocation(500,150);
		setTitle("Snake Game");
		setBackground(Color.BLACK);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	





	
}
