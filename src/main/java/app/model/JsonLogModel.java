package app.model;

public class JsonLogModel {
    public String LOGS_DIRECTORY;
    public String LOG_NAME;
    public String LOG_EXTENTION;

    public JsonLogModel(boolean useDefault) {
        if (useDefault) {
            this.LOGS_DIRECTORY = "C:\\Users\\Public\\jepm";
            this.LOG_NAME = "jepm";
            this.LOG_EXTENTION = "log";
        }
    }
}
