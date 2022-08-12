package com.person.job;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JobController<personJob> {

	@Autowired
	private PersonRepository per;

	@GetMapping("/")
	public String Indexpage(Model model) {
		model.addAttribute("command",new PersonPojo());
		return "index";
		
	}

	@GetMapping("plist")
	public int[] pJobs() {
		int arr[] = { 2, 4, 6, 7, 8, 34 };
		return arr;
	}
	//
	// @GetMapping("person")
	// public PersonPojo getPersonjob() {
	// return new PersonPojo(1, "ramesh", 28, "satish");
	//
	// }
	//
	// @GetMapping("persons")
	// public List<PersonPojo> getPersons() {
	// List<PersonPojo> persons = Arrays.asList(
	//
	// new PersonPojo(1, "kalpana", 23, "ameerpet"), new PersonPojo(2, "kirthi", 28,
	// "ambarpet"),
	// new PersonPojo(3, "kishore", 39, "jagayyapet"), new PersonPojo(4, "krishna",
	// 40, "doolpet"));
	//
	// return persons;
	//
	// }
	//
	// @GetMapping("mapData")
	// public Map<Integer, String> getmapData() {
	// Map<Integer, String> map = new HashMap<>();
	//
	// map.put(1, "kishore");
	// map.put(2, "sathish");
	// map.put(3, "ramesh");
	// return map;
	// }
	// @GetMapping("getperson")
	// public PersonPojo getPersonById(@RequestParam Integer id) {
	// System.out.println(id);
	// return new PersonPojo(1, "ramesh", 28, "satish");
	//
	// }
	// @GetMapping("getpersonModel")
	// public String getPersonById() {
	//
	// PersonPojo p = new PersonPojo(1, "ramesh", 28, "satish");
	// ModelAndView mv = new ModelAndView();
	// mv.addObject("p",p);
	// mv.setViewName("index");
	// return null;

	// }
	@PostMapping("save")
	public String savePersonPojo(PersonPojo person, Model model) {
		per.save(person);
		model.addAttribute("command",new PersonPojo());
		return "index";
		
	}

	@GetMapping("getpersonById/{id}")
	public String getPersonDetails(@PathVariable Integer id,Model model) throws PersonDetailsNotFound {

		try {
			PersonPojo p =per.findById(id).get();
			model.addAttribute("p",p);
		} catch (Exception e) {
			throw new PersonDetailsNotFound("forthis id notAvilable.pls usebelow ids");
		}
		return "view";
		
	}
	@GetMapping("getAllPersons")
	public String getAllPersons(PersonPojo perons,Model model){
		List<PersonPojo> list=per.findAll();
		model.addAttribute("list",list);
		
		return "viewAllPersonDetails" ;
		
	}
//
//	@GetMapping("getDetails")
//	public PersonPojo getPersonId(@RequestParam Integer id) {
//
//		return per.findById(id).get();
//	}

//	@DeleteMapping("deleteby/{id}")
//	public void deleteById(@PathVariable Integer id) {
//
//		per.deleteById(id);
//
//	}
	@GetMapping("deleteperson/{id}")
	public String deleteById(@PathVariable Integer id,PersonPojo p) throws DeletePersonDetailsNotFound {
		try {
			 per.delete(p);
		} catch (Exception e) {
			throw new  DeletePersonDetailsNotFound("deletedperson notAvilable.pls usebelow ids");
		}
		return "delete";

		//per.deleteById(id);

	}
	
	@GetMapping("edit")
	public void updateById(@RequestBody PersonPojo p) {
		per.save(p);
		
	}

}
