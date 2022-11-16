import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

class MainFrame
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
    JComboBox tenureBox = new JComboBox(tenureOptions);
    JComboBox intRateBox = new JComboBox(intRateOptions);
    
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

class AmortizationFrame extends MainFrame
{
    public void showFrame()
    {
        // Setting title and label for heading
        f.setTitle("Monthly Amortization");
        heading.setText("Monthly Amortization");
        
        // Setting general constraints for the radio buttons
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(10, 10, 0, 0);
        
        // Setting and adding the loan amount label to the value computation frame
        c.gridx = 0; c.gridy = 2; c.gridwidth = 1;
        loanAmtLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        f.add(loanAmtLabel, c);
        
        // Setting and adding the tenure label to the value computation frame
        c.gridx = 0; c.gridy = 4; c.gridwidth = 1;
        tenureLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        f.add(tenureLabel, c);

        // Setting and adding the interest rate label to the value computation frame
        c.gridx = 0; c.gridy = 6; c.gridwidth = 1;
        intRateLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        f.add(intRateLabel, c);
        
        // Setting and adding the loan amount text field to the value computation frame
        c.gridx = 1; c.gridy = 2; c.gridwidth = 1;
        f.add(loanAmtTextField, c);
        
        // Setting and adding the tenure box to the value computation frame
        c.gridx = 1; c.gridy = 4; c.gridwidth = 1;
        tenureBox.setFont(new Font("Verdana", Font.PLAIN, 14));
        f.add(tenureBox, c);
        
        // Setting and adding the interest rate box to the value computation frame
        c.gridx = 1; c.gridy = 6; c.gridwidth = 1;
        intRateBox.setFont(new Font("Verdana", Font.PLAIN, 14));
        f.add(intRateBox, c);
        
        // Setting general constraints for the option guide labels
        c.insets = new Insets(-2, 10, 0, 0);
        
        // Setting and adding the guide label for loan amount to the value computation frame
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
        loanAmtGuide.setForeground(Color.GRAY);
        loanAmtGuide.setFont(new Font("Futura", Font.BOLD | Font.ITALIC, 11));
        f.add(loanAmtGuide, c);
        
        // Setting and adding the guide label for tenure to the value computation frame
        c.gridx = 0; c.gridy = 5; c.gridwidth = 2;
        tenureGuide.setForeground(Color.GRAY);
        tenureGuide.setFont(new Font("Futura", Font.BOLD | Font.ITALIC, 11));
        f.add(tenureGuide, c);
        
        // Setting and adding the guide label for interest rate to the value computation frame
        c.gridx = 0; c.gridy = 7; c.gridwidth = 2;
        intRateGuide.setForeground(Color.GRAY);
        intRateGuide.setFont(new Font("Futura", Font.BOLD | Font.ITALIC, 11));
        f.add(intRateGuide, c);
        
        // Setting general constraints for the buttons
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(20, 0, 10, 10);
        
        // Setting and adding the calculate button to the frame
        c.gridx = 2; c.gridy = 8; c.gridwidth = 1;
        f.add(calcButton, c);
        
        // Setting and adding the reset button to the frame
        c.gridx = 3; c.gridy = 8; c.gridwidth = 1;
        f.add(resetButton, c);
        
        // Frame is given its preferred size
        f.pack();
        
        // Adding action listener for calculate button
        calcButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                calcButtonActionPerformed(e);
            }
        });
        
        // Adding action listener for reset button
        resetButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                resetButtonActionPerformed(e);
            }
        });
    }
    
    public void calcButtonActionPerformed(ActionEvent e)
    {
        try
        {
            int tenure, intRateChoice = intRateBox.getSelectedIndex();
            double loanAmt, intRate = 0;
            
            loanAmt = Double.parseDouble(loanAmtTextField.getText());
            tenure = Integer.parseInt((String)tenureBox.getSelectedItem());
            
            switch(intRateChoice)
            {
            case 1:
                intRate = 0.0625;
                break;
            case 2:
                intRate = 0.0675;
                break;
            case 3:
                intRate = 0.0725;
                break;
            }
            
            if (loanAmt < 500000 || intRateChoice == 0)
            {
                JOptionPane.showMessageDialog(null, "Please input/select information accordingly.", "Message", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                computeValue(loanAmt, tenure, intRate);
            }
            
        }
        catch (NumberFormatException exc)
        {
            JOptionPane.showMessageDialog(null, "Please input/select information accordingly.", "Message", JOptionPane.WARNING_MESSAGE);
        }
    
    }
    
    private void resetButtonActionPerformed(ActionEvent e)
    {
        if (e.getSource() == resetButton)
        {
            loanAmtTextField.setText("");
            tenureBox.setSelectedIndex(0);
            intRateBox.setSelectedIndex(0);
        }
    }
    
    public void computeValue(double loanAmt, int tenure, double intRate)
    {
        Calculation calc = new Calculation();
        calc.setLoanAmt(loanAmt);
        calc.setTenure(tenure);
        calc.setIntRate(intRate);
        String result = decimalFormat.format(calc.getAmort());
        JOptionPane.showMessageDialog(null, "Monthly amortization would be PHP " + result + ".", "Result", JOptionPane.INFORMATION_MESSAGE);
    }
    
}

