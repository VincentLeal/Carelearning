package tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on 19/07/2018.
 */
public class EmailValidator {
    private Pattern pattern;
    private Matcher matcher;

    private String emailPattern =
            //Must start with string, must contain one or more character
            "^[_A-Za-z0-9+-]+" +
            //follow by '.' and another string contains one or more character (optional)
            "(.[_A-Za-z0-9-]+)*" +
            //Must contains '@'
            "@" +
            "[A-Za-z0-9-]+" +
            "(.[A-Za-z0-9]+)*" +
            //Minimum length 2
            "(.[A-Za-z]{2,})$";

    public EmailValidator() {
        pattern = Pattern.compile(emailPattern);
    }

    public boolean validate(final String hex) {
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }

}
