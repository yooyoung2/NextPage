package kr.or.ddit.school.manager.auth.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import kr.or.ddit.school.manager.auth.service.AuthManageService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AuthManageController {

	@Inject
	public AuthManageService service;
}
