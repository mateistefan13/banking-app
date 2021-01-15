package com.bankingproject.utils;

import java.util.concurrent.atomic.AtomicLong;

public class IdGeneratingClass {

    private IdGeneratingClass() {

    }

    public static AtomicLong generateIdForClient = new AtomicLong(0);

    public static AtomicLong generateIdforAdmin = new AtomicLong(0);

    public static AtomicLong generateIdForBankAccount = new AtomicLong(0);

    public static AtomicLong generateIdForTransaction = new AtomicLong(0);

}
