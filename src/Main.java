import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(
        " Данная программа поможет реализовать вам шифрование текста благодаря двум методам: ");
    System.out.println("\u001B[32m Метод Цезаря \u001B[0m" + " - реализуется посредством сдвига\n"
        + "     * каждой нечетной буквы на 4 символа по алфавите, \n"
        + "     * каждой   четной буквы на 3 символа по алфавиту. ");
    System.out.println("\u001B[32m Метод Виженера \u001B[0m" + " -  это последовательность"
        + " шифров Цезаря с различными значениями сдвига, которые задает ключ.\n");

 boolean run = true;
    while (run) {
      System.out.println("1. Введите текст шифрования/расшифровки");
      System.out.println("0. Выход");
      int command = scanner.nextInt();
      // считать пустую строку, потому что nextInt() - оставляет курсор (считыватель) на той же строке, что и число
      scanner.nextLine();
      switch (command) {
        case 1:
          String text = scanner.nextLine();
          System.out.println("Выберите метод шифрования:");
          boolean run1 = true;
          while (run1) {

            System.out.println("1 метод шифрования Цезарь");
            System.out.println("2 метод шифрования Виженера");
            System.out.println("0 Выход");
            int command1 = scanner.nextInt();
            // считать пустую строку, потому что nextInt() - оставляет курсор (считыватель) на той же строке, что и число
            scanner.nextLine();
            switch (command1) {
              case 1:
                System.out.println("\u001B[32m Метод Цезаря : \u001B[0m");
                EncryptionMethods method = EncryptionMethods.CESAR;
                String key = null;
                encryptDecryptText(method, text, key);
                break;
              case 2:
                System.out.println("\u001B[32m Метод Виженера \u001B[0m");
                key = "key";
                method = EncryptionMethods.VIGENERE;
                encryptDecryptText(method, text, key);
                break;
              case 0:
                run1 = false;
                break;
            }
          }
        case 0:
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
    private static void encryptDecryptText (EncryptionMethods method, String text, String key){
      System.out.println(" Текст исходный  :        " + text);
      String encryptedText = EncryptionHelper.encrypt(method, text, key);
      System.out.println(" Текст зашифрован " + method + ":  " + encryptedText);

      String decryptedText = EncryptionHelper.decrypt(method, encryptedText, key);
      System.out.println(" Текст расшифрован " + method + ": " + decryptedText);
    }
  }