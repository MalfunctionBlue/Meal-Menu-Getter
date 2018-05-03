
import java.util.Arrays;


public class Reader {
    //public static void pl(String line) {
    //    System.out.println(line);
    //}

    public static void main(String[] args) throws Exception {

        String[] addressList = Arrays.copyOfRange(args, 2, args.length);
        JMailSender.sent(args[0], args[1], addressList);
    }

}