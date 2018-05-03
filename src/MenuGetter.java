/*
Author: David Yu and Michael Zhang
Date: 05/01/2018
Description: a java program which grab online information of UCSC dining halls, and push it into our personal emails
 */


import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MenuGetter {
    private Elements menuString;

    public static void main(String[] args) throws IOException {
        MenuGetter test = new MenuGetter();
        System.out.print(test.toString());
    }

    public MenuGetter() throws IOException {
        String targetURL = "http://nutrition.sa.ucsc.edu/menuSamp.asp?locationNum=40&locationName=College+Nine+%26+Ten&sName=&naFlag=";
        Document doc = Jsoup.connect(targetURL).get();
        menuString = doc.select("[class=menusamprecipes],[class=menusampmeals]");
    }

    public String toString() {
        String s = "";
        for (Element e : menuString) {
            if (e.is("[class=menusampmeals]")) {
                s += "<br><b>" + e.text() + "</b><hr>";
            } else {
                s += e.text() + "<br>";
            }
        }
        s = "<html><body>" + s + "</body></html>";
        return s;
    }


}



