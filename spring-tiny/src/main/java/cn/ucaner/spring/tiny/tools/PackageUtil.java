package cn.ucaner.spring.tiny.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
* @Package：cn.ucaner.spring.tiny.tools   
* @ClassName：PackageUtil   
* @Description：   <p> 通过包名返回该包下所有的类名 </p>
* @Author： - cwt   
* @CreatTime：2018年4月27日 上午11:20:25   
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class PackageUtil {

	public static List<String> getClassName(String packageName) {
		
		String filePath ="test\\java\\"+packageName.replace(".", "\\");
		List<String> fileNames = getClassName(filePath, null);
		return fileNames;	
	}

	private static List<String> getClassName(String filePath,
			List<String> className) {
		
		List<String> myClassName = new ArrayList<String>();
		File file = new File(filePath);
		File[] childFiles = file.listFiles();
		for (File childFile : childFiles) {
			if (childFile.isDirectory()) {
				myClassName.addAll(getClassName(childFile.getPath(),
						myClassName));
			} else {
				String childFilePath = childFile.getPath();
				childFilePath = childFilePath.substring(
						childFilePath.indexOf("\\classes") + 9,
						childFilePath.lastIndexOf("."));
				childFilePath = childFilePath.replace("\\", ".");
				childFilePath=childFilePath.substring(6,childFilePath.length());
				myClassName.add("com."+childFilePath);
			}
		}
		return myClassName;
	}
}
