package mvn.jdbc.application;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {

    // --------------------
    // Logger for Step 6

    //--- Never use System.out.println() in product code!
    // System.out.println("Hello Database!");
    // --use logger instead:
    //     log.info("Hello Database!");
    // --------------------
    private static final Logger log = LogManager.getLogger("db.database");

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
        // Step 5 + Step 6 (Builder + Logging Demo)
        // --------------------
        log.info("Hello Database!");

        // log messages on different log-levels (Step 6 requirement)
        log.fatal("log-message at level: fatal");
        log.error("log-message at level: error");
        log.warn("log-message at level: warning");
        log.debug("log-message at level: debug");
        log.trace("log-message at level: trace");

        Database db = Database.builder()
                .db_url("jdbc:h2:mem:freerider")
                .db_user("sa")
                .db_password("")
                .build();

        if (db == null) {
            log.error("error building database, db == null");
        } else {
            // log ToString output instead of System.out.println
            log.info(String.format("Database built with attributes: %s", db.toString()));
        }
    }
}
