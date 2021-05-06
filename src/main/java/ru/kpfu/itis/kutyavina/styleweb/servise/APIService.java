package ru.kpfu.itis.kutyavina.styleweb.servise;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class APIService {

    private static String URL_EMAIL = "https://cleaner.dadata.ru/api/v1/clean/email";
    private static String URL_PHONE = "https://cleaner.dadata.ru/api/v1/clean/phone";
    private static String TOKEN = "8809edcac820bf5caaaa1ef4d8071259815212de";

    public boolean checkEmail() {
        try {
            String postData = "[ \"tszdest@tsdcvest.cosdcm\" ]";
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
                System.out.println(answ);
            } else {
                System.out.println(HttpResult);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkPhone() {
        try {
            String postData = "[ \"89827950269\" ]";
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
                System.out.println(answ);
            } else {
                System.out.println(HttpResult);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
