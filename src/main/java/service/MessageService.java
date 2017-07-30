package service;

import dao.MybatisMessageDao;
import domain.Message;

import java.util.List;

/**
 * Created by 唐国翔 on 2017/7/30.
 */
public class MessageService {
    private MybatisMessageDao mybatisMessageDao;

    /**
     * 构造方法为mybatisDao赋值
     */
    public MessageService(){
        mybatisMessageDao = new MybatisMessageDao();
    }

    public List<Message> getMessageList(String command,String description){
        List<Message> messageList = mybatisMessageDao.getMessageList(command, description);
        return messageList;
    }

    public void deleteOne(String id){
        if(id!=null&&!id.trim().equals("")){
            mybatisMessageDao.deleteOne(Integer.parseInt(id));
        }
    }
}
