package com.jp.product.catalogue.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jp.product.catalogue.entity.Suplier;

@RestController
public class SuplierController {

	@RequestMapping(value = "/supliers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
	public Suplier createSuplier(@RequestBody Suplier suplier) {
		return null;
	}

	@RequestMapping(value = "/supliers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public List<Suplier> displayAllSuplier() {
		return null;
	}

	@RequestMapping(value = "/supliers/{suplierID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public Suplier displaySuplierById(@PathVariable int suplierID) {
		return null;
	}

	@RequestMapping(value = "/supliers", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public Suplier updateSuplier(@RequestBody Suplier suplier) {
		return null;
	}

	@RequestMapping(value = "/supliers/{suplierID}", method = RequestMethod.DELETE)
	public void deleteSuplierById(@PathVariable int suplierId) {
		return ;
	}

	@RequestMapping(value = "/supliers", method = RequestMethod.DELETE)
	public void deleteAllSuplier() {
		return;
	}

}
