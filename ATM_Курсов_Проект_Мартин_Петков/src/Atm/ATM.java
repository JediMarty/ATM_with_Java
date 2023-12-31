package Atm;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ATM extends Virtual_ATM{

	
    private int money;
    private int ds;
    private int value;
    
    public int getMoney() {
		return money;
	}

	public int getDs() {
		return ds;
	}
	
	public int getValue() {
		return value;
	}
	
	public ATM(String pincode, int money, int ds, int value) {
        super(pincode);
        this.money = money;
        this.ds = ds;
        this.value = value;
    }

	public int availability(ATM person1) {
		if (person1.money < person1.value) {
			System.out.println("no"); 
			System.exit(0);
		}
		
		return person1.money;
		
	}
	
	
    public void withdrawal(ATM person1) {
        Boolean flag = false;
        String choice2;
        String scan_value;
        Scanner scanner = new Scanner(System.in);
        while(!flag) {
        System.out.println("\t\tPlease choose how much you want to withdrawal!");
        System.out.println("1: 20 lv");
        System.out.println("2: 40 lv");
        System.out.println("3: 60 lv");
        System.out.println("4: 80 lv");
        System.out.println("5: 100 lv");
        System.out.println("6: 200 lv");
        System.out.println("7: Custom amount");
        System.out.println("8: Exit");
       
        choice2 = scanner.nextLine();
        
        switch (choice2) {
            case "1":
                person1.value = 20;
                person1.availability(person1);
                person1.money -= person1.value;
                flag = true;
                break;
            case "2":
                person1.value = 40;
                person1.availability(person1);
                person1.money -= person1.value;
                flag = true;
                break;
            case "3":
                person1.value = 60;
                person1.availability(person1);
                person1.money -= person1.value;
                flag = true;
                break;
            case "4":
                person1.value = 80;
                person1.availability(person1);
                person1.money -= person1.value;
                flag = true;
                break;
            case "5":
                person1.value = 100;
                person1.availability(person1);
                person1.money -= person1.value;
                flag = true;
                break;
            case "6":
                person1.value = 200;
                person1.availability(person1);
                person1.money -= person1.value;
                flag = true;
                break;
            case "7":
                while(true) {
            	System.out.println("Please enter how much you want to withdraw!");
                scan_value = scanner.nextLine();
                if(scan_value.matches("\\d+")) {
                person1.value = Integer.parseInt(scan_value);
                person1.availability(person1);
                person1.money -= person1.value;
                break;
                }
                else {
            		System.out.println("Wrong data");
            		}
                }
                flag = true;
                break;
            case "8":
            	flag = true;
                break;
            default:
        	   System.out.println("You inserted invalid option, please try again!");
        	   }
        }
        
    }

    public void deposit(ATM person1) {
    	String input;
    	Scanner scanner = new Scanner(System.in);
    	while(true) {
        	System.out.println("Please enter how much you want to add!");
        	input = scanner.nextLine();
        	if(input.matches("\\d+")) {
        		person1.ds = Integer.parseInt(input);
        		break;
        	}
        	else {
        		System.out.println("Wrong data");
        		}
        	}
    	person1.money += person1.ds;
    	
    }
    
    public void Balance_Inquiry( ATM person1) {
        System.out.println("Your balance is " + person1.getMoney() + " leva");
    }

    public void note_w( ATM person1) {
        try {
            FileWriter file = new FileWriter("e:/eclipse/eclipse workspace/note.txt");
            file.write("Withdrawal: " + person1.getValue() + "\n");
            file.write("Balance Inquiry: " + person1.getMoney());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void note_D( ATM person1) {
        try {
            FileWriter file = new FileWriter("e:/eclipse/eclipse workspace/note.txt");
            file.write("Deposit: " + person1.getDs() + "\n");
            file.write("Balance Inquiry: " + person1.getMoney());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void note_BI( ATM person1) {
        try {
            FileWriter file = new FileWriter("e:/eclipse/eclipse workspace/note.txt");
            file.write("Balance Inquiry: " + person1.getMoney());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int money=0;
		int cout = 3;
		String choice3 = "";
		String choice = "";
		boolean card = false;
        
		ATM person1 = new ATM("", 0, 0, 0);
		
		while (true) {
            System.out.println("\t\tATM");
            System.out.println("\tPlease enter your pincode!");
            String enter = scanner.nextLine();
            card = person1.pinv(enter,card);
            if (card == true) {
            	break;
            }
            cout-=1;
            if (cout == 0) {
            	System.out.println("Too many wrong Pins, please try again later..."); 
            	System.exit(0); 
            }
            
        }
        
        if (new File("e:/eclipse/eclipse workspace/notes.txt").exists()) {
			money = person1.read_note(person1,money);
            person1 = new ATM(person1.getPincode(), money, 0, 0);
        } else {
        	person1 = new ATM("", 0, 0, 0);
        }
        
        boolean flag = false;
        while (!flag) {
            System.out.println("\t\tPlease choose service");
            System.out.println("1: Withdrawal");
            System.out.println("2: Deposit");
            System.out.println("3: Balance Inquiry");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    person1.withdrawal(person1);
                    flag = true;
                    break;
                case "2":
                    person1.deposit(person1);
                    flag = true;
                    break;
                case "3":
                    person1.Balance_Inquiry(person1);
                    flag = true;
                    break;
                default:
                    System.out.println("Wrong choice!");
                    System.out.println("Please try again...");
                    break;
            }
        }
       
        while (!(choice3.equals("Y") || choice3.equals("N"))) { //law of De Morgan
            System.out.println("Would you like a note ?");
            System.out.println("Y/N");
            choice3 = scanner.nextLine().toUpperCase();
        }
        if (choice3.equals("Y")) {
            if (choice.equals("1")) {
                person1.note_w(person1);
                person1.saves_note(person1);
                System.out.println("Have a nice day!");
            } else if (choice.equals("2")) {
                person1.note_D(person1);
                person1.saves_note(person1);
                System.out.println("Have a nice day!");
            } else {
                person1.note_BI(person1);
                person1.saves_note(person1);
                System.out.println("Have a nice day!");
            }
        } else {
            person1.saves_note(person1);
            System.out.println("Have a nice day!");
        }
        scanner.close();
    }
		
	

}





