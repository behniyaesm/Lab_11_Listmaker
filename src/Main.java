import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) {
        ArrayList<String> myArrList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        String itemChoice = "";

        do {
            itemChoice = displayMenu(sc, myArrList);
            switch (itemChoice) {
                case "A":
                    addItem(sc, myArrList);
                    break;
                case "D":
                    deleteItem(sc, myArrList);
                    break;
                case "I":
                    insertItem(sc, myArrList);
                    break;
                case "P":
                    printitems(sc, myArrList);
                    break;
                case "Q":
                case "q":
                    if (SafeInput.getYNConfirm(sc, "Are you sure you want to quit?")) {
                        done = true;
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");

            }
        } while (!done);
    }

    private static String displayMenu(Scanner sc, ArrayList<String> itemList) {
        if (itemList.isEmpty()) {
            System.out.println("You have not entered any items!");
        } else {
            System.out.println("This is the current list");
            for (int i = 0; i < itemList.size(); i++) {
                System.out.printf(" %d. %s\n", i + 1, itemList.get(i));
            }
        }
        return SafeInput.getRegExString(sc, "Type one of these letters to select:\n A: Add\n D: Delete\n I: Insert\n P: Print\n Q: Quit\n", "[AaDdIiPpQq]").toUpperCase();
    }


    public static void addItem(Scanner sc, ArrayList<String> itemList) {
        String addItem = SafeInput.getNonZeroLenString(sc,"Enter the item to add");
        itemList.add(addItem);
        System.out.println("Item added to the list");
    }

    public static void deleteItem(Scanner sc, ArrayList<String> itemList) {
        int deleteItem = SafeInput.getRangedInt(sc,"Enter the item number to delete", 1, itemList.size());
        itemList.remove(deleteItem - 1);
    }

    private static void insertItem(Scanner sc, ArrayList<String> itemList) {
        String insertItem = SafeInput.getNonZeroLenString(sc,"Enter the item to insert");
        int position = SafeInput.getRangedInt(sc,"Enter the position to insert at", 1, itemList.size() + 1) - 1;
        itemList.add(position, insertItem);
        System.out.println("Item inserted.");
    }

    private static void printitems(Scanner sc, ArrayList<String> itemList) {
        if (itemList.isEmpty()) {
            System.out.println("You have not entered any items!");
        } else {
            System.out.println("This is the current list");
            for (int i = 0; i < itemList.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, itemList.get(i));
            }
        }
    }


}