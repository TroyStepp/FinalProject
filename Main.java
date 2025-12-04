import javax.swing.*;

public class Main {
    public static void main(String[] args) {

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





    }
}