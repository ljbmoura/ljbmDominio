package br.com.ljbm.utilitarios;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * Classe utilitária para testes.
 */
public class Recurso {

	private static final int BUFFER_LEN = 4096;

//	private static final String DADOS_ESTADOS = "/resources/common/estados.xml";
//
//	private static final String DADOS_USUARIOS_E_AGENTES = "/resources/common/usuarios_e_agentes.xml";

//	/**
//	 * Carrega o banco de dados de testes com os dados gerais de usu�rios e
//	 * agentes.
//	 */
//	public static DbUnitUtil setupDb() throws Exception {
//		DbUnitUtil dbUnitUtil = new DbUnitUtil(Arrays.asList(TestUtil.getFileAbsolutePath(TestUtil.DADOS_ESTADOS),
//				TestUtil.getFileAbsolutePath(TestUtil.DADOS_USUARIOS_E_AGENTES)));
//		dbUnitUtil.resetTestDatabase();
//		return dbUnitUtil;
//	}

//	/**
//	 * Carrega um conjunto de configura��es para uso em testes automatizados.
//	 * 
//	 * @param resourcesDir
//	 * @throws Exception
//	 */
//	public static void setUpConfiguracaoParaTestes(File resourcesDir) throws Exception {
//		Properties properties = new Properties();
//		properties.put("CAPACIDADE_REPOSITORIO", "100");
//		properties.put("PASTA_REPOSITORIO", resourcesDir.getAbsolutePath());
//		properties.put("LOCAL_ARQUIVOS_TEMPORARIOS", "c:/temp/");
//		properties.put("IDE_USUARIO_ROBO_IEW", "531439");
//		Configuracao configuracao = new Configuracao(properties) {
//		};
//		Configuracao.setConfiguracaoParaTestes(configuracao);
//	}

//	/**
//	 * Carrega o banco de dados de testes com os dados do dataSet especificado e
//	 * com os dados gerais de usu�rios e agentes.
//	 */
//	public static DbUnitUtil setupDb(String dadosDb, File resourcesDir) throws Exception {
//		DbUnitUtil dbUnitUtil = new DbUnitUtil(Arrays.asList(TestUtil.getFileAbsolutePath(TestUtil.DADOS_ESTADOS),
//				TestUtil.getFileAbsolutePath(TestUtil.DADOS_USUARIOS_E_AGENTES), new File(resourcesDir, dadosDb)));
//
//		dbUnitUtil.resetTestDatabase();
//		
//		return dbUnitUtil;
//	}

	public static <T> File getPastaRecursos(Class<T> type) {
		String res = "/" + type.getName().replace('.', '/') + "/";

		URL resource = type.getResource(res);

		if (resource == null) {
			throw new IllegalArgumentException("Recurso não encontrado: " + res);
		}
		return new File(resource.getPath());
	}

//	public static <T> Set<T> asSet(T... array) {
//		Set<T> set = new HashSet<T>();
//		if (array != null) {
//			for (T element : array) {
//				set.add(element);
//			}
//		}
//		return set;
//	}

	public static String getFileContents(String path) throws IOException {
		StringBuilder contents = new StringBuilder();
		FileReader reader = new FileReader(path);
		char[] buffer = new char[BUFFER_LEN];
		boolean eof = false;

		while (!eof) {
			int chars = reader.read(buffer, 0, BUFFER_LEN);
			if (chars > 0) {
				contents.append(buffer, 0, chars);
			} else {
				eof = true;
			}
		}
		reader.close();
		return contents.toString();
	}

//	private static File getFileAbsolutePath(String relativePath) throws URISyntaxException {
//		return new File(Recurso.class.getResource(relativePath).toURI());
//	}
}
