package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {
    private int changesAmount=0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        changesAmount++;
        System.out.println("Update nr " + changesAmount);
        System.out.println(message);
        System.out.println(worldMap);

    }
}
