package com.cl.entity.view;

import com.cl.entity.NongchanpinsuyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 农产品溯源
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-18 10:22:53
 */
@TableName("nongchanpinsuyuan")
public class NongchanpinsuyuanView  extends NongchanpinsuyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public NongchanpinsuyuanView(){
	}
 
 	public NongchanpinsuyuanView(NongchanpinsuyuanEntity nongchanpinsuyuanEntity){
 	try {
			BeanUtils.copyProperties(this, nongchanpinsuyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
