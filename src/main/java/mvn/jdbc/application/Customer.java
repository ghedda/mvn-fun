package mvn.jdbc.application;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Accessors(fluent = true, chain = true)
public class Customer {

    private final long id;     // required argument
    private String name;
    private String firstName;
    private String contact;
}
