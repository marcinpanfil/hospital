package com.edgelab.hospital.report;

import com.edgelab.hospital.Patient;

import java.util.List;
import java.util.Map;

/**
 * Created by Marcin Panfil on 23.02.17.
 */
interface DiseaseCounter {

    Map<Character, Integer> count(List<Patient> patients);

}
