package com.toby.study;

import com.toby.study.domain.dao.CustomUserDao;
import com.toby.study.domain.dao.UserDao;
import com.toby.study.domain.user.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

//@SpringBootApplication
public class StudyApplication {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		SpringApplication.run(StudyApplication.class, args);

		UserDao dao = new CustomUserDao();
		User user = new User();

		user.setId("1");
		user.setName("박영재");
		user.setPassword("1234");

		// 등록
		dao.add(user);
		System.out.println(user.getId() + " 등록 성공");

		// 	조회
		User getUser = dao.get(user.getId());
		System.out.println(getUser.getName());
		System.out.println(getUser.getPassword());
		System.out.println(getUser.getId() + " 조회 성공");
	}


}
