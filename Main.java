import javax.swing.*;

//imports layout manager
import java.awt.*;

//imports event listeners like button clicks
import java.awt.event.*;

import java.io.*;

//imports ArrayList for storing items
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        new CoffeeShopGUI();
    }
}
//creates class that is a window
class CoffeeShopGUI extends JFrame {

    //displays total price at the bottom
    private JLabel totalLabel;

    //shows items added
    private JTextArea orderSummary;

    //stores running price
    private double total = 0.0;

    //stores items(strings) for saving to the file
    private ArrayList<String> orderItems = new ArrayList<>();

    public CoffeeShopGUI() {
        setTitle("Coffee Shop Ordering System");
        setSize(400, 500);

        //closes program after exiting window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //organizes screen into north, south, and center for more organized/user-friendly experience
        setLayout(new BorderLayout());

        // top buttons
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));

        JButton coffeeBtn = new JButton("Coffee - $3.50");
        JButton latteBtn = new JButton("Latte - $4.50");
        JButton mochaBtn = new JButton("Croissant - $5.00");

        //adds buttons for your menu options
        buttonPanel.add(coffeeBtn);
        buttonPanel.add(latteBtn);
        buttonPanel.add(mochaBtn);

        // places panels at the top of the window
        add(buttonPanel, BorderLayout.NORTH);

        //area for order summary
        orderSummary = new JTextArea();
        //prevents user from being able to type
        orderSummary.setEditable(false);

        //area for text and allows user to scroll
        add(new JScrollPane(orderSummary), BorderLayout.CENTER);

        //creates panel with 3 rows
        JPanel bottomPanel = new JPanel(new GridLayout(3, 1));

        totalLabel = new JLabel("Total: $0.00");
        JButton saveBtn = new JButton("Save Order");
        //button for loading/displaying orders
        JButton loadBtn = new JButton("Load Order History");

        //adds labels and buttons to the bottom panel
        bottomPanel.add(totalLabel);
        bottomPanel.add(saveBtn);
        bottomPanel.add(loadBtn);
        //so the button is at the bottom of the window
        add(bottomPanel, BorderLayout.SOUTH);

        //GUI buttons
        coffeeBtn.addActionListener(e -> addItem("Coffee", 3.50));
        latteBtn.addActionListener(e -> addItem("Latte", 4.50));
        mochaBtn.addActionListener(e -> addItem("Croissant", 5.00));

        saveBtn.addActionListener(e -> saveOrder());
        loadBtn.addActionListener(e -> loadOrderHistory());

        setVisible(true);
    }
//adds items to the order (add order method)
    private void addItem(String item, double price) {
        orderItems.add(item + " - $" + price);
        total += price;

        orderSummary.append(item + " added ($" + price + ")\n");
        totalLabel.setText(String.format("Total: $%.2f", total));
    }
    //saves data so it isn't erased after closing(save order method)
    private void saveOrder() {
        //writes the order into the file
        try (PrintWriter writer = new PrintWriter(new FileWriter("order_history.txt", true))) {
            writer.println("=== New Order ===");
            for (String item : orderItems) {
                writer.println(item);
            }
            writer.println("Total: $" + String.format("%.2f", total));
            //displays the total
            writer.println();
            JOptionPane.showMessageDialog(this, "Order saved!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving order.");
        }
    }
//load order method
    private void loadOrderHistory() {
        try {
            //references the file
            File file = new File("order_history.txt");
            if (!file.exists()) {

            }
            //reads the file line by line
            BufferedReader reader = new BufferedReader(new FileReader(file));
            orderSummary.setText(""); // clear
            String line;

            //displays receipt when loading history
            while ((line = reader.readLine()) != null) {
                orderSummary.append(line + "\n");
            }

            reader.close();
        } catch (IOException e) {
        }
    }
}
