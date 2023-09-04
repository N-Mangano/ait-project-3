public class Main {

  public static void main(String[] args) {

    String text="Hello there!";
    System.out.println(" Текст исходный  :  "+text);
    String encryptedText=EncryptionHelper.encrypt(EncryptionMethods.CESAR,text);
    System.out.println(" Текст зашифрован:  "+ encryptedText);

    String decryptedText=EncryptionHelper.decrypt(EncryptionMethods.CESAR,encryptedText);
    System.out.println(" Текст расшифрован: "+ decryptedText);
///////////////////////////////////////////////////////////////////////////////////////////////////////
//    String text1="Hello there!";
//    System.out.println(" Текст исходный  :  "+text);
//    String encryptedText1=EncryptionHelper.encrypt(EncryptionMethods.CESAR,key,text);
//    System.out.println(" Текст зашифрован:  "+ encryptedText1);
//
//    String decryptedText1=EncryptionHelper.decrypt(EncryptionMethods.CESAR,key,encryptedText1);
//    System.out.println(" Текст расшифрован: "+ decryptedText1);



  }
}