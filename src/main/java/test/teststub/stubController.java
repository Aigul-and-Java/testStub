package test.teststub;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/api")
public class stubController {

    private final List<String> storage = new CopyOnWriteArrayList<>();

    @PostMapping("/post")

    public Map<String, String> post(@RequestBody Map<String, String> body) {

        String id = body.get("id");
        if (id !=null && id.length() == 5 ){
            storage.add(id);
            return Map.of("status","saved", "value", id);
        }
        return Map.of("status","failed","message", "Invalid ID");
    }

    @GetMapping("/get")
    public String getData(){
        return storage.toString();
    }

}
