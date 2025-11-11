import javax.swing.*;

public class StudentForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("STUDENT REGISTRATION FORM");
        frame.setSize(400, 350);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("NAME:");
        nameLabel.setBounds(50, 50, 100, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(150, 50, 190, 25);

        JLabel ageLabel = new JLabel("AGE:");
        ageLabel.setBounds(50, 90, 100, 25);
        JTextField ageField = new JTextField();
        ageField.setBounds(150, 90, 190, 25);

        JLabel genderLabel = new JLabel("GENDER:");
        genderLabel.setBounds(50, 130, 100, 25);
        JRadioButton male = new JRadioButton("MALE");
        male.setBounds(150, 130, 70, 25);
        JRadioButton female = new JRadioButton("FEMALE");
        female.setBounds(230, 130, 80, 25);
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        JLabel courseLabel = new JLabel("COURSE:");
        courseLabel.setBounds(50, 170, 100, 25);
        String courses[] = {"BCA", "B.Sc", "B.Tech","M.Tech","BBA","MBA", "MCA"};
        JComboBox courseBox = new JComboBox(courses);
        courseBox.setBounds(150, 170, 130, 25);

        JButton submitButton = new JButton("SUBMIT");
        submitButton.setBounds(150, 220, 100, 30);

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(ageLabel);
        frame.add(ageField);
        frame.add(genderLabel);
        frame.add(male);
        frame.add(female);
        frame.add(courseLabel);
        frame.add(courseBox);
        frame.add(submitButton);

        submitButton.addActionListener(e -> {
            String name = nameField.getText().toUpperCase();
            String age = ageField.getText().toUpperCase();
            String gender = male.isSelected() ? "MALE" : (female.isSelected() ? "FEMALE" : "NOT SELECTED");
            String course = courseBox.getSelectedItem().toString().toUpperCase();

            JFrame display = new JFrame("STUDENT DETAILS");
            display.setSize(350, 250);
            display.setLayout(null);

            JLabel d1 = new JLabel("NAME: " + name);
            d1.setBounds(50, 40, 250, 25);
            JLabel d2 = new JLabel("AGE: " + age);
            d2.setBounds(50, 70, 250, 25);
            JLabel d3 = new JLabel("GENDER: " + gender);
            d3.setBounds(50, 100, 250, 25);
            JLabel d4 = new JLabel("COURSE: " + course);
            d4.setBounds(50, 130, 250, 25);

            display.add(d1);
            display.add(d2);
            display.add(d3);
            display.add(d4);
            display.setVisible(true);
        });

        frame.setVisible(true);
    }
}