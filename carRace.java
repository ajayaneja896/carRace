import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class CarRace   implements KeyListener,ActionListener
{
	JFrame  f;
	JLabel  background;
	JLabel  one,two,three,car,score,result,speed;
	Timer t;
	int x,y=0; int position,carNo,count=0; 
	static int randomNum=0;
	int pos1=100,pos2=100,pos3=100,flag1=0,flag2=0,flag3=0;
	JButton start;

	int scoreValue=0;


	CarRace(){

		f = new JFrame("Car Race");
		f.setSize(600,700);
		f.setLayout(null);
		f.setBounds(250,3,600,700);

		background = new JLabel(new ImageIcon("road.jpg"));
		background.setBounds(0,0,600,700);
		f.add(background);


		car = new JLabel(new ImageIcon("red.png"));
		car.setBounds(120,500,120,70);
		background.add(car);
		position=1;

		

		one = new JLabel(new ImageIcon("pink.png"));
		one.setBounds(120,100,120,70);
		background.add(one);

		two = new JLabel(new ImageIcon("yellow.png"));
		two.setBounds(240,100,120,70);
		background.add(two);

		three = new JLabel(new ImageIcon("blue.png"));
		three.setBounds(360,100,120,70);
		background.add(three);

		one.setVisible(false);
		two.setVisible(false);
		three.setVisible(false);

		start = new JButton("Start");
		start.setBounds(240,600,100,25);
		background.add(start);

		start.addKeyListener(this);
		start.addActionListener(this);

		score= new JLabel("score " + scoreValue);
		score.setBounds(430,20,130,35);
		background.add(score);
		score.setFont(new Font("", Font.BOLD,25));
		score.setForeground(Color.WHITE);

		speed = new JLabel("speed");
		speed.setBounds(40,20,160,35);
		background.add(speed);
		speed.setFont(new Font("", Font.BOLD,25));
		speed.setForeground(Color.WHITE);


		result = new JLabel();
		result.setBounds(180,250,400,40);
		result.setVisible(false);
		result.setForeground(Color.WHITE);
		result.setFont(new Font(" ",Font.BOLD,40));
		background.add(result);

        
        x=120;
		t = new Timer(x,this);
		




		f.setVisible(true);
     


	}

	public static void main(String[] args) {
		new CarRace();
	}

	public static int randInt() {

    // NOTE: Usually this should be a field rather than a method
    // variable so that it is not re-seeded every call.
    Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
     randomNum = rand.nextInt(3)+1 ;                   // nextInt( max-min+1) + min
    if(randomNum==0)
         	randomNum=2;

    return randomNum;

    }

	public  void actionPerformed(ActionEvent e)
	{
            if(e.getSource()==start)
            {
            		t.start();
 			        
 			        result.setVisible(false);
 			        scoreValue=0;
 			        speed.setText("SPEED " + 40);  // this is starting speeed

 			       
 			        
 		    }
 		
 			if(count%10==0)
 			{
 				carNo=CarRace.randInt();

                if(carNo==1&&flag1==0)
                {
                 one.setVisible(true);
                 one.setBounds(120,100,120,70);
                 pos1=100;
                 flag1=1;
                }
            	if(carNo==2&&flag2==0)
            	{
            	 two.setVisible(true);
 				 two.setBounds(240,100,120,70);
 				 pos2=100;
 				 flag2=1;
 				} 

            	if(carNo==3&&flag3==0)
            	{
                  three.setVisible(true);	
                  three.setBounds(360,100,120,70);
                  pos3=100;
                  flag3=1;
                }


                
 			}

 			count++;
 			if(count>=1000)
 				count=0;

            if(one.isVisible()==true)
            {
 				one.setBounds(120,pos1,120,70);
 				pos1+=10;
 				if(pos1>520)
 			    {
 			    	flag1=0;
 			    	one.setVisible(false);

 			    }


 		    }

 		    if(two.isVisible()==true)
 		    {
 				two.setBounds(240,pos2,120,70);
 				pos2+=10;
 				if(pos2>520)
 			    {
 			    	flag2=0;
 			    	two.setVisible(false);
 			    }
 			}

 		    if(three.isVisible()==true)
 		    {
 				three.setBounds(360,pos3,120,70);
 				pos3+=10;
 				if(pos3>520)
 			    {
 			    	flag3=0;
 			    	three.setVisible(false);
 			    }

 			}

 			if(one.getY()+70==car.getY()&&car.getX()==120)
 			{
 				t.stop();
 				result.setText(" SCORE " + scoreValue);
 				result.setVisible(true);
 			}
 			else if(two.getY()+70==car.getY()&&car.getX()==240)
 			{
 				t.stop();
 				result.setText(" SCORE " + scoreValue);
 				result.setVisible(true);
 			}
 			else if(three.getY()+70==car.getY()&&car.getX()==360)
 			{
 				t.stop();
 				result.setText(" SCORE " + scoreValue);
 				result.setVisible(true);
 			}
 		    

 		    scoreValue += 1;
 		    score.setText("score "+ scoreValue);
            
            int m= 160-x;
            if(m<0)
            	m=0;
 		    speed.setText("SPEED " + m);



	}


	public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode()==KeyEvent.VK_UP)
        {
        	if(x>20)
        	{
        		x -=5 ;

        		//y+=5;
        	}
        }
        else if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
        	 x += 10;

        	// if(y>0)
        	 	//y--;
        }
        else if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            if(position==2)
            {
            	position =1;

            	car.setBounds(120,500,120,70);
            }
            if(position==3)
            {
            	position=2;
            	car.setBounds(240,500,120,70);
            }   
        }      
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            if(position==2)
            {
            	position =3;
            	car.setBounds(360,500,120,70);
            }
            if(position==1)
            {
            	position =2;

            	car.setBounds(240,500,120,70);
            }

              
        }
    }
    public void keyReleased(KeyEvent e)
    {

    }
    public void keyTyped(KeyEvent e)
    {
        
    }

    
}
