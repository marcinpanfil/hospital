package com.edgelab.hospital;

import lombok.Getter;

/**
 * Created by Marcin Panfil on 23.02.17.
 */

@Getter
public enum Medicine {

    ASPIRIN('F', true),
    ANTIBIOTIC('T', true),
    INSULIN('D', false),
    PARACETAMOL('F', true);

    private char disease;
    private boolean cureCompletely;

    Medicine(char disease, boolean cureCompletely) {
        this.disease = disease;
        this.cureCompletely = cureCompletely;
    }



}
