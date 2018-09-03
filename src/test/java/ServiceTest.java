import com.imooc.o2o.dao.AreaMapper;
import com.imooc.o2o.pojo.Area;
import com.imooc.o2o.service.IAreaService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceTest extends BaseTest{
    @Autowired
    private AreaMapper areaMapper;
    @Autowired
    private IAreaService iAreaService;

    @Test
    public void insertArea(){

            Area area = new Area();
            area.setAreaName("大原");
            area.setAreaDesc("大苑");
            area.setPriority(15);

        int count = iAreaService.add(area) ;
        System.out.println(count);
    }
}
