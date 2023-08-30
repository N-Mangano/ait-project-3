/** Enum который содержит метод выбора способа шифрования
 *
 */
import simpleName.SimpleNames;

public enum EncryptionMethods {
  CESAR(SimpleNames.CESAR_NAME),
  VISIONERE(SimpleNames.VISIONER_NAME);


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
      case SimpleNames.VISIONER_NAME->VISIONERE;// v
      default -> null;
    };
  }
}
