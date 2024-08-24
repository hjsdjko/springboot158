package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.NongchanpinsuyuanDao;
import com.cl.entity.NongchanpinsuyuanEntity;
import com.cl.service.NongchanpinsuyuanService;
import com.cl.entity.view.NongchanpinsuyuanView;

@Service("nongchanpinsuyuanService")
public class NongchanpinsuyuanServiceImpl extends ServiceImpl<NongchanpinsuyuanDao, NongchanpinsuyuanEntity> implements NongchanpinsuyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NongchanpinsuyuanEntity> page = this.selectPage(
                new Query<NongchanpinsuyuanEntity>(params).getPage(),
                new EntityWrapper<NongchanpinsuyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NongchanpinsuyuanEntity> wrapper) {
		  Page<NongchanpinsuyuanView> page =new Query<NongchanpinsuyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<NongchanpinsuyuanView> selectListView(Wrapper<NongchanpinsuyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NongchanpinsuyuanView selectView(Wrapper<NongchanpinsuyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
