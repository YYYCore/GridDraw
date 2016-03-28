import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Frame1 extends JPanel{
	

	
	private static final int DRAWING_SIZE = 600;
	private static final int SUBDIVISIONS = 10;
	private static final int SUBDIVISION_SIZE = DRAWING_SIZE / SUBDIVISIONS;
	
	private static int x1 = 0;
	private static int x2 = 0;
	private static int y1 = 0;
	private static int y2 = 0;
	
	private static int[][] points = new int [2][100];


	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}						
		});
	}
	

	

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1272, 864);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel(){
			 @Override public void paintComponent(Graphics g) {
		            super.paintComponent(g);
		            Graphics2D g2 = (Graphics2D) g;
		            g2.setPaint(Color.GRAY);
		            for (int i = 1; i < SUBDIVISIONS; i++) {
		               int x = i * SUBDIVISION_SIZE;
		               g2.drawLine(x, 0, x, getSize().height);
		            }
		            for (int i = 1; i < SUBDIVISIONS; i++) {
		               int y = i * SUBDIVISION_SIZE;
		               g2.drawLine(0, y, getSize().width, y);
		            }	
		            
		            for (int i = 1; i < SUBDIVISIONS; i++) {	            	
		            	for (int j = 1; j < SUBDIVISIONS; j++){   
		            		int x = i * SUBDIVISION_SIZE;
		            		int y = j * SUBDIVISION_SIZE;
		            		points[0][j-1] = x;
		            		points[1][j-1] = y;
		            		g2.setPaint(Color.BLACK);
		            		g2.drawOval(x-5, y-5, 10, 10);
		            		g2.fillOval(x-5, y-5, 10, 10);
		            	}
		            }
		            
			 }
		};
		panel.setBounds(10, 11, 600, 600);
		frame.getContentPane().add(panel);
		
		MouseListener l = null;
		panel.addMouseListener(l);
;
		
		
		panel.addMouseListener(new MouseAdapter() { 
	        public void mousePressed(MouseEvent me) { 
	          System.out.println(me); 
	        } 
	      });
		
		
		
		JPanel panel_1 = new JPanel() {
			 @Override public void paintComponent(Graphics g) {
		            super.paintComponent(g);
		            Graphics2D g2 = (Graphics2D) g;
		            g2.setPaint(Color.GRAY);
		            for (int i = 1; i < SUBDIVISIONS; i++) {
		               int x = i * SUBDIVISION_SIZE;
		               g2.drawLine(x, 0, x, getSize().height);
		            }
		            for (int i = 1; i < SUBDIVISIONS; i++) {
		               int y = i * SUBDIVISION_SIZE;
		               g2.drawLine(0, y, getSize().width, y);
		            }	
		            
		            for (int i = 1; i < SUBDIVISIONS; i++) {	            	
		            	for (int j = 1; j < SUBDIVISIONS; j++){   
		            		int x = i * SUBDIVISION_SIZE;
		            		int y = j * SUBDIVISION_SIZE;
		            		g2.setPaint(Color.BLACK);
		            		g2.drawOval(x-5, y-5, 10, 10);
		            		g2.fillOval(x-5, y-5, 10, 10);
		            	}
		            }
		            
		            g2.drawOval(x1, y1, 20, 20);
		            
		            			 }
		};
		panel_1.setBounds(633, 11, 600, 600);
		frame.getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(643, 622, 238, 43);
		frame.getContentPane().add(btnNewButton);
	}
	
	
	
	
	public void mouseClicked(MouseEvent evt) {
		int x = evt.getX();
		int y = evt.getY();
		
		
        for (int i = 1; i < points.length; i++) {
        	int pointX = points[0][i];
        	if ((x < pointX + 15) && (x > pointX - 15 )){
        		
        		
        		if (x1 == 0 && y1 == 0) {
        			x1 = x;
        			y1 = y;
        			repaint();
        			System.out.println("repaint: " + x1 + " " + y1);
        		} else {
        			x2 = x;
        			y2 = y;
        			
        		
        			
        			
        			
        			
        		}  	       		
        	}
        }	
	}
	
	
}
