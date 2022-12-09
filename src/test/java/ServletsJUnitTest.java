import Servlet.Service;
import Servlet.model.BackingBean;
import Servlet.model.Todo;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServletsJUnitTest {

    public ServletsJUnitTest() {

    }

    @Test
    public void givenNumberShouldLoseGame() {
        //Arrange
        BackingBean bean = new BackingBean();
        int num = bean.getRandomNumber();
        //Act
        bean.setAttemptNumber(num);
        //Assert
        Assert.assertEquals(bean.getGameState(), "Perdiste.");
    }

    @Test
    public void givenGameStateShouldWin() {
        //Arrange
        BackingBean bean = new BackingBean();
        //Act
        bean.setGameState("Ganaste");
        //Assert
        Assert.assertEquals(bean.getGameState(), "Ganaste");
    }

    @Test
    public void givenTodoShouldBuildHTMLService() {
        //Arrange
        Todo todo = new Todo(1, 1, "Ejemplo", true);
        Service service = new Service();
        //Act
        String salida = service.todoToHTMLRow(todo);
        //Assert
        Assert.assertEquals(salida, "<tr><td>1</td><td>1</td><td>Ejemplo</td><td>true</td></tr>");
        //Arrange
        todo.setId(2);
        todo.setTitle("Ejemplo2");
        todo.setUserId(2);
        todo.setCompleted(false);
        //Act
        String salida2 = service.todoToHTMLRow(todo);
        //Assert
        Assert.assertNotEquals(salida2, "<tr><td>1</td><td>1</td><td>Ejemplo</td><td>true</td></tr>");
    }

    @Test
    public void givenTodoShouldBuildHTMLTableService() throws IOException {
        Todo todo1 = new Todo(1, 1, "Ejemplo", true);
        Todo todo2 = new Todo(1, 1, "Ejmplo2", true);
        Service service = new Service();
        List<Todo> todoList = new ArrayList<>();
        todoList.add(service.getTodo(1));
        todoList.add(todo2);
        String salida = service.todosToHTMLTable(todoList);
        Assert.assertNotEquals(salida, "<table><tr><th>User Id</th><th>Id</th><th>Title</th><th>Completed</th></tr><tr><td>1</td><td>1</td><td>Ejemplo</td><td>true</td></tr><tr><td>1</td><td>1</td><td>Ejmplo2</td><td>true</td></tr></table>");
        Assert.assertEquals(salida, "<table><tr><th>User Id</th><th>Id</th><th>Title</th><th>Completed</th></tr><tr><td>1</td><td>1</td><td>delectus aut autem</td><td>false</td></tr><tr><td>1</td><td>1</td><td>Ejmplo2</td><td>true</td></tr></table>");
    }
}
