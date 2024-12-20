package com.lcaohoanq.mode;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class WindowsShutdown {

    public interface User32 extends Library {
        User32 INSTANCE = (User32) Native.load("user32", User32.class);

        boolean ExitWindowsEx(int uFlags, int dwReason);
    }

    public static void shutdown(){
        // Flags for shutdown, see: https://docs.microsoft.com/en-us/windows/win32/api/winuser/nf-winuser-exitwindowsex
        int EWX_SHUTDOWN = 0x00000001;
        int EWX_FORCE = 0x00000004;

        try {
            boolean success = User32.INSTANCE.ExitWindowsEx(EWX_SHUTDOWN | EWX_FORCE, 0);
            if (success) {
                System.out.println("Computer shutdown initiated successfully.");
            } else {
                System.err.println("Failed to initiate computer shutdown. Please ensure you have sufficient privileges.");
            }
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Error: Unable to load user32.dll library. Make sure you're running on Windows.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

    }
}
