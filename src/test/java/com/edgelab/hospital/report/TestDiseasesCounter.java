package com.edgelab.hospital.report;

import com.edgelab.hospital.Condition;
import com.edgelab.hospital.Patient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marcin Panfil on 23.02.17.
 */
public class TestDiseasesCounter implements DiseaseCounter {


    @Override
    public Map<Condition, MutableInt> count(List<Patient> patients) {
        Map<Condition, MutableInt> diseasesCount = new HashMap<>();
        for (Condition condition : Condition.values()) {
            diseasesCount.put(condition, new MutableInt(2));
        }
        return diseasesCount;
    }
}
