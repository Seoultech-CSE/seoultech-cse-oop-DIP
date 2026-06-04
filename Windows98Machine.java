public class Windows98Machine {
    
    // [TODO] Change these fields to depend on abstractions (Interfaces), not concrete classes.
    private final StandardKeyboard keyboard;
    private final StandardMonitor monitor;

    public Windows98Machine() {
        // ========================================================
        // [TODO] VIOLATION of DIP: High-level module depends on low-level modules.
        // Remove 'new' keywords. Inject dependencies via constructor parameters.
        // ========================================================
        this.keyboard = new StandardKeyboard();
        this.monitor = new StandardMonitor();
    }

    public void work() {
        keyboard.type();
        monitor.display();
    }
}