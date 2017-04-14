import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/**
 * Created by Janek Taras on 4/14/2017.
 */
public class Splitter {
    private static Splitter ourInstance = new Splitter();
    private BreakIterator iterator;


    public static Splitter getInstance() {
        return ourInstance;
    }

    private Splitter() {
        iterator = BreakIterator.getSentenceInstance(Locale.US);

    }

    public ArrayList<String> extractSentences(String text)
    {
        ArrayList<String> sentences = new ArrayList<String>();
        iterator.setText(text);
        int start = iterator.first();
        for (int end = iterator.next(); end != BreakIterator.DONE;
             start = end, end = iterator.next()) {
            sentences.add(text.substring(start,end).replaceAll("[(){},.;!?<>%\\-\"'‘’]", " "));
        }
        return  sentences;
    }


}
