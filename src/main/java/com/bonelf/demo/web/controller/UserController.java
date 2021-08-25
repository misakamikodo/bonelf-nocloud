package com.bonelf.demo.web.controller;

import com.bonelf.demo.web.domain.vo.UserInfoVO;
import com.bonelf.frame.core.domain.Result;
import com.bonelf.frame.web.util.ContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * mock Controller
 * @author bonelf
 * @date 2021/8/24 15:18
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private ContextUtil contextUtil;

	@GetMapping("/info")
	public Result<UserInfoVO> info() {
		log.debug("userId:{}", contextUtil.getUserId());
		return Result.ok(new UserInfoVO());
	}
}
