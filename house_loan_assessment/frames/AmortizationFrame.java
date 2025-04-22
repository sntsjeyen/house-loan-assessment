package house_loan_assessment.frames;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import house_loan_assessment.Calculation;

public class AmortizationFrame extends MainFrame
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