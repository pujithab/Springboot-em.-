package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.config.FilesStuff;
import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;

@Controller
public class StudentControler {
	@Autowired
	StudentDao sdao;
	@Autowired
	FilesStuff fileTemplate;

	@RequestMapping("/student")
	public String showform(Model model) {
		model.addAttribute("testStudent", new Student());
		List<Student> list = sdao.StudentView();
		model.addAttribute("studentList", list);

		return "student";
	}

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String saveAdmin(@Valid @ModelAttribute Student student, Model model, RedirectAttributes redir,
			@RequestParam("file") MultipartFile[] files) throws IOException {
		System.out.println(student);
		if (student.getId() == 0) {

			int result = sdao.RecordExistsOrNot(student);
			System.out.println(result);
			if (result == 1) {
				
				// file upload

				try {
					for (MultipartFile multipartFile : files) {
						String fileName = multipartFile.getOriginalFilename();
						if (!multipartFile.isEmpty()) {
							/* task.setUploadfile(fileName); */
							System.out.println(fileName);
							multipartFile.transferTo(fileTemplate.moveFileTodir(fileName));
						}
					}
				} catch (IllegalStateException e) {
					e.printStackTrace();
				}
				if(null !=student.getFiles()) {
					
				student.setFiles(fileTemplate.concurrentFileNames());
				fileTemplate.clearFiles();
				}
				
				
				sdao.SaveOrUpdate(student);
				redir.addFlashAttribute("msg", "Record inserted");
				redir.addFlashAttribute("cssMsg", "success");
				return "redirect:/student";

			} else {
				redir.addFlashAttribute("msg", "Record already exists");
				redir.addFlashAttribute("cssMsg", "danger");
				return "redirect:/student";
			}

		} else {

			int result = sdao.RecordExistsOrNot(student);
			System.out.println(result);
			if (result == 1) {
				try {
					for (MultipartFile multipartFile : files) {
						String fileName = multipartFile.getOriginalFilename();
						if (!multipartFile.isEmpty()) {
							System.out.println(fileName);
							multipartFile.transferTo(fileTemplate.moveFileTodir(fileName));
						}
					}
				} catch (IllegalStateException e) {
					e.printStackTrace();
				}

				student.setFiles(fileTemplate.concurrentFileNames());
				fileTemplate.clearFiles();

				sdao.SaveOrUpdate(student);
				redir.addFlashAttribute("msg", "Record updated");
				redir.addFlashAttribute("cssMsg", "warning");
				return "redirect:/student";

			} else {
				redir.addFlashAttribute("msg", "Record already exists");
				redir.addFlashAttribute("cssMsg", "danger");
				return "redirect:/student";
			}

		}
	}

	@RequestMapping(value = "/studentedit", method = RequestMethod.GET)
	public String update(@RequestParam(value = "id", required = true) String id, Model model,
			RedirectAttributes redir) {
		int id1 = Integer.parseInt(id);
		Student b = sdao.getStudentById(id1);
		System.out.println(b);
		model.addAttribute("testStudent", b);
		List<Student> list = sdao.StudentView();

		model.addAttribute("studentList", list);
		return "student";

	}

	@RequestMapping(value = "/studentdelete")
	public String deleteStudent(@RequestParam(value = "id", required = true) String id, Model model,
			RedirectAttributes redir) {

		int id1 = Integer.parseInt(id);
		int status = 0;
		try {
			status = sdao.StudentDelete(id1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (status == 1) {
			redir.addFlashAttribute("msg", "Record deleted");
			redir.addFlashAttribute("cssMsg", "success");
			return "redirect:/student";
		} else
			redir.addFlashAttribute("msg", "Record notdeleted");
		redir.addFlashAttribute("cssMsg", "danger");
		return "redirect:/student";

	}

}
