//package app.notafiscal;
//
///*import br.com.tegasistemas.documentofiscal.DFAmbiente;
//import br.com.tegasistemas.documentofiscal.DFUnidadeFederativa;
//import br.com.tegasistemas.documentofiscal.gnre200.GnreConfig;
//import br.com.tegasistemas.documentofiscal.gnre200.webservice.configuf.ConfigUFApplication;
//import br.com.tegasistemas.documentofiscal.gnre200.webservice.loterecepcao.LoteRecepcaoApplication;
//import br.com.tegasistemas.documentofiscal.gnre200.webservice.loterecepcao.LoteRecepcaoModel;
//import br.com.tegasistemas.documentofiscal.gnre200.webservice.resultadolote.ResultadoLoteApplication;
//import br.com.tegasistemas.documentofiscal.nfe.NFeConfig;
//import br.com.tegasistemas.documentofiscal.nfe400.classes.lote.envio.NFLoteIndicadorProcessamento;*/
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamz;
//import java.security.KeyStore;
//import java.security.KeyStoreException;
//import java.security.NoSuchAlgorithmException;
//import java.security.cert.CertificateException;
//
//public class GnreAPI {
//
//    /*private GnreConfiguracao sconfiguracao;
//    private NFLoteIndicadorProcessamento modoprocessamento;
//
//    private String sCadeiaCertificadoSenha;
//    private String sCadeiaCertificadoCaminho;
//    private String sCaminhoCertificado;
//    private String sCertificadoSenha;
//    private String sVersao;
//    private String sCodigoSegurancaContribuinte;
//    private String sReceita;
//    private Integer sCodigoSegurancaContribuinteID;
//
//    private DFUnidadeFederativa sEstado;
//    private DFAmbiente sAmbiente;
//
//    private String logs = "";
//
//
//    *//*public String configurar(String CertificadoSenha, String CadeiaCertificadoSenha, String CaminhoCertificado, String CaminhoCadeiaCertificado, String Estado, String Receita) {
//        GnreConfiguracao gConfig = new GnreConfiguracao();
//        gConfig.configGnre(CaminhoCertificado, CertificadoSenha, CaminhoCadeiaCertificado, CadeiaCertificadoSenha);
//        ConfigUFApplication cUf = new ConfigUFApplication();
//        try {
//            logs = cUf.configUf(Estado, Receita, "2.00");
//            return logs;
//        } catch (Exception e) {
//            return e.getMessage();
//        }
//
//    }*//*
//
//    private final GnreConfig config = new GnreConfig() {
//
//        private KeyStore keyStoreCertificado = null;
//        private KeyStore keyStoreCadeia = null;
//
//        @Override
//        public String getCertificadoSenha() {
//            // TODO Auto-generated method stub
//            return sCertificadoSenha;
//        }
//
//        @Override
//        public KeyStore getCertificadoKeyStore() throws KeyStoreException {
//            if (this.keyStoreCertificado == null) {
//                this.keyStoreCertificado = KeyStore.getInstance("PKCS12");
//                try (InputStream certificadoStream = new FileInputStream(sCaminhoCertificado)) {
//                    this.keyStoreCertificado.load(certificadoStream, this.getCertificadoSenha().toCharArray());
//                } catch (CertificateException | NoSuchAlgorithmException | IOException e) {
//                    this.keyStoreCadeia = null;
//                    throw new KeyStoreException("Nao foi possibel montar o KeyStore com a cadeia de certificados", e);
//                }
//            }
//            return this.keyStoreCertificado;
//        }
//
//        @Override
//        public String getCadeiaCertificadosSenha() {
//            // TODO Auto-generated method stub
//            return sCadeiaCertificadoSenha;
//        }
//
//        @Override
//        public KeyStore getCadeiaCertificadosKeyStore() throws KeyStoreException {
//            if (this.keyStoreCadeia == null) {
//                this.keyStoreCadeia = KeyStore.getInstance("JKS");
//                try (InputStream cadeia = new FileInputStream(sCadeiaCertificadoCaminho)) {
//                    this.keyStoreCadeia.load(cadeia, sCadeiaCertificadoSenha.toCharArray());
//                } catch (CertificateException | NoSuchAlgorithmException | IOException e) {
//                    this.keyStoreCadeia = null;
//                    throw new KeyStoreException("Nao foi possibel montar o KeyStore com o certificado", e);
//                }
//            }
//            return this.keyStoreCadeia;
//        }
//
//        @Override
//        public DFUnidadeFederativa getCUF() {
//            // TODO Auto-generated method stub
//            return sEstado;
//        }
//
//        @Override
//        public String getVersao() {
//            return sVersao;
//        }
//
//        @Override
//        public DFAmbiente getAmbiente() {
//            return sAmbiente;
//        }
//
//        @Override
//        public String getCodigoSegurancaContribuinte() {
//            return sCodigoSegurancaContribuinte;
//        }
//
//        @Override
//        public Integer getCodigoSegurancaContribuinteID() {
//            return sCodigoSegurancaContribuinteID;
//        }
//    };
//
//    public void configurar(String CertificadoSenha, String CadeiaCertificadoSenha, String CaminhoCertificado, String CaminhoCadeiaCertificado, String Estado, String Receita, String Ambiente, String Versao) {
//
//        sconfiguracao = new GnreConfiguracao();
//
//        sconfiguracao.getCadeiaCertificadosKeyStore = CaminhoCadeiaCertificado;
//        sconfiguracao.getCadeiaCertificadosSenha    = CadeiaCertificadoSenha;
//        sconfiguracao.getCertificadoKeyStore    = CaminhoCertificado;
//        sconfiguracao.getCertificadoSenha       = CertificadoSenha;
//        sconfiguracao.DFUnidadeFederativa   = BuscaUnidadeFederativa(Estado);
//        sconfiguracao.DFAmbiente            = BuscaAmbiente(Ambiente);
//        sCadeiaCertificadoCaminho   = CaminhoCadeiaCertificado;
//        sCadeiaCertificadoSenha     = CadeiaCertificadoSenha;
//        sCaminhoCertificado = CaminhoCertificado;
//        sCertificadoSenha   = CertificadoSenha;
//        sAmbiente   = BuscaAmbiente(Ambiente);
//        sEstado     = BuscaUnidadeFederativa(Estado);
//        sReceita = Receita;
//        sVersao  = Versao;
//
//	    System.out.println("--------------------------- Certificado ------------------------");
//	    System.out.println("Caminho Certificado " + CaminhoCertificado);
//	    System.out.println("Senha Certificado   " + CertificadoSenha);
//	    System.out.println("---------------------- Cadeia de Certificado -------------------");
//	    System.out.println("Path  Cadeia Certificado " + CaminhoCadeiaCertificado);
//        System.out.println("Senha Cadeia Certificado " + CadeiaCertificadoSenha);
//	    System.out.println("--------------------- Ambiente / Uf / Versão  ------------------");
//	    System.out.println("Estado:     " + Estado);
//	    System.out.println("EstadoDesc: " + BuscaUnidadeFederativa(Estado));
//	    System.out.println("Ambiente:   " + BuscaAmbiente(Ambiente));
//	    System.out.println("Versao:     " + Versao);
//
//    }
//
//    public String transmitir(String setUfFavorecida, String setInscricaoEstadual, String setCodigoReceita, String setEmitenteCnpj, String setTipoDocumentoOrigem, String setDocumentoOrigem, String setValorPrincipal, String setDataVencimento, String setEmitenteRazaoSocial, String setEmitenteEndereco, String setEmitenteCodigoMunicipio, String setEmitenteUf, String setEmitenteCep, String setDataPagamento, String setEmitenteTelefone, String setConvenio, String setPeriodo, String setMes, String setAno, String setTipoValor, String setValorTotal, String setNumParcela, String setIncricaoEstadualContribuinte, String setCnpjContribuinte, String setCpfContribuinte, String setCodigoDetalhamentoReceita, String setCodigoProduto, String setDestinatarioRazaoSocial, String setDestinatarioCodMunicipio) {
//        String versao = "2.00";
//        LoteRecepcaoModel model = new LoteRecepcaoModel();
//        model.setUfFavorecida(setUfFavorecida);
//        model.setInscricaoEstadual(setInscricaoEstadual);
//        model.setCodigoReceita(setCodigoReceita);
//        model.setEmitenteCnpj(setEmitenteCnpj);
//        model.setTipoDocumentoOrigem(setTipoDocumentoOrigem);
//        model.setDocumentoOrigem(setDocumentoOrigem);
//        model.setValorPrincipal(setValorPrincipal);
//        model.setEmitenteRazaoSocial(setEmitenteRazaoSocial);
//        model.setEmitenteEndereco(setEmitenteEndereco);
//        model.setEmitenteCodigoMunicipio(setEmitenteCodigoMunicipio);
//        model.setEmitenteUf(setEmitenteUf);
//        model.setEmitenteCep(setEmitenteCep);
//        model.setEmitenteTelefone(setEmitenteTelefone);
//        model.setDataPagamento(setDataPagamento);
//        model.setDataVencimento(setDataVencimento);
//        model.setEmitenteTelefone(setEmitenteTelefone);
//        model.setConvenio(setConvenio);
//        model.setPeriodo(setPeriodo.isEmpty() ? "0" : setPeriodo);
//        model.setTipoValor(setTipoValor.isEmpty() ? "11" : setTipoValor);
//        model.setValorTotal(setValorTotal);
//        model.setNumParcela(setNumParcela);
//        model.setCnpjDestinatario(setCnpjContribuinte);
//        model.setInscricaoEstadualDestinatario(setIncricaoEstadualContribuinte);
//        model.setCpfDestinatario(setCpfContribuinte);
//        model.setCodigoDetalhamentoReceita(setCodigoDetalhamentoReceita);
//        model.setCodigoProduto(setCodigoProduto);
//        model.setDestinatarioRazaoSocial(setDestinatarioRazaoSocial);
//        model.setDestinatarioCodigoMunicipio(setDestinatarioCodMunicipio);
//        model.setMes(setMes);
//        model.setAno(setAno);
//        try {
//            logs = LoteRecepcaoApplication.transmitir(model, versao);
//        } catch (Exception e) {
//            logs = e.getMessage();
//            e.getStackTrace();
//        }
//
//        return logs;
//    }
//
//    public String transmitirXML(String XML) {
//        String versao = "2.00";
//        LoteRecepcaoModel model = new LoteRecepcaoModel();
//
//        try {
//            logs = LoteRecepcaoApplication.transmitir(model, versao);
//        } catch (Exception e) {
//            logs = e.getMessage();
//            e.getStackTrace();
//        }
//
//        return logs;
//    }
//
//    public String consultar(String numeroRecibo) {
//        try {
//            logs = ResultadoLoteApplication.consultaLote(numeroRecibo);
//        } catch (Exception e) {
//            logs = e.getMessage();
//            e.getStackTrace();
//        }
//
//        return logs;
//    }
//
//    private DFUnidadeFederativa BuscaUnidadeFederativa(String UF) {
//
//        DFUnidadeFederativa unidadefederativa;
//
//        switch (UF) {
//            case "PR":
//                unidadefederativa = DFUnidadeFederativa.PR;
//                break;
//            case "RR":
//                unidadefederativa = DFUnidadeFederativa.RR;
//                break;
//            case "AM":
//                unidadefederativa = DFUnidadeFederativa.AM;
//                break;
//            case "AC":
//                unidadefederativa = DFUnidadeFederativa.AC;
//                break;
//            case "RO":
//                unidadefederativa = DFUnidadeFederativa.RO;
//                break;
//            case "AP":
//                unidadefederativa = DFUnidadeFederativa.AP;
//                break;
//            case "PA":
//                unidadefederativa = DFUnidadeFederativa.PA;
//                break;
//            case "MT":
//                unidadefederativa = DFUnidadeFederativa.MT;
//                break;
//            case "TO":
//                unidadefederativa = DFUnidadeFederativa.TO;
//                break;
//            case "MA":
//                unidadefederativa = DFUnidadeFederativa.MA;
//                break;
//            case "PI":
//                unidadefederativa = DFUnidadeFederativa.PI;
//                break;
//            case "MS":
//                unidadefederativa = DFUnidadeFederativa.MS;
//                break;
//            case "GO":
//                unidadefederativa = DFUnidadeFederativa.GO;
//                break;
//            case "DF":
//                unidadefederativa = DFUnidadeFederativa.DF;
//                break;
//            case "MG":
//                unidadefederativa = DFUnidadeFederativa.MG;
//                break;
//            case "RJ":
//                unidadefederativa = DFUnidadeFederativa.RJ;
//                break;
//            case "SP":
//                unidadefederativa = DFUnidadeFederativa.SP;
//                break;
//            case "SC":
//                unidadefederativa = DFUnidadeFederativa.SC;
//                break;
//            case "RS":
//                unidadefederativa = DFUnidadeFederativa.RS;
//                break;
//            case "ES":
//                unidadefederativa = DFUnidadeFederativa.ES;
//                break;
//            case "BA":
//                unidadefederativa = DFUnidadeFederativa.BA;
//                break;
//            case "RN":
//                unidadefederativa = DFUnidadeFederativa.RN;
//                break;
//            case "CE":
//                unidadefederativa = DFUnidadeFederativa.CE;
//                break;
//            case "AL":
//                unidadefederativa = DFUnidadeFederativa.AL;
//                break;
//            case "PE":
//                unidadefederativa = DFUnidadeFederativa.PE;
//                break;
//            case "PB":
//                unidadefederativa = DFUnidadeFederativa.PB;
//                break;
//            case "SE":
//                unidadefederativa = DFUnidadeFederativa.SE;
//                break;
//            default:
//                unidadefederativa = DFUnidadeFederativa.PR;
//                break;
//        }
//
//        return unidadefederativa;
//    }
//
//    private DFAmbiente BuscaAmbiente(String Ambiente) {
//
//        DFAmbiente dfambiente;
//
//        switch (Ambiente) {
//            case "2":
//                dfambiente = DFAmbiente.HOMOLOGACAO;
//                break;
//            case "1":
//                dfambiente = DFAmbiente.PRODUCAO;
//                break;
//            default:
//                dfambiente = DFAmbiente.HOMOLOGACAO;
//                break;
//        }
//
//
//        return dfambiente;
//    }
//
//    private NFLoteIndicadorProcessamento DFBuscarModoProcessamento(String ModoProcessamento) {
//
//        if (ModoProcessamento.equals("1")) {
//            modoprocessamento = NFLoteIndicadorProcessamento.PROCESSAMENTO_SINCRONO;
//        } else {
//            modoprocessamento = NFLoteIndicadorProcessamento.PROCESSAMENTO_ASSINCRONO;
//        }
//
//        return modoprocessamento;
//    }
//*/
//}
