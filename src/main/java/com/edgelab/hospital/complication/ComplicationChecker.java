package com.edgelab.hospital.complication;

import com.edgelab.hospital.Patient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin Panfil on 23.02.17.
 */
public class ComplicationChecker {

    private List<Complication> complications = new ArrayList<>();

    public ComplicationChecker() {
        complications.add(new AntibioticInsulinComplication());
        complications.add(new AspirinParacetamolComplication());
        complications.add(new UntreatedDiabetesComplication());
    }

    public void checkComplications(Patient patients) {
        complications.forEach(c -> c.complicationResult(patients));
    }

}
