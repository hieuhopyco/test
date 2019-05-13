package test.questions;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class Question1 {

    public LinkedHashMap<String, String>[] load(final String arrayInput) {
        if(StringUtils.isNotEmpty(arrayInput)) {
            final String[] items = arrayInput.split("\n");

            final List<LinkedHashMap<String, String>> list = Arrays.stream(items).map(o -> {
                final LinkedHashMap<String, String> map = new LinkedHashMap<>();
                final String[] mapItems = o.split(";");
                for (final String item : mapItems) {
                    final String[] pairValues = item.split("=");
                    map.put(pairValues[0], pairValues[1]);
                }
                return map;
            }).collect(Collectors.toList());

            return list.toArray(new LinkedHashMap[items.length]);
        }
        return null;
    }

    public String store(final Map<String, String>[] arr) {
        final StringBuilder sb = new StringBuilder();
        if(arr != null && arr.length > 0) {
            Arrays.stream(arr).forEach(o -> {
                o.entrySet().forEach(e -> sb.append(e + ";"));
                sb.replace(sb.length() -1, sb.length(), "\n");
            });
        }

        return sb.substring(0, sb.length() -1);
    }

}
