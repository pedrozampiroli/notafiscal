package app.notafiscal;

import com.fincatto.documentofiscal.gnre200.webservice.ClientFactory;

import java.security.KeyStoreException;

public class GnreConfiguracao {
    private static String logs;

    public static String configGnre(String certificado, String certificadoPasswd, String cadeiaCertificado, String cadeiaCertificadoPasswd) {
        ClientFactory client = new ClientFactory();
        try {
            logs = client.setCertificado(certificado, certificadoPasswd, cadeiaCertificado, cadeiaCertificadoPasswd);
        } catch (KeyStoreException e) {
            logs = e.getMessage();
        }
        return logs;
    }

}
