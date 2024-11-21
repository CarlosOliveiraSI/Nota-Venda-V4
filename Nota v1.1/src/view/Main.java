package view;

import model.*;

public class Main {
    public static void main(String[] args) {
        
        Stock stock = new Stock();

        Product p1 = new Product();
        p1.setCode("at");
        p1.setDescription("Produto A");
        p1.setPrice(100.0);

        Product p2 = new Product();
        p2.setCode("ff");
        p2.setDescription("Produto B");
        p2.setPrice(50.0);

        Product p3 = new Product();
        p3.setCode("msa");
        p3.setDescription("Produto C");
        p3.setPrice(75.0);

        stock.addItem(new ItemStock(p1, 10));
        stock.addItem(new ItemStock(p2, 5));
        stock.addItem(new ItemStock(p3, 8));

        
        Sale sale = new Sale();
        sale.createSaleItem("at", 2); 
        sale.createSaleItem("ff", 1); 
        sale.createSaleItem("msa", 2); 

        
        sale.setPaymentMethod("c"); 

       
        System.out.println("Itens da Venda:");
        for (String item : sale.getItems()) {
            System.out.println(item);
        }

        System.out.println(String.format("Total: %.2f", sale.getTotal()));
        System.out.println(String.format("Forma de pagamento: '%s'", sale.getPaymentMethod()));

        
        SalesManager manager = new SalesManager(stock);
        boolean success = manager.processSale(sale);

        
        if (success) {
            System.out.println(String.format("Valor a ser pago: R$%.2f", sale.getFinalPrice()));
            System.out.println("Venda realizada com sucesso!");
        } else {
            System.out.println("Falha na venda. Verifique o estoque.");
        }

        
        System.out.println("\nEstoque Atualizado:");
        stock.displayStock();
    }
}
