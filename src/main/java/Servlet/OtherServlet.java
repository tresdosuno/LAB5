package Servlet;

import Servlet.model.Todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        urlPatterns = "/Other"
)
public class OtherServlet extends HttpServlet {
    static final long serialVersionUID = 36L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responser = resp.getWriter();
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Todo data = Service.getTodo(id);
            List<Todo> todoList = new ArrayList<>();
            todoList.add(data);
            String table = Service.todosToHTMLTable(todoList);
            resp.setStatus(HttpServletResponse.SC_OK);
            responser.write(table);
        } catch(MalformedURLException e) {
            responser.write(new StringBuilder("<h1>Error interno en el servidor").append("</h1>").toString());
        } catch (NumberFormatException e) {
            responser.write(new StringBuilder("<h1>Requerimiento no válido").append("</h1>").toString());
        }
        responser.flush();
    }
}
