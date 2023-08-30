import static simpleName.SimpleNames.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class EncryptionHelper {
  private static final Map<String, EncryptionFunction> encryptionFunction =new HashMap<>();

  static{                                                   //Map<String    , EncryptionFunction>
    encryptionFunction.put(CESAR_NAME + "encrypt", c-> {      //с encrypt , Khoor#wkhuh$
      StringBuilder res=new StringBuilder();
      int counter=0;
      for(char ch:c.toCharArray()){
        res.append((char)(ch+3));
        //TODO Hello there!
        res.append((char)(ch+(counter%2==0 ? 4 : 3)));
        counter++;
      }
      return res.toString();
    });
    encryptionFunction.put(CESAR_NAME + "decrypt", c-> { //с decrypt , Hello there!
      StringBuilder res=new StringBuilder();
      int counter=0;
      for(char ch:c.toCharArray()){
        res.append((char)(ch-3));
        //TODO
       // res.append((char)(ch-(counter%2==0 ? 4 : 3)));
      //  counter++;
      }
      return res.toString();
    });

  }

  public static String encrypt(EncryptionMethods method, String text) {
    return switch (method) {
      case CESAR ->encryptionFunction.get(method.getSimpleName() + "encrypt").process(text);
      case VISIONERE -> "";
    };
  }

  public static String decrypt(EncryptionMethods method, String text){
     return switch (method){
        case CESAR -> encryptionFunction.get(method.getSimpleName()+"decrypt").process(text);
        case VISIONERE -> "";
      };
  }

}
