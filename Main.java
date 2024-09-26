import java.util.Scanner;

public class Main {
    public static String[] todos = new String[2];
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showTodoList() {
        System.out.println("TODO LIST");
        for (int i = 0; i < todos.length; i++) {
            String todo = todos[i];
            if (todos[i] != null) {
                System.out.println((i + 1) + ". " + todo);
            }
        }
    }

    public static void addTOdoList (String todo) {
        resizeArrayIfFull();


        for (int i =  0; i <todos.length; i++) {
            if (todos[i] == null) {
                todos[i] = todo;
                break;
            }
        }
    }

    private static void resizeArrayIfFull() {
        boolean isFull = isArrayFull();

        if (isFull) {
            resizeArrayToTwoTimesBigger();

        }
    }

    private static void resizeArrayToTwoTimesBigger() {
        String[] temp = todos;
        todos = new String[todos.length * 2];
        for (int i = 0; i < temp.length; i++) {
            todos[i] = temp[i];
        }
    }

    private static boolean isArrayFull() {
        boolean isFull = true;
        for (int i = 0; i < todos.length; i++) {
            if (todos[i] == null) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }
    public static boolean removeTodoList(Integer number) {
        if (isSelectedTodoNotValid(number)) return false;
        for (int i = number - 1; i < todos.length; i++) {
            // if todo is the last element
            if (i == (todos.length - 1)) {
                todos[i] = null;
            } else {
                //replace with the the element on the right
                todos[i] = todos[i + 1];
            }
        }
        return true;
    }

    private static boolean isSelectedTodoNotValid(Integer number) {
        if (number <= 0) {
            return true;
        }
        if (number - 1 > todos.length - 1) {
            return true;
        }
        if (todos [number - 1] == null) {
            return true;
        }
        return false;
    }
    public static boolean editTodoList(Integer number, String newTodo) {
        if (isSelectedTodoNotValid(number)) {
            return false;
        }
        todos[number - 1] = newTodo;
        return true;
    }
    public static void showMainMenu() {
        boolean isRunnung = true;
        while (isRunnung) {
            showTodoList();
            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Edit");
            System.out.println("4. Keluar");
            System.out.println("Pilih : ");
            String selectedMenu = scanner.nextLine();
            switch (selectedMenu) {
                case "1":
                    // showMenuAddTodoList();
                    System.out.println("Menu add todo list");
                    break;

                case "2":
                    //showMenuRemoveTodoList();
                    System.out.println("Menu remove todo list");
                    break;

                case "3":
                    //showMenuEditTodoList();
                    System.out.println("Menu edit todo list");
                    break;

                case "4":
                    isRunnung = false;
                    break;

                default:
                    System.out.println("Pilih menu dengan benar");
            }
        }
    }
}