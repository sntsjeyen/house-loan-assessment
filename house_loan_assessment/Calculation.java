package house_loan_assessment;

public class Calculation
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
