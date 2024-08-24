package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.NongchanpinsuyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.NongchanpinsuyuanView;


/**
 * 农产品溯源
 *
 * @author 
 * @email 
 * @date 2024-03-18 10:22:53
 */
public interface NongchanpinsuyuanService extends IService<NongchanpinsuyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NongchanpinsuyuanView> selectListView(Wrapper<NongchanpinsuyuanEntity> wrapper);
   	
   	NongchanpinsuyuanView selectView(@Param("ew") Wrapper<NongchanpinsuyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NongchanpinsuyuanEntity> wrapper);
   	

}

