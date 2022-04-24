package activities;

interface Addable {
    int add(int num1,int num2);
}

public class Activity12{

    public static void main(String[] args) {
        Addable ad1=(a,b)->(a+b);
        System.out.println("Sum is : "+ad1.add(2,16));

        Addable ad2=(int a,int b)->{
            return (a+b);
        };
        System.out.println("Sum is : "+ad2.add(21,22));
    }
}