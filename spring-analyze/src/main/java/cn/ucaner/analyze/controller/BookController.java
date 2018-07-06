package cn.ucaner.analyze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.ucaner.analyze.service.BookService;

/**
* @Package：cn.ucaner.analyze.controller   
* @ClassName：BookController   
* @Description：   <p> BookController </p>
* @Author： - Jason   
* @CreatTime：2018年7月6日 下午11:25:40   
* @Modify By：   
* @ModifyTime：  2018年7月6日
* @Modify marker：   
* @version    V1.0
 */
@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;

}
