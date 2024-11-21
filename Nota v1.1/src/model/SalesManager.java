package model;

public class SalesManager {
    private Stock stock;

    public SalesManager(Stock stock) {
        this.stock = stock;
    }

    
        for (SaleItem saleItem : sale.getItemsObject()) {
            Product product = saleItem.getProduct();
            int quantity = saleItem.getQuantity();

            if (!stock.checkAvailability(product, quantity)) {
                System.out.println("Produto indisponível no estoque: " + product.getDescription());
                return false;
            }
        }

       
        for (SaleItem saleItem1 : sale.getItemsObject()) {
            Product product = saleItem.getProduct();
            int quantity = saleItem.getQuantity();

            boolean reduced = stock.reduceStock(product, quantity);
            if (!reduced) {
                System.out.println("Erro ao reduzir o estoque para o produto: " + product.getDescription());
                return false;
            }
        }

   
        System.out.println("Venda concluída. Valor final: " + sale.getFinalPrice());
        return true;
    }
}
