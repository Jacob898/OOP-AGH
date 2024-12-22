package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class SimulationPresenter implements MapChangeListener {

    private WorldMap map;

    public void setWorldMap (WorldMap map){
        this.map=map;
    }

    @FXML
    private Label infoLabel;
    @FXML
    private TextField movesListTextField;
    @FXML
    private Button startButton;
    @FXML
    private Label moveLabel;
    @FXML
    private GridPane mapGrid;

    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0));
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }

    private void drawGridAxes(Boundary boundary) {
        Label label = new Label("x/y");
        label.setMinWidth(50);
        label.setMinHeight(50);
        label.setAlignment(Pos.CENTER);
        mapGrid.add(label ,0,0);

        for(int x = boundary.mapBottomLeft().getX(); x <= boundary.mapTopRight().getX(); x++) {
            Label labelX = new Label(Integer.toString(x));
            labelX.setMinWidth(50);
            labelX.setMinHeight(50);
            labelX.setAlignment(Pos.CENTER);
            mapGrid.add(labelX, x + 1 - boundary.mapBottomLeft().getX(), 0);
        }

        for(int y = boundary.mapBottomLeft().getY(); y <= boundary.mapTopRight().getY(); y++) {
            Label labelY = new Label(Integer.toString(y));
            labelY.setMinWidth(50);
            labelY.setMinHeight(50);
            labelY.setAlignment(Pos.CENTER);
            mapGrid.add(labelY, 0, boundary.mapTopRight().getY()-y+1);
        }

    }

    private void drawGrid(Boundary boundary) {
        for (int i = boundary.mapBottomLeft().getY(); i <= boundary.mapTopRight().getY(); i++) {
            for (int j = boundary.mapBottomLeft().getX(); j <= boundary.mapTopRight().getX(); j++) {
                Vector2d position = new Vector2d(j, i);
                drawGridCell(position, j - boundary.mapBottomLeft().getX() + 1, boundary.mapTopRight().getY() - i + 1);
            }
        }
    }

    private void drawGridCell(Vector2d position, int column, int row) {
        WorldElement element = map.objectAt(position);
        Label label = createLabelForElement(element);
        mapGrid.add(label, column, row);
    }

    private Label createLabelForElement(WorldElement element) {
        Label label;
        if (element != null) {
            label = new Label(element.toString());
        } else {
            label = new Label(" ");
        }
        label.setMinWidth(50);
        label.setMinHeight(50);
        label.setAlignment(Pos.CENTER);
        return label;
    }

    public void drawMap(){
        clearGrid();

        Boundary boundary = map.getCurrentBounds();
        drawGridAxes(boundary);
        drawGrid(boundary);

        infoLabel.setText("");
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        Platform.runLater(()-> {
            this.drawMap();
            moveLabel.setText(message);
        });
    }

    @FXML
    public void onSimulationStartClicked() {
        String movesString = movesListTextField.getText();
        try {
            List<MoveDirection> movesList = OptionsParser.parse(movesString.split(""));
            List<Simulation> simulationsList = new ArrayList<>();
            simulationsList.add(new Simulation(List.of(new Vector2d(1,1), new Vector2d(3,4)),movesList,map));

            new Thread (() -> {
                SimulationEngine engine = new SimulationEngine(simulationsList);
                engine.runAsync();
            }).start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}