package com.edgelab.hospital;

import lombok.Getter;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin Panfil on 23.02.17.
 */

@Getter
public class Patient {

    private char[] conditions;
    private List<Medicine> medicines = new ArrayList<>();

    public Patient(char[] conditions) {
        this.conditions = conditions;
    }

    public void giveMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    public void cure(char diseaseCure) {
        this.conditions = ArrayUtils.removeElement(this.conditions, diseaseCure);
    }

    public boolean isAlive() {
        return this.conditions[0] != 'X';
    }

    public void kill() {
        conditions = new char[]{'X'};
    }

    public void makeSick() {
        conditions = new char[]{'F'};
    }

    public void cureCompletely() {
        conditions = new char[] {'H'};
    }
}
