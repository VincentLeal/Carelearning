package tool;

public class HttpRequest<T> {

    private final String url;
    private Class responseType;
    private String method = "GET";
    private String contentType = "application/json";
    private T body;

    public HttpRequest(String url) {
        this(url, null);
    }

    public HttpRequest(String url, Class responseType) {
        this.url = url;
        this.responseType = responseType;
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public Class getResponseType() {
        return responseType;
    }
}