package com.soa.framework.core.interactions;

import com.soa.framework.core.interactions.objects.EditText;

/**
 * Created by Carlo Matulessy on 11-7-17.
 */

public class Enter extends Interaction {

    public static EditText theValue(String value) {
        EditText editText = new EditText(value);
        return editText;
    }
}
