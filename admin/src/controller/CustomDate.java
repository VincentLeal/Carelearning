package controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created on 23/05/2018.
 */
public class CustomDate extends Date {
    public CustomDate(long date) {
        super(date);
    }

    public String toString() {
        return new SimpleDateFormat("dd/MM/yyyy").format(this);
    }
}
