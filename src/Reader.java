/*
Author: David Yu and Michael Zhang
Date: 05/01/2018
Description: a java program which grab online information of UCSC dining halls, and push it into our personal emails.
How to use: run the program with args[0] as your outlook email address, args[1] as your email password, and the rest of the args
            as recipients' email address
 */
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