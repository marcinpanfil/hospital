package com.edgelab.hospital.report;

import com.edgelab.hospital.Patient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marcin Panfil on 23.02.17.
 */
public class TestDiseasesCounter implements DiseaseCounter {

    private final char[] possibleDiseases = {'F', 'H', 'D', 'T', 'X'};

    @Override
    public Map<Character, Integer> count(List<Patient> patients) {
        Map<Character, Integer> diseasesCount = new HashMap<>();
        for (char possibleDisease : possibleDiseases) {
            diseasesCount.put(possibleDisease, 2);
        }
        return diseasesCount;
    }
}
