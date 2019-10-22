package io.renren.modules.sysstudent.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-07-23 10:34:01
 */
@Data
@TableName("order_i")
public class OrderIEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer numble;
	/**
	 * 
	 */
	private String orderId;
	/**
	 * 
	 */
	private String userId;
	/**
	 * 
	 */
	private Integer status;
	/**
	 * 
	 */
	private String address;
	/**
	 * 
	 */
	private String receiver;
	/**
	 * 
	 */
	private String phone;
	/**
	 * 
	 */
	private Float money;
	/**
	 * 
	 */
	private Date time;

}
