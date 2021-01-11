package com.ms.bootcamp.entity;

//import javax.persistence.Embeddable;
import java.io.Serializable;

public class PrimaryKey implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private int productId;
    
    
    public PrimaryKey() {}
    
    public PrimaryKey(int userId,int productId) {
		super();
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


}