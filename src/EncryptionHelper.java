import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static SimpleNames.*;
public class EncryptionHelper {
  private static final Map<String, EncryptionFunction> encryptionFunction =new HashMap<>();

  static{
    encryptionFunction.put(CESAR_NAME + "encrypt", s-> {
      StringBuilder res=new StringBuilder();
      for(char ch:s.toCharArray()){
        res.append(ch+3)
      }
      return res.toString();
    });


    encryptionFunction.put(CESAR_NAME + "decrypt", s-> "hello");

  }

  public static String encrypt(EncryptionMethods methods, String text){
    return "";
  }
  public static String decrypt(EncryptionMethods methods, String text){
    return "";
  }

}
