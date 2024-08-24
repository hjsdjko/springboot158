package com.cl.dao;

import com.cl.entity.NongchanpinsuyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.NongchanpinsuyuanView;


/**
 * 农产品溯源
 * 
 * @author 
 * @email 
 * @date 2024-03-18 10:22:53
 */
public interface NongchanpinsuyuanDao extends BaseMapper<NongchanpinsuyuanEntity> {
	
	List<NongchanpinsuyuanView> selectListView(@Param("ew") Wrapper<NongchanpinsuyuanEntity> wrapper);

	List<NongchanpinsuyuanView> selectListView(Pagination page,@Param("ew") Wrapper<NongchanpinsuyuanEntity> wrapper);
	
	NongchanpinsuyuanView selectView(@Param("ew") Wrapper<NongchanpinsuyuanEntity> wrapper);
	

}
