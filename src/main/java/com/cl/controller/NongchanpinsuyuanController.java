package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.NongchanpinsuyuanEntity;
import com.cl.entity.view.NongchanpinsuyuanView;

import com.cl.service.NongchanpinsuyuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 农产品溯源
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-18 10:22:53
 */
@RestController
@RequestMapping("/nongchanpinsuyuan")
public class NongchanpinsuyuanController {
    @Autowired
    private NongchanpinsuyuanService nongchanpinsuyuanService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NongchanpinsuyuanEntity nongchanpinsuyuan,
		HttpServletRequest request){
        EntityWrapper<NongchanpinsuyuanEntity> ew = new EntityWrapper<NongchanpinsuyuanEntity>();

		PageUtils page = nongchanpinsuyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanpinsuyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,NongchanpinsuyuanEntity nongchanpinsuyuan, 
		HttpServletRequest request){
        EntityWrapper<NongchanpinsuyuanEntity> ew = new EntityWrapper<NongchanpinsuyuanEntity>();

		PageUtils page = nongchanpinsuyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanpinsuyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NongchanpinsuyuanEntity nongchanpinsuyuan){
       	EntityWrapper<NongchanpinsuyuanEntity> ew = new EntityWrapper<NongchanpinsuyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( nongchanpinsuyuan, "nongchanpinsuyuan")); 
        return R.ok().put("data", nongchanpinsuyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NongchanpinsuyuanEntity nongchanpinsuyuan){
        EntityWrapper< NongchanpinsuyuanEntity> ew = new EntityWrapper< NongchanpinsuyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( nongchanpinsuyuan, "nongchanpinsuyuan")); 
		NongchanpinsuyuanView nongchanpinsuyuanView =  nongchanpinsuyuanService.selectView(ew);
		return R.ok("查询农产品溯源成功").put("data", nongchanpinsuyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NongchanpinsuyuanEntity nongchanpinsuyuan = nongchanpinsuyuanService.selectById(id);
		nongchanpinsuyuan = nongchanpinsuyuanService.selectView(new EntityWrapper<NongchanpinsuyuanEntity>().eq("id", id));
        return R.ok().put("data", nongchanpinsuyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NongchanpinsuyuanEntity nongchanpinsuyuan = nongchanpinsuyuanService.selectById(id);
		nongchanpinsuyuan = nongchanpinsuyuanService.selectView(new EntityWrapper<NongchanpinsuyuanEntity>().eq("id", id));
        return R.ok().put("data", nongchanpinsuyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NongchanpinsuyuanEntity nongchanpinsuyuan, HttpServletRequest request){
    	nongchanpinsuyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nongchanpinsuyuan);
        nongchanpinsuyuanService.insert(nongchanpinsuyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NongchanpinsuyuanEntity nongchanpinsuyuan, HttpServletRequest request){
    	nongchanpinsuyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nongchanpinsuyuan);
        nongchanpinsuyuanService.insert(nongchanpinsuyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody NongchanpinsuyuanEntity nongchanpinsuyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongchanpinsuyuan);
        nongchanpinsuyuanService.updateById(nongchanpinsuyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        nongchanpinsuyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
