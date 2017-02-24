package com.edgelab.hospital;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marcin Panfil on 24.02.17.
 */


public enum Condition {

    FEVER("F"),
    HEALTHY("H"),
    DIABETES("D"),
    TUBERCULOSIS("T"),
    DEAD("X");

    @Getter
    private String condition;
    private static Map<String, Condition> conditions;

    static {
        conditions = new HashMap<>();
        conditions.put("H", Condition.HEALTHY);
        conditions.put("F", Condition.FEVER);
        conditions.put("D", Condition.DIABETES);
        conditions.put("T", Condition.TUBERCULOSIS);
        conditions.put("X", Condition.DEAD);
    }

    Condition(String condition) {
        this.condition = condition;
    }

    public static Condition getByShortName(String name) {
        return conditions.get(name);
    }

}
