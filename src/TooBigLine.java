public class TooBigLine extends Exception{

    TooBigLine(String message) {
        System.out.println((message));
        throw new RuntimeException();
    }

}
