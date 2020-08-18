package io.example;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FDFSServiceApp.class)
public class FDFSApplicationTest {

	@Autowired
	private FastFileStorageClient fastFileStorageClient;

	@Test
	public void uploadFile() {
		try {
			File image = new File("D:\\Keep\\var\\temp\\yasuo.jpg");
			String fileName = image.getName();
			String extFileName = fileName.substring(fileName.lastIndexOf(".") + 1);
			FileInputStream fileInputStream = new FileInputStream(image);

			StorePath storePath = fastFileStorageClient.uploadFile(fileInputStream, image.length(), extFileName, null);

			System.out.println(storePath.getClass());
			System.out.println(storePath.getFullPath());
			System.out.println(storePath.getGroup());
			System.out.println(storePath.getPath());

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteFile() {
		fastFileStorageClient.deleteFile("group1/M00/00/00/wKgAb18gIj2AXYcnAAX2TtXI2Rs403.jpg");
		System.out.println("success");
	}

}
