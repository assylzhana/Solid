package interfaces;

import java.util.List;

public interface LibraryCatalog {
    void addItem(Item item);
    void removeItem(Item item);
    List<Item> getAllItems();
}