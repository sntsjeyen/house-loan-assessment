package house_loan_assessment;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import house_loan_assessment.frames.*;

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