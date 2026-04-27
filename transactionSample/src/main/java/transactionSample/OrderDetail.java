package transactionSample;
 
//OrderDetail.java
public class OrderDetail {
 private int detailId;
 private int orderId;
 private String productId;
 private int quantity;
 private double price;
 private double subtotal;

 public int getDetailId() { return detailId; }
 public void setDetailId(int detailId) { this.detailId = detailId; }

 public int getOrderId() { return orderId; }
 public void setOrderId(int orderId) { this.orderId = orderId; }

 public String getProductId() { return productId; }
 public void setProductId(String productId) { this.productId = productId; }

 public int getQuantity() { return quantity; }
 public void setQuantity(int quantity) { this.quantity = quantity; }

 public double getPrice() { return price; }
 public void setPrice(double price) { this.price = price; }

 public double getSubtotal() { return subtotal; }
 public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
}


