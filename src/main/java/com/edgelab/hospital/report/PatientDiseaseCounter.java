package com.edgelab.hospital.report;

import com.edgelab.hospital.Patient;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marcin Panfil on 23.02.17.
 */
public class PatientDiseaseCounter implements DiseaseCounter {

    private final char[] possibleDiseases = {'F', 'H', 'D', 'T', 'X'};

    public Map<Character, Integer> count(List<Patient> patients) {
        Map<Character, Integer> count = new LinkedHashMap<>();
        StringBuilder diseases = new StringBuilder();
        patients.forEach(patient -> diseases.append(patient.getConditions()));
        for (char possibleDisease : possibleDiseases) {
            count.put(possibleDisease, StringUtils.countMatches(diseases, possibleDisease));
        }
        return count;
    }

}
