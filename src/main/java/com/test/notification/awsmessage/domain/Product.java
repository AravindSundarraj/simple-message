package com.test.notification.awsmessage.domain;


public class Product {



    private String productId;
    private String productName;
    private long qtypack;
    private String refillStatus;
    private long remainingQtyPack;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getQtypack() {
        return qtypack;
    }

    public void setQtypack(long qtypack) {
        this.qtypack = qtypack;
    }

    public String getRefillStatus() {
        return refillStatus;
    }

    public void setRefillStatus(String refillStatus) {
        this.refillStatus = refillStatus;
    }

    public long getRemainingQtyPack() {
        return remainingQtyPack;
    }

    public void setRemainingQtyPack(long remainingQtyPack) {
        this.remainingQtyPack = remainingQtyPack;
    }
}
