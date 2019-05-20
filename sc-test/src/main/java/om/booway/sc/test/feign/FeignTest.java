package om.booway.sc.test.feign;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.booway.sc.TestInit;
import com.booway.sc.user.client.UserClient;
import com.booway.sc.user.entity.dto.UserDto;

/**
 * 
 * @author jsb-hujie
 * 
 *         2019年5月5日
 *
 */
@SpringBootTest(classes = { TestInit.class })
@RunWith(SpringRunner.class)
public class FeignTest
{
	/** 调用feign的客户端 */
	@Autowired
	private UserClient userClient;

	@Test
	public void testCall()
	{
		List<UserDto> udtos = userClient.queryById(1);
		System.out.println(udtos);
	}
	@Test
	public void testUpload() throws Exception
	{
		File file = new File("C:\\Users\\jsb-hujie\\Desktop\\日常记录.txt");
		DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file", MediaType.TEXT_PLAIN_VALUE, true, file.getName());
		
		InputStream input = new FileInputStream(file); 
		OutputStream os = fileItem.getOutputStream();
		IOUtils.copy(input, os);
		MultipartFile multi = new CommonsMultipartFile(fileItem);
		
		String str = userClient.upload(multi);
		System.out.println(str);
	}
}
