public class Exception_ {
    public static void main(String[] args){
        try {
            checkStroke("afda 21421 13 werf");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        try {
            checkNumber(3);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        try {
            checkNumber(1234341234);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        try {
            checkNumber(12351247);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void checkNumber(int number) throws ArithmeticException{
        if(number % 2 == 1){
            throw new ArithmeticException(number + " - нечётное число");
        }
    }

    public static void checkStroke(String stroke) throws Exception{
        for(int i = 0; i < stroke.length(); ++i){
            if(Character.isDigit(stroke.charAt(i))){
                throw new Exception("Найдено число в строке");
            }
        }
    }
}
