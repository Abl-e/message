import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MybatisUtil;

import java.io.IOException;

/**
 * Created by 唐国翔 on 2017/7/30.
 */
public class MybatisTest {
    @Test
    public void getSqlSession() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        System.out.println(sqlSession);
    }
}
