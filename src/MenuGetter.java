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
    public static void main(String[] args) throws IOException {
        String targetURL = "http://nutrition.sa.ucsc.edu/menuSamp.asp?locationNum=40&locationName=College+Nine+%26+Ten&sName=&naFlag=";
        Document doc = Jsoup.connect(targetURL).get();
        //System.out.println(doc.toString());
        //"[class=menusamprecipes]" is the tag for food
        Elements foods = doc.select("[class=menusamprecipes],[class=menusampmeals]");
        //System.out.println(foods);
        for (Element food : foods) {
            System.out.println(food.text());
        }

    }
}



