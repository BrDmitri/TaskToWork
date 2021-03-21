import java.io.*;
import java.util.*;

public class CountingSymbols {
        public static void main(String[] args) throws IOException {
        String str;
        int maxValue;
        char lastKey = ' ';
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите слово или строку:");
        str = br.readLine();
        if (str.trim().length() == 0) {
            System.out.println("Не введено значение");
            return;
        };

            Map<Character, Integer> charMap = new LinkedHashMap<Character, Integer>();
            char[] arr = str.toCharArray();
            for (char value : arr) {
                if (Character.isAlphabetic(value)) {
                    if (charMap.containsKey(value)) {
                        charMap.put(value, charMap.get(value) + 1);
                    } else {
                        charMap.put(value, 1);
                    }
                }
            }

            maxValue = Collections.max(charMap.values());

            for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
                if (entry.getValue() > 1) {
                    Character key = entry.getKey();
                    Integer value = entry.getValue();
                    if (value == maxValue) {
                        lastKey = key;
                    }
                }
            }
            if (lastKey != ' ') {
                System.out.println(lastKey + " " + maxValue);
            }
        }

}