class IncomeFrame extends AmortizationFrame
{    
    public void showFrame()
    {
        // Setting title and label for heading
        super.showFrame();
        f.setTitle("Gross Monthly Income");
        heading.setText("Gross Monthly Income");
        
    }
    
    public void computeValue(double loanAmt, int tenure, double intRate)
    {
        Calculation calc = new Calculation();
        calc.setLoanAmt(loanAmt);
        calc.setTenure(tenure);
        calc.setIntRate(intRate);
        String result = decimalFormat.format(calc.getIncome());
        JOptionPane.showMessageDialog(null, "Monthly income would be PHP " + result + ".", "Result", JOptionPane.INFORMATION_MESSAGE);
    }
}

class LoanValueFrame extends MainFrame
{
    public void showFrame(int val)
    {
        // Setting the title and heading
        f.setTitle("Estimated Loan Value");
        heading.setText("Estimated Loan Value");
        
        // Setting general constraints
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(10, 10, 0, 0);
        
        if (val == 2)
        {   
            // Setting and adding the loan amount label to the value computation frame
            c.gridx = 0; c.gridy = 2; c.gridwidth = 1;
            propertyValLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
            f.add(propertyValLabel, c);
            
            // Setting and adding the property value text field
            c.gridx = 1; c.gridy = 2; c.gridwidth = 1;
            propertyValTextField.setFont(new Font("Verdana", Font.PLAIN, 14));
            f.add(propertyValTextField, c);
            
            // Setting and adding the guide label for property value
            c.insets = new Insets(-2, 10, 0, 0);
            c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
            propertyValGuide.setForeground(Color.GRAY);
            propertyValGuide.setFont(new Font("Futura", Font.BOLD | Font.ITALIC, 11));
            f.add(propertyValGuide, c);
            
            // Setting the general constraints for the buttons
            c.anchor = GridBagConstraints.EAST;
            c.insets = new Insets(20, 0, 10, 10);
            
            // Setting and adding the calculate button to the frame
            c.gridx = 2; c.gridy = 4; c.gridwidth = 1;
            f.add(calcButton, c);
        
            // Setting and adding the reset button to the frame
            c.gridx = 3; c.gridy = 4; c.gridwidth = 1;
            f.add(resetButton, c);
            
            // Frame is given its preferred size
            f.pack();
            
            // Adding action listener for calculate button
            calcButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    calcButtonActionPerformed2(e);
                }
            });
        
            // Adding action listener for reset button
            resetButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    resetButtonActionPerformed(e);
                }
            });
        }
        
        else if (val == 0 || val == 1)
        {
            // Setting and adding the amortization label to the value computation frame
            c.gridx = 0; c.gridy = 2; c.gridwidth = 1;
            amortLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
            f.add(amortLabel, c);
            
            // Setting and adding the tenure label to the value computation frame
            c.gridx = 0; c.gridy = 4; c.gridwidth = 1;
            tenureLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
            f.add(tenureLabel, c);
    
            // Setting and adding the interest rate label to the value computation frame
            c.gridx = 0; c.gridy = 6; c.gridwidth = 1;
            intRateLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
            f.add(intRateLabel, c);
            
            // Setting and adding the amortization text field to the value computation frame
            c.gridx = 1; c.gridy = 2; c.gridwidth = 1;
            f.add(amortTextField, c);
            
            // Setting and adding the tenure box to the value computation frame
            c.gridx = 1; c.gridy = 4; c.gridwidth = 1;
            tenureBox.setFont(new Font("Verdana", Font.PLAIN, 14));
            f.add(tenureBox, c);
            
            // Setting and adding the interest rate box to the value computation frame
            c.gridx = 1; c.gridy = 6; c.gridwidth = 1;
            intRateBox.setFont(new Font("Verdana", Font.PLAIN, 14));
            f.add(intRateBox, c);
            
            // Setting general constraints for guide labels
            c.insets = new Insets(-2, 10, 0, 0);
            
            // Setting and adding the guide label for loan amount to the value computation frame
            c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
            amortGuide.setForeground(Color.GRAY);
            amortGuide.setFont(new Font("Futura", Font.BOLD | Font.ITALIC, 11));
            f.add(amortGuide, c);
            
            // Setting and adding the tenure guide label for tenure to the value computation frame
            c.gridx = 0; c.gridy = 5; c.gridwidth = 2;
            tenureGuide.setForeground(Color.GRAY);
            tenureGuide.setFont(new Font("Futura", Font.BOLD | Font.ITALIC, 11));
            f.add(tenureGuide, c);
            
            // Setting and adding the interest rate guide label for interest rate to the value computation frame
            c.gridx = 0; c.gridy = 7; c.gridwidth = 2;
            intRateGuide.setForeground(Color.GRAY);
            intRateGuide.setFont(new Font("Futura", Font.BOLD | Font.ITALIC, 11));
            f.add(intRateGuide, c);
            
            // Setting general constraints for the buttons
            c.anchor = GridBagConstraints.EAST;
            c.insets = new Insets(20, 0, 10, 10);
            
            // Setting and adding the calculate button to the frame
            c.gridx = 2; c.gridy = 8; c.gridwidth = 1;
            f.add(calcButton, c);
            
            // Setting and adding the reset button to the frame
            c.gridx = 3; c.gridy = 8; c.gridwidth = 1;
            f.add(resetButton, c);
            
            if (val == 1)
            {
                // Setting and adding the income label to the value computation frame
                c.anchor = GridBagConstraints.WEST;
                c.insets = new Insets(10, 10, 0, 0);
                c.gridx = 0; c.gridy = 2; c.gridwidth = 1;
                incomeLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
                f.remove(amortLabel); f.add(incomeLabel, c);
                
                // Setting and adding the income text field to the value computation frame
                c.gridx = 1; c.gridy = 2; c.gridwidth = 1;
                f.remove(amortTextField); f.add(incomeTextField, c);
                
                // Setting and adding the guide label for income to the value computation frame
                c.insets = new Insets(-2, 10, 0, 0);
                c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
                incomeGuide.setForeground(Color.GRAY);
                incomeGuide.setFont(new Font("Futura", Font.BOLD | Font.ITALIC, 11));
                f.remove(amortGuide); f.add(incomeGuide, c);
            }
            
            // Frame is given its preferred size
            f.pack();
            
            // Adding action listener for calculate button
            calcButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    calcButtonActionPerformed1(e);
                }
            });
            
            // Adding action listener for reset button
            resetButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    resetButtonActionPerformed(e);
                }
            });
        
        }
     
    }
    
    public void calcButtonActionPerformed1(ActionEvent e)
    {
        try
        {
            int tenure, intRateChoice = intRateBox.getSelectedIndex();
            double amort = Double.NaN, income = Double.NaN, propertyVal = Double.NaN, intRate = 0;
                
            tenure = Integer.parseInt((String)tenureBox.getSelectedItem());
            
            switch(intRateChoice)
            {
            case 1:
                intRate = 0.0625;
                break;
            case 2:
                intRate = 0.0675;
                break;
            case 3:
                intRate = 0.0725;
                break;
            }
            
            if (intRate == 0)
            {
                JOptionPane.showMessageDialog(null, "Please input/select information accordingly.", "Message", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                if (amortTextField.isShowing())
                {
                    amort = Double.parseDouble(amortTextField.getText());
                    computeLoan(amort, income, tenure, intRate);
                }
                else if (incomeTextField.isShowing())
                {
                    income = Double.parseDouble(incomeTextField.getText());
                    computeLoan(amort, income, tenure, intRate);
                }
            }

        }
        catch (NumberFormatException exc)
        {
            JOptionPane.showMessageDialog(null, "Please input/select information accordingly.", "Message", JOptionPane.WARNING_MESSAGE);
        }
    
    }
    
    private void calcButtonActionPerformed2(ActionEvent e)
    {
        try
        {
            double propertyVal = Double.parseDouble(propertyValTextField.getText());
            computeLoan(propertyVal);
        }
        catch (NumberFormatException exc)
        {
            JOptionPane.showMessageDialog(null, "Please input/select information accordingly.", "Message", JOptionPane.WARNING_MESSAGE);
        }
    
    }
    
    private void resetButtonActionPerformed(ActionEvent e)
    {
        if (e.getSource() == resetButton)
        {
            amortTextField.setText("");
            incomeTextField.setText("");
            propertyValTextField.setText("");
            tenureBox.setSelectedIndex(0);
            intRateBox.setSelectedIndex(0);
        }
    }
    
    private void resetButtonActionPerformed2(ActionEvent e)
    {
        if (e.getSource() == resetButton)
        {
            propertyValTextField.setText("");
        }
    }
        
    public void computeLoan(double amort, double income, int tenure, double intRate)
    {
        Calculation calc = new Calculation();
        calc.setAmort(amort);
        calc.setIncome(income);
        calc.setTenure(tenure);
        calc.setIntRate(intRate);
        
        if (amortTextField.isShowing() == true)
        {
            String result = decimalFormat.format(calc.getLoanAmt1());
            JOptionPane.showMessageDialog(null, "Estimated loan value would be PHP " + result + ".", "Result", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (incomeTextField.isShowing() == true)
        {
            String result = decimalFormat.format(calc.getLoanAmt2());
            JOptionPane.showMessageDialog(null, "Estimated loan value would be PHP " + result + ".", "Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void computeLoan(double propertyVal)     
    {
        Calculation calc = new Calculation();
        calc.setPropertyVal(propertyVal);
        String result = decimalFormat.format(calc.getLoanAmt3());
        JOptionPane.showMessageDialog(null, "Estimated loan value would be PHP " + result + ".", "Result", JOptionPane.INFORMATION_MESSAGE);
    }

}

class Calculation
{
    private double l;       // Loan amount
    private int t;          // Tenure
    private double r;       // Interest rate
    private double a;       // Amortization
    private double i;       // Income
    private double p;       // Property value
    private double base;    // Base for calculation
    private double expo;    // Exponent for calculation
    
    public void setLoanAmt(double l)        // Sets the loan amount
    {
        this.l = l;
    }
    
    public void setTenure(int t)            // Sets the tenure
    {
        this.t = t;
    }

    public void setIntRate(double r)        // Sets the interest rate
    {
        this.r = r;
    }
    
    public void setAmort(double a)          // Sets the monthly amortization
    {
        this.a = a;
    }
    
    public void setIncome(double i)         // Sets the monthly income
    {
        this.i = i;
    }
    
    public void setPropertyVal(double p)    // Sets the property value
    {
        this.p =p;
    }
    
    public double getAmort()                // Returns the monthly amortization
    {
        base = 1 + (r / 12);
        expo = t * 12;
        a = (l * (r / 12) * Math.pow(base, expo)) / (Math.pow(base, expo) - 1);
        return a;
    }
    
    public double getIncome()               // Returns the monthly income
    {
        a = getAmort();
        i = a / 0.40;
        return i;
    }
    
    public double getLoanAmt1()             // Returns the loan amount based on amortization
    {
        base = 1 + (r / 12);
        expo = t * 12;
        l = (a * (Math.pow(base, expo) - 1)) / ((r / 12) * Math.pow(base, expo));
        return l;
    }
    
    public double getLoanAmt2()             // Returns the loan amount based on income
    {
        base = 1 + (r / 12);
        expo = t * 12;
        a = i * 0.40;
        l = (a * (Math.pow(base, expo) - 1)) / ((r / 12) * Math.pow(base, expo));
        return l;
    }
    
    public double getLoanAmt3()             // Returns the loan amount based on property value
    {
        l = p * 0.80;
        return l;
    }
}

public class HouseLoanAssessment extends JFrame
{
    // Labels
    JLabel heading = new JLabel("  HOUSING LOAN AFFORDABILITY ASSESSMENT  ", JLabel.CENTER);
    JLabel subheading = new JLabel("Please select an option to determine any of the following:", JLabel.CENTER);
    JLabel optionGuide1 = new JLabel("Calculate the required monthly payment for desired loan value.");
    JLabel optionGuide2 = new JLabel("Calculate the required gross monthly income for desired loan value.");
    JLabel optionGuide3 = new JLabel("Calculate the loan value based on amortization, income, or property value.");
    
    // Radio buttons
    JRadioButton option1 = new JRadioButton("Monthly Amortization");
    JRadioButton option2 = new JRadioButton("Gross Monthly Income");
    JRadioButton option3 = new JRadioButton("Loan Value Based on");
    ButtonGroup optionGroup = new ButtonGroup();
    
    // Buttons
    JButton selectButton = new JButton("SELECT");
    JButton exitButton = new JButton("EXIT");
    
    // Combo box
    String loanValueOptions[] = {"Amortization", "Income", "Property Value"};
    JComboBox loanValueBox = new JComboBox(loanValueOptions);
    
    public HouseLoanAssessment()
    {
        // Frame setup for the main menu 
        setTitle("Housing Loan Affordability Assessment");
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        // Setting and adding the heading to the frame
        c.insets = new Insets(10, 0, 0, 0);
        c.gridx = 0; c.gridy = 0; c.gridwidth = 4;
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Century Gothic", Font.BOLD, 25));
        getContentPane().add(heading, c);
        
        // Setting and adding the subheading to the frame
        c.insets = new Insets(3, 0, 0, 0);
        c.gridx = 0; c.gridy = 1; c.gridwidth = 4;
        subheading.setForeground(Color.RED);
        subheading.setFont(new Font("Verdana", Font.BOLD, 14));
        getContentPane().add(subheading, c);
        
        // Adding the radio button for each option to the option button group
        optionGroup.add(option1);
        optionGroup.add(option2);
        optionGroup.add(option3);
        
        // Setting general constraints for the radio buttons
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(5, 10, 0, 0);
        
        // Setting and adding the first option to the frame
        c.gridx = 0; c.gridy = 2; c.gridwidth = 2;
        option1.setFont(new Font("Verdana", Font.PLAIN, 14));
        getContentPane().add(option1, c);
        
        // Setting and adding the second option to the frame
        c.gridx = 0; c.gridy = 4; c.gridwidth = 2;
        option2.setFont(new Font("Verdana", Font.PLAIN, 14));
        getContentPane().add(option2, c);
        
        // Setting and adding the third option to the frame
        c.gridx = 0; c.gridy = 6; c.gridwidth = 1;
        option3.setFont(new Font("Verdana", Font.PLAIN, 14));
        getContentPane().add(option3, c);
        
        // Setting and adding the box of loan value options to the frame
        c.gridx = 1; c.gridy = 6; c.gridwidth = 1;
        loanValueBox.setFont(new Font("Verdana", Font.PLAIN, 12));
        getContentPane().add(loanValueBox, c);
        loanValueBox.setEnabled(false);
        
        // Setting general constraints for the option guide labels
        c.insets = new Insets(-2, 32, 0, 0);
        
        // Setting and adding the guide label for the first option to the frame
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
        optionGuide1.setForeground(Color.GRAY);
        optionGuide1.setFont(new Font("Futura", Font.BOLD | Font.ITALIC, 11));
        getContentPane().add(optionGuide1, c);
        
        // Setting and adding the guide label for the second option to the frame
        c.gridx = 0; c.gridy = 5; c.gridwidth = 2;
        optionGuide2.setForeground(Color.GRAY);
        optionGuide2.setFont(new Font("Futura", Font.BOLD | Font.ITALIC, 11));
        getContentPane().add(optionGuide2, c);
        
        // Setting and adding the guide label for the third option to the frame
        c.gridx = 0; c.gridy = 7; c.gridwidth = 2;
        optionGuide3.setForeground(Color.GRAY);
        optionGuide3.setFont(new Font("Futura", Font.BOLD | Font.ITALIC, 11));
        getContentPane().add(optionGuide3, c);
        
        // Setting general constraints for the buttons
        c.insets = new Insets(10, 0, 10, 10);
        
        // Setting and adding the select button to the frame
        c.gridx = 2; c.gridy = 8; c.gridwidth = 1;
        getContentPane().add(selectButton, c);
        
        // Setting and adding the exit button to the frame
        c.gridx = 3; c.gridy = 8; c.gridwidth = 1;
        getContentPane().add(exitButton, c);
        
        // Frame is given its preferred size
        pack();
        
        // Adding an item listener for the third option
        option3.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                option3ActionPerformed(e);
            }
            
        });
        
        // Adding an action listener for the select button
        selectButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                selectButtonActionPerformed(e);
            }
        });
        
        // Adding an action listener for the exit button
        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                exitButtonActionPerformed(e);
            }
        });
    }
    
    private void option3ActionPerformed(ItemEvent e)
    {
        if(e.getStateChange() == ItemEvent.SELECTED)
        {
            loanValueBox.setEnabled(true);
        }
        else if(e.getStateChange() == ItemEvent.DESELECTED)
        {
            loanValueBox.setEnabled(false);
        }
    
    }
    
    private void selectButtonActionPerformed(ActionEvent e)
    {
        int val = loanValueBox.getSelectedIndex();
        if(option1.isSelected())
        {
            AmortizationFrame a = new AmortizationFrame();
            a.showFrame();
        }
        else if(option2.isSelected())
        {
            IncomeFrame i = new IncomeFrame();
            i.showFrame();
        }
        else if(option3.isSelected())
        {
            LoanValueFrame l = new LoanValueFrame();
            l.showFrame(val);
        }
    }
    
    private void exitButtonActionPerformed(ActionEvent e)
    {
        JFrame f = new JFrame();
        int exitOption = JOptionPane.showConfirmDialog(f, "Are you sure?", "Confirm Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (exitOption == 1)
        {
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        else
        {
            JOptionPane.showMessageDialog(f, "Exiting application . . .");
            System.exit(0);
        }
    
    }
    
    public static void main(String[] args)
    {
        new HouseLoanAssessment().show();    
    }
}