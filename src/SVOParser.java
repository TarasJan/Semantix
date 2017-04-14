import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Janek Taras on 4/14/2017.
 */
public class SVOParser {
    private static SVOParser ourInstance = new SVOParser();


    public static SVOParser getInstance() {
        return ourInstance;
    }

    private SVOParser() {


    }


    public void updateMeaningMap(String sentence, HashMap<String, Logo> meaningMap) {
        String s = sentence;
        s = s.toLowerCase();
        String[] words = s.split("\\s");
        for (String word : words) {
            if (!meaningMap.containsKey(word)) {
                meaningMap.put(word, new Logo(word));
            }

            for (String other : words) {
                if (!meaningMap.containsKey(other)) {
                    meaningMap.put(other, new Logo(other));
                }
                if (!other.equals(word)) meaningMap.get(word).solidifyBond(meaningMap.get(other));
            }

        }

    }

}
