package app.model;

import java.util.ArrayList;
import java.util.Arrays;

public class JsonRunModel {
    public String ENDPOINT_NAME;
    public String ENDPOINT_IP;
    public String ENDPOINT_DOMAIN;

    public String EMAIL_SERVER;
    public String EMAIL_PROTOCOL;
    public int EMAIL_PORT;
    public String EMAIL_USERNAME;
    public String EMAIL_PASSWORD;
    public String EMAIL_SENDER;
    public ArrayList<String> EMAIL_RECIPIENT_LIST;
    public int EMAIL_TIMEOUT;

    public JsonRunModel(boolean useDefault) {
        if (useDefault) {
            this.ENDPOINT_NAME = "Google";
            this.ENDPOINT_IP = "8.8.8.8";
            this.ENDPOINT_DOMAIN = "google.com";

            this.EMAIL_SERVER = "smtp.server.com";
            this.EMAIL_PROTOCOL = "SSL";
            this.EMAIL_PORT = 465;
            this.EMAIL_USERNAME = "sender@address.com";
            this.EMAIL_PASSWORD = "password";
            this.EMAIL_SENDER = "My Unique Device Name < sender@address.com >";
            this.EMAIL_RECIPIENT_LIST = new ArrayList<>(Arrays.asList("recipient-1@address.com", "recipient-2@address.com"));
            this.EMAIL_TIMEOUT = 30000;
        }
    }
}
