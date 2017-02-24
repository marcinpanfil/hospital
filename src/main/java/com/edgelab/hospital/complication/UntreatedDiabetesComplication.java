package com.edgelab.hospital.complication;

import com.edgelab.hospital.Condition;
import com.edgelab.hospital.Medicine;
import com.edgelab.hospital.Patient;

/**
 * Created by Marcin Panfil on 24.02.17.
 */
public class UntreatedDiabetesComplication implements Complication {
    @Override
    public Patient complicationResult(Patient patient) {
        if (patient.getConditions().contains(Condition.DIABETES)
                && !patient.getMedicines().contains(Medicine.INSULIN)) {
            patient.kill();
        }
        return patient;
    }
}
