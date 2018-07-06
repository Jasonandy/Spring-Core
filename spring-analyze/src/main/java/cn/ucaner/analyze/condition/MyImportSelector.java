package cn.ucaner.analyze.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
* @Package：cn.ucaner.analyze.condition   
* @ClassName：MyImportSelector   
* @Description：   <p> 自定义逻辑返回需要导入的组件 </p>
* @Author： - Jason   
* @CreatTime：2018年7月6日 下午11:14:06   
* @Modify By：   
* @ModifyTime：  2018年7月6日
* @Modify marker：   
* @version    V1.0
 */
public class MyImportSelector implements ImportSelector {

	//返回值，就是到导入到容器中的组件全类名
	//AnnotationMetadata:当前标注@Import注解的类的所有注解信息
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		//importingClassMetadata
		//方法不要返回null值
		return new String[]{"cn.ucaner.analyze.bean.Blue","cn.ucaner.analyze.bean.Yellow"};
	}

}
