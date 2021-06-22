package app.notafiscal;
/*

import br.com.tegasistemas.documentofiscal.DFAmbiente;
import br.com.tegasistemas.documentofiscal.DFUnidadeFederativa;
import br.com.tegasistemas.documentofiscal.gnre200.GnreConfig;
import br.com.tegasistemas.documentofiscal.gnre200.webservice.ClientFactory;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class GnreConfiguracao extends GnreConfig {


    private static String logs;
    private KeyStore keyStoreCertificado = null;
    private KeyStore keyStoreCadeia = null;
    public String getCertificadoSenha;
    public String getCadeiaCertificadosSenha;
    public String getCertificadoKeyStore;
    public String getCadeiaCertificadosKeyStore;
    public DFUnidadeFederativa DFUnidadeFederativa;
    public DFAmbiente DFAmbiente;


    public DFAmbiente getAmbiente() {
        return DFAmbiente;
    }

    public DFUnidadeFederativa getCUF() {
        return DFUnidadeFederativa;
    }

    public String getCertificadoSenha() {
        return getCertificadoSenha;
    }

    public String getCadeiaCertificadosSenha() {
        return getCadeiaCertificadosSenha;
    }

    public KeyStore getCertificadoKeyStore() throws KeyStoreException {
        if (this.keyStoreCertificado == null) {
            this.keyStoreCertificado = KeyStore.getInstance("PKCS12");

            try (InputStream certificadoStream = new FileInputStream(getCertificadoKeyStore)) {
                this.keyStoreCertificado.load(certificadoStream, this.getCertificadoSenha().toCharArray());


            } catch (NoSuchAlgorithmException | IOException e) {
                this.keyStoreCadeia = null;
                throw new KeyStoreException("Nao foi possivel montar o KeyStore com a cadeia de certificados", e);
            } catch (java.security.cert.CertificateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return this.keyStoreCertificado;
    }

    public KeyStore getCadeiaCertificadosKeyStore() throws KeyStoreException {
        if (this.keyStoreCadeia == null) {
            this.keyStoreCadeia = KeyStore.getInstance("JKS");
            try (InputStream cadeia = new FileInputStream(getCadeiaCertificadosKeyStore)) {
                this.keyStoreCadeia.load(cadeia, this.getCadeiaCertificadosSenha().toCharArray());
            } catch (NoSuchAlgorithmException | IOException e) {
                this.keyStoreCadeia = null;
                throw new KeyStoreException("Nao foi possivel montar o KeyStore com o certificado", e);
            } catch (java.security.cert.CertificateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return this.keyStoreCadeia;
    }


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
*/