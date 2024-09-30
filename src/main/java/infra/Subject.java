package infra;

import java.util.ArrayList;

public abstract class Subject {
    ArrayList<Observer> observers;

    public Subject(){
        observers = new ArrayList<>();
    }

    public void addObserver(Observer ob){
        if(observers==null){
            observers=new ArrayList<>();
        }
        observers.add(ob);
    }

    public void notifyAllObservers(){
        for (Observer each : observers) {
            try {
                each.update(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
