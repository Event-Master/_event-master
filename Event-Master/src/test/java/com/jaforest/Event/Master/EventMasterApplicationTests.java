package com.jaforest.Event.Master;

import com.jaforest.Event.Master.model.event.Event;
import com.jaforest.Event.Master.model.family.Family;
import com.jaforest.Event.Master.model.member.Member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class EventMasterApplicationTests {


	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void testGettersAndSettersMember() {
		Member member = new Member();
		assertEquals("",member.getPassword());
		assertEquals("", member.getUsername());
		assertEquals("",member.getFirstName());
		assertEquals("",member.getLastName());
		assertEquals("",member.getRole());
		assertEquals("",member.getFamilyIBelongTo());
	}

	@Test
	public void testGetterAndSettersFamily() {
		Family family = new Family();
		assertEquals("", family.getFamilyName());
	}

	@Test
	public void testGetterAndSettersEvent() {
		Event event = new Event();
		assertEquals("", event.getTitle());
		assertEquals("", event.getStartDay());
		assertEquals("", event.getStartDay());
		assertEquals("", event.getFamilyEventsIBelongTo());
	}


	@Test
	public void testGetRequestEndpointsHome() throws IOException {
		URL url = new URL("http://localhost:8080");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		System.out.println(http.getResponseCode() + "" + http.getResponseMessage());
		assertEquals("http://localhost:8080", url);
	}

	@Test
	public void testGetRequestEndpointsLogin() throws IOException {
		URL url = new URL("http://localhost:8080/login");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		System.out.println(http.getResponseCode() + "" + http.getResponseMessage());
		assertEquals("http://localhost:8080/login", url);
	}

	@Test
	public void testGetRequestEndpointsSignup() throws IOException {
		URL url = new URL("http://localhost:8080/signup");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		System.out.println(http.getResponseCode() + "" + http.getResponseMessage());
		assertEquals("http://localhost:8080/signup", url);
	}

	@Test
	public void testGetRequestEndpointsCalendar() throws IOException {
		URL url = new URL("http://localhost:8080/calendar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		System.out.println(http.getResponseCode() + "" + http.getResponseMessage());
		assertEquals("http://localhost:8080/calendar", url);
	}

	@Test
	public void testGetRequestEndpointsProfile() throws IOException {
		URL url = new URL("http://localhost:8080/profile");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		System.out.println(http.getResponseCode() + "" + http.getResponseMessage());
		assertEquals("http://localhost:8080/profile", url);
	}

	@Test
	public void testGetRequestEndpointsAbout() throws IOException {
		URL url = new URL("http://localhost:8080/aboutus");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		System.out.println(http.getResponseCode() + "" + http.getResponseMessage());
		assertEquals("http://localhost:8080/aboutus", url);
	}

	@Test
	void testHomePage() throws Exception {
		mockMvc.perform(get("/home"))
				.andDo(print())
				.andExpect((content().string(containsString("<!doctype html>"))))
				.andExpect((content().string(containsString("<html lang=\"en\" xmlns:th=\"\">"))))
				.andExpect((content().string(containsString("<head>"))))
				.andExpect((content().string(containsString("<meta charset=\"UTF-8\">"))))
				.andExpect((content().string(containsString("<meta name=\"viewport\"\n" +
						"          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">"))))
				.andExpect((content().string(containsString("<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">"))))
				.andExpect((content().string(containsString("<title>Document</title>"))))
				.andExpect((content().string(containsString("<link rel=\"stylesheet\" href=\"/css/main.css\">"))))
				.andExpect((content().string(containsString("</head>"))))
				.andExpect((content().string(containsString("<body>"))))
				.andExpect((content().string(containsString("<header class=\"header\" th:replace=\"./fragments/header :: header\"></header>"))))
				.andExpect((content().string(containsString("<div class=\"section\">"))))
				.andExpect((content().string(containsString("<div class=\"row\">"))))
				.andExpect((content().string(containsString("<div class=\"col-1-of-2\">"))))
				.andExpect((content().string(containsString("<form action=\"/login\" method=\"POST\" class=\"form\">"))))
				.andExpect((content().string(containsString("<div class=\"form__group\">"))))
				.andExpect((content().string(containsString("<input  id=\"username-1\" class=\"form__input\"\n" +
						"                                type=\"text\"placeholder=\"Username\" required name=\"username\">"))))
				.andExpect((content().string(containsString("<label for=\"username-1\" class=\"form__label\">Username</label>"))))
				.andExpect((content().string(containsString("</div>"))))
				.andExpect((content().string(containsString("<div class=\"form__group\">"))))
				.andExpect((content().string(containsString("<input  id=\"password-1\" class=\"form__input\" required type=\"password\"\n" +
						"                                placeholder=\"Password\" name=\"password\">"))))
				.andExpect((content().string(containsString(" <label for=\"password-1\" class=\"form__label\">Password</label>"))))
				.andExpect((content().string(containsString("</div>"))))
				.andExpect((content().string(containsString("<div class=\"form__group form__group--btn\">"))))
				.andExpect((content().string(containsString("<button class=\"btn btn--orange\" type=\"submit\">Login</button>"))))
				.andExpect((content().string(containsString("</div>"))))
				.andExpect((content().string(containsString("<div class=\"col-1-of-2\">"))))
				.andExpect((content().string(containsString("<form for=\"username\" action=\"/newUser\" class=\"form form__create-account\"\n" +
						"                      method=\"POST\">"))))
				.andExpect((content().string(containsString("<div class=\"form__group\">"))))
				.andExpect((content().string(containsString("<input  id=\"username\" class=\"form__input\"\n" +
						"                                type=\"text\" placeholder=\"Choose a Username\" required\n" +
						"                                name=\"username\">"))))
				.andExpect((content().string(containsString(" <label for=\"username\" class=\"form__label\">Choose a Username</label>"))))
				.andExpect((content().string(containsString("</div>"))))
				.andExpect((content().string(containsString("<div class=\"form__group\">"))))
				.andExpect((content().string(containsString(" <input  id=\"password\" class=\"form__input\" type=\"password\"\n" +
						"                                placeholder=\"Enter a Password\" name=\"password\">"))))
				.andExpect((content().string(containsString("<label for=\"password\" class=\"form__label\">Enter a Password</label>"))))
				.andExpect((content().string(containsString("</div>"))))
				.andExpect((content().string(containsString("<div class=\"form__group \">"))))
				.andExpect((content().string(containsString(" <input id=\"firstName\" class=\"form__input\"\n" +
						"                               placeholder=\"Enter your first name\"\n" +
						"                               type=\"text\"name=\"firstName\">"))))
				.andExpect((content().string(containsString("<label for=\"firstName\" class=\"form__label\" >First Name</label>"))))
				.andExpect((content().string(containsString("</div>"))))
				.andExpect((content().string(containsString("<div class=\"form__group \">"))))
				.andExpect((content().string(containsString(" <input id=\"lastName\" class=\"form__input\"\n" +
						"                               placeholder=\"Enter your last name\"\n" +
						"                               type=\"text\"name=\"lastName\">"))))
				.andExpect((content().string(containsString("<label for=\"lastName\" class=\"form__label\" >Last Name</label>"))))
				.andExpect((content().string(containsString("</div>"))))
				.andExpect((content().string(containsString("<div class=\"form__group form__group--btn\">"))))
				.andExpect((content().string(containsString("<button type=\"submit\" class=\"btn btn--orange\">Create Account</button>"))))
				.andExpect((content().string(containsString("</div>"))))
				.andExpect((content().string(containsString("</form>"))))
				.andExpect((content().string(containsString("</div>"))))
				.andExpect((content().string(containsString("</div>"))))
				.andExpect((content().string(containsString("</div>"))))
				.andExpect((content().string(containsString("<footer th:replace=\"./fragments/footer :: footer\"></footer>"))))
				.andExpect((content().string(containsString("</body>"))))
				.andExpect((content().string(containsString("</html>"))))
				.andExpect(status().isOk());
	}

	@Test
	void testSignUpPage() throws Exception {
		mockMvc.perform(get("/signup"))
				.andDo(print())
				.andExpect((content().string(containsString("<!DOCTYPE html>"))))
				.andExpect((content().string(containsString("<html lang=\"en\" xmlns:th=\"\">"))))
				.andExpect((content().string(containsString("<head>"))))
				.andExpect((content().string(containsString("<meta charset=\"UTF-8\">"))))
				.andExpect((content().string(containsString("<title>Title</title>"))))
				.andExpect((content().string(containsString("<link rel=\"stylesheet\" href=\"/css/main.css\">"))))
				.andExpect((content().string(containsString("</head>"))))
				.andExpect((content().string(containsString("<body>"))))
				.andExpect((content().string(containsString("<header th:replace=\"./fragments/header :: header\"></header>"))))
				.andExpect((content().string(containsString("<h1>Signup</h1>"))))
				.andExpect((content().string(containsString("<form action=\"/newFamily\" method=\"POST\">"))))
				.andExpect((content().string(containsString("<label for=\"familyUsername\">Username</label>"))))
				.andExpect((content().string(containsString("<input id=\"familyUsername\" type=\"text\" name=\"familyUsername\">"))))
				.andExpect((content().string(containsString("<label for=\"familyPassword\">Password</label>"))))
				.andExpect((content().string(containsString("<input id=\"familyPassword\" type=\"password\" name=\"familyPassword\">"))))
				.andExpect((content().string(containsString("<label for=\"familyName\">Family Name</label>"))))
				.andExpect((content().string(containsString("<input id=\"familyName\" type=\"text\" name=\"familyName\">"))))
				.andExpect((content().string(containsString("<input type=\"submit\" value=\"Create New Family\">"))))
				.andExpect((content().string(containsString("</form>"))))
				.andExpect((content().string(containsString("<footer th:replace=\"./fragments/footer :: footer\"></footer>"))))
				.andExpect((content().string(containsString("</body>"))))
				.andExpect((content().string(containsString("</html>"))))
				.andExpect(status().isOk());
	}

	@Test
	void testLoginPage() throws Exception {
		mockMvc.perform(get("/login"))
				.andDo(print())
				.andExpect((content().string(containsString("<!DOCTYPE html>"))))
				.andExpect((content().string(containsString("<html lang=\"en\" xmlns:th=\"\">"))))
				.andExpect((content().string(containsString("<head>"))))
				.andExpect((content().string(containsString("<meta charset=\"UTF-8\">"))))
				.andExpect((content().string(containsString("<title>Title</title>"))))
				.andExpect((content().string(containsString("<link rel=\"stylesheet\" href=\"/css/main.css\">"))))
				.andExpect((content().string(containsString("</head>"))))
				.andExpect((content().string(containsString("<body>"))))
				.andExpect((content().string(containsString("<header th:replace=\"./fragments/header :: header\"></header>"))))
				.andExpect((content().string(containsString("<form action=\"/login\" method=\"POST\">"))))
				.andExpect((content().string(containsString("<label for=\"username\">Username</label>"))))
				.andExpect((content().string(containsString("<input id=\"username\" type=\"text\" name=\"username\">"))))
				.andExpect((content().string(containsString("<label for=\"password\">Password</label>"))))
				.andExpect((content().string(containsString("<input id=\"password\" type=\"password\" name=\"password\">"))))
				.andExpect((content().string(containsString("<input type=\"submit\" value=\"login\">"))))
				.andExpect((content().string(containsString("</form>"))))
				.andExpect((content().string(containsString("<footer th:replace=\"./fragments/footer :: footer\"></footer>"))))
				.andExpect((content().string(containsString("</body>"))))
				.andExpect((content().string(containsString("</html>"))))
				.andExpect(status().isOk());
	}

	@Test
	void testCalendarPage() throws Exception {
		mockMvc.perform(get("/calendar"))
				.andDo(print())
				.andExpect((content().string(containsString("<!doctype html>"))))
				.andExpect((content().string(containsString("<html lang=\"en\" xmlns:th=\"http://www.thymeleaf.org\">"))))
				.andExpect((content().string(containsString("<head>"))))
				.andExpect((content().string(containsString("<meta charset=\"UTF-8\">"))))
				.andExpect((content().string(containsString("<title>Document</title>"))))
				.andExpect((content().string(containsString("<link rel=\"stylesheet\" href=\"/css/main.css\">"))))
				.andExpect((content().string(containsString("</head>"))))
				.andExpect((content().string(containsString("<body>"))))
				.andExpect((content().string(containsString("<header th:replace=\"./fragments/header :: header\"></header>"))))
				.andExpect((content().string(containsString("<h3>Add new Event</h3>"))))
				.andExpect((content().string(containsString("<form action=\"/newEvent\" method=\"post\">"))))
				.andExpect((content().string(containsString("<label for=\"title\">Title</label>"))))
				.andExpect((content().string(containsString("<input id=\"title\" type=\"text\" placeholder=\"Type your Event title here\" required name=\"title\">"))))
				.andExpect((content().string(containsString("<label for=\"date\">Date</label>"))))
				.andExpect((content().string(containsString("<input id=\"date\" type=\"date\"  required name=\"date\">"))))
				.andExpect((content().string(containsString("<input type=\"submit\" value=\"Add\">"))))
				.andExpect((content().string(containsString("</form>"))))
				.andExpect((content().string(containsString("<div class=\"ui container\">"))))
				.andExpect((content().string(containsString("<div class=\"ui grid\">"))))
				.andExpect((content().string(containsString("<div class=\"ui sixteen column\">"))))
				.andExpect((content().string(containsString("<div id=\"calendar-main\"></div>"))))
				.andExpect((content().string(containsString("</div>"))))
				.andExpect((content().string(containsString("</div>"))))
				.andExpect((content().string(containsString("</div>"))))
				.andExpect((content().string(containsString("<footer th:replace=\"./fragments/footer :: footer\"></footer>"))))
				.andExpect((content().string(containsString("</body>"))))
				.andExpect((content().string(containsString("</html>"))))
				.andExpect(status().isOk());
	}


}
