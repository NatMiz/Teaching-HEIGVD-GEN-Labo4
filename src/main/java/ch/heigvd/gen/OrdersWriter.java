package ch.heigvd.gen;

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
                jsonProduct.add("color", product.getColor().toString());

                if (product.getSize() != Size.SIZE_NOT_APPLICABLE) {
                    jsonProduct.add("size", product.getSize().toString());
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
}