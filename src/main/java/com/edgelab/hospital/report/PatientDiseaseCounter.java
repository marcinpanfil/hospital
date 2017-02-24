package com.edgelab.hospital.report;

import com.edgelab.hospital.Condition;
import com.edgelab.hospital.Patient;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marcin Panfil on 23.02.17.
 */
public class PatientDiseaseCounter implements DiseaseCounter {

    public Map<Condition, MutableInt> count(List<Patient> patients) {
        Map<Condition, MutableInt> count = new LinkedHashMap<>();
        for (Condition condition : Condition.values()) {
            count.put(condition, new MutableInt());
        }
        patients.stream().forEach(p -> {
            p.getConditions().forEach(c -> {
                MutableInt value = count.get(c);
                value.increment();
            });
        });
        return count;
    }


}
