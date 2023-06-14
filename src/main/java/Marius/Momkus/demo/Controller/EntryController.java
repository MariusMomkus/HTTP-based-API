package Marius.Momkus.demo.Controller;

import Marius.Momkus.demo.DataStore;
import Marius.Momkus.demo.Entry;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntryController {
    private final DataStore dataStore;

    public EntryController() {
        dataStore = new DataStore();
    }

    @GetMapping("/store")
    public List<Entry> getEntries(@RequestParam("query") String query) {
        return dataStore.getEntries(query);
    }

    @PostMapping("/store")
    public void storeEntry(@RequestBody Entry entry) {
        dataStore.storeEntry(entry);
    }
}
