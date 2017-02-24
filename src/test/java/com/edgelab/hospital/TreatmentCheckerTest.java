package com.edgelab.hospital;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Marcin Panfil on 24.02.17.
 */

public class TreatmentCheckerTest {

    private TreatmentChecker treatmentChecker = new TreatmentChecker();

    @Test
    public void testTreatmentWithParacetamolAndInsulin() {
        Patient patient = new Patient("FD".toCharArray());
        patient.giveMedicine(Medicine.INSULIN);
        patient.giveMedicine(Medicine.PARACETAMOL);
        treatmentChecker.checkTreatment(patient);
        assertEquals(patient.getConditions().length, 1);
        assertEquals(patient.getConditions()[0], 'D');
    }

    @Test
    public void testTreatmentWithAspirinAndInsulin() {
        Patient patient = new Patient("FD".toCharArray());
        patient.giveMedicine(Medicine.INSULIN);
        patient.giveMedicine(Medicine.ASPIRIN);
        treatmentChecker.checkTreatment(patient);
        assertEquals(patient.getConditions().length, 1);
        assertEquals(patient.getConditions()[0], 'D');
    }

    @Test
    public void testTreatmentWithAspirinInsulinAntibiotic() {
        Patient patient = new Patient("FDT".toCharArray());
        patient.giveMedicine(Medicine.INSULIN);
        patient.giveMedicine(Medicine.ASPIRIN);
        patient.giveMedicine(Medicine.ANTIBIOTIC);
        treatmentChecker.checkTreatment(patient);
        assertEquals(patient.getConditions().length, 1);
        assertEquals(patient.getConditions()[0], 'D');
    }

    @Test
    public void testTreatmentOfHealthyPatientWithInsulinAntibiotic() {
        Patient patient = new Patient("H".toCharArray());
        patient.giveMedicine(Medicine.INSULIN);
        patient.giveMedicine(Medicine.ANTIBIOTIC);
        treatmentChecker.checkTreatment(patient);
        assertEquals(patient.getConditions().length, 1);
        assertEquals(patient.getConditions()[0], 'F');
    }

    /*
    After antibiotic and insulin healthy guy should have fever, but he/she took also aspirin, which cures fever.
    So he/she is healthy.
     */
    @Test
    public void testTreatmentOfHealthyPatientWithAspirinInsulinAntibiotic() {
        Patient patient = new Patient("H".toCharArray());
        patient.giveMedicine(Medicine.INSULIN);
        patient.giveMedicine(Medicine.ASPIRIN);
        patient.giveMedicine(Medicine.ANTIBIOTIC);
        treatmentChecker.checkTreatment(patient);
        assertEquals(patient.getConditions().length, 1);
        assertEquals(patient.getConditions()[0], 'H');
    }

    @Test
    public void testTreatmentOfUntreatedDiabetes() {
        Patient patient = new Patient("FD".toCharArray());
        patient.giveMedicine(Medicine.ASPIRIN);
        treatmentChecker.checkTreatment(patient);
        assertEquals(patient.getConditions().length, 1);
        assertEquals(patient.getConditions()[0], 'X');
    }


}