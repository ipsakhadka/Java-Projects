
public class ProductMusic extends Product {
private String artistname;
private String albumname;

public ProductMusic () {
super ();
this.artistname= artistname;
this.albumname= albumname;
}

public ProductMusic (int productid, String producttype, double productprice, int yearofrelease, String artistname, String albumname){
super (productid, producttype, productprice, yearofrelease);
this.artistname= artistname;
this.albumname= albumname;
}

public void setArtistName (String artistname) {
this.artistname = artistname;
}

public String getArtistName () {
return this.artistname;
}
public void setAlbumName (String albumname) {
this.albumname = albumname;
}

public String getAlbumName () {
return this.albumname;
}

public void displayInfo () {
  System.out.printf ("\nProuduct ID:%d", getProductId ());
  System.out.print ("\nProduct Type:" + getProductType ());
  System.out.print ("\nArtist:"+ getArtistName ());
  System.out.print ("\nAlbum:"+ getAlbumName ());
  System.out.printf ("\nPrice: %.2f", getProductPrice ());
  System.out.printf ("\nRelease Year:%d", getYearofRelease ());
}
}