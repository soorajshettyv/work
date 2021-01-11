package com.ms.bootcamp.entity;

//import javax.persistence.Embeddable;
import java.io.Serializable;

public class PrimaryKey implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long orderId;
	private int userId;
	private int productId;
    
    
    public PrimaryKey() {}
    
    public PrimaryKey(long orderId,int userId,int productId) {
		super();
		this.orderId= orderId;
		this.userId = userId;
		this.productId = productId;
		
	}

    public int getProductId() {
        return productId;
    }

    

	public void setProductId(int productId) {
        this.productId = productId;
    }

   
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}


}