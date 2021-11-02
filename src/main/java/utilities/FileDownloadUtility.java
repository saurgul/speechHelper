package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/// Given a url and fileName, download the contents of the URL and save it to a file.
public class FileDownloadUtility {

	private static void downloadFile(URL url, String outputPath) throws Exception {
		InputStream inputStream = url.openStream();
		Files.copy(inputStream, Paths.get(outputPath), StandardCopyOption.REPLACE_EXISTING);
	}

	public static String getFileContents(URL url, String fileName) throws Exception {
		String outputPath = "Documents" + "/" + fileName;
		downloadFile(url, outputPath);
		String fileContent = "";
		try {
			fileContent = new String(Files.readAllBytes(Paths.get(outputPath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileContent;
	}
}
