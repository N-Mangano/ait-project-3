import static simpleName.SimpleNames.CESAR_NAME;

import java.util.HashMap;
import java.util.Map;

public class EncryptionHelper {

  //Мапа длдя хранения результатов шифрования и дешифрования
  // методом Цезаря
  private static final Map<String, EncryptionFunction> encryptionFunction = new HashMap<>();

  private static class EncryptionFunctions{
    public static String encryptionCesar(String c){
      StringBuilder res = new StringBuilder();
      int counter = 0;
      for (char ch : c.toCharArray()) {
        //  res.append((char) (ch + 3));
        res.append((char) (ch + (counter % 2 == 0 ? 4 : 3)));
        counter++;
      }
      return res.toString();

    }
    public static String decryptionCesar(String c){
      StringBuilder res = new StringBuilder();
      int counter = 0;
      for (char ch : c.toCharArray()) {
        // res.append((char) (ch - 3));
        res.append((char) (ch - (counter % 2 == 0 ? 4 : 3)));
        counter++;
      }
      return res.toString();

    }

  }
  static {
    encryptionFunction.put(CESAR_NAME + "encrypt", EncryptionFunctions::encryptionCesar);
    encryptionFunction.put(CESAR_NAME + "decrypt", EncryptionFunctions::decryptionCesar);
  }

/////////////////////////////////////////////////////////////////////////////////////////////////////


  public static String encrypt(EncryptionMethods method, String text) {
    return switch (method) {
      case CESAR -> encryptionFunction.get(method.getSimpleName() + "encrypt").process(text);
      case VISIONERE -> "";
    };
  }

  public static String decrypt(EncryptionMethods method, String text) {
    return switch (method) {
      case CESAR -> encryptionFunction.get(method.getSimpleName() + "decrypt").process(text);
      case VISIONERE -> "";
    };
  }

}
