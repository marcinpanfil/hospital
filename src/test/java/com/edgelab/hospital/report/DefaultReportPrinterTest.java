package com.edgelab.hospital.report;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Marcin Panfil on 23.02.17.
 */
public class DefaultReportPrinterTest {

    private ReportPrinter reportPrinter = new DefaultReportPrinter(new TestDiseasesCounter());

    @Test
    public void print() throws Exception {
        String output = reportPrinter.print(null);
        assertTrue(output.contains("F:2"));
        assertTrue(output.contains("H:2"));
        assertTrue(output.contains("D:2"));
        assertTrue(output.contains("T:2"));
        assertTrue(output.contains("X:2"));
    }

}