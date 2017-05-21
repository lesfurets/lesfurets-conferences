/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.lesfurets.model;

import java.util.Arrays;

public enum ESexe {

    HOMME(1), //
    FEMME(2);

    private final int intValue;

    ESexe(int intValue) {
        this.intValue = intValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public static ESexe fromIntValue(int intValue) {
        return Arrays.stream(values()).filter(sexe -> sexe.intValue == intValue).findFirst().orElse(null);
    }

}
