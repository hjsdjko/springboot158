package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 农产品溯源
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-18 10:22:53
 */
@TableName("nongchanpinsuyuan")
public class NongchanpinsuyuanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public NongchanpinsuyuanEntity() {
		
	}
	
	public NongchanpinsuyuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 农产品名称
	 */
					
	private String nongchanpinmingcheng;
	
	/**
	 * 简介
	 */
					
	private String jianjie;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 播种
	 */
					
	private String bozhong;
	
	/**
	 * 成熟
	 */
					
	private String chengshu;
	
	/**
	 * 收货
	 */
					
	private String shouhuo;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：农产品名称
	 */
	public void setNongchanpinmingcheng(String nongchanpinmingcheng) {
		this.nongchanpinmingcheng = nongchanpinmingcheng;
	}
	/**
	 * 获取：农产品名称
	 */
	public String getNongchanpinmingcheng() {
		return nongchanpinmingcheng;
	}
	/**
	 * 设置：简介
	 */
	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}
	/**
	 * 获取：简介
	 */
	public String getJianjie() {
		return jianjie;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：播种
	 */
	public void setBozhong(String bozhong) {
		this.bozhong = bozhong;
	}
	/**
	 * 获取：播种
	 */
	public String getBozhong() {
		return bozhong;
	}
	/**
	 * 设置：成熟
	 */
	public void setChengshu(String chengshu) {
		this.chengshu = chengshu;
	}
	/**
	 * 获取：成熟
	 */
	public String getChengshu() {
		return chengshu;
	}
	/**
	 * 设置：收货
	 */
	public void setShouhuo(String shouhuo) {
		this.shouhuo = shouhuo;
	}
	/**
	 * 获取：收货
	 */
	public String getShouhuo() {
		return shouhuo;
	}

}
