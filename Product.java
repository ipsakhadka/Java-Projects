
public class Product {
  private int productid;
  private String producttype;
  private double productprice;
  private int yearofrelease;
  
  
  public Product () { // default constructor
    this.productid = 0;
    this.producttype = "";
    this.productprice = 0.0;
    this.yearofrelease = 0;
  }
  
  public Product (int productid, String producttype, double productprice, int yearofrelease) { //polymorphism
    this.productid= productid;
    this.producttype= producttype;
    this.productprice= productprice;
    this.yearofrelease = yearofrelease;
  }
  public void setProductId (int productid) {
    this.productid = productid;
  }
  public int getProductId () {
  return this.productid;
  }
  
  public void setProductType (String producttype){
  this.producttype= producttype;
  }
  public String getProductType () {
  return this.producttype;
  }
  
  public void setProductPrice (Double productprice) {
  this.productprice = productprice;
  }
  public Double getProductPrice () {
  return this.productprice;
  }
  
  public void setYearofRelease (int yearofrelease) {
  this.yearofrelease= yearofrelease; 
  }
  public int getYearofRelease () {
  return this.yearofrelease;
  }
  
  public void displayInfo () {
  System.out.printf ("\nProuduct ID:%d", getProductId ());
  System.out.print ("\nProduct Type:" + getProductType ());
  System.out.printf ("\nPrice: %.2f", getProductPrice ());
  System.out.printf ("\nRelease Year:%d", getYearofRelease ());
  }
  
  
  
  
  
  
  
}
