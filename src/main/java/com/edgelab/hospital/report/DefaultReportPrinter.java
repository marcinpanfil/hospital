package com.edgelab.hospital.report;

import com.edgelab.hospital.Patient;

import java.util.List;
import java.util.Map;

/**
 * Created by Marcin Panfil on 23.02.17.
 */
public class DefaultReportPrinter implements ReportPrinter {

    private DiseaseCounter diseaseCounter;

    public DefaultReportPrinter(DiseaseCounter diseaseCounter) {
        this.diseaseCounter = diseaseCounter;
    }

    @Override
    public String print(List<Patient> patients) {
        StringBuilder outputBuilder = new StringBuilder();
        Map<Character, Integer> diseaseCount = diseaseCounter.count(patients);
        for (Character diseaseName : diseaseCount.keySet()) {
            outputBuilder.append(diseaseName);
            outputBuilder.append(":");
            outputBuilder.append(diseaseCount.get(diseaseName));
            outputBuilder.append(" ");
        }
        return outputBuilder.toString().replaceAll("[ ]$", "");
    }
}
