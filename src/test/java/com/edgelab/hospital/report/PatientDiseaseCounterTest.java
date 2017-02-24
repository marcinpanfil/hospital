package com.edgelab.hospital.report;

import com.edgelab.hospital.Condition;
import com.edgelab.hospital.Patient;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Marcin Panfil on 23.02.17.
 */
public class PatientDiseaseCounterTest {

    private PatientDiseaseCounter patientDiseaseCounter = new PatientDiseaseCounter();
    private List<Patient> patients = new ArrayList<>();

    @Before
    public void setUp() {
        patients.add(new Patient(Arrays.asList(Condition.FEVER, Condition.TUBERCULOSIS)));
        patients.add(new Patient(Arrays.asList(Condition.FEVER, Condition.DIABETES)));
        patients.add(new Patient(Arrays.asList(Condition.DIABETES, Condition.TUBERCULOSIS)));
        patients.add(new Patient(Arrays.asList(Condition.HEALTHY)));
        patients.add(new Patient(Arrays.asList(Condition.DEAD)));
    }

    @Test
    public void count() throws Exception {
        Map<Condition, MutableInt> count = patientDiseaseCounter.count(patients);
        assertEquals(2, count.get(Condition.FEVER).get());
        assertEquals(2, count.get(Condition.TUBERCULOSIS).get());
        assertEquals(1, count.get(Condition.HEALTHY).get());
        assertEquals(2, count.get(Condition.DIABETES).get());
        assertEquals(1, count.get(Condition.DEAD).get());
    }

}