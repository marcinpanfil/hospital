package com.edgelab.hospital.report;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Created by Marcin Panfil on 24.02.17.
 */

@NoArgsConstructor
@AllArgsConstructor
class MutableInt {

    private int value = 0;

    public void increment() {
        ++value;
    }

    public int get() {
        return value;
    }

}
