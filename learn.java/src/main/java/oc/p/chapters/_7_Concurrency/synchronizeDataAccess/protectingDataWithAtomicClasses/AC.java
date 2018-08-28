package oc.p.chapters._7_Concurrency.synchronizeDataAccess.protectingDataWithAtomicClasses;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.atomic.*;

class AC {

    AtomicBoolean atomicBoolean = new AtomicBoolean(true);
    {
        atomicBoolean = new AtomicBoolean(new Boolean(true));
    }

    AtomicInteger atomicInteger = new AtomicInteger(12);
    {
        atomicInteger = new AtomicInteger(new Integer(7));
    }

    AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[]{1, 2, 3});
    {
//        atomicInteger = new AtomicInteger(new Integer[]{new Integer(1), new Integer(2)});
    }

    AtomicLong atomicLong = new AtomicLong(2);
    {
        atomicLong = new AtomicLong(new Long(2));
    }

    AtomicReference<String> atomicReference = new AtomicReference<>("Ana");
    {
        atomicReference = new AtomicReference<>(new String("Ana"));
    }

    AtomicReferenceArray<LocalDate> atomicReferenceArray = new AtomicReferenceArray<LocalDate>(new LocalDate[2]);
}
