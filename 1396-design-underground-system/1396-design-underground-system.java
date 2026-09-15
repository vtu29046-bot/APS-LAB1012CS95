import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // id -> [stationName, checkInTime]
    private Map<Integer, CheckInData> checkIns;

    // "start#end" -> [totalTime, numberOfTrips]
    private Map<String, RouteData> routes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInData(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInData data = checkIns.get(id);

        String route = data.stationName + "#" + stationName;
        int travelTime = t - data.time;

        RouteData routeData = routes.getOrDefault(
            route,
            new RouteData(0, 0)
        );

        routeData.totalTime += travelTime;
        routeData.trips++;

        routes.put(route, routeData);

        // Customer is no longer checked in
        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "#" + endStation;

        RouteData routeData = routes.get(route);

        return (double) routeData.totalTime / routeData.trips;
    }

    // Stores customer's check-in information
    private static class CheckInData {
        String stationName;
        int time;

        CheckInData(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    // Stores total travel time and number of trips for a route
    private static class RouteData {
        int totalTime;
        int trips;

        RouteData(int totalTime, int trips) {
            this.totalTime = totalTime;
            this.trips = trips;
        }
    }
}
