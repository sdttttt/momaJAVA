package com.moma.Tools;

import java.util.UUID;

public class Tools {
    public static String randChar(){

        UUID uuid = UUID.randomUUID();
        String[] strings = uuid.toString().split("-");
        return strings[0] + strings[1] + strings[2];

    }
}
