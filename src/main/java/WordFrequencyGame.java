import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public static final String BLANK_SPACE = "\\s+";
    public static final String NEW_LINE = "\n";
    public static final String CALCULATE_ERROR = "Calculate Error";


    public String getResult(String sentence) {


        try {
            List<WordInfo> wordInfoList = getListMap(sentence);
            Map<String, List<WordInfo>> map = getListMap(wordInfoList);
            
            return formatWordInfo(wordInfoList);
        } catch (Exception e) {
            return CALCULATE_ERROR;
        }
    }

    private String formatWordInfo(List<WordInfo> wordInfoList) {
        return wordInfoList.stream()
                .map(wordInfo -> String.format("%s %d", wordInfo.getWord(), wordInfo.getWord()))
                .collect(Collectors.joining(NEW_LINE));
    }

    private Map<String, List<WordInfo>> getListMap(List<WordInfo> wordInfoList) {
        Map<String, List<WordInfo>> map = new HashMap<>();
        for (WordInfo wordInfo : wordInfoList) {
//       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!map.containsKey(wordInfo.getWord())) {
                ArrayList arr = new ArrayList<>();
                arr.add(wordInfo);
                map.put(wordInfo.getWord(), arr);
            } else {
                map.get(wordInfo.getWord()).add(wordInfo);
            }
        }


        return map;
    }


}
