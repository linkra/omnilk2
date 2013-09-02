package plan3.recruitment.backend.resources;

import javax.ws.rs.core.MediaType;

public class Constant {
    public static final String APPLICATION_JSON_UTF8 = MediaType.APPLICATION_JSON + "; charset=utf-8";;
    static final String EMAIL_PARAM = "email";
    static final String EMAIL_PATH_PARAM = '{' + EMAIL_PARAM + '}';

    public Constant() {
    }
}