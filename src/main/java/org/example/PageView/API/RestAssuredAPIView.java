package org.example.PageView.API;

public class RestAssuredAPIView {
    protected String baseUrl;
    protected String endPoint;
    private static volatile RestAssuredAPIView assuredAPIView;

    private RestAssuredAPIView() {
    }

    public static RestAssuredAPIView getInstance() {
        if (assuredAPIView == null) {
            synchronized (RestAssuredAPIView.class) {
                if (assuredAPIView == null) {
                    assuredAPIView = new RestAssuredAPIView();
                }
            }
        }
        return assuredAPIView;
    }
    public void setBaseUrl(String baseUrl){
        this.baseUrl=baseUrl;
    }
    public void setEndPoint(String endPoint){
        this.endPoint=endPoint;
    }
}
