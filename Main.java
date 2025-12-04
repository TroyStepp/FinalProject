import javax.swing.*;
import java.util.Scanner;

class Order {
    String drinkName;
    double basePrice;


    Order(String drinkName, double basePrice) {
        this.drinkName = drinkName;
        this.basePrice = basePrice;
    }


    void printBill() {
        Scanner input = new Scanner(System.in);
        System.out.print("Are you a café member (Y/N)? ");
        String member = input.nextLine();

        double discount = 0.0;
        if (member.equalsIgnoreCase("Y")) {
            discount = 0.10;
        }

        double finalPrice = basePrice - (basePrice * discount);

        System.out.println("Drink: " + drinkName);
        System.out.println("Base Price: $" + basePrice);
        System.out.println("Discount: " + (discount * 100) + " %");
        System.out.printf("Final Price: $%.2f\n", finalPrice);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        JFrame Frame = new JFrame(" Coffee Shop");
        Frame.setSize(400, 200);
        Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel Label = new JLabel(" Welcome to the coffee shop! Please select an item you would like.");
        JButton Coffee= new JButton(" Coffee");
        JButton Latte= new JButton(" Latte");
        JButton croissant= new JButton(" croissant");
        JPanel Panel = new JPanel();
        Panel.add(Coffee);
        Panel.add(Label);
        Panel.add(Latte);
        Panel.add(Label);
        Panel.add(croissant);
        Panel.add(Label);
        Frame.add(Panel);
        Coffee.addActionListener(e -> Label.setText("One Coffee coming right up!"));
        Latte.addActionListener(e -> Label.setText("One Latte coming right up!"));
        croissant.addActionListener(e -> Label.setText("One croissant coming right up!"));
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setVisible(true);

        int choice = input.nextInt();


        Order order = null;

        switch (choice) {
            case 1:
                order = new Order("Coffee", 3.50);
                break;
            case 2:
                order = new Order("Latte", 4.50);
                break;
            case 3:
                order = new Order("Croissant", 5.00);
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }


        order.printBill();
    }
}