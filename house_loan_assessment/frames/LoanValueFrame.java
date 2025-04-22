package house_loan_assessment.frames;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import house_loan_assessment.Calculation;

public class LoanValueFrame extends MainFrame
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
            double amort = Double.NaN, income = Double.NaN, intRate = 0;    // propertyVal = Double.NaN
                
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
    
    /*
    private void resetButtonActionPerformed2(ActionEvent e)
    {
        if (e.getSource() == resetButton)
        {
            propertyValTextField.setText("");
        }
    }
    */
        
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