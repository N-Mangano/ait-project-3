public class Vigenere {
  private String key;

  public Vigenere(String key) {
    this.key = key;
  }
  public String encrypt(String text) {
    StringBuilder encryptedText = new StringBuilder();
    int keyIndex = 0;

    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      if (Character.isLetter(c)) {
        char numberOfCyrillicLetters = Character.isUpperCase(c) ? 'А' : 'а';
        char numberOfLatinLetters = Character.isUpperCase(c) ? 'A' : 'a';


}
