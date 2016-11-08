package com.intertech.lab8;

import java.util.concurrent.Future;

public interface PigLatinService {
    //Sync
//    String translate(String english);

    //Async
    Future<String> translate(String english);
}
