package himedia.myportal.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.myportal.repositories.vo.GuestbookVo;
import himedia.myportal.services.GuestbookServices;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	private static final Logger logger = LoggerFactory.getLogger(GuestbookController.class);
	@Autowired
	private GuestbookServices guestbookServiceImpl;
	
	//	방명록 리스트 가져오기
	@GetMapping({"", "/", "/list"})
	public String list(Model model) {
		List<GuestbookVo> list = guestbookServiceImpl.getMessageList();
		model.addAttribute("list", list);
		return "guestbook/list";
	}
	
	// 방명록 글쓰기 처리
	
	@PostMapping("/write")
	public String write(@ModelAttribute GuestbookVo vo) {
		System.out.println("FORM:" + vo);
		boolean success = guestbookServiceImpl.writeMessage(vo);
		System.out.println("Write Result:" + success);
		return "redirect:/guestbook";
	}
	
	//	삭제 폼
	@GetMapping("/delete/{no}")
	public String deleteForm(@PathVariable("no") Integer no, Model model) {
		model.addAttribute("no", no);
		return "guestbook/deleteform";
	}
	
	//	삭제 처리
	@PostMapping("/delete")
	public String deleteAction(@ModelAttribute GuestbookVo vo) {
		boolean success = guestbookServiceImpl.deleteMessage(vo);
		System.out.println("Delete Result:" + success);
		return "redirect:/guestbook";
	}
	
	/*
	@Autowired
	GuestbookService guestbookServiceImpl;
	
	@GetMapping({"", "/", "/list"})
	public String list(Model model) {
		List<GuestbookVo> list = 
				guestbookServiceImpl.getMessageList();
		model.addAttribute("list", list);
		return "guestbook/list";
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute GuestbookVo vo) {
		System.out.println("FORM:" + vo);
		boolean success = guestbookServiceImpl
							.writeMessage(vo);
		System.out.println("Write Result:" + success);
		return "redirect:/guestbook";
	}
	
	@RequestMapping(value="/delete/{no}",
			method=RequestMethod.GET)
	public String deleteForm(@PathVariable("no") Integer no, 
							Model model) {
		model.addAttribute("no", no);
		return "guestbook/deleteform";
	}
	
	@RequestMapping(value="/delete",
			method=RequestMethod.POST)
	public String deleteAction(@ModelAttribute GuestbookVo vo) {
		boolean success = guestbookServiceImpl.deleteMessage(vo);
		System.out.println("Delete Result:" + success);
		return "redirect:/guestbook";
	}
	*/
}