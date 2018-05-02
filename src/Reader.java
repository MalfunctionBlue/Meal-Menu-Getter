import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.net.URL;


public class Reader {
    public static void pl(String line) {
        System.out.println(line);
    }

    public static void main(String[] args) throws Exception {
        String url = "http://nutrition.sa.ucsc.edu/menuSamp.asp?locationNum=40&locationName=College+Nine+%26+Ten&sName=&naFlag=";
        Document doc = Jsoup.connect(url).get();
        // Elements mainFrame=doc.select("Frame[name=AuroraMain]");
        // String mainFrameSrc=mainFrame.attr("src");
        System.out.println(doc.text());
        //pl(mainFrame.toString());
        //pl(mainFrameSrc);
    }
}