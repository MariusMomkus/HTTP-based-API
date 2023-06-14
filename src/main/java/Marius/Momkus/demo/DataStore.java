package Marius.Momkus.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataStore {
    private Map<String, Entry> data;

    public DataStore() {
        data = new HashMap<>();
    }

    public List<Entry> getEntries(String query) {
        // Implement the query filtering logic here
        // Parse the query string and apply the corresponding filters

        // Example implementation:
        return data.values()
                .stream()
                .filter(entry -> evaluateQuery(entry, query))
                .collect(Collectors.toList());
    }

    public void storeEntry(Entry entry) {
        data.put(entry.getId(), entry);
    }

    private boolean evaluateQuery(Entry entry, String query) {
        // Implement the query evaluation logic here
        // Parse the query string and apply the corresponding filters

        // Example implementation:
        // Assuming the query has a single filter, either EQUAL or GREATER_THAN or LESS_THAN
        String[] parts = query.split(",");
        String filterType = parts[0];
        String property = parts[1];
        String value = parts[2].replaceAll("\"", "");

        switch (filterType) {
            case "EQUAL":
                return entryMatchesEqualFilter(entry, property, value);
            case "GREATER_THAN":
                return entryMatchesGreaterThanFilter(entry, property, Integer.parseInt(value));
            case "LESS_THAN":
                return entryMatchesLessThanFilter(entry, property, Integer.parseInt(value));
            default:
                return false;
        }
    }

    private boolean entryMatchesEqualFilter(Entry entry, String property, String value) {
        switch (property) {
            case "id":
                return entry.getId().equals(value);
            case "title":
                return entry.getTitle().equals(value);
            case "content":
                return entry.getContent().equals(value);
            default:
                return false;
        }
    }

    private boolean entryMatchesGreaterThanFilter(Entry entry, String property, int value) {
        switch (property) {
            case "views":
                return entry.getViews() > value;
            case "timestamp":
                return entry.getTimestamp() > value;
            default:
                return false;
        }
    }

    private boolean entryMatchesLessThanFilter(Entry entry, String property, int value) {
        switch (property) {
            case "views":
                return entry.getViews() < value;
            case "timestamp":
                return entry.getTimestamp() < value;
            default:
                return false;
        }
    }
}
