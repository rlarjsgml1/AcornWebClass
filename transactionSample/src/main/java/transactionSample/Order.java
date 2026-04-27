package transactionSample;

 

import java.util.Date;
public class Order {
    private int orderId;
    private String customerId;
    private java.sql.Date orderDate;
    private double totalAmount;
    private String status;

    // Getter / Setter
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public java.sql.Date getOrderDate() { return orderDate; }
    public void setOrderDate(java.sql.Date orderDate) { this.orderDate = orderDate; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
