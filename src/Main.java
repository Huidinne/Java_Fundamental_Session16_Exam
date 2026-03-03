import java.util.*;

public class Main {
    public static void main(String[] args) {

        ProductRepository repo = new ProductRepository();

        repo.add(new ElectronicProduct("E01", "Laptop", 20000000, 24));
        repo.add(new ElectronicProduct("E02", "Tivi", 15000000, 12));
        repo.add(new FoodProduct("F01", "Sữa", 30000, 10));
        repo.add(new FoodProduct("F02", "Bánh", 50000, 5));

        System.out.println("===== DANH SÁCH SẢN PHẨM =====");
        for (Product p : repo.findAll()) {
            p.displayInfo();
            System.out.println("Thành tiền: " + p.calculateFinalPrice());
            System.out.println("------------------------");
        }

        // Sắp xếp theo giá tăng dần
        System.out.println("\n===== SẮP XẾP THEO GIÁ =====");
        List<Product> sortedList = new ArrayList<>(repo.findAll());
        Collections.sort(sortedList, Comparator.comparingDouble(Product::getPrice));

        for (Product p : sortedList) {
            p.displayInfo();
            System.out.println("Thành tiền: " + p.calculateFinalPrice());
        }

        // Thống kê
        System.out.println("\n===== THỐNG KÊ =====");
        Map<String, Integer> stats = new HashMap<>();

        for (Product p : repo.findAll()) {
            String type = p.getClass().getSimpleName();
            stats.put(type, stats.getOrDefault(type, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
