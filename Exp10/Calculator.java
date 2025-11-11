import javax.swing.*;

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("SIMPLE CALCULATOR");
        frame.setSize(500, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("ENTER FIRST NUMBER:");
        l1.setBounds(50, 40, 180, 30);
        JTextField t1 = new JTextField();
        t1.setBounds(250, 40, 180, 30);

        JLabel l2 = new JLabel("ENTER SECOND NUMBER:");
        l2.setBounds(50, 90, 180, 30);
        JTextField t2 = new JTextField();
        t2.setBounds(250, 90, 180, 30);

        JButton addBtn = new JButton("ADD");
        addBtn.setBounds(50, 150, 90, 35);

        JButton subBtn = new JButton("SUBTRACT");
        subBtn.setBounds(150, 150, 110, 35);

        JButton mulBtn = new JButton("MULTIPLY");
        mulBtn.setBounds(270, 150, 110, 35);

        JButton divBtn = new JButton("DIVIDE");
        divBtn.setBounds(390, 150, 90, 35);

        addBtn.addActionListener(e -> {
            double num1 = Double.parseDouble(t1.getText());
            double num2 = Double.parseDouble(t2.getText());
            double result = num1 + num2;
            JOptionPane.showMessageDialog(frame, "SUM: " + result);
        });

        subBtn.addActionListener(e -> {
            double num1 = Double.parseDouble(t1.getText());
            double num2 = Double.parseDouble(t2.getText());
            double result = num1 - num2;
            JOptionPane.showMessageDialog(frame, "DIFFERENCE: " + result);
        });

        mulBtn.addActionListener(e -> {
            double num1 = Double.parseDouble(t1.getText());
            double num2 = Double.parseDouble(t2.getText());
            double result = num1 * num2;
            JOptionPane.showMessageDialog(frame, "PRODUCT: " + result);
        });

        divBtn.addActionListener(e -> {
            double num1 = Double.parseDouble(t1.getText());
            double num2 = Double.parseDouble(t2.getText());
            if (num2 == 0)
                JOptionPane.showMessageDialog(frame, "ERROR: CANNOT DIVIDE BY ZERO!");
            else
                JOptionPane.showMessageDialog(frame, "QUOTIENT: " + (num1 / num2));
        });

        frame.add(l1);
        frame.add(t1);
        frame.add(l2);
        frame.add(t2);
        frame.add(addBtn);
        frame.add(subBtn);
        frame.add(mulBtn);
        frame.add(divBtn);

        frame.setVisible(true);
    }
}