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
        res.append(ch+3);
      }
      return res.toString();
    });
    encryptionFunction.put(CESAR_NAME + "decrypt", s-> {
      StringBuilder res=new StringBuilder();
      for(char ch:s.toCharArray()){
        res.append(ch-3);
      }
      return res.toString();
    });

  }

  public static String encrypt(EncryptionMethods method, String text) {
    return switch (method) {
      case CESAR -> encryptionFunction.get(method.getSimpleName() + "encrypt").process(text);
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
