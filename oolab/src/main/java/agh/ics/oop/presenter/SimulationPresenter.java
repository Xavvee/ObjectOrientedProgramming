package agh.ics.oop.presenter;

import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

import static agh.ics.oop.OptionsParser.parse;


public class SimulationPresenter implements MapChangeListener {
    private WorldMap map;

    @FXML
    private Label infoLabel;

    @FXML
    private TextField movementTextField;

    private SimulationEngine simulationEngine;

    public void setSimulationEngine(SimulationEngine simulationEngine) {
        this.simulationEngine = simulationEngine;
    }

    public String[] getMoves() {
        String movesString = movementTextField.getText();
        return movesString.split("\\s+");
    }
    public void setWorldMap(WorldMap map){
        this.map = map;
    }

    public void drawMap(WorldMap worldMap){
        this.infoLabel.setText(worldMap.toString());
    }


    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        Platform.runLater(()->{
            drawMap(worldMap);
        });
    }

    public void onSimulationStartClicked() {
        List<MoveDirection> directions = parse(List.of(this.getMoves()));
        List<Vector2d> positions = List.of(new Vector2d(0,0), new Vector2d(0,2));
        GrassField map = new GrassField(4);
        this.setWorldMap(map);
        map.addObserver(this);
        Simulation simulation = new Simulation(positions, directions, map);
        simulationEngine = new SimulationEngine(List.of(simulation));
        simulationEngine.runAsyncInThreadPool();
    }


}
