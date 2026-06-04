import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== DIP Refactoring Practice ===\n");

        try {
            // 1. Try to find the refactored architecture (Interfaces)
            Class<?> keyboardInterface = null;
            Class<?> monitorInterface = null;
            
            try {
                keyboardInterface = Class.forName("Keyboard");
                monitorInterface = Class.forName("Monitor");
            } catch (ClassNotFoundException e) {
                // Interfaces not created yet - handle in fallback
            }

            if (keyboardInterface != null && monitorInterface != null && 
                keyboardInterface.isInterface() && monitorInterface.isInterface()) {
                
                // 2. Refactored State: Check for the constructor with parameters
                Class<?> machineClass = Class.forName("Windows98Machine");
                Constructor<?> constructor = machineClass.getConstructor(keyboardInterface, monitorInterface);

                Object keyboard = Class.forName("StandardKeyboard").getDeclaredConstructor().newInstance();
                Object monitor = Class.forName("StandardMonitor").getDeclaredConstructor().newInstance();

                Object machine = constructor.newInstance(keyboard, monitor);
                machineClass.getMethod("work").invoke(machine);

                System.out.println("\n[Success] Windows98Machine now correctly depends on abstractions (Interfaces)!");
            } else {
                throw new NoSuchMethodException(); // Force fallback
            }

        } catch (NoSuchMethodException | ClassNotFoundException e) {
            // 3. Fallback for Skeleton state (Before Refactoring)
            System.out.println("[Warning] Windows98Machine is tightly coupled to specific implementations.");
            System.out.println("Please create interfaces and inject them via the constructor!\n");
            
            try {
                System.out.println("--- Current Output ---");
                Class<?> machineClass = Class.forName("Windows98Machine");
                // Use reflection to call the no-arg constructor to avoid compile errors
                Object oldMachine = machineClass.getDeclaredConstructor().newInstance();
                machineClass.getMethod("work").invoke(oldMachine);
            } catch (Exception ex) {
                System.out.println("Could not run the machine. Make sure Windows98Machine has a valid constructor.");
            }

        } catch (Exception e) {
            System.out.println("\n[Error] Refactoring is incomplete or incorrect: " + e.getMessage());
        }
    }
}
