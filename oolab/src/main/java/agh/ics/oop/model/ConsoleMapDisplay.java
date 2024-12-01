package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {
    private int changesAmount=0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        synchronized (System.out) {
            changesAmount++;
            System.out.println("Update nr " + changesAmount + " : " + message + " on map with ID: " + worldMap.getId());
            System.out.println(worldMap);
        }
    }
}
