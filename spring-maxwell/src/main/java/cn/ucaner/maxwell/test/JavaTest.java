package cn.ucaner.maxwell.test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;

import org.junit.Test;

import cn.ucaner.maxwell.base.Student;

public class JavaTest {

    private class MyList extends ArrayList<Object> {

		private static final long serialVersionUID = -1354914750258632312L;

		@Override
        public String get(int index) {
            return "";
        }
    }

    public static void main(String[] args) {
        for (Method method : MyList.class.getDeclaredMethods()) {
            System.out.println("name: " + method.getName() + ", return: " + method.getReturnType());
        }
    }

    @Test
    public void classpath() {
        System.out.println(System.getProperty("java.class.path"));
    }
//Outputs
//name: get, return: class java.lang.String
//name: get, return: class java.lang.Object

    
    @Test
    public void findClass() throws IOException {
        Enumeration<URL> base = JavaTest.class.getClassLoader().getResources("classpath:/*");
        while (base.hasMoreElements()) {
            System.out.println(base.nextElement().toString());
        }
    }

    @Test
    public void intro() throws IntrospectionException {
        BeanInfo info = Introspector.getBeanInfo(Student.class);
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.println(pd.getReadMethod());
            System.out.println(pd.getWriteMethod());
        }
    }
//Outputs 
//    public int cn.ucaner.maxwell.base.Student.getAge()
//    public void cn.ucaner.maxwell.base.Student.setAge(int)
//    public final native java.lang.Class java.lang.Object.getClass()
//    null
//    public java.lang.String cn.ucaner.maxwell.base.BaseStudent.getId()
//    public void cn.ucaner.maxwell.base.BaseStudent.setId(java.lang.String)
//    public java.lang.String cn.ucaner.maxwell.base.Student.getName()
//    public void cn.ucaner.maxwell.base.Student.setName(java.lang.String)
    
    

    @Test
    public void split() {
        String str = "1\t2\taug\tfri\t14.7\t66\t2.7\t0\t0";
        String[] arr = str.split("\t");
        System.out.println(Arrays.toString(arr));
        System.out.println(arr);
        System.out.println("月份: " + arr[2]);
        System.out.println("天气: " + arr[4]);
    }
//Outputs
//[1, 2, aug, fri, 14.7, 66, 2.7, 0, 0]
//		[Ljava.lang.String;@32a1bec0
//		月份: aug
//		天气: 14.7

}
