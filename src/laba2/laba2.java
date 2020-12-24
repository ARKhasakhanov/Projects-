package laba2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class Laba2 {

    public static void main(String[] args) {
        File[] f = getFileArray("in");
        File file = new File(f[0].getAbsolutePath());
        ObjectMapper mapper = new ObjectMapper();
        DataObject dataObject = new DataObject();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            dataObject = (DataObject)mapper.readValue(file, DataObject.class);
        } catch (IOException var13) {
            Logger.getLogger(Laba2.class.getName()).log(Level.SEVERE, (String)null, var13);
        }

        String jsonObject = new String();

        try {
            jsonObject = mapper.writeValueAsString(dataObject);
        } catch (JsonProcessingException var12) {
            Logger.getLogger(Laba2.class.getName()).log(Level.SEVERE, (String)null, var12);
        }

        jsonObject = transliterate(jsonObject);
        jsonObject = jsonObject.replace("lname", "Фамилия:");
        jsonObject = jsonObject.replace("fname", "Имя:");
        jsonObject = jsonObject.replace("mname", "Отчество:");
        jsonObject = jsonObject.replace("bdate", "Дата Рождения:");
        System.out.println(jsonObject);

        try {
            String html = "<!doctype html>\n<html dir=\"ltr\" lang=\"ru\"><head><meta charset=\"utf-8\"><title>Добро пожаловать в Chrome!</title></head><body>" + jsonObject + "</body></html>";
            File[] f1 = getFileArray("laba2");
            File file1 = new File("out1");
            FileOutputStream fos = new FileOutputStream(file1);
            fos.write(html.getBytes("utf-8"));
            fos.flush();
            fos.close();
        } catch (JsonProcessingException var10) {
            var10.printStackTrace();
        } catch (IOException var11) {
            var11.printStackTrace();
        }

    }

    public static File[] getFileArray(String path) {
        File f = new File(path);
        File[] list = f.listFiles();
        return list;
    }

    public static String transliterate(String message) {
        char[] abcCyr = new char[]{'.', ',', ' ', 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        String[] abcLat = new String[]{".", " ", " ", "a", "b", "v", "g", "d", "e", "e", "zh", "z", "i", "y", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "h", "ts", "ch", "sh", "sch", "", "i", "", "e", "ju", "ja", "A", "B", "V", "G", "D", "E", "E", "Zh", "Z", "I", "Y", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "F", "H", "Ts", "Ch", "Sh", "Sch", "", "I", "", "E", "Ju", "Ja", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < message.length(); ++i) {
            for(int x = 0; x < abcCyr.length; ++x) {
                if (message.charAt(i) == abcCyr[x]) {
                    builder.append(abcLat[x]);
                }
            }
        }

        return builder.toString();
    }
}
