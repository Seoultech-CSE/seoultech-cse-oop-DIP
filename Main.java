import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== DIP Refactoring Practice ===\n");

        // Note: Reflection is used here so you DO NOT need to modify Main.java.
        // It will automatically test your refactored architecture!
        try {
            // 1. Check if the interfaces exist in the default package
            Class<?> keyboardInterface = Class.forName("Keyboard");
            Class<?> monitorInterface = Class.forName("Monitor");

            if (!keyboardInterface.isInterface() || !monitorInterface.isInterface()) {
                throw new Exception("Keyboard and Monitor must be defined as 'interface'.");
            }

            // 2. Check the refactored constructor
            Class<?> machineClass = Class.forName("Windows98Machine");
            Constructor<?> constructor = machineClass.getConstructor(keyboardInterface, monitorInterface);

            // 3. Instantiate and run
            Object keyboard = Class.forName("StandardKeyboard").getDeclaredConstructor().newInstance();
            Object monitor = Class.forName("StandardMonitor").getDeclaredConstructor().newInstance();

            Object machine = constructor.newInstance(keyboard, monitor);
            machineClass.getMethod("work").invoke(machine);

            System.out.println("\n[Success] Windows98Machine now correctly depends on abstractions (Interfaces)!");

        } catch (NoSuchMethodException e) {
            // Fallback for Skeleton state (Before Refactoring)
            System.out.println("[Warning] Windows98Machine is tightly coupled to specific implementations.");
            System.out.println("Please create interfaces and inject them via the constructor!\n");
            
            System.out.println("--- Current Output ---");
            Windows98Machine oldMachine = new Windows98Machine();
            oldMachine.work();

        } catch (Exception e) {
            System.out.println("\n[Error] Refactoring is incomplete or incorrect: " + e.getMessage());
        }
    }
}
