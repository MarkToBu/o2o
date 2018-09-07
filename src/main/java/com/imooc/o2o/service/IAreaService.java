package com.imooc.o2o.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.imooc.o2o.pojo.Area;

import java.io.IOException;
import java.util.List;

public interface IAreaService {
      int add(Area area);

    List<Area> getAreaList() throws JsonParseException, JsonMappingException,
            IOException;;
}
