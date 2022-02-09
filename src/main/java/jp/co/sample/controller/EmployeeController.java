package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
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
	
	@ModelAttribute
	public UpdateEmployeeForm setUpdateEmployeeForm() {
		return new UpdateEmployeeForm();
	}
	
	/**
	 * 従業員情報を取得
	 * @param id
	 * @param model
	 * @return 従業員詳細
	 */
	@RequestMapping("/showDetail")
	public String showDatail(String id, Model model) {
		Employee employee = employeeservice.showDetail(Integer.parseInt(id));
	    model.addAttribute("employee", employee);
	    return "employee/detail";
	}
	
	/**
	 * 従業員詳細を更新
	 * @param form
	 * @return 従業員リスト
	 */
	@RequestMapping("/update")
	public String update(
		@Validated UpdateEmployeeForm form
		,BindingResult result
		,RedirectAttributes redirectAttributes
		,Model model
			
		) {
		
		if(result.hasErrors()) {
			return showDatail(form.getId(), model);
		}
		
		Employee employee = employeeservice.showDetail(Integer.parseInt(form.getId()));
		employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));
		employeeservice.update(employee);
		return "redirect:/employee/showList";
	}
}
