package app.notafiscal;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.utils.DFCadeiaCertificados;

public class GerarCadeia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        try {
			FileUtils.writeByteArrayToFile(new File("C:\\Docker\\Linux\\srv\\apps\\cacerts\\homologacao.cacerts"), DFCadeiaCertificados.geraCadeiaCertificados(DFAmbiente.HOMOLOGACAO, "changeit"));
			FileUtils.writeByteArrayToFile(new File("C:\\Docker\\Linux\\srv\\apps\\cacerts\\producao.cacerts"), DFCadeiaCertificados.geraCadeiaCertificados(DFAmbiente.PRODUCAO, "changeit"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
