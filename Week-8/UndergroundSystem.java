package tasks;
import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {

    // Helper class to track where and when a user checked in
    private static class CheckInInfo {
        String station;
        int time;

        CheckInInfo(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // Helper class to keep track of total travel time and trip count for a route
    private static class RouteStats {
        double totalTime;
        int tripCount;

        RouteStats(double totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }

    // Maps to store the state of the system
    private Map<Integer, CheckInInfo> activeTrips;
    private Map<String, RouteStats> completedRouteStats;

    public UndergroundSystem() {
        activeTrips = new HashMap<>();
        completedRouteStats = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        // Store the check-in info using the customer's ID as the key
        activeTrips.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        // Retrieve and remove the check-in info (since the trip is now finishing)
        CheckInInfo startInfo = activeTrips.remove(id);
        
        // Create a unique key for the start -> end station pair
        String routeKey = startInfo.station + "->" + stationName;
        int travelTime = t - startInfo.time;

        // Update the running totals for this specific route
        RouteStats stats = completedRouteStats.getOrDefault(routeKey, new RouteStats(0.0, 0));
        stats.totalTime += travelTime;
        stats.tripCount += 1;
        
        completedRouteStats.put(routeKey, stats);
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteStats stats = completedRouteStats.get(routeKey);
        return stats.totalTime / stats.tripCount;
    }

    // Main method to test the logic (Matches your LeetCode screenshot example)
    public static void main(String[] args) {
        UndergroundSystem us = new UndergroundSystem();
        
        us.checkIn(45, "Leyton", 3);
        us.checkIn(32, "Paradise", 8);
        us.checkIn(27, "Leyton", 10);
        
        us.checkOut(45, "Waterloo", 15);  // Time: 15-3 = 12
        us.checkOut(27, "Waterloo", 20);  // Time: 20-10 = 10
        us.checkOut(32, "Cambridge", 22); // Time: 22-8 = 14
        
        System.out.println("Avg Paradise to Cambridge: " + us.getAverageTime("Paradise", "Cambridge")); // 14.0
        System.out.println("Avg Leyton to Waterloo: " + us.getAverageTime("Leyton", "Waterloo"));      // (12+10)/2 = 11.0
        
        us.checkIn(10, "Leyton", 24);
        System.out.println("Avg Leyton to Waterloo: " + us.getAverageTime("Leyton", "Waterloo"));      // Still 11.0
        
        us.checkOut(10, "Waterloo", 38);  // Time: 38-24 = 14
        System.out.println("Avg Leyton to Waterloo (Updated): " + us.getAverageTime("Leyton", "Waterloo")); // (12+10+14)/3 = 12.0
    }
}
