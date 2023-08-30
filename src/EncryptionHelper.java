import static simpleName.SimpleNames.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class EncryptionHelper {
  private static final Map<String, EncryptionFunction> encryptionFunction =new HashMap<>();

  static{
    encryptionFunction.put(CESAR_NAME + "encrypt", c-> {
      StringBuilder res=new StringBuilder();
      int counter=0;
      for(char ch:c.toCharArray()){
        res.append((char)(ch+3));
        //res.append((char)(ch+(counter%2==0 ? 4 : 3)));
      }
      return res.toString();
    });
    encryptionFunction.put(CESAR_NAME + "decrypt", c-> {
      StringBuilder res=new StringBuilder();
      for(char ch:c.toCharArray()){
        res.append((char)(ch-3));
        //res.append((char)(ch-(counter%2==0 ? 4 : 3)));
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
