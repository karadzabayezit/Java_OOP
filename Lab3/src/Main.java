import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        String[] names = { "Steel", "Light", "Armor", "Ural", "Techno" };

        Bicycles bicycles = new Bicycles();

        for (int i = 0; i < 10; ++i) {
            String name = names[random.nextInt(5)];
            int year = 1980 + random.nextInt(40);
            int wheelCount = random.nextInt(3) + 1;
            int wheelDiameter = random.nextInt(20) + 10;

            bicycles.add(new Bicycle(name, year, wheelCount, wheelDiameter));
        }

        bicycles.printBikes();

        bicycles.sort();
        System.out.println("After sorting:");
        bicycles.printBikes();

        bicycles.sort(SortCriteria.BY_NAME_YEAR);
        System.out.println("After sorting by year:");
        bicycles.printBikes();
    }
}