package activities;

abstract public class Book {
    String title;
    abstract public void setTitle(String titleName);
    public String getTitle(){
        return title;
    }
}
