import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JRadioButton;
import javax.swing.JLabel;



public class Frame1 extends JPanel{
	
	
	
    private MouseHandler mouseHandler = new MouseHandler();
    private Point p1 = new Point(100, 100);
    private Point p2 = new Point(540, 380);
    private boolean drawing;

    
	
	public int p1x = 0;
	public int p1y = 0;
	public int p2x = 0;
	public int p2y = 0;

	
	private static final int DRAWING_SIZE = 600;
	private static final int SUBDIVISIONS = 10;
	private static final int SUBDIVISION_SIZE = DRAWING_SIZE / SUBDIVISIONS;
	
	private static int x1 = 0;
	private static int x2 = 0;
	private static int y1 = 0;
	private static int y2 = 0;
	
	private static int[][] points = new int [2][100];

	
	
	

	private JFrame frame;
	
	
	private int[][] lines = new int [5][20];
	public int linecounter = 0;
	
	
	
	
	
	public Frame1() {
		this.addMouseListener(mouseHandler);
		this.addMouseMotionListener(mouseHandler);
		initialize();
	}
	

	
	private class MouseHandler extends MouseAdapter {

		public boolean drawing = true;
		
		
		
		
        @Override
        public void mousePressed(MouseEvent e) {
            drawing = true;
         
         
            Point p1 = e.getPoint();
            int x = e.getX();
            int y = e.getY();
            
            
            
            for (int i = 1; i < points.length; i++) {
            	int pointX = points[0][i];
            	if ((x < pointX + 15) && (x > pointX - 15 )){
            		if (((y < points[1][i] + 15) && (y > points[1][i] - 15))){
            			p1.setLocation(points[0][i], points[1][i]);
            		}   	
            	}
            }
            
            
            p2 = p1;
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            drawing = false;
            
            int x = e.getX();
            int y = e.getY();
            
            for (int i = 1; i < points.length; i++) {
            	int pointX = points[0][i];
            	if ((x < pointX + 15) && (x > pointX - 15 )){
            		if (((y < points[1][i] + 15) && (y > points[1][i] - 15))){
            			p2.setLocation(points[0][i], points[1][i]);
            		}   	
            	}
            }
            
            
            
            
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (drawing) {
                p2 = e.getPoint();
                repaint();
            }
        }
    }
	
	
	
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
	



	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1272, 864);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		int zahler = 0;
		
		for (int i = 1; i < 10; i++){
			for (int j = 1; j < 10; j++){
				
				points[0][zahler] = 60*j;		
				points[1][zahler] = 60*i;	
				
				zahler++;		
			}	
		}
		
		
		JRadioButton rdbtnGreen = new JRadioButton("Green");
		rdbtnGreen.setBounds(6, 632, 109, 23);
		frame.getContentPane().add(rdbtnGreen);
		
		JRadioButton rdbtnRed = new JRadioButton("Red");
		rdbtnRed.setBounds(131, 632, 109, 23);
		frame.getContentPane().add(rdbtnRed);
		
		JRadioButton rdbtnBlue = new JRadioButton("Blue");
		rdbtnBlue.setBounds(263, 632, 109, 23);
		frame.getContentPane().add(rdbtnBlue);
		
		JRadioButton rdbtnOrange = new JRadioButton("Orange");
		rdbtnOrange.setBounds(398, 632, 109, 23);
		frame.getContentPane().add(rdbtnOrange);
		
		JRadioButton rdbtnPink = new JRadioButton("Pink");
		rdbtnPink.setBounds(6, 671, 109, 23);
		frame.getContentPane().add(rdbtnPink);
		
		JRadioButton rdbtnCyan = new JRadioButton("Cyan");
		rdbtnCyan.setBounds(131, 671, 109, 23);
		frame.getContentPane().add(rdbtnCyan);
		
		JRadioButton rdbtnBlack = new JRadioButton("Black");
		rdbtnBlack.setBounds(263, 671, 109, 23);
		frame.getContentPane().add(rdbtnBlack);
		
		JRadioButton rdbtnMagenta = new JRadioButton("Magenta");
		rdbtnMagenta.setBounds(398, 671, 109, 23);
		frame.getContentPane().add(rdbtnMagenta);
		
		
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

		            		g2.setPaint(Color.BLACK);
		            		g2.drawOval(x-5, y-5, 10, 10);
		            		g2.fillOval(x-5, y-5, 10, 10);
		            		
		            		g2.setStroke(new BasicStroke(4));
		            		
		            		for (int p = 0; p < lines.length; p++){    			
		            		}
		            		
		            		
		            		for (int q = 0; q < 20; q++){
		            			if (lines[0][q] != 0) {
		            				
		            				if (lines[4][q] == 1) {
		            					g2.setColor(Color.GREEN);
		            				} else if (lines[4][q] == 2){
		            					g2.setColor(Color.RED);
		            				} else if (lines[4][q] == 3){
		            					g2.setColor(Color.BLUE);
		            				} else if (lines[4][q] == 4){
		            					g2.setColor(Color.ORANGE);
		            				} else if (lines[4][q] == 5){
		            					g2.setColor(Color.PINK);
		            				} else if (lines[4][q] == 6){
		            					g2.setColor(Color.CYAN);
		            				} else if (lines[4][q] == 7){
		            					g2.setColor(Color.BLACK);
		            				} else if (lines[4][q] == 8){
		            					g2.setColor(Color.MAGENTA);
		            				}
		            				
		            				

		            				g2.drawLine(lines[0][q], lines[1][q], lines[2][q], lines[3][q]);
		            				this.revalidate();
		            			}	       	
		            		}
		            		
		            	}
		            }
		            
		           frame.setVisible(true);
		           frame.validate();
		            
			 }
		};
		panel.setBounds(10, 11, 600, 600);
		frame.getContentPane().add(panel);
		
		MouseListener l = null;
		panel.addMouseListener(l);
