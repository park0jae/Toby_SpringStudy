package com.toby.study;

import com.toby.study.domain.dao.UserDao;
import com.toby.study.domain.user.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class StudyApplication {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		SpringApplication.run(StudyApplication.class, args);
	}

}
