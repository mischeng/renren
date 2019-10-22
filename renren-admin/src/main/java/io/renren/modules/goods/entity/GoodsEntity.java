package io.renren.modules.goods.entity;

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
 * @date 2019-07-12 09:52:28
 */
@Data
@TableName("goods")
public class GoodsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String goodsId;
	/**
	 * 
	 */
	private String goodsName;
	/**
	 * 
	 */
	private String textarea;
	/**
	 * 
	 */
	private Float price;
	/**
	 * 
	 */
	private Integer cataloguetwoId;
	/**
	 * 
	 */
	private Date time;
	/**
	 * 
	 */
	private Integer status;
	/**
	 * 
	 */
	private Integer amount;
	/**
	 * 
	 */
	private String image;
	/**
	 * 
	 */
	@TableId
	private Integer number;

}
