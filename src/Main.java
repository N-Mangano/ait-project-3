import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String text;
    MainMenu.beginning();
    boolean run = true;
    int commandMain;
    while (run) {
      commandMain = MainMenu.readCommandMainMenu(scanner);
      switch (commandMain) {
        case MainMenu.FIRST:
          text = scanner.nextLine();

          // МЕНЮ МЕТОДОВ
          boolean run1 = true;
          int commandSecondMain;
          while (run1) {
            commandSecondMain = MainMenu.readCommandSecondMenu(scanner);
            switch (commandSecondMain) {
              case MainMenu.FIRST:
                System.out.println("\u001B[32m Метод Цезаря : \u001B[0m");
                EncryptionMethods method = EncryptionMethods.CESAR;
                String key = null;
                encryptDecryptText(method, text, key);
                break;
              case MainMenu.SECOND:
                System.out.println("\u001B[32m Метод Виженера \u001B[0m");
                System.out.println("Введите ключ ->");
                key = scanner.nextLine();
                method = EncryptionMethods.VIGENERE;
                encryptDecryptText(method, text, key);
                break;
              case MainMenu.EXIT:
                System.out.println("\u001B[32m До новых встреч! \u001B[0m");
                run1 = false;
                break;
            }
          }
          break;
        case MainMenu.EXIT:
          run = false;
          break;
      }

    }
  }

  /**
   * Функция шаблон для вывода результата зашифрованного/расшифрованного текста
   *
   * @param method передается название метода который используется для шифрования
   * @param text   исходный текст, который вводит пользователь с консоли
   * @param key    ключ для метода Виженера, для метода Цезаря его значение null
   */
  private static void encryptDecryptText(EncryptionMethods method, String text, String key) {
    System.out.println(" Текст исходный  :        " + text);
    String encryptedText = EncryptionHelper.encrypt(method, text, key);
    System.out.println(" Текст зашифрован " + method + ":  " + encryptedText);

    String decryptedText = EncryptionHelper.decrypt(method, encryptedText, key);
    System.out.println(" Текст расшифрован " + method + ": " + decryptedText);
  }
}