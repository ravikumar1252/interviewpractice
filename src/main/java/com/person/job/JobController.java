package com.person.job;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

@RestController
public class JobController<personJob> {

	@Autowired
	private PersonRepository per;

	@GetMapping("pjob")
	public String getJob() {

		return "create ajob for person";

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
	public void savePersonPojo(@RequestBody PersonPojo p) {

		per.save(p);
	}

	@GetMapping("getDetails/{id}")
	public PersonPojo getPersonDetails(@PathVariable Integer id) throws PersonDetailsNotFound {

		try {
			return per.findById(id).get();
		} catch (Exception e) {
			throw new PersonDetailsNotFound("forthis id notAvilable.pls usebelow ids");
		}
		
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
	@DeleteMapping("deleteby/{id}")
	public PersonPojo deleteById(@PathVariable Integer id) throws DeletePersonDetailsNotFound {
		try {
			return per.findById(id).get();
		} catch (Exception e) {
			throw new  DeletePersonDetailsNotFound("deletedperson notAvilable.pls usebelow ids");
		}

		//per.deleteById(id);

	}
	
	@PutMapping("update")
	public void update(@RequestBody PersonPojo p) {
		per.save(p);
		
	}

}
