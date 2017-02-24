package com.edgelab.hospital;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin Panfil on 23.02.17.
 */

@Getter
public class Patient {

    private List<Condition> conditions;
    private List<Medicine> medicines = new ArrayList<>();

    public Patient(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public void giveMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    public void cure(Condition diseaseToCure) {
        conditions.remove(diseaseToCure);
    }

    public boolean isAlive() {
        return this.conditions.get(0) != Condition.DEAD;
    }

    public void kill() {
        conditions = new ArrayList<>();
        conditions.add(Condition.DEAD);
    }

    public void makeSick() {
        conditions.remove(Condition.HEALTHY);
        conditions.add(Condition.FEVER);
    }

    public void cureCompletely() {
        conditions = new ArrayList<>();
        conditions.add(Condition.HEALTHY);
    }
}
