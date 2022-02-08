package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

/**
 * 管理者登録画面を表示する処理を行います。
 * 
 * @author kashimamiyu
 *
 */

@Controller
@RequestMapping("/")
public class AdministratorController {
	
	@Autowired
	private HttpSession session;

	@Autowired
	private AdministratorService administratorService;
	
	/**
	 * @return InsertAdministratorFormをインスタンス化
	 */
	
	@ModelAttribute
	public InsertAdministratorForm setUpAdministratorForm(){
		return new InsertAdministratorForm();
	}
	
	/**
	 * @return administrator/insert.htmlにフォワード
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}
	
	/**
	 * 管理者情報を登録する。
	 * @param form
	 * @return "/"
	 */
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form) {
		Administrator administrator = new Administrator();
		administrator.setName(form.getName());
		administrator.setMailAddress(form.getMailAddress());
		administrator.setPassword(form.getPassword());
		administratorService.insert(administrator);
		return "/";
	}
	
	@ModelAttribute
	public LoginForm setUpLoginForm() {
		return new LoginForm();
	}
	
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login";
	}
	
	@RequestMapping("/login")
	public String login(LoginForm form, Model model) {
		
		 Administrator administrator = administratorService.login(form.getMailAddress(), form.getPassword());
		 
		 if(administrator == null) {
			 model.addAttribute("message", "メールアドレスまたはパスワードが不正です。");
			 return "administrator/login";
		 }
		 session.setAttribute("administratorName", administrator.getName());
		 return "foward:/employee/showList";
	}
}
