package com.lcaohoanq.mode;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.win32.W32APIOptions;

public class WindowsSleep {
    public interface PowrProf extends Library {
        PowrProf INSTANCE = Native.load("PowrProf", PowrProf.class, W32APIOptions.DEFAULT_OPTIONS);

        boolean SetSuspendState(boolean hibernate, boolean forceCritical, boolean disableWakeEvent);
    }

    public static void sleep() {
        PowrProf.INSTANCE.SetSuspendState(false, true, true);
    }

    public static void main(String[] args) {
        sleep();
    }
}

