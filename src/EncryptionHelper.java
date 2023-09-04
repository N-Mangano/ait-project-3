import static simpleName.SimpleNames.*;

import java.util.HashMap;
import java.util.Map;

public class EncryptionHelper {

  //Мапа длдя хранения результатов шифрования и дешифрования
  // методом Цезаря
  private static final Map<String, EncryptionFunction> encryptionFunction = new HashMap<>();

  private static class EncryptionFunctions{
    public static String encryptionCesar(String c, String key){
      StringBuilder res = new StringBuilder();
      int counter = 0;
      for (char ch : c.toCharArray()) {
        //  res.append((char) (ch + 3));
        res.append((char) (ch + (counter % 2 == 0 ? 4 : 3)));
        counter++;
      }
      return res.toString();

    }
    public static String decryptionCesar(String c,String key){
      StringBuilder res = new StringBuilder();
      int counter = 0;
      for (char ch : c.toCharArray()) {
        // res.append((char) (ch - 3));
        res.append((char) (ch - (counter % 2 == 0 ? 4 : 3)));
        counter++;
      }
      return res.toString();
    }
    public static String encryptionVigener(String v,String key){
      StringBuilder encryptedText = new StringBuilder();
      int keyIndex = 0;

      for (int i = 0; i < v.length(); i++) {
        char c = v.charAt(i);
        if (Character.isLetter(c)) {
          char numberOfCyrillicLetters = Character.isUpperCase(c) ? 'А' : 'а';
          char numberOfLatinLetters = Character.isUpperCase(c) ? 'A' : 'a';
          // если КИРИЛЛИЦА
          if (c>1040) {
            int offset = (int) (c - numberOfCyrillicLetters);
            int keyChar = key.charAt(keyIndex) - 'А';
            char encryptedChar = (char) ((offset + keyChar) % 32 + numberOfCyrillicLetters);
            encryptedText.append(encryptedChar);
            keyIndex = (keyIndex + 1) % key.length();
            // если ЛАТИНИЦА
          } else {
            int offset = (int) (c - numberOfLatinLetters);
            int keyChar = key.charAt(keyIndex) - 'A';
            char encryptedChar = (char) ((offset + keyChar) % 26 + numberOfLatinLetters);
            encryptedText.append(encryptedChar);
            keyIndex = (keyIndex + 1) % key.length();
          }

        } else {
          encryptedText.append(c);
        }
      }
      return encryptedText.toString();
    }
    public static String decryptionVigener(String v,String key){
      StringBuilder decryptedText = new StringBuilder();
      int keyIndex = 0;

      for (int i = 0; i < v.length(); i++) {
        char c = v.charAt(i);
        if (Character.isLetter(c)) {
          char numberOfCyrillicLetters = Character.isUpperCase(c) ? 'А' : 'а';
          char numberOfLatinLetters = Character.isUpperCase(c) ? 'A' : 'a';
          // если КИРИЛЛИЦА
          if (c>1040) {
            int offset = (int) (c - numberOfCyrillicLetters);
            int keyChar = key.charAt(keyIndex) - 'А';
            char encryptedChar = (char) ((offset + keyChar) % 32 + numberOfCyrillicLetters);
            decryptedText.append(encryptedChar);
            keyIndex = (keyIndex + 1) % key.length();
            // если ЛАТИНИЦА
          } else {
            int offset = (int) (c - numberOfLatinLetters);
            int keyChar = key.charAt(keyIndex) - 'A';
            char encryptedChar = (char) ((offset + keyChar) % 26 + numberOfLatinLetters);
            decryptedText.append(encryptedChar);
            keyIndex = (keyIndex + 1) % key.length();
          }

        } else {
          decryptedText.append(c);
        }
      }
      return decryptedText.toString();
    }
   }
  static {
    encryptionFunction.put(CESAR_NAME + "encrypt", EncryptionFunctions::encryptionCesar);
    encryptionFunction.put(CESAR_NAME + "decrypt", EncryptionFunctions::decryptionCesar);
    encryptionFunction.put(VIGENERE_NAME + "encrypt", EncryptionFunctions::encryptionVigener);
    encryptionFunction.put(VIGENERE_NAME + "decrypt", EncryptionFunctions::decryptionVigener);
  }

/////////////////////////////////////////////////////////////////////////////////////////////////////


  public static String encrypt(EncryptionMethods method, String text,String key) {
    return switch (method) {
      case CESAR -> encryptionFunction.get(method.getSimpleName() + "encrypt").process(text,null);
      case VIGENERE -> encryptionFunction.get(method.getSimpleName() + "encrypt").process(text,key);
    };
  }

  public static String decrypt(EncryptionMethods method, String text, String key) {
    return switch (method) {
      case CESAR -> encryptionFunction.get(method.getSimpleName() + "decrypt").process(text,null);
      case VIGENERE -> encryptionFunction.get(method.getSimpleName() + "decrypt").process(text,key);
    };
  }

}
