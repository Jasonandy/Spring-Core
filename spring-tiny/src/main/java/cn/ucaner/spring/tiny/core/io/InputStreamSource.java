package cn.ucaner.spring.tiny.core.io;

import java.io.IOException;
import java.io.InputStream;

public interface InputStreamSource {
	
	InputStream getInputStream() throws IOException;

}
