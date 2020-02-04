package com.tommytech.bootstrap;

import com.tommytech.domain.Student;
import com.tommytech.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent>{

@Autowired	
private StudentRepository repository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Student student_a = new Student();
		student_a.setFirstName("Jane");
		student_a.setLastName("Doe");
		student_a.setYear("Junior");
		repository.save(student_a);
		
		Student student_b = new Student();
		student_b.setFirstName("Martin");
		student_b.setLastName("Fowler");
		student_b.setYear("Senior");
		repository.save(student_b);
		
		Student student_c = new Student();
		student_c.setFirstName("Roy");
		student_c.setLastName("Fielding");
		student_c.setYear("Freshman");
		repository.save(student_c);

		Student student_d = new Student();
		student_d.setFirstName("Branford");
		student_d.setLastName("Gbieor");
		student_d.setYear("Senior");
		repository.save(student_d);

        Student student_e = new Student();
        student_e.setFirstName("Rhoda");
        student_e.setLastName("Howard");
        student_e.setYear("Senior");
        repository.save(student_e);

        Student student_f = new Student();
        student_f.setFirstName("Tim");
        student_f.setLastName("Jones");
        student_f.setYear("Freshman");
        repository.save(student_f);

	}

}
