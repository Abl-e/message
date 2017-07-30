package dao;

import domain.Message;
import util.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 唐国翔 on 2017/7/28.
 */
public class MessageDao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    /**
     * 得到message列表 支持模糊查询
     * @param command 指令名称
     * @param description 描述
     * @return List<Message> 集合
     */
    public List<Message> getMessageList(String command,String description){
        List<Message> messageList = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        if(command.equals("")&&description.equals("")){
            stringBuffer.append("select * from message");
        }else if(!command.equals("")&&description.equals("")){
            stringBuffer.append("select * from message where command like '%").append(command).append("%'");
        }else if(command.equals("")&&!description.equals("")){
            stringBuffer.append("select * from message where description like '%").append(description).append("%'");
        }else {
            stringBuffer.append("select * from message where description like '%").append(description).append("%'")
                    .append("and command like '%").append(command).append("%'");
        }
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(stringBuffer.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Message message = new Message();
                message.setId(resultSet.getInt(1));
                message.setCommand(resultSet.getString(2));
                message.setDescription(resultSet.getString(3));
                message.setContent(resultSet.getString(4));
                messageList.add(message);
            }
        } catch (ClassNotFoundException | IOException |SQLException e) {
            e.printStackTrace();
        }
        return messageList;
    }
}
