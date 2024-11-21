package model;

public class ItemStock {
    private Product product;
    private int quantity;

    public ItemStock(Product product, int quantity) {
        if (product == null || quantity < 0) {
            throw new IllegalArgumentException("Produto ou quantidade inválida.");
        }
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean reduceQuantity(int quantity) {
        if (quantity <= 0 || quantity > this.quantity) {
            return false;
        }
        this.quantity -= quantity;
        return true;
    }
}
