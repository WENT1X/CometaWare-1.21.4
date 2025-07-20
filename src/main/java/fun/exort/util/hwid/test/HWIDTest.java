package fun.exort.util.hwid.test;

import fun.exort.util.hwid.HWID;

public class HWIDTest {
    public static void main(String[] args) {
        try {
            String hwid = HWID.getHWID();
            System.out.println("Your HWID: " + hwid);
        } catch (Exception e) {
            System.err.println("Failed to generate HWID: " + e.getMessage());
        }
    }
}