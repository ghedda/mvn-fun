package mvn.jdbc.application;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        // --------------------
        // Step 4 (Lombok Demo)
        // --------------------
        /*
        System.out.println("Hello Customer!");

        Customer c1 = new Customer(1L, "Meyer", "Eric", "eme@gmail.com");
        Customer c2 = new Customer(2L, "Hauser", "Lena", "+49 030 345862365");
        Customer c3 = new Customer(3L); // using RequiredArgsConstructor

        c3.name("Brinkmann")   // fluent setters
                .firstName("Tobias")
                .contact("+49 030 662465724");

        List.of(c1, c2, c3)
                .stream()
                .filter(c -> c.id() > 1) // fluent getter
                .forEach(System.out::println); // ToString output
        */

        // --------------------
        // Step 5 (Builder Demo)
        // --------------------
        System.out.println("Hello Database!");

        Database db = Database.builder()
                .db_url("jdbc:h2:mem:freerider")
                .db_user("sa")
                .db_password("")
                .build();

        System.out.println(db);
    }
}
