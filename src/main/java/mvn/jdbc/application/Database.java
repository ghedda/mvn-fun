package mvn.jdbc.application;

import lombok.*;

@Builder
@ToString
public class Database {
    private String db_url;
    private String db_user;
    private String db_password;
}
