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
        // если КИРИЛЛИЦА
        if (c>1040) {
          int offset = (int) (c - numberOfCyrillicLetters);
          int keyChar = key.charAt(keyIndex) - 'А';
          char encryptedChar = (char) ((offset + keyChar) % 32 + numberOfCyrillicLetters);
          encryptedText.append(encryptedChar);
          keyIndex = (keyIndex + 1) % key.length();
          // если ЛАТИНИЦА
        } else {
          int offset = (int) (c - numberOfLatinLetters);
          int keyChar = key.charAt(keyIndex) - 'A';
          char encryptedChar = (char) ((offset + keyChar) % 26 + numberOfLatinLetters);
          encryptedText.append(encryptedChar);
          keyIndex = (keyIndex + 1) % key.length();
        }

      } else {
        encryptedText.append(c);
      }
    }
    return encryptedText.toString();
  }





}
