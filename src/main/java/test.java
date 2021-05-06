import ru.kpfu.itis.kutyavina.styleweb.servise.APIService;

public class test {

    public static void main(String[] args) {
        APIService apiService = new APIService();
        apiService.checkEmail();
        apiService.checkPhone();
    }
}
