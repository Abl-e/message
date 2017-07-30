package servlet;

import dao.MessageDao;
import dao.MybatisMessageDao;
import domain.Message;
import service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 唐国翔 on 2017/7/28.
 * 列表页面初始化控制
 */
@WebServlet(name = "listServlet",urlPatterns = "/list")
public class ListServlet extends HttpServlet{
    private MessageService messageService;

    public ListServlet(){
        messageService = new MessageService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command")==null?"":req.getParameter("command").trim();
        String description = req.getParameter("description")==null?"":req.getParameter("description").trim();
        /*List<Message> messageList = messageDao.getMessageList(command,description);*/
        List<Message> messageList = messageService.getMessageList(command, description);
        req.setAttribute("messageList",messageList);
        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req,resp);
    }

}
