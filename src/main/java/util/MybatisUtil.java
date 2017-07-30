package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by 唐国翔 on 2017/7/30.
 */
public class MybatisUtil {
    private static SqlSession sqlSession;
    public static SqlSession getSqlSession() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        sqlSession = sessionFactory.openSession();
        return sqlSession;
    }
    public static void close(SqlSession sqlSession){
        if(sqlSession!=null){
            sqlSession.close();
        }
    }
}
