package com.owcs;
import com.fatwire.csdt.client.main.*;
import com.fatwire.csdt.client.util.CSDTClientUtility;
import com.fatwire.csdt.client.util.RequestValueObject;


public class CSDTClient extends CSDT {

	public static void main(String[] args) {

		
		 if (args.length < 3) {
		      printUsage();
		    } else {
		      try
		      {
		    	printmsg("[INFO] CSDT has been started");
		        RequestValueObject valObj = CSDTClientUtility.parseCommand(args);
		        String response = CSDTClientUtility.callCS(valObj);
		        handleResponse(response, valObj);
		        printmsg("[INFO] CSDT has been Completed successfully");
		      }
		      catch (Exception e)
		      {
		        e.printStackTrace();
		      }
		    }

	}
	
	private static void printmsg(String str){
		
		System.out.println("\033[1;32m\033");
		System.out.println("\033[1;32m[INFO] =============================================\033");
		System.out.println("\033[1;32m"+str+"...!!!\033");
		System.out.println("\033[1;32m[INFO] =============================================\033[0m");
	}
	
}
