public class DivideAndException {
  public static void main (String [] args) {
  
    int numerator = 10;
    int denominator = 0;// if denominator is 0 then the result is not printed
    try {
      if (denominator == 0)
        throw new DivideByZeroException ();
      
    int result = numerator / denominator;
    System.out.printf ("%d / %d = %d", numerator,denominator, result);
    
    }
    
   // catch (Exception e) {
     // System.out.println (e.toString ());
      //System.out.println (e.getMessage());
      //System.out.println ("Can't divide by zero");
    
    //}
    
    catch (DivideByZeroException d) {
    System.out.println (d.toString ());
    }
    
    System.out.println ("\nEnd Successfully");// use if-else to get a result.
  }
}