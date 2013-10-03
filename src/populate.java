 /*
 * Spatial Database ACCESS POINT Tracker 
 */
package my.spatialDBUI;

//Importing all packages for system input/output through data streams, serialization and the file system
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
//Importing all SQL packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Vasu
 */
public class populate {
    
public static Connection connection;

//Function to connect to a database using the connection string with username and password for the database
public void connectDB()
{
    System.out.println("Checking for Drivers");
    try
    {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        connection=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","SYSTEM","orcl");
        System.out.println("Connected");
    }
    catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Could not Connect. Error is "+ex);
        }
}
//Function poulates all the entries from the user file into the accesspoint table
public void populateApt(String file)
    {
     try
        {
            FileInputStream f= new FileInputStream(file);
            DataInputStream d=new DataInputStream(f);
            BufferedReader b=new BufferedReader(new InputStreamReader(d));
            String strLine;
            
            int rowNum=0;
            while((strLine=b.readLine())!=null)
            {
                rowNum++;
                String str[]=strLine.split(",");
                
                for(int i=0;i<str.length;i++)
                {
                    str[i]=str[i].replaceAll(" ","");
                    //System.out.println(str[i]+" "+str[i].length());
                }
                int x=Integer.parseInt(str[1]);
                int y=Integer.parseInt(str[2]);
                int r=Integer.parseInt(str[3]);
                
                String query="insert into apt1 values('"+str[0]+ "',"+str[3]+",MDSYS.SDO_GEOMETRY("+"2001,NULL,MDSYS.SDO_POINT_TYPE("+str[1]+","+str[2]+",NULL),NULL,NULL))";
                //System.out.println(query);
                //String query="INSERT INTO apt1 VALUES ('"+str[0]+ "',"+str[3]+",MDSYS.SDO_GEOMETRY (2001, null, null, sdo_elem_info_array (1,1003,4),MDSYS.sdo_ordinate_array ("+x1+","+y+","+x2+","+y+","+x+","+y3+")))";
                PreparedStatement prepStat=connection.prepareStatement(query);
                prepStat.execute();                
            }
            System.out.println(rowNum+" rows updated.");                    
        }
     catch (Exception e)
        {
            System.out.println("Could not Read from Input file. Error is "+e);
        }
     
    }
//Function poulates all the entries from the user file into the building table
public void populateBuilding(String file)
    {
    try
        {
            FileInputStream f= new FileInputStream(file);
            DataInputStream d=new DataInputStream(f);
            BufferedReader b=new BufferedReader(new InputStreamReader(d));
            String strLine;
            int rowNum=0;
            while((strLine=b.readLine())!=null)
            {
                rowNum++;
                String str[]=strLine.split(",");
                
                for(int i=0;i<str.length;i++)
                {
                    str[i]=str[i].replaceAll(" ","");
                    //System.out.println(str[i]+" "+str[i].length());
                }
                //int numPoints=Integer.parseInt(str[2]);
                
                String polyCood="";
                for(int i=3;i<(str.length-1);i++)
                {
                    polyCood+=str[i]+",";
                }
                        
                polyCood+=str[str.length-1];
                polyCood+=","+str[3];
                polyCood+=","+str[4];
                
                String query="insert into building1 values('"+str[0]+"','"+str[1]+"',"+str[2]+",MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY("+polyCood+")))";    
                PreparedStatement prepStat=connection.prepareStatement(query);
                prepStat.execute();                
            }
            System.out.println(rowNum+" rows updated.");
                    
        }
     catch (Exception e)
        {
            System.out.println("Could not Read from Input file. Error is "+e);
        }
    }
//Function poulates all the entries from the user file into the People table
public void populatePeople(String file)
    {
    try
        {
            FileInputStream f= new FileInputStream(file);
            DataInputStream d=new DataInputStream(f);
            BufferedReader b=new BufferedReader(new InputStreamReader(d));
            String strLine;
            int rowNum=0;
            while((strLine=b.readLine())!=null)
            {
                rowNum++;
                String str[]=strLine.split(",");
                
                for(int i=0;i<str.length;i++)
                {
                    str[i]=str[i].replaceAll(" ","");
                    //System.out.println(str[i]+" "+str[i].length());
                }
                String query="insert into people1 values('"+str[0]+ "',MDSYS.SDO_GEOMETRY("+"2001,NULL,MDSYS.SDO_POINT_TYPE("+str[1]+","+str[2]+",NULL),NULL,NULL))";
                PreparedStatement prepStat=connection.prepareStatement(query);
                prepStat.execute();                
            }
            System.out.println(rowNum+" rows updated.");
            
        }
     catch (Exception e)
        {
            System.out.println("Could not Read from Input file. Error is "+e);
        }
    }
    //Function to remove the previous data in tables; so as the tables will not have redundant data.
	public void deleteDB()
    {
        try
        {
            PreparedStatement del1=connection.prepareStatement("delete from building1");
            del1.execute();
            PreparedStatement del2=connection.prepareStatement("delete from people1");
            del2.execute();
            PreparedStatement del3=connection.prepareStatement("delete from apt1");
            del3.execute();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
