/** Enum который содержит
 *
 */
import static SimpleNames.*;
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
      case CESAR_NAME->CESAR;
      case VISIONER_NAME->VISIONERE;
      default -> null;
    };
  }
}
