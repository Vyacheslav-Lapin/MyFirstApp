package com.example.myfirstapp;


import java.util.function.BiConsumer;
import java.util.function.Consumer;

import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
public class Log {

    private static <T, U> Consumer<U> partialLeft(BiConsumer<T, U> biConsumer, T t) {
        return u -> biConsumer.accept(t, u);
    }

//    public void wtf(String s) {
//        android.util.Log.wtf(tag, s);
//    }
    Consumer<String> wtf;
    Consumer<String> e;
    Consumer<String> w;
    Consumer<String> i;
    Consumer<String> d;
    Consumer<String> v;

    public Log(String tag) {
        wtf = partialLeft(android.util.Log::wtf, tag);
        e = partialLeft(android.util.Log::e, tag);
        w = partialLeft(android.util.Log::w, tag);
        i = partialLeft(android.util.Log::i, tag);
        d = partialLeft(android.util.Log::d, tag);
        v = partialLeft(android.util.Log::v, tag);
    }

    public void e(String s) {
//        android.util.Log.e(tag, s);
        e.accept(s);
    }

    public void w(String s) {
        w.accept(s);
    }

    public void i(String s) {
        i.accept(s);
    }

    public void d(String s) {
        d.accept(s);
    }

    public void v(String s) {
        v.accept(s);
    }
}
