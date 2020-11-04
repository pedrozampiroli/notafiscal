package app.notafiscal;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.consultaRecibo.MDFeConsultaReciboRetorno;
import com.fincatto.documentofiscal.mdfe3.classes.consultanaoencerrados.MDFeConsultaNaoEncerradosRetorno;
import com.fincatto.documentofiscal.mdfe3.classes.lote.envio.MDFEnvioLote;
import com.fincatto.documentofiscal.mdfe3.classes.lote.envio.MDFEnvioLoteRetornoDados;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFe;
import com.fincatto.documentofiscal.mdfe3.classes.nota.consulta.MDFeNotaConsultaRetorno;
import com.fincatto.documentofiscal.mdfe3.classes.nota.evento.MDFeRetorno;
import com.fincatto.documentofiscal.mdfe3.utils.MDFGeraQRCode;
import com.fincatto.documentofiscal.mdfe3.webservices.WSFacade;
import com.fincatto.documentofiscal.utils.DFPersister;


public class MDFeAPI {

	private MDfeConfiguracao sconfiguracao;
	private DFUnidadeFederativa sEstado;
	private DFAmbiente sAmbiente;
	
	private String  sCadeiaCertificadoSenha;
	private String  sCadeiaCertificadoCaminho;
	private String  sCaminhoCertificado;
	private String  sCertificadoSenha;

	private String  logs;
	
	private MDFeConfig config = new MDFeConfig() {

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
		                throw new KeyStoreException("Nao foi possivel montar o KeyStore com a cadeia de certificados", e);
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
		public DFAmbiente getAmbiente() {
	        return sAmbiente;
	    }
		
	
	};
	
	public void Configurar(String CertificadoSenha,
						   String CadeiaCertificadoSenha,
						   String CaminhoCertificado,
						   String CaminhoCadeiaCertificado,
						   String Estado,
						   String Ambiente ) {
		
		sconfiguracao = new MDfeConfiguracao();
		
		sconfiguracao.getCertificadoKeyStore        = CaminhoCertificado;  
		sconfiguracao.getCertificadoSenha 		    = CertificadoSenha;		
		
		sconfiguracao.getCadeiaCertificadosKeyStore = CaminhoCadeiaCertificado;   
		sconfiguracao.getCadeiaCertificadosSenha    = CadeiaCertificadoSenha;

		sconfiguracao.DFUnidadeFederativa 		    = BuscaUnidadeFederativa(Estado);
		sconfiguracao.DFAmbiente           		    = BuscaAmbiente(Ambiente);
		
		sAmbiente 				 				    = BuscaAmbiente(Ambiente);
		sEstado   				  				    = BuscaUnidadeFederativa(Estado);
	
		sCadeiaCertificadoCaminho 				    = CaminhoCadeiaCertificado;
		sCadeiaCertificadoSenha   				    = CadeiaCertificadoSenha;
		
		sCaminhoCertificado 	  				    = CaminhoCertificado;
		sCertificadoSenha                           = CertificadoSenha;
			       
	}



	private DFUnidadeFederativa BuscaUnidadeFederativa(String UF) {
		
		DFUnidadeFederativa unidadefederativa;
		
		switch (UF) {		
		case "PR" :
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
			case "1" :
				dfambiente = DFAmbiente.PRODUCAO;
				 break;
			default:
				dfambiente = DFAmbiente.HOMOLOGACAO;
				 break;
		}
		
		
		return dfambiente;
	}

	public String transmitir(String loteid, String ver, String xml) {

		xml = xml.replaceAll("\r","");
		xml = xml.replaceAll("\t","");
		xml = xml.replaceAll("\n","");
		xml = xml.replaceAll("&lt;","<");
		xml = xml.replaceAll("&gt;",">");

		String value = null;

		try {
			value = new String(xml.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e2) {
		      System.out.println(e2.getMessage());
		}

		try {
			MDFe mdfe = new DFPersister().read(MDFe.class, value);

			MDFEnvioLote LoteEnvio = new MDFEnvioLote();
			LoteEnvio.setIdLote(loteid);
			LoteEnvio.setVersao(ver);
			LoteEnvio.setMdfe(mdfe);

			MDFEnvioLoteRetornoDados mdfEnvioLoteRetornoDados = new WSFacade(config).envioRecepcaoLote(LoteEnvio);

			logs = mdfEnvioLoteRetornoDados.getLoteAssinado().toString();
			logs += "," + mdfEnvioLoteRetornoDados.getRetorno();

		} catch (Exception e) {
			logs = "error: " + e.getMessage();
		}

		return logs;

	}

	public String cancelar(String chave, String protocolo, String justificativa) {

		try {
			MDFeRetorno mdfEnvioLoteRetornoDados = new WSFacade(config).cancelaMdfe(chave,protocolo,justificativa);
			logs = mdfEnvioLoteRetornoDados.getEventoRetorno().toString();
		} catch (Exception e) {
			logs = e.getMessage();
		}
		return logs;
	}
	
	public String encerrar(String chave, String protocolo, String codigomunicipio , String dataencerramento) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate localDate = LocalDate.parse(dataencerramento, formatter);

		try {
			MDFeRetorno mdfEnvioLoteRetornoDados = new WSFacade(config).encerramento(chave,protocolo,codigomunicipio,localDate,sEstado);
			logs = mdfEnvioLoteRetornoDados.getEventoRetorno().toString();
		} catch (Exception e) {
			logs = e.getMessage();
		}
		return logs;
	}

	public String naoencerrada(String cnpj){

		try {

			MDFeConsultaNaoEncerradosRetorno  mdfeconsultanaorncerradosretorno = new WSFacade(config).consultaNaoEncerrados(cnpj);

			logs = mdfeconsultanaorncerradosretorno.toString();
		} catch (Exception e) {
			logs = e.getMessage();
		}
		return logs;

	}

	public String consultar(String chave){

		try {
			MDFeNotaConsultaRetorno mdfEnvioLoteRetornoDados = new WSFacade(config).consultaMdfe(chave);
			logs = mdfEnvioLoteRetornoDados.toString();
		} catch (Exception e) {
			logs = e.getMessage();
		}
		return logs;

	}

	public String consultarrecibo(String recibo){

		try {
			MDFeConsultaReciboRetorno mdfeconsultareciboretorno = new WSFacade(config).consultaRecibo(recibo);
			logs = mdfeconsultareciboretorno.toString();
		} catch (Exception e) {
			logs = "error: " + e.getMessage();
		}

		return logs;
	}

	public String gerarQRCode(String xml) {




		xml = xml.replaceAll("&lt;","<");
		xml = xml.replaceAll("&gt;",">");

		MDFe mdfe = null;

		try {
			mdfe = new DFPersister().read(MDFe.class, xml);
			MDFGeraQRCode qrcode = new MDFGeraQRCode(mdfe,config);
			logs = qrcode.getQRCode();
		} catch (Exception e) {
			logs = "error: " + e.getMessage();
		}

		return logs;
	}


}

