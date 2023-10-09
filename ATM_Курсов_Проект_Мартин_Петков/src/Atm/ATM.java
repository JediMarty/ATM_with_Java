package Atm;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ATM {

   private String pincode;
    private int money;
    private int ds;
    private int value;
    
    public String getPincode() {
    	return pincode;
    }
    
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
        this.pincode = pincode;
        this.money = money;
        this.ds = ds;
        this.value = value;
    }

    public void withdrawal(ATM person1) {
        System.out.println("\t\tPlease choose how much you want to withdrawal!");
        System.out.println("1: 20 lv");
        System.out.println("2: 40 lv");
        System.out.println("3: 60 lv");
        System.out.println("4: 80 lv");
        System.out.println("5: 100 lv");
        System.out.println("6: 200 lv");
        System.out.println("7: Custom amount");
        Scanner scanner = new Scanner(System.in);
        String choice2 = scanner.nextLine();
        switch (choice2) {
            case "1":
                person1.value = 20;
                person1.money -= person1.value;
                break;
            case "2":
                person1.value = 40;
                person1.money -= person1.value;
                break;
            case "3":
                person1.value = 60;
                person1.money -= person1.value;
                break;
            case "4":
                person1.value = 80;
                person1.money -= person1.value;
                break;
            case "5":
                person1.value = 100;
                person1.money -= person1.value;
                break;
            case "6":
                person1.value = 200;
                person1.money -= person1.value;
                break;
            case "7":
                System.out.println("Please enter how much you want to withdraw!");
                person1.value = Integer.parseInt(scanner.nextLine());
                person1.money -= person1.value;
                break;
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
            FileWriter file = new FileWriter("c:/Users/Admin/Desktop/gits/ATM/note.txt");
            file.write("Withdrawal: " + person1.getValue() + "\n");
            file.write("Balance Inquiry: " + person1.getMoney());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void note_D( ATM person1) {
        try {
            FileWriter file = new FileWriter("c:/Users/Admin/Desktop/gits/ATM/note.txt");
            file.write("Deposit: " + person1.getDs() + "\n");
            file.write("Balance Inquiry: " + person1.getMoney());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void note_BI( ATM person1) {
        try {
            FileWriter file = new FileWriter("c:/Users/Admin/Desktop/gits/ATM/note.txt");
            file.write("Balance Inquiry: " + person1.getMoney());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saves_note( ATM person1) {
        try {
            FileWriter file = new FileWriter("c:/Users/Admin/Desktop/gits/ATM/notes.txt");
            file.write(String.valueOf(person1.getMoney()));
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int read_note() {
        try {
            File file = new File("c:/Users/Admin/Desktop/gits/ATM/notes.txt");
            Scanner scanner = new Scanner(file);
            int money = scanner.nextInt();
            
            return money;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int money;
		 ATM person1 = new  ATM("", 0, 0, 0);
		if (new File("c:/Users/Admin/Desktop/gits/ATM/notes.txt").exists()) {
             
			money = person1.read_note();
            person1 = new  ATM("7777", money, 0, 0);
        } else {
        	  person1 = new  ATM("7777", 0, 0, 0);
        } 
		 String choice3 = "";
		 String choice = "";
		boolean card = false;
        while (!card) {
            System.out.println("\t\tATM");
            System.out.println("\tPlease enter your pincode!");
            String enter = scanner.nextLine();
            if (enter.equals(person1.getPincode())) {
                card = true;
            } else {
                System.out.println("Wrong pincode!");
            }
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
       
        while (!(choice3.equals("Y") || choice3.equals("N"))) {
            System.out.println("Would you like a note ?");
            System.out.println("Y/N");
            choice3 = scanner.nextLine().toUpperCase();
        }
        if (choice3.equals("Y")) {
            if (choice.equals("1")) {
                person1.note_w(person1);
                person1.saves_note(person1);
            } else if (choice.equals("2")) {
                person1.note_D(person1);
                person1.saves_note(person1);
            } else {
                person1.note_BI(person1);
                person1.saves_note(person1);
            }
        } else {
            person1.saves_note(person1);
            System.out.println("Have a nice day!");
        }
        scanner.close();
    }
		
	

}

