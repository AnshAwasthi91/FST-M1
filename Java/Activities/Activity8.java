package activities;

public class Activity8 {

    public static void main(String[] args) {
        try{
            exceptionTest("Will print to Console");
            exceptionTest(null);
            exceptionTest("Won't Execute this line");
        } catch (CustomException e) {
            System.out.println("Custom Error message : "+e.getMessage());
        }


    }

    static void exceptionTest(String testValue) throws CustomException {
            if(testValue==null)
                throw new CustomException("Null String is provided, hence user exception is thrown!!");
            else
                System.out.println("String value provided : "+testValue);

    }
}
