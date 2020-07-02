package com.jp.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

	@RequestMapping(value = "/logger", method = RequestMethod.GET)
	public void logger() {
		LOGGER.warn("logger warning");
		LOGGER.info("logger info");
		LOGGER.debug("logger debug");
		LOGGER.error("logger error");
	}
}
