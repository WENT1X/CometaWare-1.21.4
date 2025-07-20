package fun.cometaware.util.hwid;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.Enumeration;

public class HWID {
    public static String getHWID() throws Exception {
        StringBuilder hwid = new StringBuilder();

        // Получаем серийный номер диска (Windows)
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            hwid.append(System.getenv("PROCESSOR_IDENTIFIER"))
                    .append(System.getenv("COMPUTERNAME"));
        } else {
            // Для Linux/MacOS используем MAC-адрес
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface ni = networkInterfaces.nextElement();
                byte[] hardwareAddress = ni.getHardwareAddress();
                if (hardwareAddress != null) {
                    for (byte b : hardwareAddress) {
                        hwid.append(String.format("%02X", b));
                    }
                    break;
                }
            }
        }

        // Шифруем HWID с помощью SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(hwid.toString().getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}