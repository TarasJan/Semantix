import sun.misc.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Janek Taras on 4/14/2017.
 */
public class Semantix {

    public HashMap<String, Logo> getLogos() {
        return logos;
    }

    private HashMap<String, Logo> logos;


    public Semantix() {
        logos = new HashMap<String, Logo>();
    }

    public static void main(String[] args) {
        Semantix app = new Semantix();
        SVOParser parser = SVOParser.getInstance();
        Splitter splitter = Splitter.getInstance();

        File f = new File("alice.txt");
        Scanner fi = null;
        String text = "";
        try {
            fi = new Scanner(f);
            while(fi.hasNext())
            {
                text = text.concat(String.format("%s%s",fi.nextLine(),"\n"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        fi.close();
        System.out.println(text);

        ArrayList<String> sentences = splitter.extractSentences(text);

        for( String sentence : sentences) {
            parser.updateMeaningMap(sentence, app.getLogos());
        }
        app.getLogos().forEach((k, v) -> v.display());
        Logo[] sorted = app.getLogos().values().toArray(new Logo[0]);
        Arrays.sort( sorted );
        for (Logo l : sorted)
        {
            l.display();
        }
    }

}
