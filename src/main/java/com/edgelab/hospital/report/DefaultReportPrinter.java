package com.edgelab.hospital.report;

import com.edgelab.hospital.Condition;
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
        Map<Condition, MutableInt> conditionCount = diseaseCounter.count(patients);
        for (Condition condition : conditionCount.keySet()) {
            outputBuilder.append(condition.getCondition());
            outputBuilder.append(":");
            outputBuilder.append(conditionCount.get(condition).get());
            outputBuilder.append(" ");
        }
        return outputBuilder.toString().replaceAll("[ ]$", "");
    }
}
