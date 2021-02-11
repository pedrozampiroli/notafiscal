package app.notafiscal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import com.fincatto.documentofiscal.nfe.NFTipoEmissao;
import com.fincatto.documentofiscal.nfe400.utils.qrcode20.NFGeraQRCode20;
import com.fincatto.documentofiscal.nfe400.utils.qrcode20.NFGeraQRCodeContingenciaOffline20;
import com.fincatto.documentofiscal.nfe400.utils.qrcode20.NFGeraQRCodeEmissaoNormal20;
import com.fincatto.documentofiscal.utils.DFPersister;
import org.apache.commons.io.FileUtils;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.cadastro.NFRetornoConsultaCadastro;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEventoRetorno;
import com.fincatto.documentofiscal.nfe400.classes.lote.consulta.NFLoteConsultaRetorno;
import com.fincatto.documentofiscal.nfe400.classes.lote.envio.NFLoteEnvio;
import com.fincatto.documentofiscal.nfe400.classes.lote.envio.NFLoteEnvioRetornoDados;
import com.fincatto.documentofiscal.nfe400.classes.lote.envio.NFLoteEnvioRetornoDadosNew;
import com.fincatto.documentofiscal.nfe400.classes.lote.envio.NFLoteIndicadorProcessamento;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoSuplementar;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaProcessada;
import com.fincatto.documentofiscal.nfe400.classes.nota.consulta.NFNotaConsultaRetorno;
import com.fincatto.documentofiscal.nfe400.classes.statusservico.consulta.NFStatusServicoConsultaRetorno;
import com.fincatto.documentofiscal.nfe400.utils.NFGeraQRCode;
import com.fincatto.documentofiscal.nfe400.webservices.WSFacade;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFCadeiaCertificados;
import com.fincatto.documentofiscal.validadores.StringValidador;
import com.fincatto.documentofiscal.validadores.XMLValidador;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class NfeApi {

    private NFeConfiguracao sconfiguracao;
    private NFLoteIndicadorProcessamento modoprocessamento;

    private String sCadeiaCertificadoSenha;
    private String sCadeiaCertificadoCaminho;
    private String sCaminhoCertificado;
    private String sCertificadoSenha;
    private String sVersao;
    private String sCodigoSegurancaContribuinte;
    private Integer sCodigoSegurancaContribuinteID;

    private DFUnidadeFederativa sEstado;
    private DFAmbiente sAmbiente;

    private String xmlretorno;

    private final NFeConfig config = new NFeConfig() {

        private KeyStore keyStoreCertificado = null;
        private KeyStore keyStoreCadeia = null;

        @Override
        public String getCertificadoSenha() {
            // TODO Auto-generated method stub
            return sCertificadoSenha;
        }

        @Override
        public KeyStore getCertificadoKeyStore() throws KeyStoreException {
            if (this.keyStoreCertificado == null) {
                this.keyStoreCertificado = KeyStore.getInstance("PKCS12");
                try (InputStream certificadoStream = new FileInputStream(sCaminhoCertificado)) {
                    this.keyStoreCertificado.load(certificadoStream, this.getCertificadoSenha().toCharArray());
                } catch (CertificateException | NoSuchAlgorithmException | IOException e) {
                    this.keyStoreCadeia = null;
                    throw new KeyStoreException("Nao foi possibel montar o KeyStore com a cadeia de certificados", e);
                }
            }
            return this.keyStoreCertificado;
        }

        @Override
        public String getCadeiaCertificadosSenha() {
            // TODO Auto-generated method stub
            return sCadeiaCertificadoSenha;
        }

        @Override
        public KeyStore getCadeiaCertificadosKeyStore() throws KeyStoreException {
            if (this.keyStoreCadeia == null) {
                this.keyStoreCadeia = KeyStore.getInstance("JKS");
                try (InputStream cadeia = new FileInputStream(sCadeiaCertificadoCaminho)) {
                    this.keyStoreCadeia.load(cadeia, sCadeiaCertificadoSenha.toCharArray());
                } catch (CertificateException | NoSuchAlgorithmException | IOException e) {
                    this.keyStoreCadeia = null;
                    throw new KeyStoreException("Nao foi possibel montar o KeyStore com o certificado", e);
                }
            }
            return this.keyStoreCadeia;
        }

        @Override
        public DFUnidadeFederativa getCUF() {
            // TODO Auto-generated method stub
            return sEstado;
        }

        @Override
        public String getVersao() {
            return sVersao;
        }

        @Override
        public DFAmbiente getAmbiente() {
            return sAmbiente;
        }

        @Override
        public String getCodigoSegurancaContribuinte() {
            return sCodigoSegurancaContribuinte;
        }

        @Override
        public Integer getCodigoSegurancaContribuinteID() {
            return sCodigoSegurancaContribuinteID;
        }
    };

    public void NfeConfigurar(String CertificadoSenha, String CadeiaCertificadoSenha, String CaminhoCertificado, String CaminhoCadeiaCertificado, String Estado, String Ambiente, String CodigoSegurancaContribuinte, String IdentificadorSegurancaContribuinte, String Versao) {

        sconfiguracao = new NFeConfiguracao();

        sconfiguracao.getCertificadoKeyStore = CaminhoCertificado;
        sconfiguracao.getCertificadoSenha = CertificadoSenha;

        sconfiguracao.getCadeiaCertificadosKeyStore = CaminhoCadeiaCertificado;
        sconfiguracao.getCadeiaCertificadosSenha = CadeiaCertificadoSenha;

        sconfiguracao.DFUnidadeFederativa = BuscaUnidadeFederativa(Estado);
        sconfiguracao.DFAmbiente = BuscaAmbiente(Ambiente);

        sAmbiente = BuscaAmbiente(Ambiente);
        sEstado = BuscaUnidadeFederativa(Estado);

        sCadeiaCertificadoCaminho = CaminhoCadeiaCertificado;
        sCadeiaCertificadoSenha = CadeiaCertificadoSenha;

        sCaminhoCertificado = CaminhoCertificado;
        sCertificadoSenha = CertificadoSenha;

        sVersao = Versao;
        sCodigoSegurancaContribuinte = CodigoSegurancaContribuinte;

        try {
            sCodigoSegurancaContribuinteID = Integer.valueOf(IdentificadorSegurancaContribuinte);
        } catch (NumberFormatException e) {
            sCodigoSegurancaContribuinteID = 0;
        }
	    
        /*
	    System.out.println("____________________________________ Configuração NF ____________________________________");
	    System.out.println("-------------------------------------- Certificado --------------------------------------");
	    System.out.println(CaminhoCertificado);
	    System.out.println(CertificadoSenha);
	    System.out.println("--------------------------------- Cadeia de Certificado ---------------------------------");
	    System.out.println(CaminhoCadeiaCertificado);
	    System.out.println("-------------------------------- Ambiente / Uf / Versão  --------------------------------");
	    System.out.println(Estado);
	    System.out.println(BuscaUnidadeFederativa(Estado));
	    System.out.println(BuscaAmbiente(Ambiente));
	    System.out.println(Versao);
	    System.out.println("_________________________________________________________________________________________");
        */
    }

    public String NfConsultaCNPJ(String cnpj, String unidadefederativa) {

        DFUnidadeFederativa dfunidadefederativa = BuscaUnidadeFederativa(unidadefederativa);
        String retorno = null;

        try {
            NFRetornoConsultaCadastro nfretornoconsultacadastro = new WSFacade(config).consultaCadastro(cnpj, dfunidadefederativa);
            retorno = nfretornoconsultacadastro.toString();

        } catch (KeyManagementException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (UnrecoverableKeyException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (KeyStoreException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (CertificateException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        }

        return retorno;
    }

    public String NfeValidar(String xml) {

        xml = xml.replaceAll("\r", "");
        xml = xml.replaceAll("\t", "");
        xml = xml.replaceAll("\n", "");
        xml = xml.replaceAll("\n", "");
        xml = xml.replaceAll("&lt;", "<");
        xml = xml.replaceAll("&gt;", ">");

        xml = xml.trim();

        Boolean valido = null;
        String retorno = null;

        try {

            valido = XMLValidador.validaNota400(xml);
            retorno = valido.toString();

        } catch (Exception e) {

            retorno = "Error: " + e.getMessage();

        }

        return retorno;
    }

    public String NfeConsultaLote(String idlote, String Modelo) {

        String retorno = null;
        DFModelo dfmodelo = BuscarModelo(Modelo);
        NFLoteConsultaRetorno retc;

        try {
            retc = new WSFacade(config).consultaLote(idlote.trim(), dfmodelo);

            retorno = retc.toString();

        } catch (KeyManagementException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        } catch (UnrecoverableKeyException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        } catch (KeyStoreException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        } catch (CertificateException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }

        return retorno;

    }

    public String NfeConsultaNota(String chave) {

        NFNotaConsultaRetorno nfloteconsultaretorno = null;
        String retorno = null;

        try {

            nfloteconsultaretorno = new WSFacade(config).consultaNota(chave);
            retorno = nfloteconsultaretorno.toString();

        } catch (KeyManagementException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (KeyStoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (CertificateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return retorno;

    }

    public String NfSituacaoNota(String chave, String xml) {
        //System.out.println("-----------------------------------------------------------------------------------------");
        NFNota notaRecuperadaAssinada = null;
        NFNotaConsultaRetorno notaRetorno = null;

        try {

            notaRetorno = new WSFacade(config).consultaNota(chave);

            notaRecuperadaAssinada = new DFPersister().read(NFNota.class, xml);

            NFNotaProcessada notaProcessada = new NFNotaProcessada();
            notaProcessada.setVersao(new BigDecimal(config.getVersao()));
            notaProcessada.setProtocolo(notaRetorno.getProtocolo());
            notaProcessada.setNota(notaRecuperadaAssinada);

            //System.out.println("-----------------------------------------------------------------------------------------");
            return notaProcessada.toString();

        } catch (KeyManagementException e) {
            // TODO Auto-generated catch block
            return e.getMessage();
        } catch (UnrecoverableKeyException e) {
            // TODO Auto-generated catch block
            return e.getMessage();
        } catch (KeyStoreException e) {
            // TODO Auto-generated catch block
            return e.getMessage();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            return e.getMessage();
        } catch (CertificateException e) {
            // TODO Auto-generated catch block
            return e.getMessage();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            return e.getMessage();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return e.getMessage();
        }

    }

    public String NfSituacaoNotaXfd(String chave, String xml) {
        //System.out.println("-----------------------------------------------------------------------------------------");
        NFLoteEnvio notaRecuperadaAssinada = null;
        NFNotaConsultaRetorno notaRetorno = null;
        NFNota notaFiscal = null;

        try {

            notaRetorno = new WSFacade(config).consultaNota(chave);

            notaRecuperadaAssinada = new DFPersister().read(NFLoteEnvio.class, xml);

            notaFiscal = new DFPersister().read(NFNota.class, notaRecuperadaAssinada.getNotas().get(0).toString());

            NFNotaProcessada notaProcessada = new NFNotaProcessada();

            notaProcessada.setVersao(new BigDecimal(config.getVersao()));
            notaProcessada.setProtocolo(notaRetorno.getProtocolo());
            notaProcessada.setNota(notaFiscal);
            //System.out.println("-----------------------------------------------------------------------------------------");
            return notaProcessada.toString();

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String NFeEmitir(String XML, String LoteID, String Modulo, String ModoProcessamento) {

        XML = XML.replaceAll("\r", "");
        XML = XML.replaceAll("\t", "");
        XML = XML.replaceAll("\n", "");
        XML = XML.replaceAll("\n", "");
        XML = XML.replaceAll("&lt;", "<");
        XML = XML.replaceAll("&gt;", ">");

        NFLoteIndicadorProcessamento modoprocessamento;
        modoprocessamento = DFBuscarModoProcessamento(ModoProcessamento);

        String value = null;

        xmlretorno = null;

        try {
            value = new String(XML.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            // TODO Auto-generated catch block
            xmlretorno = "Error: " + e2.getMessage();
        }
        NFNota notaRecuperadaAssinada = null;

        try {
            notaRecuperadaAssinada = new DFPersister().read(NFNota.class, value);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            xmlretorno = "Error: " + e1.getMessage();
        }

        NFLoteEnvioRetornoDados LoteEnvioRetornoDados;

        // Lote
        NFLoteEnvio lote = new NFLoteEnvio();
        List<NFNota> notas = new ArrayList<>();

        notas.add(notaRecuperadaAssinada);
        lote.setNotas(notas);

        if (LoteID.length() > 1) {

            String loteid = LoteID.replaceAll("\\s+", " ");
            System.out.println(loteid);

            StringValidador.tamanho15N(loteid, "ID do Lote");
            lote.setIdLote(LoteID);
        }

        lote.setVersao(sVersao);
        lote.setIndicadorProcessamento(modoprocessamento);

        if (xmlretorno == null) {
            try {
                LoteEnvioRetornoDados = new WSFacade(config).enviaLote(lote);
                xmlretorno = LoteEnvioRetornoDados.getRetorno().toString();
            } catch (Exception e) {
                xmlretorno = "Error: " + e.getMessage();
            }
        }

        return xmlretorno;
    }

    public String NFeEmitirLote(String XML, String modelo, String ModoProcessamento) {
        while (XML.contains(" <")) {
            XML = XML.replaceAll(" <", "<");
        }
        XML = XML.replaceAll("\r", "");
        XML = XML.replaceAll("\t", "");
        XML = XML.replaceAll("\n", "");
        XML = XML.replaceAll("\n", "");
        XML = XML.replaceAll("&lt;", "<");
        XML = XML.replaceAll("&gt;", ">");
        NFLoteIndicadorProcessamento modoprocessamento;
        System.out.println(XML);
        if (ModoProcessamento.isEmpty()) ModoProcessamento = "1";
        modoprocessamento = DFBuscarModoProcessamento(ModoProcessamento);
        DFModelo model = null;
        try {
            model = BuscarModelo(modelo);
        } catch (Exception e) {
            xmlretorno = "Erro ao encontrar modelo informado (modelo:" + modelo + ")";
            return xmlretorno;
        }
        String xmlConvertido = null;
        xmlretorno = null;
        NFLoteEnvioRetornoDadosNew LoteEnvioRetornoDados;
        try {
            xmlConvertido = new String(XML.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            xmlretorno = "Error: " + e2.getMessage();
        }
        if (xmlretorno == null) {
            try {
                LoteEnvioRetornoDados = new WSFacade(config).enviaLoteString(xmlConvertido, model);
                xmlretorno = LoteEnvioRetornoDados.getRetorno().toString();
            } catch (Exception e) {
                xmlretorno = "Error: " + e.getMessage();
            }
        }
        return xmlretorno;
    }

    public String NfceQrCode(String XML, String filePath, int width, int height) {


        NFNotaProcessada nota;

        String retornPath = null;

        try {
            nota = new DFPersister().read(NFNotaProcessada.class, XML);
            NFNotaInfoSuplementar NfinfoSumplementar = nota.getNota().getInfoSuplementar();

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix;

            bitMatrix = qrCodeWriter.encode(NfinfoSumplementar.getQrCode(), BarcodeFormat.QR_CODE, width, height);

            Path path = FileSystems.getDefault().getPath(filePath);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
            retornPath = NfinfoSumplementar.getQrCode();

        } catch (Exception e1) {
            // TODO Auto-generated catch block
            retornPath = e1.getMessage();
        }


        return retornPath;

    }

    public String NfceQrCodeUrl(String Url, String filePath, int width, int height) {

        String retornPath = null;

        try {

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix;

            bitMatrix = qrCodeWriter.encode(Url, BarcodeFormat.QR_CODE, width, height);

            Path path = FileSystems.getDefault().getPath(filePath);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
            retornPath = filePath + path.getFileName();


        } catch (Exception e1) {
            // TODO Auto-generated catch block
            retornPath = e1.getMessage();
        }


        return retornPath;
    }

    public String NfeAssinar(String xmlNotaRecuperada) {

        xmlNotaRecuperada = xmlNotaRecuperada.replaceAll("\r", "");
        xmlNotaRecuperada = xmlNotaRecuperada.replaceAll("\t", "");
        xmlNotaRecuperada = xmlNotaRecuperada.replaceAll("\n", "");
        xmlNotaRecuperada = xmlNotaRecuperada.replaceAll("\n", "");
        xmlNotaRecuperada = xmlNotaRecuperada.replaceAll("&lt;", "<");
        xmlNotaRecuperada = xmlNotaRecuperada.replaceAll("&gt;", ">");

        String xmlNotaRecuperadaAssinada = null;

        try {
            xmlNotaRecuperadaAssinada = new DFAssinaturaDigital(config).assinarDocumento(xmlNotaRecuperada);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            xmlNotaRecuperadaAssinada += "error :" + e.getMessage();
        }

        return xmlNotaRecuperadaAssinada;
    }

    public String NfeValidade(String CertificadoKeyStore, String senha) {

        String info = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(new FileInputStream(CertificadoKeyStore), senha.toCharArray());
            Enumeration<String> eAliases = keyStore.aliases();

            while (eAliases.hasMoreElements()) {
                String alias = eAliases.nextElement();

                Certificate certificado = keyStore.getCertificate(alias);
                X509Certificate c = (X509Certificate) certificado;

                try {
                    c.checkValidity();
                    info = "true_" + sdf.format(c.getNotAfter()) + "_" + c.getSubjectAlternativeNames() + "_" + c.getSubjectDN();
                } catch (CertificateExpiredException e) {
                    info = "false_" + sdf.format(c.getNotAfter()) + "_" + c.getSubjectAlternativeNames() + "_" + c.getSubjectDN();
                }
            }
        } catch (Exception e) {
            info = e.getLocalizedMessage();
        }


        return info;
    }

    public String NfeWebServiceStatus(String UF, String Modelo) {
        DFUnidadeFederativa dfuf = BuscaUnidadeFederativa(UF);
        DFModelo dfmodelo = BuscarModelo(Modelo);
        String retorno = null;
        try {
            NFStatusServicoConsultaRetorno nfstatusservicoconsultatretorno = new WSFacade(config).consultaStatus(dfuf, dfmodelo);
            retorno = nfstatusservicoconsultatretorno.getStatus() + "," + nfstatusservicoconsultatretorno.getMotivo() + "," + nfstatusservicoconsultatretorno.getObservacao();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return retorno;
    }

    public String NfCancelar(String chaveDeAcessoDaNota, String protocoloDaNota, String motivoCancelamento) {

        NFEnviaEventoRetorno nfenviaeventoretorno = null;

        try {
            nfenviaeventoretorno = new WSFacade(config).cancelaNota(chaveDeAcessoDaNota, protocoloDaNota, "CANCELAMENTO SOLCITADO.");
        } catch (KeyManagementException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (KeyStoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (CertificateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return nfenviaeventoretorno.toString();
    }

    public String NfCorrigirNota(String chaveDeAcessoDaNota, String textoCorrecao, int sequencialEventoDaNota) {

        System.out.println("--------------------------------- CARTA DE CORREÇÃO NFe ---------------------------------");

        NFEnviaEventoRetorno nfenviaeventoretorno = null;
        String xmlEnvio = null;
        String retorno;
        try {
            //nfenviaeventoretorno = new WSFacade(config).corrigeNota(chaveDeAcessoDaNota, textoCorrecao, sequencialEventoDaNota);
            xmlEnvio = new WSFacade(config).geraXMLCorrecaoAssinado(chaveDeAcessoDaNota, textoCorrecao, sequencialEventoDaNota);
            nfenviaeventoretorno = new WSFacade(config).corrigeNotaAssinada(xmlEnvio);
            retorno = xmlEnvio + "|" + nfenviaeventoretorno.toString();
            //corrigeNota(chaveDeAcessoDaNota, textoCorrecao, sequencialEventoDaNota);
        } catch (Exception e) {
            retorno = e.getMessage();
        }
        System.out.println(retorno);
        System.out.println("-----------------------------------------------------------------------------------------");

        return retorno;
    }

    public String NFInutilizarXML(String xmlassinado, String modelo) {

        DFModelo dfmodelo = BuscarModelo(modelo);
        String retorno = null;

        com.fincatto.documentofiscal.nfe400.classes.evento.inutilizacao.NFRetornoEventoInutilizacao nfretornoeventoinutilizacao;
        try {
            nfretornoeventoinutilizacao = new WSFacade(config).inutilizaNotaAssinada(xmlassinado, dfmodelo);
            retorno = nfretornoeventoinutilizacao.toString();
        } catch (KeyManagementException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (UnrecoverableKeyException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (KeyStoreException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (CertificateException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        }

        return retorno;
    }

    public String NFInutilizar(int anoInutilizacaoNumeracao, String cnpjEmitente, String serie, String numeroInicial, String numeroFinal, String justificativa, String modelo) {

        String retorno = null;

        DFModelo dfmodelo = BuscarModelo(modelo);

        try {
            com.fincatto.documentofiscal.nfe400.classes.evento.inutilizacao.NFRetornoEventoInutilizacao nfretornoeventoinutilizacao = new WSFacade(config).inutilizaNota(anoInutilizacaoNumeracao, cnpjEmitente, serie, numeroInicial, numeroFinal, justificativa, dfmodelo);
            retorno = nfretornoeventoinutilizacao.toString();

        } catch (KeyManagementException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (UnrecoverableKeyException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (KeyStoreException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (CertificateException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        }

        return retorno;
    }

    public String NFCadeiaCertificado(String pathprod, String senhaprod, String pathhomol, String senhahomol) {

        String retorno = null;

        try {
            FileUtils.writeByteArrayToFile(new File(pathhomol), DFCadeiaCertificados.geraCadeiaCertificados(DFAmbiente.HOMOLOGACAO, senhahomol));
            FileUtils.writeByteArrayToFile(new File(pathprod), DFCadeiaCertificados.geraCadeiaCertificados(DFAmbiente.PRODUCAO, senhaprod));
            retorno = "Atualizado cadeia de certificado com sucesso";
            System.out.println(retorno);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return retorno;

    }

    public String NFManifestaDestNotaAssinada(String chaveAcesso, String eventoAssinadoXml) {

        NFEnviaEventoRetorno nfenviaeventoretorno;
        String retorno = null;

        try {
            nfenviaeventoretorno = new WSFacade(config).manifestaDestinatarioNotaAssinada(chaveAcesso, eventoAssinadoXml);
            retorno = nfenviaeventoretorno.toString();

        } catch (KeyManagementException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (UnrecoverableKeyException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (KeyStoreException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (CertificateException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        }


        return retorno;
    }

    public String NFGeraURLString(String xml) {


        String retorno = null;

        try {


            NFNota notaRecuperadaAssinada = new DFPersister().read(NFNota.class, xml);


            NFNotaProcessada notaProcessada = new NFNotaProcessada();
            notaProcessada.setVersao(new BigDecimal(config.getVersao()));
            notaProcessada.setNota(notaRecuperadaAssinada);

            NFGeraQRCode nfgeraqrcode = new NFGeraQRCode(notaProcessada.getNota(), config);
            //retorno = nfgeraqrcode.getQRCodev2();

            retorno = "";

        } catch (Exception e) {
            // TODO Auto-generated catch block
            retorno = e.getMessage();
        }

        return retorno;


    }

    public String NFDateTime(String local) {


        String DATE_FORMAT = "yyyy-MM-dd HH:mm:s";

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
        sdf.setTimeZone(java.util.TimeZone.getTimeZone(local));
        String utcTime = sdf.format((new Date()));

        return utcTime;
    }

    public String NFDanfeImprimir() {

        return null;

    }

    public String NFCeGerarLinkQRcode(String XML) {
        XML = XML.replaceAll("\r", "");
        XML = XML.replaceAll("\t", "");
        XML = XML.replaceAll("\n", "");
        XML = XML.replaceAll("\n", "");
        XML = XML.replaceAll("&lt;", "<");
        XML = XML.replaceAll("&gt;", ">");
        String value = null;
        xmlretorno = null;
        try {
            value = new String(XML.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            xmlretorno = "Error na conversão do xml para UTF-8: " + e2.getMessage();
        }
        NFNota nota = null;
        try {
            nota = new DFPersister().read(NFNota.class, value);
        } catch (Exception e1) {
            xmlretorno = "Error ao converter dados da NF: " + e1.getMessage();
        }
        NFGeraQRCode20 geraQRCode = getNfGeraQRCode20(nota);
        try {
            xmlretorno = "<![CDATA[" + geraQRCode.getQRCode() + "]]>;" + geraQRCode.urlConsultaChaveAcesso();
        } catch (Exception e) {
            xmlretorno = "Erro ao retornar dados do QR Code " + e;
        }

        return xmlretorno;
    }

    private NFGeraQRCode20 getNfGeraQRCode20(NFNota nota) {
        if (NFTipoEmissao.EMISSAO_NORMAL.equals(nota.getInfo().getIdentificacao().getTipoEmissao())) {
            return new NFGeraQRCodeEmissaoNormal20(nota, this.config);
        } else if (NFTipoEmissao.CONTIGENCIA_OFFLINE.equals(nota.getInfo().getIdentificacao().getTipoEmissao())) {
            return new NFGeraQRCodeContingenciaOffline20(nota, this.config);
        } else {
            throw new IllegalArgumentException("QRCode 2.0 Tipo Emissao nao implementado: " + nota.getInfo().getIdentificacao().getTipoEmissao().getDescricao());
        }
    }

    private DFUnidadeFederativa BuscaUnidadeFederativa(String UF) {

        DFUnidadeFederativa unidadefederativa;

        switch (UF) {
            case "PR":
                unidadefederativa = DFUnidadeFederativa.PR;
                break;
            case "RR":
                unidadefederativa = DFUnidadeFederativa.RR;
                break;
            case "AM":
                unidadefederativa = DFUnidadeFederativa.AM;
                break;
            case "AC":
                unidadefederativa = DFUnidadeFederativa.AC;
                break;
            case "RO":
                unidadefederativa = DFUnidadeFederativa.RO;
                break;
            case "AP":
                unidadefederativa = DFUnidadeFederativa.AP;
                break;
            case "PA":
                unidadefederativa = DFUnidadeFederativa.PA;
                break;
            case "MT":
                unidadefederativa = DFUnidadeFederativa.MT;
                break;
            case "TO":
                unidadefederativa = DFUnidadeFederativa.TO;
                break;
            case "MA":
                unidadefederativa = DFUnidadeFederativa.MA;
                break;
            case "PI":
                unidadefederativa = DFUnidadeFederativa.PI;
                break;
            case "MS":
                unidadefederativa = DFUnidadeFederativa.MS;
                break;
            case "GO":
                unidadefederativa = DFUnidadeFederativa.GO;
                break;
            case "DF":
                unidadefederativa = DFUnidadeFederativa.DF;
                break;
            case "MG":
                unidadefederativa = DFUnidadeFederativa.MG;
                break;
            case "RJ":
                unidadefederativa = DFUnidadeFederativa.RJ;
                break;
            case "SP":
                unidadefederativa = DFUnidadeFederativa.SP;
                break;
            case "SC":
                unidadefederativa = DFUnidadeFederativa.SC;
                break;
            case "RS":
                unidadefederativa = DFUnidadeFederativa.RS;
                break;
            case "ES":
                unidadefederativa = DFUnidadeFederativa.ES;
                break;
            case "BA":
                unidadefederativa = DFUnidadeFederativa.BA;
                break;
            case "RN":
                unidadefederativa = DFUnidadeFederativa.RN;
                break;
            case "CE":
                unidadefederativa = DFUnidadeFederativa.CE;
                break;
            case "AL":
                unidadefederativa = DFUnidadeFederativa.AL;
                break;
            case "PE":
                unidadefederativa = DFUnidadeFederativa.PE;
                break;
            case "PB":
                unidadefederativa = DFUnidadeFederativa.PB;
                break;
            case "SE":
                unidadefederativa = DFUnidadeFederativa.SE;
                break;
            default:
                unidadefederativa = DFUnidadeFederativa.PR;
                break;
        }

        return unidadefederativa;
    }

    private DFAmbiente BuscaAmbiente(String Ambiente) {

        DFAmbiente dfambiente;

        switch (Ambiente) {
            case "2":
                dfambiente = DFAmbiente.HOMOLOGACAO;
                break;
            case "1":
                dfambiente = DFAmbiente.PRODUCAO;
                break;
            default:
                dfambiente = DFAmbiente.HOMOLOGACAO;
                break;
        }


        return dfambiente;
    }

    private DFModelo BuscarModelo(String Modelo) {

        DFModelo modelo;

        //'01' '04' '55' '65' '57' '58' '67'

        switch (Modelo) {
            case "01":
                modelo = DFModelo.AVULSA;
                break;
            case "57":
                modelo = DFModelo.CTE;
                break;
            case "67":
                modelo = DFModelo.CTeOS;
                break;
            case "58":
                modelo = DFModelo.MDFE;
                break;
            case "65":
                modelo = DFModelo.NFCE;
                break;
            case "55":
                modelo = DFModelo.NFE;
                break;
            case "04":
                modelo = DFModelo.PRODUTOR;
                break;
            default:
                modelo = DFModelo.NFE;
        }

        return modelo;
    }

    private NFLoteIndicadorProcessamento DFBuscarModoProcessamento(String ModoProcessamento) {

        if (ModoProcessamento.equals("1")) {
            modoprocessamento = NFLoteIndicadorProcessamento.PROCESSAMENTO_SINCRONO;
        } else {
            modoprocessamento = NFLoteIndicadorProcessamento.PROCESSAMENTO_ASSINCRONO;
        }

        return modoprocessamento;
    }

}
