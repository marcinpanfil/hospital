package com.edgelab.hospital.complication;

import com.edgelab.hospital.Medicine;
import com.edgelab.hospital.Patient;

/**
 * Created by Marcin Panfil on 23.02.17.
 */
@SuppressWarnings("ALL")
class AntibioticInsulinComplication implements Complication {

    @Override
    public Patient complicationResult(Patient patient) {
        if(patient.isAlive()) {
            if (patient.getConditions()[0] == 'H' && patient.getMedicines().contains(Medicine.INSULIN)
                    && patient.getMedicines().contains(Medicine.ANTIBIOTIC)) {
                patient.makeSick();
            }
        }
        return patient;
    }
}
