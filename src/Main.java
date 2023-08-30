public class Main {

  public static void main(String[] args) {
    String text="Hello there!";
    System.out.println(" Текст исходный  :  "+text);
    String encryptedText=EncryptionHelper.encrypt(EncryptionMethods.CESAR,text);
    System.out.println(" Текст зашифрован:  "+ encryptedText);

    String decryptedText=EncryptionHelper.decrypt(EncryptionMethods.CESAR,encryptedText);
    System.out.println(" Текст расшифрован: "+ decryptedText);

    /* TODO
  // если код символа  больше A-я
    if((int)ch<=1040 & (int)ch>1104 ){
  // будет выполняться код для русской клавиатуры
    }
    else {
      //код для английской
    } */
  }
}