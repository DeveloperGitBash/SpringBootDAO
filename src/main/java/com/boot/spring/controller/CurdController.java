package com.boot.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.spring.beans.Department;
import com.boot.spring.beans.Student;
import com.boot.spring.exception.UserDefinedException;
import com.boot.spring.repository.CurdRepositry;

@RestController
@RequestMapping("curd")
public class CurdController {
	  Logger logger = LoggerFactory.getLogger(CurdController.class);

	@Autowired
	private CurdRepositry repository;

	@GetMapping("/alldept")
	public ResponseEntity<List<Department>> getAllDept() {
		logger.debug("CurdController--getAllDept()");
		List<Department> allDept = repository.findAll();
		return new ResponseEntity<>(allDept, HttpStatus.OK);
	}

	@GetMapping("/getById/{deptId}")
	public ResponseEntity<Department> getDeptById(@PathVariable Long deptId) {

		Department deptById = repository.findById(deptId)
				.orElseThrow(() -> new UserDefinedException("Department not found for this id :: " + deptId));
		return new ResponseEntity<>(deptById, HttpStatus.OK);
	}

	@PostMapping("/createDept")
	public ResponseEntity<Department> createDept(@RequestBody Department dept) {

		Department saveUser = repository.save(dept);
		return new ResponseEntity<>(saveUser, HttpStatus.OK);
	}

	@PutMapping("/update/{deptId}/{stuId}")
	public ResponseEntity<Department> updateDept(@RequestBody Department dept, @PathVariable Long deptId,
			@PathVariable Long stuId) {

		Department updateDept = repository.findById(deptId).get();
		updateDept.setDepNane(dept.getDepNane());
		updateDept.setHodName(dept.getHodName());
		updateDept.setHodContact(dept.getHodContact());
		if (!updateDept.getStudents().isEmpty()) {
			Student student = updateDept.getStudents().stream().filter(stu -> stu.getSudentId() == stuId)
					.collect(Collectors.toList()).get(0);

			student.setStudentName(dept.getStudents().get(0).getStudentName());
			List<Student> stuList = new ArrayList<>();
			stuList.add(student);
			updateDept.setStudents(stuList);
		}
		Department update = repository.save(updateDept);

		return new ResponseEntity<>(update, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{deptId}")
	public Map<String, Boolean> deletDeptById(@PathVariable Long deptId) {
		Department department = repository.findById(deptId)
				.orElseThrow(() -> new UserDefinedException("Department not found for this id :: " + deptId));
		repository.delete(department);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
