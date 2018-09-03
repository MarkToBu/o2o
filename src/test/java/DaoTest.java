import com.imooc.o2o.dao.AreaMapper;
import com.imooc.o2o.dao.ShopMapper;
import com.imooc.o2o.pojo.Area;
import com.imooc.o2o.pojo.PersonInfo;
import com.imooc.o2o.pojo.Shop;
import com.imooc.o2o.pojo.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class DaoTest extends  BaseTest{

        @Autowired
        private AreaMapper areaMapper;
        @Autowired
        private ShopMapper shopMapper;
        @Test
        public void insertArea(){
            Area area = new Area();
            area.setAreaName("中原");
            area.setAreaDesc("中苑");
            area.setPriority(15);
            int count = areaMapper.insert(area) ;
            System.out.println(count);
        }
        @Test
        public void  insertShop(){
            Shop shop = new Shop();

        }
}

