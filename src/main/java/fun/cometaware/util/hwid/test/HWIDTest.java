package fun.cometaware.util.hwid.test;

import fun.cometaware.util.hwid.HWID;

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