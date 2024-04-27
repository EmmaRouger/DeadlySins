/**
 * Sin21 deals with using the correct cryptography
 * this is a file with two examples of such, the first being a bad example and the second is a good one
 * Mason Myre
 * 
 * 
 */

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;


public class Sin21 {
    
    public static void main(String[] args) {
        goodExample();
    }

    
    public static void badExample(){
        try{
            KeyGenerator generator = KeyGenerator.getInstance("DES"); //des is not secure
            SecretKey k = generator.generateKey();

            Cipher c = Cipher.getInstance("DES/ECB/PKCS5Padding"); //des is vulnerable to burte force attacks
            c.init(Cipher.ENCRYPT_MODE, k);

            byte[] text = "the encrypted message".getBytes("UTF8");

            byte[] encrypted = c.doFinal(text);

            System.out.println("Encrypted message: " + encrypted);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //had to look up the docs on how to use AES and DES
    public static void goodExample(){
        try{
            KeyGenerator gen = KeyGenerator.getInstance("AES"); //AES is the standard strong encryption protocol
            gen.init(256);
            SecretKey k = gen.generateKey();

            Cipher c = Cipher.getInstance("AES/GCM/NoPadding");
            final int AES_KEY_SIZE = 128;

            GCMParameterSpec spec = new GCMParameterSpec(AES_KEY_SIZE, new byte[12]);

            c.init(Cipher.ENCRYPT_MODE, k, spec);

            byte[] text = "the better encrypted message".getBytes("UTF8");

            byte[] encrypted = c.doFinal(text);

            System.out.println("Encrypted Message: " + encrypted);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }






}
