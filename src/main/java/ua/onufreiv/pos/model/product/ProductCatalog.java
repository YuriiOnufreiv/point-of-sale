package ua.onufreiv.pos.model.product;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class ProductCatalog {
    private static ProductCatalog instance;

    private Map<String, Product> beverages;

    private ProductCatalog() {
        initializeCatalog();
    }

    public static synchronized ProductCatalog getInstance() {
        if (instance == null) {
            instance = new ProductCatalog();
        }
        return instance;
    }

    private void initializeCatalog() {
        beverages = new HashMap<>();

        try(Scanner scanner =  new Scanner(new File("catalog.txt"))) {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                String name = line[0];
                int price = Integer.parseInt(line[1]);

                beverages.put(name, new Product(name, price));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Product getByName(String productName) {
        return beverages.get(productName.toUpperCase());
    }

    public String getStringRepresentation() {
        StringBuilder builder = new StringBuilder();
        beverages.forEach((k, v) -> {
            builder.append("- " + v).append("\n");
        });
        return builder.toString();
    }
}
