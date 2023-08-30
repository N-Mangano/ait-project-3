public class Main {

  public static void main(String[] args) {
    String text="Hello there!";
    String encryptedText=EncryptionHelper.encrypt(EncryptionMethods.CESAR,text);
    System.out.println(" Текст зашифрован:  "+ encryptedText);

    String decryptedText=EncryptionHelper.encrypt(EncryptionMethods.CESAR,text);
    System.out.println(" Текст расшифрован: "+ decryptedText);
  }
}