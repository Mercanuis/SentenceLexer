import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.lang.Integer;

public class SentenceLexer
{
    public static void main(String[] args)
    {
        if(args.length == 0 || args.length > 1)
        {
            System.out.println("Usage: SentenceLexer \"<string>\"");
        }
        else
        {
            String sentence = args[0];
            if (sentence != null && !sentence.isEmpty())
            {
                String[] words = sentence.split("[\\p{Space}\\p{Punct}]++");
                Hashtable<String, Integer> wordMap = new Hashtable<String, Integer>();
                for (final String word : words)
                {
                    if (wordMap.get(word.toLowerCase()) != null)
                    {
                        int count = wordMap.get(word.toLowerCase());
                        wordMap.put(word.toLowerCase(), count + 1);
                    }
                    else
                    {
                        wordMap.put(word.toLowerCase(), 1);
                    }
                }

                for (final String key : wordMap.keySet())
                {
                    System.out.println(key + " - " + wordMap.get(key));
                }
            }
        }
    }
}
