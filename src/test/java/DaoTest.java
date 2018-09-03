import com.imooc.o2o.dao.AreaMapper;
import com.imooc.o2o.pojo.Area;
import com.imooc.o2o.service.IAreaService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DaoTest extends  BaseTest{

        @Autowired
        private AreaMapper areaMapper;
        @Test
        public void insertArea(){

            Area area = new Area();
            area.setAreaName("中原");
            area.setAreaDesc("中苑");
            area.setPriority(15);

            int count = areaMapper.insert(area) ;
            System.out.println(count);
            }
}
