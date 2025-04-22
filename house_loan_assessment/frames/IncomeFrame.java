package house_loan_assessment.frames;

import javax.swing.*;
import house_loan_assessment.Calculation;

public class IncomeFrame extends AmortizationFrame
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