package com.edgelab.hospital.complication;

import com.edgelab.hospital.Medicine;
import com.edgelab.hospital.Patient;

/**
 * Created by Marcin Panfil on 23.02.17.
 */
class AspirinParacetamolComplication implements Complication {

    @Override
    public Patient complicationResult(Patient patient) {
        if(patient.isAlive()) {
            if (patient.getMedicines().contains(Medicine.ASPIRIN) && patient.getMedicines().contains(Medicine.PARACETAMOL)) {
                patient.kill();
            }
        }
        return patient;
    }
}
