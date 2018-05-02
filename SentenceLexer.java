import java.util.HashMap;
import java.util.Map;

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
                Map<String, Integer> wordMap = new HashMap<String, Integer>();
                for (final String word : words)
                {
                    if (wordMap.get(word.toLowerCase()) != null)
                    {
                        Integer count = wordMap.get(word);
                        count = count + 1;
                        wordMap.put(word, count);
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
