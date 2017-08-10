package com.mysite.controller;



	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.repository.GuestBookDao;
	import com.mysite.vo.GuestBookVo;

	@Controller
	@RequestMapping(value="guestbook")
	public class GuestBookController {
		
		@Autowired
		private GuestBookDao guestbookDao;
		
		@RequestMapping(value="/list", method=RequestMethod.GET)
		public String getList(Model model) {
			List<GuestBookVo> list = guestbookDao.getList();
			model.addAttribute("list", list);
			return "guestbook/list";
		}

		@RequestMapping(value="/add", method=RequestMethod.POST)
		public String add(@ModelAttribute GuestBookVo vo) {
			int count = guestbookDao.insert(vo);
			System.out.println(count + "건 등록");
			return "redirect:/guestbook/list";
		}
		
		@RequestMapping(value="/deleteform", method=RequestMethod.GET)
		public String deleteform(@RequestParam("no") int no, Model model) {
			System.out.println(no);
			return "/guestbook/deleteform";
		}
		
		@RequestMapping(value="/delete", method=RequestMethod.POST)
		public String deleteform(@ModelAttribute GuestBookVo vo) {
			int count = guestbookDao.delete(vo);
			System.out.println(count + "건 삭제");
			return "redirect:/guestbook/list";
		}
	
}
