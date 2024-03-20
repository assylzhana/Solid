package models;

import interfaces.Item;
import interfaces.LibraryCatalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library implements LibraryCatalog {
    private List<Item> catalog;

    public Library() {
        this.catalog = new ArrayList<>();
    }

    @Override
    public void addItem(Item item) {
        catalog.add(item);
        System.out.println("Item added to catalog: " + item.getTitle());
    }

    @Override
    public void removeItem(Item item) {
        catalog.remove(item);
        System.out.println("Item removed from catalog: " + item.getTitle());
    }

    @Override
    public List<Item> getAllItems() {
        return Collections.unmodifiableList(catalog);
    }
}