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

    public  ATM(String pincode, int money, int ds, int value) {
        this.pincode = pincode;
        this.money = money;
        this.ds = ds;
        this.value = value;
    }

    public void withdrawal( ATM person1) {
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

    public void deposit( ATM person1) {
        System.out.println("Please enter how much you want to add!");
        Scanner scanner = new Scanner(System.in);
        person1.ds = Integer.parseInt(scanner.nextLine());
        person1.money += person1.ds;
    }

	public int getMoney() {
		// TODO Auto-generated method stub
		return money;
	}

	public int getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	public int getDs() {
		// TODO Auto-generated method stub
		return ds;
	}



    public static void Balance_Inquiry( ATM person1) {
        System.out.println("Your balance is " + person1.getMoney() + " leva");
    }

    public static void note_w( ATM person1) {
        try {
            FileWriter file = new FileWriter("c:/Users/Admin/Desktop/gits/ATM/note.txt");
            file.write("Withdrawal: " + person1.getValue() + "\n");
            file.write("Balance Inquiry: " + person1.getMoney());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void note_D( ATM person1) {
        try {
            FileWriter file = new FileWriter("c:/Users/Admin/Desktop/gits/ATM/note.txt");
            file.write("Deposit: " + person1.getDs() + "\n");
            file.write("Balance Inquiry: " + person1.getMoney());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void note_BI( ATM person1) {
        try {
            FileWriter file = new FileWriter("c:/Users/Admin/Desktop/gits/ATM/note.txt");
            file.write("Balance Inquiry: " + person1.getMoney());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saves_note( ATM person1) {
        try {
            FileWriter file = new FileWriter("c:/Users/Admin/Desktop/gits/ATM/notes.txt");
            file.write(String.valueOf(person1.getMoney()));
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int read_note() {
        try {
            File file = new File("c:/Users/Admin/Desktop/gits/ATM/notes.txt");
            Scanner scanner = new Scanner(file);
            int money = scanner.nextInt();
            scanner.close();
            return money;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
	
	public static void main(String[] args) {
		int money;
		 ATM person1 = new  ATM("", 0, 0, 0);
		if (new File("notes.txt").exists()) {
             
			money = read_note();
             person1 = new  ATM("7777", money, 0, 0);
        } else {
        	  person1 = new  ATM("7777", 120, 0, 0);
        } 
		 String choice3 = "";
		 String choice = "";
		boolean card = false;
        while (!card) {
            System.out.println("\t\tATM");
            System.out.println("\tPlease enter your pincode!");
            Scanner scanner = new Scanner(System.in);
            String enter = scanner.nextLine().toLowerCase();
            if (enter.equals("7777")) {
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
            Scanner scanner = new Scanner(System.in);
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
            Scanner scanner = new Scanner(System.in);
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
    }
		
	

}






