import app.notafiscal.CTeAPI;

public class CTeTestService {


    public static void main(String[] args) {

        CTeAPI api = new CTeAPI();

        api.configurar("123456",
                "changeit",
                "D:\\Projects\\certificados\\entregarapida.pfx",
                "D:\\Projects\\certificados\\producao.cacerts",
                "PR",
                "1");

        String response;

        try {
            response = api.consultar("41201124476580000156570010000275021000375663");

        } catch (Exception e) {
            response = "Error: " + e.getMessage();
        }

        System.out.println(response);

    }
}

