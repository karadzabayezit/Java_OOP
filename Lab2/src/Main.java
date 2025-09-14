import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Unicycle unicycle = new Unicycle(20);
        Bicycle bicycle = new Bicycle(26);
        Tricycle tricycle = new Tricycle(24);

        RepairService repairService = new RepairService();

        System.out.println("=== Buying ===");
        unicycle.buy();
        bicycle.buy();
        tricycle.buy();

        System.out.println("\n=== Using ===");
        unicycle.use();
        bicycle.use();
        tricycle.use();

        System.out.println("\n=== Repairing ===");
        repairService.repairBike(unicycle);
        repairService.repairBike(bicycle);
        repairService.repairBike(tricycle);

        System.out.println("\n=== Building ===");
        unicycle.build();
        bicycle.build();
        tricycle.build();

        System.out.println("\n=== Repair All ===");
        repairService.repairAll(Arrays.asList(unicycle, bicycle, tricycle));
    }
}