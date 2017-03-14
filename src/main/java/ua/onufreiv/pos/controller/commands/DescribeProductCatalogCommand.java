package ua.onufreiv.pos.controller.commands;

import ua.onufreiv.pos.controller.PosResponse;
import ua.onufreiv.pos.model.PosModel;
import ua.onufreiv.pos.model.product.ProductCatalog;

/**
 * Created by Yurii_Onufreiv on 14-Mar-17.
 */
public class DescribeProductCatalogCommand implements Command {
    private PosModel posModel;

    public DescribeProductCatalogCommand() {
        posModel = PosModel.getInstance();
    }

    @Override
    public PosResponse execute(String[] args) {
        ProductCatalog productCatalog = posModel.getProductCatalog();
        StringBuilder builder = new StringBuilder();
        builder.append("Available products: ")
                .append("\n")
                .append(productCatalog.getStringRepresentation());
        return new PosResponse(builder.toString());
    }
}
