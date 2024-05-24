import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstForm extends JFrame {
    JTextField resultTextField;
    public FirstForm() {
        GridBagConstraints constraints = new GridBagConstraints();
        GridBagLayout layout = new GridBagLayout();

        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("The distance determinator");
        this.setLayout(layout);

        JLabel label1 = new JLabel("Initial Speed: ");
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(label1, constraints);

        JTextField textField1 = new JTextField(5);
        constraints.gridx = 1;
        constraints.gridy = 1;
        this.add(textField1, constraints);

        JLabel label2 = new JLabel("Launch Angle (Only 0 - 90 degrees): ");
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(label2, constraints);

        JTextField textField2 = new JTextField(5);
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(textField2, constraints);

        JLabel label3 = new JLabel("Constant Acceleration: ");
        constraints.gridx = 0;
        constraints.gridy = 2;
        this.add(label3, constraints);

        JTextField textField3 = new JTextField(5);
        constraints.gridx = 1;
        constraints.gridy = 2;
        this.add(textField3, constraints);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double initialSpeed = Double.parseDouble(textField1.getText());
                double launchAngle = Double.parseDouble(textField2.getText());
                double constantAcceleration = Double.parseDouble(textField3.getText());

                if (launchAngle < 0 || launchAngle > 90) {
                    JOptionPane.showMessageDialog(null, "Launch Angle must be between 0 and 90 degrees.");
                    return;
                }

                launchAngle = Math.toRadians(launchAngle);

                double maximumHeight = Math.pow(initialSpeed, 2) * Math.sin(2 * launchAngle) / constantAcceleration;
                resultTextField.setText(String.format("%.2f", maximumHeight));
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 3;
        this.add(calculateButton, constraints);

        this.setVisible(true);

        JLabel resultLabel = new JLabel("Maximum Height: ");
        constraints.gridx = 0;
        constraints.gridy = 4;
        this.add(resultLabel, constraints);

        resultTextField = new JTextField(5);
        constraints.gridx = 1;
        constraints.gridy = 4;
        this.add(resultTextField, constraints);
        resultTextField.setEditable(false);
    }

    public static FirstForm launchTheApp() {
        FirstForm app = new FirstForm();
        app.setVisible(true);
        return app;
    }

    public static void main(String[] args) {

    }
}
