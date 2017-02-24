package com.edgelab.hospital.complication;

import com.edgelab.hospital.Medicine;
import com.edgelab.hospital.Patient;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by Marcin Panfil on 24.02.17.
 */
public class UntreatedDiabetesComplication implements Complication {
    @Override
    public Patient complicationResult(Patient patient) {
        if (ArrayUtils.contains(patient.getConditions(), 'D')
                && !patient.getMedicines().contains(Medicine.INSULIN)) {
            patient.kill();
        }
        return patient;
    }
}
