package com.edgelab.hospital;

import com.edgelab.hospital.report.DefaultReportPrinter;
import com.edgelab.hospital.report.PatientDiseaseCounter;
import com.edgelab.hospital.report.ReportPrinter;

import java.util.ArrayList;
import java.util.List;

public class Quarantine {

    private List<Patient> patients = new ArrayList<>();
    private ReportPrinter reportPrinter = new DefaultReportPrinter(new PatientDiseaseCounter());
    private TreatmentChecker treatmentChecker = new TreatmentChecker();

    public Quarantine(String subjects) {
        String[] patientsState = subjects.split(",");
        for (String state : patientsState) {
            patients.add(new Patient(state.toCharArray()));
        }
    }

    public void aspirin() {
        patients.forEach(patient -> patient.giveMedicine(Medicine.ASPIRIN));
    }

    public void antibiotic() {
        patients.forEach(patient -> patient.giveMedicine(Medicine.ANTIBIOTIC));
    }

    public void insulin() {
        patients.forEach(patient -> patient.giveMedicine(Medicine.INSULIN));
    }

    public void paracetamol() {
        patients.forEach(patient -> patient.giveMedicine(Medicine.PARACETAMOL));
    }

    public void wait40Days() {
        patients.forEach(patient -> treatmentChecker.checkTreatment(patient));
    }

    public String report() {
        return reportPrinter.print(patients);
    }

}
