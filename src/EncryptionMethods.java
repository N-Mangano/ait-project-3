public enum EncryptionMethods {
  /**
   *
   */
  CESAR("c"),
  VISIONERE("v");


  private String simpleName;
  EncryptionMethods(String name){
    simpleName=name;
  }

  public String getSimpleName() {
    return simpleName;
  }
  public static EncryptionMethods getBySimpleName(String name){
    return switch (name) {
      case "c"->CESAR;
      case "v"->VISIONERE;
      default -> null;
    }
  }
}
