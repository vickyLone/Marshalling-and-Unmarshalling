package com.vicky.jaxbApplication;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.vicky.jaxb.Employee;

public class JaxbApplication {

	public static void main(String[] args) {
		
			
			convertObjectToXml();
			convertXmltoObject();
		
	}

	private static void convertXmltoObject() {
		  JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
          Marshaller marshaller = jaxbContext.createMarshaller();
          marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
          
          Employee employee = new Employee();
          employee.setId(101);
          employee.setName("Morarji");
          employee.setSalary(9000.00);
          
          marshaller.marshal(employee,new FileOutputStream("employee.xml"));
          System.out.println("emoloyee.xml created successfully...");
	}
	}

	private static void convertObjectToXml() {
		
		 File file = new File("employee.xml");
         JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
         Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
         Employee employee = (Employee)unmarshaller.unmarshal(file);
         
         System.out.println(employee);
	}
        		
	}

}
