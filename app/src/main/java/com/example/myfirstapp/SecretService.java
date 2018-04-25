package com.example.myfirstapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public class SecretService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
//        "abc([sdg]*\\ddfdfd\\f)?"
        return null;
    }
}
