package Servlet.model;

public class Todo {

    private int userId, id;
    private String title;

    private boolean completed;
    public Todo(int userId,int id,String title, boolean completed){
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public int getUserId(){
        return this.userId;
    }

    public int getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public boolean getCompleted(){
        return completed;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }

}
