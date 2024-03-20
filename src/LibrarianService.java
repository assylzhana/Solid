import interfaces.Item;
import interfaces.LibraryCatalog;
import interfaces.User;

import java.util.List;
import java.util.List;

public class LibrarianService {
    private LibraryCatalog catalog;
    private User currentUser;

    public LibrarianService(LibraryCatalog catalog) {
        this.catalog = catalog;
        this.currentUser = null;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public boolean isLibrarian() {
        return isLoggedIn() && currentUser.isLibrarian();
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void addItemToCatalog(Item item) {
        if (!isLoggedIn()) {
            System.out.println("Please log in to add items.");
            return;
        }

        if (!isLibrarian()) {
            System.out.println("Only librarians can add items.");
            return;
        }

        catalog.addItem(item);
    }

    public void removeItemFromCatalog(Item item) {
        if (!isLoggedIn()) {
            System.out.println("Please log in to remove items.");
            return;
        }

        if (!isLibrarian()) {
            System.out.println("Only librarians can remove items.");
            return;
        }

        catalog.removeItem(item);
    }

    public void printCatalog() {
        if (!isLoggedIn()) {
            System.out.println("Please log in to view the catalog.");
            return;
        }

        List<Item> items = catalog.getAllItems();
        System.out.println("Catalog:");
        for (Item item : items) {
            System.out.println("- " + item.getTitle());
        }
    }
}
