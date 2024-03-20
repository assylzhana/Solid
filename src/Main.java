import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.*;
import interfaces.*;

public class Main {
    public static void main(String[] args) {
        LibraryCatalog catalog = new Library();
        LibrarianService librarianService = new LibrarianService(catalog);
        Scanner scanner = new Scanner(System.in);

        boolean continueSession = true;
        while (continueSession) {
            System.out.println("Choose an option:");
            System.out.println("1. Sign in");
            System.out.println("2. Sign up");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter username:");
                    String username = scanner.nextLine();
                    User user = authenticateUser(username);
                    if (user != null) {
                        librarianService.setCurrentUser(user);
                        System.out.println("Welcome, " + username + "!");
                        if (user.isLibrarian()) {
                            System.out.println("You are logged in as a librarian.");
                        } else {
                            System.out.println("You are logged in as a simple user.");
                        }
                    } else {
                        System.out.println("Invalid username. Please try again.");
                    }
                    break;
                case 2:
                    System.out.println("Enter username:");
                    String newUsername = scanner.nextLine();
                    System.out.println("Choose user type (1 for librarian, 2 for simple user):");
                    int userType = scanner.nextInt();
                    scanner.nextLine();
                    if (userType == 1) {
                        librarianService.setCurrentUser(new Librarian(newUsername));
                        System.out.println("Librarian account created successfully!");
                    } else if (userType == 2) {
                        librarianService.setCurrentUser(new SimpleUser(newUsername));
                        System.out.println("Simple user account created successfully!");
                    } else {
                        System.out.println("Invalid user type.");
                    }
                    break;
                case 3:
                    continueSession = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            while (librarianService.isLoggedIn()) {
                System.out.println("Choose an option:");
                System.out.println("1. View catalog");
                System.out.println("2. Logout");

                if (librarianService.getCurrentUser().isLibrarian()) {
                    System.out.println("3. Add item to catalog");
                    System.out.println("4. Remove item from catalog");
                }

                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        librarianService.printCatalog();
                        break;
                    case 2:
                        librarianService.setCurrentUser(null);
                        break;
                    case 3:
                        if (librarianService.getCurrentUser().isLibrarian()) {
                            System.out.println("Enter item type (book/magazine/cd):");
                            String itemType = scanner.nextLine().toLowerCase();
                            Item newItem = createItem(itemType, scanner);
                            if (newItem != null) {
                                librarianService.addItemToCatalog(newItem);
                            }
                        } else {
                            System.out.println("Invalid option.");
                        }
                        break;
                    case 4:
                        if (librarianService.getCurrentUser().isLibrarian()) {
                            System.out.println("Enter the title of the item to remove:");
                            String title = scanner.nextLine();
                            removeItemByTitle(title, catalog, librarianService);
                        } else {
                            System.out.println("Invalid option.");
                        }
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }

        scanner.close();
    }

    private static User authenticateUser(String username) {
        List<User> users = new ArrayList<>();
        users.add(new Librarian("librarian"));
        users.add(new SimpleUser("user"));

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }

    private static Item createItem(String itemType, Scanner scanner) {
        switch (itemType) {
            case "book":
                System.out.println("Enter book title:");
                String bookTitle = scanner.nextLine();
                System.out.println("Enter book author:");
                String bookAuthor = scanner.nextLine();
                return new Book(bookTitle, bookAuthor);
            case "magazine":
                System.out.println("Enter magazine title:");
                String magazineTitle = scanner.nextLine();
                System.out.println("Enter magazine issue number:");
                int magazineIssueNumber = scanner.nextInt();
                scanner.nextLine();
                return new Magazine(magazineTitle, magazineIssueNumber);
            case "cd":
                System.out.println("Enter CD title:");
                String cdTitle = scanner.nextLine();
                System.out.println("Enter CD artist:");
                String cdArtist = scanner.nextLine();
                return new CD(cdTitle, cdArtist);
            default:
                System.out.println("Invalid item type.");
                return null;
        }
    }
    private static void removeItemByTitle(String title, LibraryCatalog catalog, LibrarianService librarianService) {
        if (!librarianService.getCurrentUser().isLibrarian()) {
            System.out.println("You don't have permission to remove items from the catalog.");
            return;
        }

        List<Item> items = catalog.getAllItems();
        for (Item item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                librarianService.removeItemFromCatalog(item);
                return;
            }
        }
        System.out.println("Item not found in catalog: " + title);
    }
}
