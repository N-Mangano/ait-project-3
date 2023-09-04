import simpleName.SimpleNames;

public class Main {

  public static void main(String[] args) {

    EncryptionMethods method = EncryptionMethods.CESAR;
    String key = null;
    String text = "Hello there!";

    encryptDecryptText(method, text, key);
///////////////////////////////////////////////////////////////////////////////////////////////////////
//    String text1="Hello there!";
//    System.out.println(" Текст исходный  :  "+text);
//    String encryptedText1=EncryptionHelper.encrypt(EncryptionMethods.CESAR,key,text);
//    System.out.println(" Текст зашифрован:  "+ encryptedText1);
//
//    String decryptedText1=EncryptionHelper.decrypt(EncryptionMethods.CESAR,key,encryptedText1);
//    System.out.println(" Текст расшифрован: "+ decryptedText1);

    key = "key";
    text = "Hello there222!";
    method = EncryptionMethods.VIGENERE;

    encryptDecryptText(method, text, key);

  }

  private static void encryptDecryptText(EncryptionMethods method, String text, String key) {
    System.out.println(" Текст исходный  : " + text);
    String encryptedText = EncryptionHelper.encrypt(method, text, key);
    System.out.println(" Текст зашифрован " + method + ": " + encryptedText);

    String decryptedText = EncryptionHelper.decrypt(method, encryptedText, key);
    System.out.println(" Текст расшифрован " + method + ": " + decryptedText);
  }
}