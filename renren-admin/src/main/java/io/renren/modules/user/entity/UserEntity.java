package io.renren.modules.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author xx
 * @email xx
 * @date 2019-07-17 15:40:39
 */
@TableName("user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer number;
	/**
	 * 
	 */
	private String userId;
	/**
	 * 
	 */
	private String userName;
	/**
	 * 
	 */
	private String userPassword;
	/**
	 * 
	 */
	private String question;
	/**
	 * 
	 */
	private String answer;
	/**
	 * 
	 */
	private String phone;
	/**
	 * 
	 */
	private String images;

	/**
	 * 设置：
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
	/**
	 * 获取：
	 */
	public Integer getNumber() {
		return number;
	}
	/**
	 * 设置：
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	/**
	 * 获取：
	 */
	public String getUserPassword() {
		return userPassword;
	}
	/**
	 * 设置：
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * 获取：
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * 设置：
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * 获取：
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * 设置：
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：
	 */
	public void setImages(String images) {
		this.images = images;
	}
	/**
	 * 获取：
	 */
	public String getImages() {
		return images;
	}
}
