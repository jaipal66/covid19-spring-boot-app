package com.jp.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class EmployeeService {

	public void convertToXml(EmployeeCollection employee) {
		try {
			JAXBContext context = JAXBContext.newInstance(EmployeeCollection.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(employee, new File("employeeCollection.xml"));
			System.out.println("Converted to xml");

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	public EmployeeCollection convertToObject(File file, EmployeeCollection employeeCollection) {
		try {
			JAXBContext jaxBContext = JAXBContext.newInstance(EmployeeCollection.class);
			Unmarshaller unmarshaller = jaxBContext.createUnmarshaller();
			employeeCollection = (EmployeeCollection) unmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeCollection;

	}
}
