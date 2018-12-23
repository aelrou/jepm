package app.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JsonCacheModel {
    public LocalDateTime LAST_UPDATE;

    public JsonCacheModel(boolean useDefault) {
        if (useDefault) {
            this.LAST_UPDATE = LocalDateTime.parse("2001-01-01T01:01:01.1", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }
    }
}
