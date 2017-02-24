package com.edgelab.hospital;

import lombok.Getter;

/**
 * Created by Marcin Panfil on 23.02.17.
 */

@Getter
public enum Medicine {

    ASPIRIN(Condition.FEVER, true),
    ANTIBIOTIC(Condition.TUBERCULOSIS, true),
    INSULIN(Condition.DIABETES, false),
    PARACETAMOL(Condition.FEVER, true);

    private Condition condition;
    private boolean cureCompletely;

    Medicine(Condition condition, boolean cureCompletely) {
        this.condition = condition;
        this.cureCompletely = cureCompletely;
    }

}
