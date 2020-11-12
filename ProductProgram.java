
public class ProductProgram {
  public static void main (String [] args){  
  ProductMovie p1 = new ProductMovie ();
  p1.setProductId (1);
  p1.setProductType (" Movie");
  p1.setMovieName ("Iron Man 2");
  p1.setProductPrice (9.95);
  p1.setYearofRelease (2008);
  p1.setDirectorName (" Jon Favreau");
  p1.setMainActor ("Robert Downey Jr.");
  p1.setMainActress ("Gwyneth Paltrow");
  p1.setMovieRate ("PG-13");
  p1.displayInfo ();
  
  ProductMusic p2= new ProductMusic ();
  p2.setProductId (2);
  p2.setProductType (" Music");
  p2.setArtistName ("Creed");
  p2.setAlbumName ("Full Circle");
  p2.setProductPrice (8.95);
  p2.setYearofRelease (2012);
  p2.displayInfo ();
  }
}