/*
 * Spatial Database ACCESS POINT Tracker 
 * 
 */

//Package Name
package my.spatialDBUI;

//Set of imported AWT packages
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

//Set of imported SQL packages
import java.sql.*;
import java.util.EventListener;

//Set of imported Swing packages
import javax.swing.*;
import javax.swing.SwingUtilities;
import java.io.File;
import javax.imageio.*;
import javax.swing.event.MouseInputListener;

/**
 * @author Vasu Jain vasujain@usc.edu
 */
public class hw2UI extends javax.swing.JFrame {

    /**
     * Creates new form hw2UI
     */
    Graphics g;
    Connection connection;
    public hw2UI() {
        initComponents();
        g=panel1.getGraphics();
        connectDBUI();
        jLabel5.setText("Spatial location tracker & Mapper - Vasu Jain ");
    }

    /**
     * This method is called from within the constructor to initialize the form.    
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	//This fucntion initializes all the Swing class objects used in the Interface
    private void initComponents() {
		//Initialization of all the Swing class objects used in the Interface
        buttonGroup1 = new javax.swing.ButtonGroup();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        panel1 = new java.awt.Panel();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        textArea1 = new java.awt.TextArea();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
		
		//Setting default properties for appearance of Swing components and Layout of the application
		
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1030, 720));
        setResizable(false);

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setLabel("Building");

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox2.setLabel("Access Point");

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox3.setLabel("People");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Active Feature Type");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Types of Query");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Submit Query");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(204, 204, 204));
        panel1.setName("");
        panel1.setPreferredSize(new java.awt.Dimension(820, 580));
        panel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panel1MouseMoved(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/hw2/map.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel3.setMaximumSize(new java.awt.Dimension(820, 580));
        jLabel3.setMinimumSize(new java.awt.Dimension(820, 580));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
		
		//Merging  Radio button objects into a Radio Group
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButton1.setLabel("Whole Region");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButton2.setLabel("Range Query");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButton3.setLabel("Point Query");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButton4.setLabel("Find AP Covered People");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setActionCommand("Clear Query");
        jButton2.setLabel("Clear Query");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Current Operation");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButton3)
                                        .addComponent(jRadioButton2)
                                        .addComponent(jRadioButton1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(11, 11, 11))
                                            .addComponent(jCheckBox1)
                                            .addComponent(jCheckBox2)
                                            .addComponent(jCheckBox3)))
                                    .addGap(26, 26, 26))
                                .addComponent(jRadioButton4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jButton2.getAccessibleContext().setAccessibleName("Query");

        pack();
    }// </editor-fold>//GEN-END:initComponents
	
	//This function used for testing by tracking and displaying the current mouse pointer
    private void panel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseMoved
        // TODO add your handling code here:
        int x= evt.getX();
        int y= evt.getY();        
        //textField1.setText(x+","+y);
    }//GEN-LAST:event_panel1MouseMoved
    
	//Function which triggers every functionality of the application by invoking an appropiate function corrosponding to user selection	
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:       
            //This is to display all the features of the active feature types in the whole map
			if(jRadioButton1.isSelected())
                wholeRegionQuery();
            //When this radio button is checked, the user can draw a polygon in the map. After pushing the Submit Query button, only the features of the active feature types that are inside (or intersect with) the polygons are displayed.
			else if(jRadioButton2.isSelected())
                rangeQuery();
            //Point Query. When this radio button is checked, the user can select a point in the map. After pushing the Submit Query button, only the active features inside (or intersect with) of the circle will be displayed. 
			else if(jRadioButton3.isSelected())
                pointQuery();
            //Find wireless internet-covered people by an access point. After pushing the Submit Query button, multiple yellow lines between AP and the people who are covered (within radius) by this access point will be displayed.
			else if(jRadioButton4.isSelected())
                findAPQuery();
    }//GEN-LAST:event_jButton1ActionPerformed

    //Function to reset all the global variables used in the program and bring them to intial states of these variables
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);        
        buttonGroup1.clearSelection();

        index=0;
        numPoints=0;
        String coodString="";
        jLabel3.repaint();      
        queryFlag=0;
        textArea1.setText("");
        queryCounter=0;
        clickCount=1;
    }//GEN-LAST:event_jButton2ActionPerformed
    
    //Function for handling Action event on Radio Button4. Used for testing. 
	private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    //Function for handling Action event on Radio Button3. Used for testing. 
	private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    //Function for handling Mouse Click event Tracking and then triggering appropiate code block/function  
	private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
		//Handling Event for "Find Access Point covered People" Radio button
        if(jRadioButton4.isSelected())
        {
            //Tracking Left mouse button click
			if (SwingUtilities.isLeftMouseButton(evt)) {
                int tempX4,tempY4;
                //Assigning current mouse coordinates caught using evt Getter metods to variables 
				tempX4=evt.getX();
                tempY4=evt.getY();
                //findAPQuery(tempX4,tempY4);
                tempXX4=tempX4;
                tempYY4=tempY4;
                
                 //To make sure the display for this query appears only when no other query results are present in display
				 if(clickCount==1)
                {
                    wholeRegionQuery();
                    clickCount++;
                }           
        
                //Query on Spatial DB to find Access Points location
				String APQ="SELECT A.ACCESSID AS APTID,A.APT_LOCATION.SDO_POINT.X AS APT4X,A.APT_LOCATION.SDO_POINT.Y AS APT4Y,A.RADIUS AS APT4R FROM APT1 A WHERE SDO_NN(A.APT_LOCATION,SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE("+tempX4+","+tempY4+",NULL),NULL,NULL),'SDO_NUM_RES=1')='TRUE'";
                ResultSet rsAPQ;
                //To display current query and increment the query counter on Application GUI. 
				queryCounter(APQ);
                try
                {
                    //Creating a connection statement and executing above query to fetch the resultset for above query
					int stAPQRSy=0,stAPQRSx=0,stAPQRSr=0;
                    Statement stAPQ=populate.connection.createStatement();
                    rsAPQ=stAPQ.executeQuery(APQ);
                    //While there is a result row available in result set 
                    while(rsAPQ.next())
                    {
                        //Assignment of result set variables to temporary variables
						String stAPQRSxx=(rsAPQ.getString("APT4X"));
                        stAPQRSx=Integer.parseInt(stAPQRSxx);
                        String stAPQRSyy=(rsAPQ.getString("APT4Y"));
                        stAPQRSy=Integer.parseInt(stAPQRSyy);
                        String stAPQRSrr=(rsAPQ.getString("APT4R"));
                        stAPQRSr=Integer.parseInt(stAPQRSrr);
                        //Displaying Graphical shapes on the GUI using te parameters from the query resultset
                        g.setColor(Color.BLUE);
                        g.drawRect(stAPQRSx-7, stAPQRSy-7, 15, 15);
                        g.fillRect(stAPQRSx-7, stAPQRSy-7, 15, 15);
                        drawCircle(stAPQRSx,stAPQRSy,stAPQRSr);                
                        System.out.println("coodStringAPQ: " +stAPQRSx+" "+stAPQRSy+" "+stAPQRSr);
                    }
                    rsAPQ.close();
                }
                //Catching any exception in above code and displaying it on console
				catch (Exception e)
                {
                    System.out.println("Error is: " +e);
                }
                
            }
        }
        //Handling Event for "Point Query" Radio button
		if(jRadioButton3.isSelected())
        {
            if (SwingUtilities.isLeftMouseButton(evt)) {
                //tempX3PtQ,tempY3PtQ;
                tempX3PtQ=evt.getX();
                tempY3PtQ=evt.getY();
                //Displaying Graphical shapes on the GUI using te parameters from the query resultset
				g.setColor(Color.ORANGE);
                g.drawRect(tempX3PtQ-2, tempY3PtQ-2, 5, 5);
                g.fillRect(tempX3PtQ-2, tempY3PtQ-2, 5, 5);drawCircle((tempX3PtQ),(tempY3PtQ),70);
                //int xPQ=tempX3PtQ,yPQ=tempY3PtQ;
                //Setting the pointQueryFlag as 1 and now on Submit button click, pointQuery function can execute
				pointQueryFlag=1;
                //pointQuery(tempX3,tempY3);
            }
        }
        //Handling Event for "Range Query" Radio button
        if(jRadioButton2.isSelected())
        {    
            int tempX,tempY;
            tempX=evt.getX();
            tempY=evt.getY();
			//Tracking left mouse button click to draw points of polygon	
            if (SwingUtilities.isLeftMouseButton(evt)) {
                            g.setColor(Color.red);
                            ptsX[index] = tempX;
                            ptsY[index] = tempY;

                            g.fillRect(ptsX[index], ptsY[index], 7, 7);
                            g.drawRect(ptsX[index], ptsY[index], 7, 7);                                
                            //System.out.println("currentX "+tempX+" currentY "+tempY+" index "+index);
                            //if more than one point draw line between current point and previous point
							if (index >= 1) {                    
                            g.setColor(Color.red);
                            g.drawLine(ptsX[index - 1],ptsY[index - 1], ptsX[index],ptsY[index]);
                            }
                            //if last point draw line between first point and current point
							else {
                            g.setColor(Color.red);
                            g.drawLine(ptsX[0], ptsY[0],ptsX[index], ptsY[index]);
                            }                      
                            index++;
                            numPoints++;
                    }
            //If right click then draw this as last point and color it as blue
			else if (SwingUtilities.isRightMouseButton(evt)) {
                    ptsX[index] = tempX;
                    ptsY[index] = tempY;
                    g.setColor(Color.blue);
                    g.fillRect(ptsX[index], ptsY[index], 7, 7);
                    g.drawRect(ptsX[index], ptsY[index], 7, 7);
                    g.setColor(Color.red);
                    g.drawLine(ptsX[index - 1], ptsY[index - 1],ptsX[index], ptsY[index]);
                    g.setColor(Color.red);
                    g.drawLine(ptsX[index], ptsY[index],ptsX[0], ptsY[0]);
                    numPoints++;                

                //Create a string off all x,y coordiantes to send to Spatial query operator
				for(int i=0;i<numPoints;i++)
                {
                    coodString+= ptsX[i]+","+ptsY[i]+",";
                }
                coodString+= ptsX[0]+","+ptsY[0];            
                System.out.println("numPoints++; "+numPoints+"coodString "+coodString);
                    //rangeQuery();
            }
         }                  
    }//GEN-LAST:event_jLabel3MouseClicked
    //This function draws and fills a rectangle around a point of 10 pixel
	public void drawGraphics(int x, int y)
    {
    g.setColor(Color.GREEN);
    g.drawRect(x-5, y-5, 10, 10);
    g.fillRect(x-5, y-5, 10, 10);
    }
    //This function draws and fills a rectangle around a point of 15 pixel
	public void drawApt(int x, int y, int r)
    {
    g.setColor(Color.RED);
    g.drawRect(x-7, y-7, 15, 15);
    g.fillRect(x-7, y-7, 15, 15);
    drawCircle(x,y,r);
    }
	//This function draws and fills a rectangle around a point of 15 pixel and draws a circle around that point of radius r
    public void drawApt2(int x, int y, int r)
    {
    g.setColor(Color.YELLOW);
    g.drawRect(x-7, y-7, 15, 15);
    g.fillRect(x-7, y-7, 15, 15);
    drawCircle(x,y,r);
    }
    //This function draws a circle around a point of radius r
	private void drawCircle(int x, int y, int radius)
    {
    g.drawOval(x - radius, y - radius, radius*2, radius*2);
    }
    //This function displays query on the GUI
	public void queryCounter(String s)
    {
        queryCounter++;
        textArea1.append("Query "+queryCounter+":  "+s+"\n");
    }
    //This function is used to connect Database using JDBC Drivers
	public void connectDBUI()
    {
    System.out.println("Checking for Drivers");    
    try
    {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        //Connection string with Username/password to connect to the database
		connection=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","SYSTEM","orcl");
        System.out.println("Connected");
    }
    //Throwing any exception on the front end if required
	catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Could not Connect. Error is "+ex);
        }
    }    
    /**
     * @param args the command line arguments
     */
    //
	//This function displays only the active features that are inside (or intersect with) of the circle will be displayed.
	public void pointQuery()
    {
    int xPQ=tempX3PtQ,yPQ=tempY3PtQ;
    System.out.println("tempX3PtQ,yPQ=tempY3PtQ "+tempX3PtQ+" "+tempY3PtQ);
    if(xPQ>0 && yPQ>0)
    {
    //pointQuery(tempX3,tempY3);;//pointQuery();
	//Preparing 3 points for circle query
    String circleString=xPQ+","+(yPQ-70)+","+(xPQ+70)+","+yPQ+","+xPQ+","+(yPQ+70);        
                if(jCheckBox1.isSelected())
                {
                    int poly[]=new int[1000];
                    int polypts[]=new int[100];
                    int ictr=0,jctr=0;
					//Query to result all coordinates of the building intersecting with the circle
                    String querypq="select t.column_value as polypt from building1 b,TABLE(b.points.sdo_ordinates) t where sdo_anyinteract (b.points,sdo_geometry(2003,NULL,NULL,sdo_elem_info_array(1,1003,4),sdo_ordinate_array("+circleString+")))='TRUE'";
					//Query to result number of buildings and corrosponding number of points in each building intersecting with the circle
                    String querypq2="select b.numpoint as polynum from building1 b where sdo_anyinteract (b.points,sdo_geometry(2003,NULL,NULL,sdo_elem_info_array(1,1003,4),sdo_ordinate_array("+circleString+")))='TRUE'";

                    queryCounter(querypq);
                    queryCounter(querypq2);
                    ResultSet rspq,rspq2;
                    try
                    {
                    Statement stPQB=populate.connection.createStatement();
                    rspq=stPQB.executeQuery(querypq);                    

                    Statement stPQB2=populate.connection.createStatement();
                    rspq2=stPQB2.executeQuery(querypq2);                    
					
                    while(rspq.next())
                            {
                                poly[ictr]=Integer.parseInt(rspq.getString("polypt"));
                                ictr++;
                            }			
                    while(rspq2.next())
                            {
                                polypts[jctr]=Integer.parseInt(rspq2.getString("polynum"));
                                jctr++;
                            }
                    //draw building coinciding with the circle using polygon coordinates and number of points
					int c=0;
                        for(int k=0;k<ictr;k++)
                        {				
                            for(int l=0;l<polypts[k];l++)
                            {
                                    g.setColor(Color.YELLOW);
                                    g.drawLine(poly[c],poly[c+1],poly[c+2],poly[c+3]);
                                    c=c+2;
                            }
                            c=c+2;
                        }		
                    }
                    catch(Exception e)
                    {
                            System.out.println("Exception is: "+e);
                    }
                }
                if(jCheckBox2.isSelected()) //Display All Access Point
                {    
				//Query to result all access points of the building intersecting with the circle
                String queryPQA="select a.accessid,a.APT_LOCATION.SDO_POINT.X as aptX,a.APT_LOCATION.SDO_POINT.Y as aptY,a.RADIUS as aptR from apt1 a where sdo_anyinteract(a.apt_location,sdo_geometry(2003,NULL,NULL,sdo_elem_info_array(1,1003,4),sdo_ordinate_array("+circleString+")))='TRUE'";
                queryCounter(queryPQA);
                ResultSet rsPQA;                
				//Query to result nearest access point within the circle region where circle radius is 70 units.
                String queryPQA2="select a.accessid,a.APT_LOCATION.SDO_POINT.X as aptX,a.APT_LOCATION.SDO_POINT.Y as aptY,a.RADIUS as aptR from apt1 a where sdo_nn(a.apt_location,sdo_geometry(2001,NULL,sdo_point_type("+xPQ+","+yPQ+",NULL),NULL,NULL),'sdo_num_res=1',1)='TRUE' and (select SDO_NN_DISTANCE(1) dist from apt1 a where sdo_nn(a.apt_location,sdo_geometry(2001,NULL,sdo_point_type("+xPQ+","+yPQ+",NULL),NULL,NULL),'sdo_num_res=1',1)='TRUE')<70";
                queryCounter(queryPQA2);
                ResultSet rsPQA2;
                try
                {
                Statement stPQA=populate.connection.createStatement();
                rsPQA=stPQA.executeQuery(queryPQA);                    
                queryCounter(queryPQA);
                    //Drawing all access points intersecting with circle and drawing them Green
					while(rsPQA.next())
                    {
                                    String pXXPQA = rsPQA.getString("aptX");
                                    String pYYPQA = rsPQA.getString("aptY");
                                    int pXXXPQA=Integer.parseInt(pXXPQA);
                                    int pYYYPQA=Integer.parseInt(pYYPQA);
                                    g.setColor(Color.GREEN);
                                    g.drawRect(pXXXPQA, pYYYPQA, 15, 15);
                                    g.fillRect(pXXXPQA, pYYYPQA, 15, 15);
                    }
                    rsPQA.close();
                    
                    Statement stPQA2=populate.connection.createStatement();
                    rsPQA2=stPQA2.executeQuery(queryPQA2);                    
                    queryCounter(queryPQA2);                
                    //Drawing nearest access points intersecting with circle and drawing it Yellow
					while(rsPQA2.next())
                    {
                                    String pXXPQA2 = rsPQA2.getString("aptX");
                                    String pYYPQA2 = rsPQA2.getString("aptY");
                                    int pXXXPQA2=Integer.parseInt(pXXPQA2);
                                    int pYYYPQA2=Integer.parseInt(pYYPQA2);
                                    g.setColor(Color.YELLOW);
                                    g.drawRect(pXXXPQA2, pYYYPQA2, 15, 15);
                                    g.fillRect(pXXXPQA2, pYYYPQA2, 15, 15);
                    }
                rsPQA.close();
                }
                catch(Exception e)
                {
                    System.out.println("Error:here "+e);
                }                    
          }   
    if(jCheckBox3.isSelected()) //Display All People
                {    
                //Query to result all people intersecting with the circle
				String queryPQB="select p.PEOPLE_LOCATION.SDO_POINT.X as peopleX,p.PEOPLE_LOCATION.SDO_POINT.Y as peopleY from people1 p where sdo_anyinteract(p.people_location,sdo_geometry(2003,NULL,NULL,sdo_elem_info_array(1,1003,4),sdo_ordinate_array("+circleString+")))='TRUE'";
                queryCounter(queryPQB);
                ResultSet rsPQB;
                //Query to result nearest person intersectin or in range of the circle
				String queryPQB2="select p.PEOPLE_LOCATION.SDO_POINT.X as peopleX,p.PEOPLE_LOCATION.SDO_POINT.Y as peopleY from people1 p where sdo_nn(p.people_location,sdo_geometry(2001,NULL,sdo_point_type("+xPQ+","+yPQ+",NULL),NULL,NULL),'sdo_num_res=1',1)='TRUE' and (select SDO_NN_DISTANCE(1) dist from people1 p where sdo_nn(p.people_location,sdo_geometry(2001,NULL,sdo_point_type("+xPQ+","+yPQ+",NULL),NULL,NULL),'sdo_num_res=1',1)='TRUE')<70";
                queryCounter(queryPQB2);
                ResultSet rsPQB2;
                try
                {
                Statement stPQB=populate.connection.createStatement();
                rsPQB=stPQB.executeQuery(queryPQB);                    
                queryCounter(queryPQB);
                    //Drawing all person intersecting with circle and drawing them Green
					while(rsPQB.next())
                    {
                                    String pXXPQB = rsPQB.getString("peopleX");
                                    String pYYPQB = rsPQB.getString("peopleY");
                                    int pXXXPQB=Integer.parseInt(pXXPQB);
                                    int pYYYPQB=Integer.parseInt(pYYPQB);
                                    g.setColor(Color.GREEN);
                                    g.drawRect(pXXXPQB, pYYYPQB, 10, 10);
                                    g.fillRect(pXXXPQB, pYYYPQB, 10, 10);
                                    //drawGraphics(pXXX,pYYY);
                    }
                    rsPQB.close();
                    
                    Statement stPQB2=populate.connection.createStatement();
                    rsPQB2=stPQB2.executeQuery(queryPQB2); 
                    queryCounter(queryPQB2);
                    //Drawing nearest person within circle range and drawing it Yellow
					while(rsPQB2.next())
                    {
                                    String pXXPQB2 = rsPQB2.getString("peopleX");
                                    String pYYPQB2 = rsPQB2.getString("peopleY");
                                    int pXXXPQB2=Integer.parseInt(pXXPQB2);
                                    int pYYYPQB2=Integer.parseInt(pYYPQB2);
                                    g.setColor(Color.YELLOW);
                                    g.drawRect(pXXXPQB2, pYYYPQB2, 10, 10);
                                    g.fillRect(pXXXPQB2, pYYYPQB2, 10, 10);
                    }
                    rsPQB2.close();
                }
                catch(Exception e)
                {
                    System.out.println("Error2: "+e);
                } 				                   
               }    
    }
    
}
    //The function after pushing the Submit Query button,displays only the features of the active feature types that are inside (or intersect with) the polygon drawn by user
	public void rangeQuery()
    {
                if(jCheckBox3.isSelected())
                {
                    try
                        {
                            ResultSet rs3;
                            //Query to result all people that are inside (or intersect with) the polygon drawn by user
							String query="select p.PEOPLE_LOCATION.SDO_POINT.X as x,p.PEOPLE_LOCATION.SDO_POINT.Y as y from people1 p where sdo_anyinteract(p.people_location,sdo_geometry(2003,NULL,NULL,sdo_elem_info_array(1,1003,1),sdo_ordinate_array("+coodString+")))='TRUE'";    
                            queryCounter(query);
                            Statement st3=populate.connection.createStatement();
                            rs3=st3.executeQuery(query);
                            while(rs3.next())
                            {
                                        String pXX = rs3.getString("x");
                                        String pYY = rs3.getString("y");
                                        int pXXX=Integer.parseInt(pXX);
                                        int pYYY=Integer.parseInt(pYY);
                                        drawGraphics(pXXX,pYYY);
                            }
                            rs3.close();
                        }
                    catch (Exception e)
                    {
                        System.out.println("Error: "+e);
                    }              
                }
                if(jCheckBox2.isSelected())
                {
                    try
                        {
                            ResultSet rs3;
                            //Query to result all access point that are inside (or intersect with) the polygon drawn by user
							String query="select p.APT_LOCATION.SDO_POINT.X as peopleX,p.APT_LOCATION.SDO_POINT.Y as peopleY,p.RADIUS as aptR from apt1 p where sdo_anyinteract(p.apt_location,sdo_geometry(2003,NULL,NULL,sdo_elem_info_array(1,1003,1),sdo_ordinate_array("+coodString+")))='TRUE'";
                            queryCounter(query);
                            Statement st3=populate.connection.createStatement();
                            rs3=st3.executeQuery(query);                            
                            while(rs3.next())
                            {
                                        String pXX = rs3.getString("peopleX");
                                        String pYY = rs3.getString("peopleY");
                                        String pRR = rs3.getString("aptR");
                                        int pXXX=Integer.parseInt(pXX);
                                        int pYYY=Integer.parseInt(pYY);
                                        int pRRR=Integer.parseInt(pRR);
                                        drawApt2(pXXX,pYYY,pRRR);
                            }
                            rs3.close();
                        }
                    catch (Exception e)
                    {
                        System.out.println("Error: "+e);
                    }              
                }              
                if(jCheckBox1.isSelected())
                {
                    try
                        {
                            //Query to result all building that are inside (or intersect with) the polygon drawn by user
							String queryrq1="select t.column_value as pt from building1 b,TABLE(b.points.sdo_ordinates) t where sdo_anyinteract"
                            + "(b.points,sdo_geometry(2003,NULL,NULL,sdo_elem_info_array(1,1003,1),sdo_ordinate_array("+coodString+")))='TRUE'";
                            queryCounter(queryrq1);
                            String queryrq2="select b.numpoint as num from building1 b where sdo_anyinteract(b.points,sdo_geometry(2003,NULL,NULL,"
                                                + "sdo_elem_info_array(1,1003,1),sdo_ordinate_array("+coodString+")))='TRUE'";
                            queryCounter(queryrq2);
                            ResultSet rsrq1,rsrq2;
                            
                            Statement st3rq1=populate.connection.createStatement();
                            rsrq1=st3rq1.executeQuery(queryrq1);                            
                            int i1=0,j1=0;
                            int[] ax1=new int[1000];
                            int[] ay1=new int[100];
                            
                            while(rsrq1.next())
                            {
                                int aXX1 = Integer.parseInt(rsrq1.getString("pt"));
                                ax1[i1]=aXX1;
                                i1++;
                            }
                            rsrq1.close();
                            
                            Statement st3rq2=populate.connection.createStatement();
                            rsrq2=st3rq2.executeQuery(queryrq2);                            
                            while(rsrq2.next())
                            {
                                int aYY1 = Integer.parseInt(rsrq2.getString("num"));
                                ay1[j1]=aYY1;
                                j1++;
                            }
                            rsrq2.close();
                            g.setColor(Color.YELLOW);
                            int x11,y11,x21,y22;
                            i1=0;j1=0;
                            int c1=0;
                            while(i1<624)
                            {
                                x11=ax1[i1];y11=ax1[i1+1];x21=ax1[i1+2];y22=ax1[i1+3];
                                g.drawLine(x11, y11, x21, y22);     
                                i1+=2;
                                c1++;
                                if(c1==ay1[j1])
                                {   j1++;
                                    i1+=2;   
                                    c1=0;
                                }     
                            }                            
                        }
                    catch (Exception e)
                    {
                        System.out.println("Error: "+e);
                    }              //Code point 1 Code here
                    
                }              
    }       
    //This function display all the features of the active feature types in the whole map.
	//Here Access Point is Red Square (15x15 pixels) and Buildings by Yellow Polygon outline and People by Green Rectangular (10x10 pixels)
	public void wholeRegionQuery()
    {   
        if(jCheckBox1.isSelected()) //Display All Buildings
              {  
              ResultSet rs2,rs3;
              //Query to result all buildings that are inside our Spatial database
			  String query3="select t.column_value as p from building1 b,table(b.points.sdo_ordinates) t";
              queryCounter(query3);
              String query4="select numpoint from building1";
              queryCounter(query4);
               try
                    {
                    Statement st2=populate.connection.createStatement();
                    rs2=st2.executeQuery(query3);                                        
                    
                    Statement st3=populate.connection.createStatement();
                    rs3=st3.executeQuery(query4);                                        
                    
                    int i=0,j=0;
                    int[] ax=new int[1000];
                    int[] ay=new int[100];
                    
                        while(rs2.next())
                        {
                                        int aXX = Integer.parseInt(rs2.getString("p"));
                                        ax[i]=aXX;
                                        i++;
                        }
                        rs2.close();
                        while(rs3.next())
                        {
                                        int aYY = Integer.parseInt(rs3.getString("numpoint"));
                                        ay[j]=aYY;
                                        j++;
                        }
                        rs3.close();
                        g.setColor(Color.YELLOW);
                        
                        int x1,y1,x2,y2;
                        i=0;j=0;
                        int c=0;
                        
                            while(i<624)
                            {
                                x1=ax[i];y1=ax[i+1];x2=ax[i+2];y2=ax[i+3];
                                g.drawLine(x1, y1, x2, y2);     
                                i+=2;
                                c++;
                                if(c==ay[j])
                                {   j++;
                                    i+=2;   
                                    c=0;
                                }     
                            }                            
                    }
                catch(Exception e)
                {
                    System.out.println("Error: "+e);
                }              
              }                         
              if(jCheckBox2.isSelected()) //Display All Access Points
              {  
              ResultSet rs2;
              //Query to result all Access Points that are inside our Spatial database
			  String query2="select a.APT_LOCATION.SDO_POINT.X as aptX,a.APT_LOCATION.SDO_POINT.Y as aptY,a.RADIUS as aptR  from apt1 a";
              queryCounter(query2);
              try
                    {
                    Statement st2=populate.connection.createStatement();
                    rs2=st2.executeQuery(query2);                    
                        while(rs2.next())
                        {
                                        String aXX = rs2.getString("aptX");
                                        String aYY = rs2.getString("aptY");
                                        String aRR = rs2.getString("aptR");
                                        int aXXX=Integer.parseInt(aXX);
                                        int aYYY=Integer.parseInt(aYY);
                                        int aRRR=Integer.parseInt(aRR);
                                        drawApt(aXXX,aYYY,aRRR);
                        }           
                        rs2.close();
                    }
                catch(Exception e)
                {
                    System.out.println("Error: "+e);
                }              
              }
              
              if(jCheckBox3.isSelected()) //Display All People
                {
                //Query to result all people that are inside our Spatial database
				String query="select p.PEOPLE_LOCATION.SDO_POINT.X as peopleX,p.PEOPLE_LOCATION.SDO_POINT.Y as peopleY from people1 p";
                queryCounter(query);
                ResultSet rs;
                try
                {
                Statement st=populate.connection.createStatement();
                rs=st.executeQuery(query);                    
                    while(rs.next())
                    {
                                    String pXX = rs.getString("peopleX");
                                    String pYY = rs.getString("peopleY");
                                    int pXXX=Integer.parseInt(pXX);
                                    int pYYY=Integer.parseInt(pYY);
                                    drawGraphics(pXXX,pYYY);
                    }
                    rs.close();
                }
                catch(Exception e)
                {
                    System.out.println("Error: "+e);
                }                    
               }              
    }    
    public void findAPQuery()
    {
        if(tempXX4>0 && tempYY4>0)
        {
            //Query to result the nearest Access Point to the point clicked by the user
			String APQ="select a.accessid as APTID,a.APT_LOCATION.SDO_POINT.X as APT4X,a.APT_LOCATION.SDO_POINT.Y as APT4Y,a.RADIUS as APT4R from apt1 a where sdo_nn(a.apt_location,sdo_geometry(2001,NULL,sdo_point_type("+tempXX4+","+tempYY4+",NULL),NULL,NULL),'sdo_num_res=1')='TRUE'";
            ResultSet rsAPQ;
            queryCounter(APQ);
            try
            {
            int stAPQRSy=0,stAPQRSx=0,stAPQRSr=0;
            Statement stAPQ=populate.connection.createStatement();
            rsAPQ=stAPQ.executeQuery(APQ);
            while(rsAPQ.next())
            {
                String stAPQRSxx=(rsAPQ.getString("APT4X"));
                stAPQRSx=Integer.parseInt(stAPQRSxx);
                String stAPQRSyy=(rsAPQ.getString("APT4Y"));
                stAPQRSy=Integer.parseInt(stAPQRSyy);
                String stAPQRSrr=(rsAPQ.getString("APT4R"));
                stAPQRSr=Integer.parseInt(stAPQRSrr);
            }
            rsAPQ.close();
            
            stAPQRSr+=10;			
            String coodStringAPQ3=stAPQRSx+","+(stAPQRSy-stAPQRSr)+","+(stAPQRSx+stAPQRSr)+","+stAPQRSy+","+stAPQRSx+","+(stAPQRSy+stAPQRSr);        
            System.out.println("coodStringAPQ3: " +coodStringAPQ3);
            //Query to result all People that are within the range of access point radius + 10 units
			String APQr10="select p.PEOPLE_LOCATION.SDO_POINT.X as P4X10,p.PEOPLE_LOCATION.SDO_POINT.Y as P4Y10 from people1 p where sdo_anyinteract(p.people_location,sdo_geometry(2003,NULL,NULL,sdo_elem_info_array(1,1003,4),sdo_ordinate_array("+coodStringAPQ3+")))='TRUE'";
            ResultSet rsAPQr10;            
            queryCounter(APQr10);
            Statement stAPQr10=populate.connection.createStatement();
            rsAPQr10=stAPQr10.executeQuery(APQr10);
            while(rsAPQr10.next())
            {   
                String stAPQRSpxx10=rsAPQr10.getString("P4X10");
                int stAPQRSpx10=Integer.parseInt(stAPQRSpxx10);
                String stAPQRSpyy10=rsAPQr10.getString("P4Y10");
                int stAPQRSpy10=Integer.parseInt(stAPQRSpyy10);                
                //System.out.println("stAPQRSpxy10 " +stAPQRSpx10+" "+stAPQRSpy10);
                g.setColor(Color.CYAN);
                g.drawRect(stAPQRSpx10-5, stAPQRSpy10-5, 10, 10);
                g.fillRect(stAPQRSpx10-5, stAPQRSpy10-5, 10, 10);
                g.drawLine(stAPQRSpx10, stAPQRSpy10, stAPQRSx, stAPQRSy);
            }
            rsAPQr10.close();

            stAPQRSr-=5;			
            String coodStringAPQ2=stAPQRSx+","+(stAPQRSy-stAPQRSr)+","+(stAPQRSx+stAPQRSr)+","+stAPQRSy+","+stAPQRSx+","+(stAPQRSy+stAPQRSr);        
            System.out.println("coodStringAPQ2: " +coodStringAPQ2);
			
            //Query to result all People that are within the range of access point radius + 5 units
			String APQr5="select p.PEOPLE_LOCATION.SDO_POINT.X as P4X5,p.PEOPLE_LOCATION.SDO_POINT.Y as P4Y5 from people1 p where sdo_anyinteract(p.people_location,sdo_geometry(2003,NULL,NULL,sdo_elem_info_array(1,1003,4),sdo_ordinate_array("+coodStringAPQ2+")))='TRUE'";
            
			ResultSet rsAPQr5;            
            queryCounter(APQr5);
            Statement stAPQr5=populate.connection.createStatement();
            rsAPQr5=stAPQr5.executeQuery(APQr5);
            while(rsAPQr5.next())
            {   
                String stAPQRSpxx5=rsAPQr5.getString("P4X5");
                int stAPQRSpx5=Integer.parseInt(stAPQRSpxx5);
                String stAPQRSpyy5=rsAPQr5.getString("P4Y5");
                int stAPQRSpy5=Integer.parseInt(stAPQRSpyy5);                
                //System.out.println("stAPQRSpxy5 " +stAPQRSpx5+" "+stAPQRSpy5);
                g.setColor(Color.BLUE);
                g.drawRect(stAPQRSpx5-5, stAPQRSpy5-5, 10, 10);
                g.fillRect(stAPQRSpx5-5, stAPQRSpy5-5, 10, 10);
                g.drawLine(stAPQRSpx5, stAPQRSpy5, stAPQRSx, stAPQRSy);
            }
            rsAPQr5.close();

            stAPQRSr-=5;			
            String coodStringAPQ1=stAPQRSx+","+(stAPQRSy-stAPQRSr)+","+(stAPQRSx+stAPQRSr)+","+stAPQRSy+","+stAPQRSx+","+(stAPQRSy+stAPQRSr);        
            System.out.println("coodStringAPQ1: " +coodStringAPQ1);
           
		   //Query to result all People that are within the range of access point radius 
		   String APQr="select p.PEOPLE_LOCATION.SDO_POINT.X as P4X,p.PEOPLE_LOCATION.SDO_POINT.Y as P4Y from people1 p where sdo_anyinteract(p.people_location,sdo_geometry(2003,NULL,NULL,sdo_elem_info_array(1,1003,4),sdo_ordinate_array("+coodStringAPQ1+")))='TRUE'";
		   
            ResultSet rsAPQr;            
            queryCounter(APQr);
            Statement stAPQr=populate.connection.createStatement();
            rsAPQr=stAPQr.executeQuery(APQr);
            while(rsAPQr.next())
            {   
                String stAPQRSpxx=rsAPQr.getString("P4X");
                int stAPQRSpx=Integer.parseInt(stAPQRSpxx);
                String stAPQRSpyy=rsAPQr.getString("P4Y");
                int stAPQRSpy=Integer.parseInt(stAPQRSpyy);                
                //System.out.println("stAPQRSpxy " +stAPQRSpx+" "+stAPQRSpy);
                g.setColor(Color.YELLOW);
                g.drawRect(stAPQRSpx-5, stAPQRSpy-5, 10, 10);
                g.fillRect(stAPQRSpx-5, stAPQRSpy-5, 10, 10);
                g.drawLine(stAPQRSpx, stAPQRSpy, stAPQRSx, stAPQRSy);
            }
            rsAPQr.close();
            }
            
        catch(Exception e)
        {
            System.out.println("Exception: " +e);
        }
      }
    }   
    public static void main(String args[]) 
    {
        //Set the Nimbus look and feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(hw2UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hw2UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hw2UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hw2UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //Creating Object of Populate.java class to connect to DB and to remove the previous data in tables; so as the tables will not have redundant data.
		populate classObject=new populate();
        classObject.connectDB();
        classObject.deleteDB();
        
        //Parsing command line arguments and populating database using Object of Populate.java class 
		if (args.length != 0)
        {
        String file0=args[0];
        String file1=args[1];
        String file2=args[2];
        classObject.populateBuilding(file0);
        classObject.populatePeople(file1);
        classObject.populateApt(file2);
        }
        /* Create and display the form    */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hw2UI().setVisible(true);                
            }
        });
    }
    
    //Global Variables used 
    int [] ptsX=new int[20];
    int [] ptsY=new int[20];
    int index=0;
    int numPoints=0;
    String coodString="";
    int queryFlag=0;
    int queryCounter=0;
    int clickCount=1;
    int mouseButtonClick=0;
    int tempXX4=0;
    int tempYY4=0;
    int tempX3PtQ=0,tempY3PtQ=0;
    int pointQueryFlag=0;
                
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private java.awt.Panel panel1;
    private java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables
}