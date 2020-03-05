package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.bean.UserBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;

public class UserDataProviders {
 

	@DataProvider(name = "db-inputs")
	public Object [][] getUserDBData() {

		List<UserBean> list = new ELearningDAO().getUserDetails(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(UserBean temp : list){
			Object[]  obj = new Object[8]; 
			obj[0] = temp.getFirstname();
			obj[1] = temp.getLastname();
			obj[2] = temp.getEmail();
			obj[3] = temp.getProfile();
			obj[4] = temp.getUsername();
			obj[5] = temp.getPassword();
			obj[6] = temp.getPasswordConfirm();
			obj[7] = temp.getLanguage();
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "db-inputs-compare")
	public Object [][] getUserDBDataForComparison() {

		List<UserBean> list = new ELearningDAO().getUserDetailsForComparison(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(UserBean temp : list){
			Object[]  obj = new Object[8]; 
			obj[0] = temp.getFirstname();
			obj[1] = temp.getLastname();
			obj[2] = temp.getEmail();
			obj[3] = temp.getProfile();
			obj[4] = temp.getUsername();
			obj[5] = temp.getPassword();
			obj[6] = temp.getPasswordConfirm();
			obj[7] = temp.getLanguage();
			result[count ++] = obj; 
		}
		
		
		return result;
	}

	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\KAVITAKUMAR\\Desktop\\ElearningXlsDataProvider.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	
}
