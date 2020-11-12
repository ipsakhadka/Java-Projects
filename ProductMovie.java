
public class ProductMovie extends Product {
  private String moviename;
  private String mainactor;
  private String mainactress;
  private String directorname;
  private String movierate;
  
  public ProductMovie () {
  super ();
  this.moviename = "";
  this.mainactor ="";
  this.mainactress = "";
  this.directorname = "";
  this.movierate = "";
  }

  
  public ProductMovie (int productid, String producttype, double productprice, int yearofrelease, String moviename, String mainactor, String mainactress, String directorname, String movierate){
  super (productid, producttype, productprice, yearofrelease);
  this.moviename = moviename;
  this.mainactor = mainactor;
  this.mainactress = mainactress;
  this.directorname = directorname;
  this.movierate = movierate;
  }
  
  public void setMovieName (String moviename) {
  this.moviename= moviename;
  }
  public String getMovieName () {
  return this.moviename;
  }
  
  public void setMainActor (String mainactor){
  this.mainactor = mainactor;
  }
  public String getMainActor () {
  return this.mainactor;
  }
  
  public void setMainActress (String mainactress){
  this.mainactress= mainactress;
  }
  public String getMainActress () {
  return this.mainactress;
  }
  
  public void setDirectorName (String directorname){
  this.directorname = directorname;
  }
  public String getDirectorName () {
  return this.directorname;
  }
  
  public void setMovieRate (String movierate) {
  this.movierate = movierate;
  }
  
  public String getMovieRate (){
  return this.movierate;
  }
  public void displayInfo () {
  System.out.printf ("Prouduct ID:%d", getProductId ());
  System.out.print ("\nProduct Type:" + getProductType ());
  System.out.print ("\nName:"+ getMovieName ());
  System.out.printf ("\nPrice: %.2f", getProductPrice ());
  System.out.printf ("\nRelease Year:%d", getYearofRelease ());
  System.out.print ("\nDirector Name:"+ getDirectorName ());
  System.out.print ("\nMain Actor:"+ getMainActor ());
  System.out.print ("\nMain Actress Name:"+ getMainActress ());
  System.out.println ("\nRate:"+ getMovieRate());
  }
  
}

