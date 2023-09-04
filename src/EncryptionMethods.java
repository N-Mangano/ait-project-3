/** Enum который содержит метод выбора способа шифрования
 *
 */
import simpleName.SimpleNames;

public enum EncryptionMethods {
  CESAR(SimpleNames.CESAR_NAME),
  VIGENERE(SimpleNames.VIGENERE_NAME);


  private String simpleName;
  EncryptionMethods(String name){
    simpleName=name;
  }

  public String getSimpleName() {
    return simpleName;
  }

  public static EncryptionMethods getBySimpleName(String name){
    return switch (name) {
      case SimpleNames.CESAR_NAME->CESAR; //c
      case SimpleNames.VIGENERE_NAME->VIGENERE;// v
      default -> null;
    };
  }
}
