package app.notafiscal;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import br.com.tegasistemas.documentofiscal.DFAmbiente;
import br.com.tegasistemas.documentofiscal.DFUnidadeFederativa;
import br.com.tegasistemas.documentofiscal.nfe.NFeConfig;

// Exemplo de configuracao para acesso aos servicos da Sefaz.
public class NFeConfiguracao extends NFeConfig {

    private KeyStore keyStoreCertificado = null;
    private KeyStore keyStoreCadeia = null;
    public String getCertificadoSenha;
    public String getCadeiaCertificadosSenha;
    public String getCertificadoKeyStore;
    public String getCadeiaCertificadosKeyStore;
    public DFUnidadeFederativa DFUnidadeFederativa;
    public DFAmbiente DFAmbiente;


    @Override
    public DFAmbiente getAmbiente() {
        return DFAmbiente;
    }

    @Override
    public DFUnidadeFederativa getCUF() {
        return DFUnidadeFederativa;
    }

    @Override
    public String getCertificadoSenha() {
        return getCertificadoSenha;
    }

    @Override
    public String getCadeiaCertificadosSenha() {
        return getCadeiaCertificadosSenha;
    }

    @Override
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

    @Override
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


}