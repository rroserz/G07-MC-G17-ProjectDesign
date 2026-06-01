/**
 * Creator: Siti Nur Amira binti Zulkiply
 * Tester: [Insert Group Member Name Here]
 * Description: Custom exception to handle errors if a page doesn't exist.
 */
public class PageNotFoundException extends Exception {
    public PageNotFoundException(String message) {
        super(message);
    }
}
