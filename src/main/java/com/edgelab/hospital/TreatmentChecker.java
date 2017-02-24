package com.edgelab.hospital;

import com.edgelab.hospital.complication.ComplicationChecker;

/**
 * Created by Marcin Panfil on 24.02.17.
 */
class TreatmentChecker {

    public void checkTreatment(Patient patient) {
        ComplicationChecker complicationChecker = new ComplicationChecker();
        complicationChecker.checkComplications(patient);

        if (!patient.isAlive()) return;

        patient.getMedicines().stream().filter(Medicine::isCureCompletely).forEach(m -> patient.cure(m.getCondition()));

        if(patient.getConditions().size() == 0) {
            patient.cureCompletely();
        }
    }

}
