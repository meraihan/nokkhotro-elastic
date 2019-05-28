package com.datasoft.proshomon.backend.model;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class Utils {
    private static AtomicLong prescriptionUniqueIdentifier = new AtomicLong(new Date().getTime());
    private static AtomicLong transactionUniqueIdentifier = new AtomicLong(new Date().getTime());

    public static String generatePrescriptionId() {
        return String.valueOf(prescriptionUniqueIdentifier.incrementAndGet());
    }

    public static String generateTransactionId() {
        return String.valueOf(transactionUniqueIdentifier.incrementAndGet());
    }

    public static void updateAtomicValueCounters(long prescriptionIdentifier, long transactionIdentifier) {
        prescriptionUniqueIdentifier = new AtomicLong(prescriptionIdentifier);
        transactionUniqueIdentifier = new AtomicLong(transactionIdentifier);
    }
}
