package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class TruckDelivery {
    private double minDistance = Double.MAX_VALUE;
    private List<Coordinate> result;

    public List<Coordinate> getDeliverieyDestinations(List<Coordinate> destinations, int deliveries) {
        if (destinations.size() < deliveries) {
            return null;
        }
        List<Coordinate> list = new ArrayList<>();
        Coordinate origin = new Coordinate(0, 0);
        getDest(destinations, origin, deliveries, list, 0);
        return result;
    }

    private void getDest(List<Coordinate> destinations, Coordinate o, int deliveries, List<Coordinate> list, double distance) {
        if (distance >= minDistance) {
            return;
        }
        if (deliveries == 0) {
            if (distance < minDistance) {
                minDistance = distance;
                result = new ArrayList<>(list);
            }
            return;
        }
        int size = destinations.size();
        for (int i = 0; i < size; i++) {
            Coordinate c = destinations.get(i);
            double dist  = getDistance(o, c);
            destinations.remove(c);
            list.add(c);
            getDest(destinations, c, deliveries - 1, list, distance + dist);
            list.remove(c);
            destinations.add(i, c);
        }
    }

    private double getDistance(Coordinate a, Coordinate b) {
        return Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
    }

    private static class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        TruckDelivery td = new TruckDelivery();
        List<Coordinate> list = new ArrayList<>();
        list.add(new Coordinate(1, 2));
        list.add(new Coordinate(3, 4));
        list.add(new Coordinate(1, -1));
        List<Coordinate> l = td.getDeliverieyDestinations(list, 2);

        for (Coordinate c : l) {
            System.out.println(c.x + " " + c.y);
        }

    }
}
