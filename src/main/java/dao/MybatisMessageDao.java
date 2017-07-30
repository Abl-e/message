package dao;

import domain.Message;
import org.apache.ibatis.session.SqlSession;
import util.MybatisUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 唐国翔 on 2017/7/30.
 */
public class MybatisMessageDao {
    private SqlSession sqlSession = null;

    /**
     * 构造方法为 sqlSession赋值
     */
    public MybatisMessageDao(){
        try {
            sqlSession = MybatisUtil.getSqlSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Message> getMessageList(String command, String description){
        List<Message> messageList = new ArrayList<>();

        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("command",command);
        paramMap.put("description",description);
        messageList = sqlSession.selectList("listMessage",paramMap);

        return messageList;
    }

    public void deleteOne(int id){
        sqlSession.delete("deleteOne",id);
        sqlSession.commit();
    }
}
