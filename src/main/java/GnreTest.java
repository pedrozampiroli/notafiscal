import app.notafiscal.GnreAPI;

public class GnreTest {

    public static void main(String[] args) throws Exception {
        String logs;
        GnreAPI api = new GnreAPI();
        logs = api.configurar("@cafe@","changeit","D:\\Projects\\certificados\\1.pfx","D:\\Projects\\certificados\\producao.cacerts","PR","100013");
        logs = api.transmitir(
                "PR",
                "121321321",
                "100013",
                "07038710000150",
                "10",
                "1314834209",
                "1.00",
                "2020-12-01",
                "EMITENTE TESTE",
                "ENDERECO EMITENTE TESTE",
                "06200",
                "MG",
                "38540970",
                "2020-11-19",
                "439999999",
                "2312312",
                "",
                "10",
                "2020",
                "",
                "1.00",
                "1",
                "123456",
                "19278207000150",
                "",
                "123456",
                "123",
                "Razao TESTE",
                "06200"
        );
        System.out.println(logs);
    }
}
