/** Класс реализующий вызовы методов шифрования/дешифрования
 * Цезаря
 * Виженера
 * содержит внутренний клас EncryptionFunctions,
 * в котором произведены все вычисления данных способов шифрования
 */

import static simpleName.SimpleNames.CESAR_NAME;
import static simpleName.SimpleNames.VIGENERE_NAME;

import java.util.HashMap;
import java.util.Map;

public class EncryptionHelper {


  // Мапа в которую передают как ключ название метода+шафровать/расшифровать
  // и значение в которое передаем результат методов шифрование/дешифрование в виде строки
  private static final Map<String, EncryptionFunction> encryptionFunction = new HashMap<>();

  /**
   * нутренний класс, содержит методы шифрования и расшифровки Цезарь и Вижерона
   */

   static class EncryptionFunctions{
    private final int bias,
        letters;

    public EncryptionFunctions(final int bias, final int letters) {
      this.bias = bias;
      this.letters = letters;
    }
    /**
     * метод шифрования Цезаря, реализуется посредством сдвига
     * каждой нечетной буквы на 4 сивола по алфавиту в право, и
     * каждой   четной буквы на 3 сивола по алфавиту в право
     * @param c исходный текст
     * @param key ключ, который задает систему сдвига, в данном методе =null
     * @return encryptedTextCesar возвращает зашифрованную строку
     */
    public static String encryptionCesar(String c, String key){
      StringBuilder encryptedTextCesar = new StringBuilder();
      int counter = 0;
      for (char ch : c.toCharArray()) {
        //  res.append((char) (ch + 3));
        encryptedTextCesar.append((char) (ch + (counter % 2 == 0 ? 4 : 3)));
        counter++;
      }
      return encryptedTextCesar.toString();

    }
    /**
     * метод шифрования Цезаря, реализуется посредством сдвига
     * каждой нечетной буквы на 4 сивола по алфавиту в лево, и
     * каждой   четной буквы на 3 сивола по алфавиту в лево
     * @param c зашифрованный текст
     * @param key ключ, который задает систему сдвига, в данном методе =null
     * @return decryptedTextCesar возвращает зашифрованную строку
     */
    public static String decryptionCesar(String c,String key){
      StringBuilder decryptedTextCesar = new StringBuilder();
      int counter = 0;
      for (char ch : c.toCharArray()) {
        // res.append((char) (ch - 3));
        decryptedTextCesar.append((char) (ch - (counter % 2 == 0 ? 4 : 3)));
        counter++;
      }
      return decryptedTextCesar.toString();
    }

    /**
     *  метод шифрования Виженера, реализуется посредством
     *  сдвига каждого сивмола
     * @param key
     * @return
     */
    public static String encryptionVigener(String v,String key){
      StringBuilder encryptedText = new StringBuilder();
      int keyIndex = 0;

      for (int i = 0; i < v.length(); i++) {
        char c = v.charAt(i);
        if (Character.isLetter(c)) {
          //char base = Character.isUpperCase(c) ? 'А' : 'а';

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
    /////////////////////////////// TODO пересмотреть
    public String encrypt(String v, String key) {
      String encrypt = "";
      final int keyLen = key.length();
      for (int i = 0, len = v.length(); i < len; i++) {
        encrypt += (char) (((v.charAt(i) + key.charAt(i % keyLen) - 2 * this.bias) % this.letters) + this.bias);
      }
      return encrypt;
    }

    public String decrypt(String v, String key) {
      String decrypt = "";
      final int keyLen = key.length();
      for (int i = 0, len = v.length(); i < len; i++) {
        decrypt += (char) (((v.charAt(i) - key.charAt(i % keyLen) + this.letters) % this.letters) + this.bias);
      }
      return decrypt;
    }
    //////////////////
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
          }else{
            int offset = (int) (c - numberOfLatinLetters);
            int keyChar = key.charAt(keyIndex) - 'A';
            char decryptedChar = (char) ((offset - keyChar + 26) % 26 + numberOfLatinLetters);
            decryptedText.append(decryptedChar);
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
