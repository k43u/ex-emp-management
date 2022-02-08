package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.service.EmployeeService;

/**
 * 従業員情報を検索します。
 * 
 * @author kashimamiyu
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;
	
	
	/**
	 * 従業員一覧を取得
	 * @param model
	 * @return 従業員一覧
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		model.addAttribute("employeeList", employeeservice.showList());
		return "employee/list";
	}
	
}
