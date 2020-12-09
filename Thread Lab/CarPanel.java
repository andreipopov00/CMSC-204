import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
*/
public class CarPanel extends JComponent
{  
	private Car car1;
	private int x,y, delay;
	private CarQueue carQueue;
	private int direction;
	
	CarPanel(int x1, int y1, int d, CarQueue queue)
	{
		delay = d;
        x=x1;
        y=y1;
        car1 = new Car(x, y, this);
        carQueue = queue;
	}
	public void startAnimation()
	   {
	      class AnimationRunnable implements Runnable
	      {
	         public void run()
	         {
	            try
	            {
	               for(int i=0;i<10;i++)
	               {
	            	   direction = carQueue.deleteQueue();
	            	   
	            	   /*
	            	    * Move according to direction and check for boundaries.
	            	    * The frame is 300 x 400
	            	    */
	            	   switch(direction) {
	            	   case 0: //Up
	            		   y = (y - 10 <= 0 ? y + 10 : y - 10);
	            		   break;
	            	   case 1: //Down
	            		   y = (y + 10 >= 400 ? y - 10 : y + 10);
	            		   break;
	            	   case 2: //Right
	            		   x = (x + 10 >= 300 ? x - 10 : x + 10);
	            		   break;
	            	   case 3: //Left
	            		   x = (x - 10 <= 0 ? x + 10 : x - 10);
	            		   break;
	            	   }
	            	   
	            	   repaint();
	            	   Thread.sleep(delay*1000);
	               }
	            }
	            catch (InterruptedException exception)
	            {
	            	exception.printStackTrace();
	            }
	            finally
	            {
	            	
	            }
	         }
	      }
	      
	      Runnable r = new AnimationRunnable();
	      Thread t = new Thread(r);
	      t.start();
	   }
	
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;

      car1.draw(g2,x,y);    
   }
}