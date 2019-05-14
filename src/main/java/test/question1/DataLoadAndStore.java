package test.question1;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class DataLoadAndStore {
    private final String SEMICOLON = ";";
    private final String EQUAL = "=";
    private final String NEW_LINE = "\n";

    public LinkedHashMap<?, ?>[] load(final String arrayInput) {
        LinkedHashMap<?, ?>[] array = null;
        if (StringUtils.isNotEmpty(arrayInput)) {
            final String[] items = arrayInput.split(NEW_LINE);
            final int lenght = items.length;
            array = new LinkedHashMap[lenght];

            for(int i = 0; i < lenght; i++) {
                array[i] = createMap(items[i]);
            }
        }
        return array;
    }

    public String store(final Map<?, ?>[] arr) {
        String result = StringUtils.EMPTY;
        final StringBuilder sb = new StringBuilder();
        if(arr != null && arr.length > 0) {
            Arrays.stream(arr).forEach(o -> {
                o.entrySet().forEach(e -> sb.append(e + ";"));
                sb.replace(sb.length() -1, sb.length(), "\n");
            });

            result = sb.substring(0, sb.length() -1);
        }

        return result;
    }

    private LinkedHashMap<String, String> createMap(final String mapString) {
        final LinkedHashMap<String, String> map = new LinkedHashMap<>();

        final String[] mapItems = mapString.split(SEMICOLON);
        Arrays.stream(mapItems).forEach( o -> addMapEntry(map, o));

        return map;
    }

    private void addMapEntry(final LinkedHashMap<String, String> map, final String item) {
        final String[] pairValues = item.split(EQUAL);
        map.put(pairValues[0], pairValues[1]);
    }
}
