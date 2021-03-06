package com.imooc.o2o.service.impl;

import com.imooc.o2o.dao.AreaMapper;
import com.imooc.o2o.pojo.Area;
import com.imooc.o2o.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iAreaService")
public class AreaServiceImpl implements IAreaService {
    @Autowired
    private AreaMapper areaMapper;

    @Override
    public int add(Area area) {
        int count = areaMapper.insert(area);
        return count;
    }

    @Override
    public List<Area> getAreaList() {
       List<Area> areaList = areaMapper.selectAreaList();
       return areaList;
    }

}
