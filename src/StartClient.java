import InformationApp.*;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;

import java.util.*;
 
public class StartClient {
 
    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("resource")
	public static void main(String[] args) {
      try {
	    ORB orb = ORB.init(args, null);
	    org.omg.CORBA.Object objRef =   orb.resolve_initial_references("NameService");
	    NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
	    Information infoobj = (Information) InformationHelper.narrow(ncRef.resolve_str("ABC"));
 
            Scanner c=new Scanner(System.in);
            System.out.println("Welcome to the information system:");          		    
		    for(;;){
		      System.out.println("Enter a name:");
		      String aa = c.nextLine();
		      String r=infoobj.info(aa);
		      System.out.println("The information is : "+r);
		      System.out.println("-----------------------------------");
            }
       }
       catch (Exception e) {
          System.out.println("Hello Client exception: " + e);
	  e.printStackTrace();
       }
 
    }
 
}