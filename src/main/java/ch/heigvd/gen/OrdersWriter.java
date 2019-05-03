package ch.heigvd.gen;

import java.util.Locale;

public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        JsonObject jsonRoot = new JsonObject();
        JsonArray jsonOrders = new JsonArray();

        for (int i = 0; i < orders.getOrdersCount(); i++) {
            Order order = orders.getOrder(i);
            JsonObject jsonOrder = new JsonObject();
            JsonArray jsonProducts = new JsonArray();
            jsonOrder.add("id", order.getOrderId());

            for (int j = 0; j < order.getProductsCount(); j++) {
                Product product = order.getProduct(j);
                JsonObject jsonProduct = new JsonObject();

                jsonProduct.add("code", product.getCode());
                jsonProduct.add("color", getColorFor(product));

                if (product.getSize() != Product.SIZE_NOT_APPLICABLE) {
                    jsonProduct.add("size", getSizeFor(product));
                }

                jsonProduct.add("price", product.getPrice());

                jsonProduct.add("currency", product.getCurrency());
                jsonProducts.add(jsonProduct);
            }
            jsonOrder.add("products", jsonProducts);
            jsonOrders.add(jsonOrder);
        }

        jsonRoot.add("orders", jsonOrders);

        return jsonRoot.serialize();
    }

    private String getSizeFor(Product product) {
        switch (product.getSize()) {
            case 1:
                return "XS";
            case 2:
                return "S";
            case 3:
                return "M";
            case 4:
                return "L";
            case 5:
                return "XL";
            case 6:
                return "XXL";
            default:
                return "Invalid Size";
        }
    }

    private String getColorFor(Product product) {
        switch (product.getColor()) {
            case 1:
                return "blue";
            case 2:
                return "red";
            case 3:
                return "yellow";
            default:
                return "no color";
        }
    }

    private String jsonKeyValue(String key, String value){
        return String.format("\"%s\": \"%s\"", key, value);

    }

    private String jsonKeyValue(String key, int value){
        return String.format("\"%s\": %d", key, value);
    }

    private String jsonKeyValue(String key, double value){
        return String.format(Locale.US,"\"%s\": %s", key, value);
    }
}