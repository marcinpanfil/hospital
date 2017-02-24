package com.edgelab.hospital.report;

import com.edgelab.hospital.Patient;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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
        patients.add(new Patient(new char[]{'F', 'T'}));
        patients.add(new Patient(new char[]{'F', 'D'}));
        patients.add(new Patient(new char[]{'D', 'T'}));
        patients.add(new Patient(new char[]{'X'}));
        patients.add(new Patient(new char[]{'H'}));
    }

    @Test
    public void count() throws Exception {
        Map<Character, Integer> count = patientDiseaseCounter.count(patients);
        assertEquals(2, count.get('F').intValue());
        assertEquals(2, count.get('T').intValue());
        assertEquals(1, count.get('H').intValue());
        assertEquals(2, count.get('D').intValue());
        assertEquals(1, count.get('X').intValue());
    }

}