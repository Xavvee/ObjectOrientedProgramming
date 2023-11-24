package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine {
    private final List<Simulation> simulations;
    private final List<Thread> simulationThreads;
    public SimulationEngine(List<Simulation> simulations){
        this.simulations = simulations;
        this.simulationThreads = new ArrayList<>();
    }

    public void runSync(){
        for( Simulation simulation : simulations){
            simulation.run();
        }
    }

    public void runAsync() {
        for (Simulation simulation : simulations) {
            Thread thread = new Thread(() -> {
                synchronized (simulation) {
                    simulation.run();
                }
            });
            simulationThreads.add(thread);
            thread.start();
        }
    }

    public void awaitSimulationsEnd() throws InterruptedException {
        for(Thread simThread : simulationThreads){
            simThread.join();
        }
    }

    
}
