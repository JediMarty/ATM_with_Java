package Atm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Virtual_ATM {
	
	private String pincode;
	
	public Virtual_ATM(String pincode) {
		this.pincode = pincode;
		}
	
	public String getPincode() {
    	return pincode;
    }
	
	public Boolean pinv(String enter,Boolean card) {
	int cout = 3;
		 try {
	            File file = new File("c:/Users/Admin/Desktop/gits/ATM/notess.txt");
	            Scanner scanner = new Scanner(file);
	            while(scanner.hasNext() || cout!=0) {
	            if (enter.equals(scanner.next())) {
	        		pincode = enter;
	        		card = true;
	        	    break;
	        	}
	           
	            else if (enter.equals(scanner.next())) {
	            	pincode = enter;
	        		card = true;
	        	    break;
	            }
	            
	        	else {
	        		System.out.println("Wrong pin, please try again!");
	        		cout-=1;
	        	    
	        	}
	            }  
		 } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	    
		 return card;
		
	
	
	}
	 public int read_note(ATM person1,int money) {
	        try {
	            File file = new File("c:/Users/Admin/Desktop/gits/ATM/notes.txt");
	            Scanner scanner = new Scanner(file);
	        
	            if(scanner.next().equals(pincode)) {
	            
	            	 money = scanner.nextInt();
	            }
	            else {
	            	scanner.next();
	            	scanner.next();
	            	money = scanner.nextInt();}
	            return money;
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }
	 
	   public void saves_note( ATM person1) {
		   String s = ""; 
		   int m = 0;
		   try {
			    BufferedReader reader = new BufferedReader(new FileReader("c:/Users/Admin/Desktop/gits/ATM/notes.txt"));
	        	File file = new File("c:/Users/Admin/Desktop/gits/ATM/notes.txt");
	        	Scanner scanner = new Scanner(file);
	        	if(!(scanner.next().equals(pincode))) {
	        		
	        		
	        		 s = reader.readLine();
	            	
	            }
	        	else {
	        		 reader.readLine();
	        		 s = reader.readLine();
	            
	        	}
	        	FileWriter filew = new FileWriter("c:/Users/Admin/Desktop/gits/ATM/notes.txt");
	            
	            filew.write(person1.getPincode() + " " + person1.getMoney() + "\n");
	            filew.write(s);
	            filew.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}

