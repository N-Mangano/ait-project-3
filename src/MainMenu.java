import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
  public static final int FIRST = 1;
  public static final int SECOND = 2;
  public static final int EXIT = 0;
  public static final int INCORRECT = -1;
  public static void toDivide(){
    System.out.println("---------------------------------------");
  }
  public static void mainMenu() {
    toDivide();
    System.out.println(FIRST + ". Введите текст шифрования/расшифровки");
    System.out.println(EXIT + ". Выход");

  }
  protected static boolean isCommandMenu(int command) {
    switch (command) {
      case FIRST:
      case EXIT:
        return true;
      default:
        return false;
    }
  }
  protected static int readCommandMainMenu(Scanner scanner){
    int command = INCORRECT;
    while (!isCommandMenu(command)) {
      mainMenu();
      System.out.print("Выберите команду: ");
      try {
        command = scanner.nextInt();
        if (!isCommandMenu(command)) {
          System.out.println("Некорректный номер команды: " + command);
        }
      } catch (InputMismatchException e) {
        System.out.println("Некорректный ввод, введите номер команды!");
      } finally {
        scanner.nextLine();
      }
    }
    return command;
  }

  protected static void secondMenu() {
    toDivide();
    System.out.println("Выберите метод шифрования:");
    System.out.println(FIRST + ". метод шифрования Цезарь");
    System.out.println(SECOND+". метод шифрования Виженера");
    System.out.println(EXIT + ". Вернуться в предыдущее меню");

  }

  protected static boolean isCommandSecondMenu(int command) {
    switch (command) {
      case FIRST:
      case SECOND:
      case EXIT:
        return true;
      default:
        return false;
    }
  }
  protected static int readCommandSecondMenu(Scanner scanner){
    int command = INCORRECT;
    while (!isCommandSecondMenu(command)) {
      secondMenu();
      System.out.print("Выберите команду: ");
      try {
        command = scanner.nextInt();
        if (! isCommandSecondMenu(command)) {
          System.out.println("Некорректный номер команды: " + command);
        }
      } catch (InputMismatchException e) {
        System.out.println("Некорректный ввод, введите номер команды!");
      } finally {
        scanner.nextLine();
      }
    }
    return command;
  }
  public static void beginning() {
    System.out.println(
        " Данная программа поможет реализовать вам шифрование текста благодаря двум методам: ");
    System.out.println("\u001B[32m Метод Цезаря \u001B[0m" + " - реализуется посредством сдвига\n"
        + "     * каждой нечетной буквы на 4 символа по алфавите, \n"
        + "     * каждой   четной буквы на 3 символа по алфавиту. ");
    System.out.println("\u001B[32m Метод Виженера \u001B[0m" + " -  это последовательность"
        + " шифров Цезаря с различными значениями сдвига, которые задает ключ.\n");

  }

  }

