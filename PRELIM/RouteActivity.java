import java.util.Scanner;

public class RouteActivity {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter a name to start your journey: ");
        String name = s.nextLine();

        System.out.println("Welcome to my life trnsit services!");
        System.out.println("The routes are:");
        System.out.println("\nDefault Routes:");
        System.out.println("Cebu City (Start)");
        System.out.println("Minglanilla (Route 1)");
        System.out.println("San Fernando (Route 2)");
        System.out.println("Carcar (Route 3)");
        System.out.println("Barili (Route 4.1)");
        
        System.out.print("\nIs Barili obstructed? (1 = Yes, 0 = No): ");
        int isBariliObstructed = s.nextInt();
        int isDumanjugObstructed = 0;  

        if (isBariliObstructed == 0) {
            System.out.print("How fast are you going? km/hr: ");
            int speed = s.nextInt();

            double totalDistance = calculateTotalDistance(0, 0); 
            double totalTime[] = calculateTime(totalDistance, speed);

            System.out.println(" ");
            System.out.println("Recommended Route: ");
            System.out.println("Cebu City (Start)");
            System.out.println("Minglanilla (Route 1)");
            System.out.println("San Fernando (Route 2)");
            System.out.println("Carcar (Route 3)");
            System.out.println("Alcantara (Route 4.1.2)");
            System.out.println("Moalboal (End)");

            System.out.println(" ");
            System.out.println("Additional Data: ");
            System.out.println("Speed: " + speed + " km/hr");
            System.out.println("Distance: " + totalDistance + " km");
            System.out.println("ETA: " + (int) totalTime[0] + " hours and " + (int) totalTime[1] + " minutes");

            String bestRoute = calculateBestRoute(0, 0); 
            System.out.println("Best Route: " + bestRoute);
        } else {
            System.out.print("Is Dumanjug obstructed? (1 = Yes, 0 = No): ");
            isDumanjugObstructed = s.nextInt();

            int speed = 0;  

            System.out.print("How fast are you going? km/hr: ");
            speed = s.nextInt();

            double totalDistance = calculateTotalDistance(isBariliObstructed, isDumanjugObstructed);
            double totalTime[] = calculateTime(totalDistance, speed);

            System.out.println(" ");
            System.out.println("Recommended Route: ");
            System.out.println("Cebu City (Start)");
            System.out.println("Minglanilla (Route 1)");
            System.out.println("San Fernando (Route 2)");
            System.out.println("Carcar (Route 3)");
            System.out.println("Sibonga (Route 4.2)");
            System.out.println("Argao (Route 5)");
            System.out.println("Ronda (Route 5.1)");
            System.out.println("Alcantara (Route 5.2)");
            System.out.println("Moalboal (End)");

            System.out.println(" ");
            System.out.println("Additional Data: ");
            System.out.println("Speed: " + speed + " km/hr");
            System.out.println("Distance: " + totalDistance + " km");
            System.out.println("ETA: " + (int) totalTime[0] + " hours and " + (int) totalTime[1] + " minutes");

            String bestRoute = calculateBestRoute(isBariliObstructed, isDumanjugObstructed);
            System.out.println("Best Route: " + bestRoute);
        }

        s.close();
    }

    public static double[] calculateTime(double distance, double speed) {
        double totalHours = distance / speed;
        int hours = (int) totalHours;
        int minutes = (int) ((totalHours - hours) * 60);
        return new double[]{hours, minutes};
    }

    public static String calculateBestRoute(int isBariliObstructed, int isDumanjugObstructed) {
        if (isBariliObstructed == 1) {
            if (isDumanjugObstructed == 1) {
                return "Argao (Route 5)";
            } else {
                return "Sibonga (Route 4.2)";
            }
        } else {
            return "Barili (Route 4.1)";
        }
    }

    public static double calculateTotalDistance(int isBariliObstructed, int isDumanjugObstructed) {
        double routeDistances[] = {70.7, 63.1, 48.3, 30.3, 31.8};
        double totalDistance = routeDistances[0];

        if (isBariliObstructed == 1) {
            if (isDumanjugObstructed == 1) {
                totalDistance += routeDistances[4];
            } else {
                totalDistance += routeDistances[3];
            }
        }
        return totalDistance;
    }
}