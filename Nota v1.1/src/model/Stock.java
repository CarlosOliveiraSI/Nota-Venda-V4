package model;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    private List<ItemStock> items = new ArrayList<>();

    
    public void addItem(ItemStock item) {
        if (item == null || item.getQuantity() <= 0) {
            throw new IllegalArgumentException("Item ou quantidade inválida.");
        }
        items.add(item);
    }

    
    public boolean checkAvailability(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException("Produto ou quantidade inválida.");
        }
        for (ItemStock item : items) {
            if (item.getProduct().equals(product) && item.getQuantity() >= quantity) {
                return true;
            }
        }
        return false;
    }


    public boolean reduceStock(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException("Produto ou quantidade inválida.");
        }
        for (ItemStock item : items) {
            if (item.getProduct().equals(product)) {
                return item.reduceQuantity(quantity);
            }
        }
        return false; 
    }

    public void displayStock() {
        System.out.println("Estoque Atual:");
        for (ItemStock item : items) {
            System.out.println(item.getProduct().getDescription() + " - Quantidade: " + item.getQuantity());
        }
    }
}
