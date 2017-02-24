package com.edgelab.hospital;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Marcin Panfil on 24.02.17.
 */

public class TreatmentCheckerTest {

    private TreatmentChecker treatmentChecker = new TreatmentChecker();

    @Test
    public void testTreatmentWithParacetamolAndInsulin() {
        Patient patient = new Patient(new ArrayList<>(Arrays.asList(Condition.FEVER, Condition.DIABETES)));
        patient.giveMedicine(Medicine.INSULIN);
        patient.giveMedicine(Medicine.PARACETAMOL);
        treatmentChecker.checkTreatment(patient);
        assertEquals(patient.getConditions().size(), 1);
        assertTrue(patient.getConditions().contains(Condition.DIABETES));
    }

    @Test
    public void testTreatmentWithAspirinAndInsulin() {
        Patient patient = new Patient(new ArrayList<>(Arrays.asList(Condition.FEVER, Condition.DIABETES)));
        patient.giveMedicine(Medicine.INSULIN);
        patient.giveMedicine(Medicine.ASPIRIN);
        treatmentChecker.checkTreatment(patient);
        assertEquals(patient.getConditions().size(), 1);
        assertTrue(patient.getConditions().contains(Condition.DIABETES));
    }

    @Test
    public void testTreatmentWithAspirinInsulinAntibiotic() {
        Patient patient = new Patient(
                new ArrayList<>(Arrays.asList(Condition.FEVER, Condition.DIABETES, Condition.TUBERCULOSIS)));
        patient.giveMedicine(Medicine.INSULIN);
        patient.giveMedicine(Medicine.ASPIRIN);
        patient.giveMedicine(Medicine.ANTIBIOTIC);
        treatmentChecker.checkTreatment(patient);
        assertEquals(patient.getConditions().size(), 1);
        assertTrue(patient.getConditions().contains(Condition.DIABETES));
    }

    @Test
    public void testTreatmentOfHealthyPatientWithInsulinAntibiotic() {
        Patient patient = new Patient(new ArrayList<>(Arrays.asList(Condition.HEALTHY)));
        patient.giveMedicine(Medicine.INSULIN);
        patient.giveMedicine(Medicine.ANTIBIOTIC);
        treatmentChecker.checkTreatment(patient);
        assertEquals(patient.getConditions().size(), 1);
        assertTrue(patient.getConditions().contains(Condition.FEVER));
    }

    /*
    After antibiotic and insulin healthy guy should have fever, but he/she took also aspirin, which cures fever.
    So he/she is healthy.
     */
    @Test
    public void testTreatmentOfHealthyPatientWithAspirinInsulinAntibiotic() {
        Patient patient = new Patient(new ArrayList<>(Arrays.asList(Condition.HEALTHY)));
        patient.giveMedicine(Medicine.INSULIN);
        patient.giveMedicine(Medicine.ASPIRIN);
        patient.giveMedicine(Medicine.ANTIBIOTIC);
        treatmentChecker.checkTreatment(patient);
        assertEquals(patient.getConditions().size(), 1);
        assertTrue(patient.getConditions().contains(Condition.HEALTHY));
    }

    @Test
    public void testTreatmentOfUntreatedDiabetes() {
        Patient patient = new Patient(new ArrayList<>(Arrays.asList(Condition.FEVER, Condition.DIABETES)));
        patient.giveMedicine(Medicine.ASPIRIN);
        treatmentChecker.checkTreatment(patient);
        assertEquals(patient.getConditions().size(), 1);
        assertTrue(patient.getConditions().contains(Condition.DEAD));
    }

}