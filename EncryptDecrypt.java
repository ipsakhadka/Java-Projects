import java.util.Scanner;

public class EncryptDecrypt{
    public static void main(String args[]) {
      
      Scanner input= new Scanner(System.in);       

       System.out.println ("Decrypt this:");
       //recommendation: zngtq eua mktoay 
      String original= input.nextLine ();
        String decrypted = encrypt(original,-6);
        System.out.println(decrypted);
        
        System.out.println ("Encrypt this:");
      String msg= input.nextLine ();
      String encrypt = encrypt (msg,5); 
       System.out.println(encrypt);
       
    }
    public static String encrypt(String str, int num){
      
      //Scanner input= new Scanner(System.in);
        String x = "";
        //System.out.print ("i=");
        //int i= input.nextInt ();
        for(int i = 0; i < str.length(); i++){
            char temp = str.charAt(i);
            //if whitespace, leave it like that
            if(Character.isWhitespace(temp)){
                x += " ";
            }else{
                //if we provide +ve #, then this function will encrypt
                if(num >= 0){
                    if(temp+num > 'z'){
                    x+= (char)((temp+num)-'z'+'a'-1);
                    }else{
                        x+=(char)(temp+num);
                    }
                }
                //else it will decrease. for eg: -6 will decrypt a string
                else{
                    if(temp+num < 'a'){
                    x+=(char)('z' - ('a'-(temp+num+1)));
                    
                    }else{
                        x+=(char)(temp+num);
                    }
             
                }
               
            }
        }
  
        return x;
    }
}
    