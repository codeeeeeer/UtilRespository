package source.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.source.mapper.TbContentCategoryMapper;
import com.source.mapper.TbItemMapper;
import com.source.pojo.TbItem;
import com.source.pojo.TbItemExample;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/7 23:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring/applicationContext-dao.xml"})
@Slf4j
public class PageHelperTest {
    @Resource
    TbItemMapper itemMapper;

    @Test
    public void test(){
        int pageNum = 0, pageSize = 10;
        PageHelper.startPage(pageNum, pageSize);
        List<TbItem> tbItems = itemMapper.selectByExample(new TbItemExample());
        PageInfo<TbItem> info = new PageInfo<TbItem>(tbItems);
        log.error(info.getTotal() + "");
    }
}
