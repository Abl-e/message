package servlet;

import service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 唐国翔 on 2017/7/30.
 */
@WebServlet(name = "DeleteOneServlet",urlPatterns = "/deleteOne")
public class DeleteOneServlet extends HttpServlet {
    private MessageService messageService;
    public DeleteOneServlet(){
        messageService = new MessageService();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("=============>删除");
        String id = request.getParameter("id");
        messageService.deleteOne(id);
        response.sendRedirect("/list");
    }
}
