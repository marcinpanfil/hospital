package com.edgelab.hospital.report;

import com.edgelab.hospital.Patient;

import java.util.List;

/**
 * Created by Marcin Panfil on 23.02.17.
 */
public interface ReportPrinter {

    String print(List<Patient> patients);

}
