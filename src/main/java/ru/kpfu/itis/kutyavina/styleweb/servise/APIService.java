package ru.kpfu.itis.kutyavina.styleweb.servise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class APIService {

    @Autowired
    Logger logger;

    private static String URL_EMAIL = "https://cleaner.dadata.ru/api/v1/clean/email";
    private static String URL_PHONE = "https://cleaner.dadata.ru/api/v1/clean/phone";
    private static String TOKEN = "8809edcac820bf5caaaa1ef4d8071259815212de";

    public boolean checkEmail(String email) {
        try {
            String postData = "[ \"" + email + "\" ]";
            URL object = new URL(URL_EMAIL);
                HttpURLConnection con = (HttpURLConnection) object.openConnection();
            con.setDoInput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Authorization","Token " +  TOKEN);
            con.setRequestProperty("X-Secret", "fc0528818eb61d5947a3406e42982182e7e5027f");
            con.setDoOutput(true);
            OutputStream outputStream = con.getOutputStream();
            outputStream.write(postData.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            outputStream.close();

            StringBuilder sb = new StringBuilder();
            int HttpResult = con.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                String answ = sb.toString();
                int result = Integer.parseInt(Character.toString(answ.split("qc\":")[1].charAt(0)));
                return ((result == 0) || (result == 4));
            } else {
                System.out.println(HttpResult);
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, "error with server", e );
        }
        return false;
    }

    public boolean checkPhone(String phone) {
        try {
            String postData = "[ \"" + phone + "\" ]";
            URL object = new URL(URL_PHONE);
            HttpURLConnection con = (HttpURLConnection) object.openConnection();
            con.setDoInput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Authorization","Token " +  TOKEN);
            con.setRequestProperty("X-Secret", "fc0528818eb61d5947a3406e42982182e7e5027f");

            con.setDoOutput(true);
            OutputStream outputStream = con.getOutputStream();
            outputStream.write(postData.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            outputStream.close();

            StringBuilder sb = new StringBuilder();
            int HttpResult = con.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                String answ = sb.toString();
                int result = Integer.parseInt(Character.toString(answ.split("qc\":")[1].charAt(0)));
                return ((result == 0));
            } else {
                System.out.println(HttpResult);
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, "error with connection", e );
        }
        return false;
    }
}
