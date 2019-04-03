import com.imooc.o2o.dao.AreaMapper;
import com.imooc.o2o.dao.ShopCategoryMapper;
import com.imooc.o2o.dao.ShopMapper;
import com.imooc.o2o.pojo.Area;
import com.imooc.o2o.pojo.Shop;
import com.imooc.o2o.pojo.ShopCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DaoTest extends  BaseTest{

        @Autowired
        private AreaMapper areaMapper;
        @Autowired
        private ShopMapper shopMapper;
        @Autowired
        private ShopCategoryMapper shopCategoryMapper;
        @Test
        public void testQueryAssociationShop(){
            int shopId = 15;
            Shop shop = shopMapper.queryByShopIdAssociation(shopId);
            System.out.println(shop.getArea().getAreaName());
            System.out.println(shop.getArea().getAreaDesc());
        }

        @Test
        @Ignore
        public void testQueryByShopId(){
            int shopId = 15;
            Shop shop = shopMapper.selectByPrimaryKey(shopId);
            Area area = areaMapper.selectByPrimaryKey(shop.getAreaId());
            System.out.println(area.getAreaDesc());
            System.out.println(area.getAreaName());
        }

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
        @Test
        public void selectShopCategory(){
            List<ShopCategory> shopCategories = shopCategoryMapper.selectShopCategoryByParentId(null);
            assertEquals(12,shopCategories.size());
            for (ShopCategory shopCategory : shopCategories) {
                System.out.println(shopCategory.getParentId());
            }

            //ShopCategory shopCategory = shopCategoryMapper.selectByPrimaryKey(10);

        }
}

