package tool;

import org.json.JSONArray;
import org.json.JSONObject;

public class HttpResponse {
    private final JSONArray array;
    private final JSONObject object;

    public HttpResponse(JSONObject object) {
        this(null, object);
    }

    public HttpResponse(JSONArray array) {
        this(array, null);
    }

    public HttpResponse(JSONArray array, JSONObject object) {
        this.array = array;
        this.object = object;
    }

    public JSONArray getArray() {
        return array;
    }
    public JSONObject getObject() {
        return object;
    }

}