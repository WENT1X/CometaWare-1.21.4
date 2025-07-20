package fun.exort.util.hwid;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class HWIDChecker {
    // Замените на вашу RAW-ссылку с Pastebin (https://pastebin.com/raw/xxxxxxxx)
    private static final String PASTEBIN_URL = "https://pastebin.com/raw/xa7EkypP";

    public static boolean isValidHWID() {
        try {
            // Получаем HWID устройства
            String hwid = HWID.getHWID();
            System.out.println("Generated HWID: " + hwid);

            // Запрашиваем список HWID с Pastebin
            URL url = new URL(PASTEBIN_URL);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder pasteContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                pasteContent.append(line).append("\n");
            }
            reader.close();

            // Разделяем содержимое на список HWID (каждый HWID на новой строке)
            List<String> allowedHWIDs = Arrays.asList(pasteContent.toString().trim().split("\n"));

            // Проверяем, есть ли HWID в списке
            return allowedHWIDs.contains(hwid);
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Если ошибка (например, нет интернета), блокируем доступ
        }
    }
}