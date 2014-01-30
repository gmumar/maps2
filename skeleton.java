import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class skeleton extends JFrame {

	public skeleton(){
		initUI();
	}
	 
	private void initUI() {

        setTitle("Map");

        add(new Surface());

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}

class Surface extends JPanel {
	
	public void doDrawing(Graphics g){
		 
		 Graphics2D g2 =(Graphics2D)g;
		 //Point2D.Double point = new Point2D.Double(5,5);
		 
		 g2.setColor(Color.yellow);
		 g2.setStroke(new BasicStroke(4,BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
		 g2.drawLine(5, 5, 50, 50);
		 g2.drawLine(50, 50, 70,90);
		 g2.drawLine(70, 90, 100, 10);
		 
	 }
	
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
	
}

