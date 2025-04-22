package house_loan_assessment.frames;

import java.awt.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class MainFrame
{
    // Frame and decimal format setup for the value computation 
    String pattern = "###,###.##";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);
    JFrame f = new JFrame();
    GridBagConstraints c = new GridBagConstraints();
    
    // Labels
    JLabel heading = new JLabel("", JLabel.CENTER);
    JLabel subheading = new JLabel("  Provide the required information below.  ", JLabel.CENTER);
    JLabel loanAmtLabel = new JLabel("Loan Amount");
    JLabel tenureLabel = new JLabel("Tenure (Monthly)");
    JLabel intRateLabel = new JLabel("Interest Rate (%)");
    JLabel amortLabel = new JLabel("Monthly Amortization");
    JLabel incomeLabel = new JLabel("Gross Monthly Income");
    JLabel propertyValLabel = new JLabel("Estimated Property Value");
    JLabel resultLabel = new JLabel("The computed value for the ");
    
    // Guide labels
    JLabel loanAmtGuide = new JLabel("Enter the amount/value of desired loan not below PHP 500,000.");
    JLabel tenureGuide = new JLabel("Select the number of years for repayment period.");
    JLabel intRateGuide = new JLabel("Select the interest rate or preferred fixed pricing period.");
    JLabel amortGuide = new JLabel("Enter estimated monthly payment.");
    JLabel incomeGuide = new JLabel("Enter estimated monthly income.");
    JLabel propertyValGuide = new JLabel("Enter estimated value of the property.");
    
    // Text fields
    JTextField loanAmtTextField = new JTextField(15);
    JTextField amortTextField = new JTextField(15);
    JTextField incomeTextField = new JTextField(15);
    JTextField propertyValTextField = new JTextField(15);
    
    // Buttons
    JButton calcButton = new JButton("CALCULATE");
    JButton resetButton = new JButton("RESET");
    
    // Arrays for combo boxes
    String tenureOptions[] = {"Select tenure", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
    String intRateOptions[] = {"Select interest rate", "6.25% (Fixed for 1–2 years)", "6.75% (Fixed for 3 years)", "7.25% (Fixed for 4–5 years)"};
    
    // Combo boxes
    JComboBox<String> tenureBox = new JComboBox<>(tenureOptions);
    JComboBox<String> intRateBox = new JComboBox<>(intRateOptions);
    
    public MainFrame()
    {
        // Setting layout and visibility for frame
        f.setLayout(new GridBagLayout());
        f.setVisible(true);
        
        // Setting and adding the heading to the value computation frame
        c.insets = new Insets(15, 0, 0, 0);
        c.gridx = 0; c.gridy = 0; c.gridwidth = 4;
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Century Gothic", Font.BOLD, 25));
        f.add(heading, c);
        
        // Setting and adding the subheading to the value computation frame
        c.insets = new Insets(3, 0, 10, 0);
        c.gridx = 0; c.gridy = 1; c.gridwidth = 4;
        subheading.setForeground(Color.RED);
        subheading.setFont(new Font("Verdana", Font.BOLD, 14));
        f.add(subheading, c);
    }
}