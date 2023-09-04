import static org.junit.jupiter.api.Assertions.*;

class EncryptionHelperTest {

  @org.junit.jupiter.api.Test
  void encrypt() {
    EncryptionHelper.EncryptionFunctions h = new EncryptionHelper.EncryptionFunctions(1072, 32);
   // String key = "eee";
    //String t1 = "werwer";
     String key = "ключ";
    String t1 = "привет мир";

    String out = h.encrypt(t1, key);
    System.out.println(t1 + " ---> " + out);
    String t2 = h.decrypt(out, key);
    System.out.println(out + "-->" +t2);
  }

  @org.junit.jupiter.api.Test
  void decrypt() {
  }
}