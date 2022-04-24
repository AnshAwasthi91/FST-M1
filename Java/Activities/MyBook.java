package activities;

public class MyBook extends Book{
    @Override
    public void setTitle(String titleName) {
        title=titleName;
    }

    public static void main(String[] args) {
        MyBook novel = new MyBook();
        novel.setTitle("Java World!");
        System.out.println(novel.getTitle());
    }
}