;
		
		
		panel.addMouseListener(new MouseAdapter() { 
	        public void mousePressed(MouseEvent e) { 
	          System.out.println(e); 
	          System.out.println("drawing?: " + drawing);
	          
	          int x = 0;
	          int y = 0;
	          
	          x = e.getX();
	          y = e.getY();
	          
	          if (!drawing){
	        	  
	              for (int i = 0; i < 100; i++) {
	              	int pointX = points[0][i];
	              	int pointY = points[1][i];
	              	if ((x < pointX + 15) && (x > pointX - 15 )){
	              		System.out.println("test");
	              		if (((y < pointY + 15) && (y > pointY - 15))){
	              			p1x = pointX;
	              			p1y = pointY;
	              			drawing = true;            			
	              			System.out.println("Point 1: " + p1x + " / " + p1y);
	              			
	              			break;
	              			
	              		}   	
	              	}             	
	           		              	
	              }   	  
	          } else {
	        	  
	              for (int i = 1; i < 100; i++) {
		              	int pointX = points[0][i];
		              	int pointY = points[1][i];
		              	if ((x < pointX + 15) && (x > pointX - 15 )){
		              		if (((y < pointY + 15) && (y > pointY - 15))){
		              			p2x = pointX;
		              			p2y = pointY;
		              			drawing = false;
		              			
		              			System.out.println("Point 2: " + p2x + " / " + p2y);
		              			
	       			
	              				lines[0][linecounter] = p1x;
	              				lines[1][linecounter] = p1y;
	              				lines[2][linecounter] = p2x;
	              				lines[3][linecounter] = p2y;
	              				
	              				
	              				if (rdbtnGreen.isSelected()){
	              					lines[4][linecounter] = 1;
	              				} else if (rdbtnRed.isSelected()){
	              					lines[4][linecounter] = 2;
	              				} else if (rdbtnBlue.isSelected()){
	              					lines[4][linecounter] = 3;
	              				} else if (rdbtnOrange.isSelected()){
	              					lines[4][linecounter] = 4;
	              				} else if (rdbtnPink.isSelected()){
	              					lines[4][linecounter] = 5;
	              				} else if (rdbtnCyan.isSelected()){
	              					lines[4][linecounter] = 6;
	              				} else if (rdbtnBlack.isSelected()){
	              					lines[4][linecounter] = 7;
	              				} else if (rdbtnMagenta.isSelected()){
	              					lines[4][linecounter] = 8;
	              				}
	              				
	              				
	              				
	              				
	              				
		              			
		              			linecounter++;
		              			
		              			System.out.println(linecounter);
		              			
		              			setVisible(true);
		              			validate();

		              			panel.validate();
		              			panel.setVisible(false);
		              			panel.setVisible(true);
		              			
		              			
		              			
		              		}   	
		              	}

		          }   	 
	        	  
	        	  repaint();
	        	  
	          }
	          
	          
	          
	          
	          
	          
	          
	          
	          
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
		
		JButton btnNewButton = new JButton("Check!");
		btnNewButton.setBounds(643, 622, 238, 43);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnGreen);
		group.add(rdbtnRed);
		group.add(rdbtnBlue);
		group.add(rdbtnOrange);
		
		group.add(rdbtnPink);
		group.add(rdbtnCyan);
		group.add(rdbtnBlack);
		group.add(rdbtnMagenta);
		
		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setBounds(10, 731, 68, 23);
		frame.getContentPane().add(lblDifficulty);
		
		JRadioButton rdbtnEasy = new JRadioButton("Easy");
		rdbtnEasy.setBounds(84, 731, 76, 23);
		frame.getContentPane().add(rdbtnEasy);
		
		JRadioButton rdbtnMedium = new JRadioButton("Medium");
		rdbtnMedium.setBounds(162, 731, 85, 23);
		frame.getContentPane().add(rdbtnMedium);
		
		JRadioButton rdbtnHard = new JRadioButton("Hard");
		rdbtnHard.setBounds(258, 731, 68, 23);
		frame.getContentPane().add(rdbtnHard);
		
		
		ButtonGroup groupdif = new ButtonGroup();
		groupdif.add(rdbtnEasy);
		groupdif.add(rdbtnHard);
		groupdif.add(rdbtnMedium);

	}
	
	
	
	
	public void mouseClicked(MouseEvent evt) {
		
		System.out.print("clicked!!!");
		
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
