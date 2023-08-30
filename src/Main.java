public class Main {

  public static void main(String[] args) {
    String text="Hello there!";
    System.out.println(" Текст исходный  :  "+text);
    String encryptedText=EncryptionHelper.encrypt(EncryptionMethods.CESAR,text);
    System.out.println(" Текст зашифрован:  "+ encryptedText);

    String decryptedText=EncryptionHelper.decrypt(EncryptionMethods.CESAR,encryptedText);
    System.out.println(" Текст расшифрован: "+ decryptedText);
  }
}