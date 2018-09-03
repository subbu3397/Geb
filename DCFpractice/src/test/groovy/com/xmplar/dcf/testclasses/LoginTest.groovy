package com.xmplar.dcf.testclasses
import geb.Page
import geb.spock.GebSpec;
import org.json.simple.JSONObject
import com.xmplar.dcf.pages.*;
import com.xmplar.dcf.utils.*;

class LoginTest extends GebSpec {
	def reportId="";
	def "Login to DCF application"(){
		
		given: "Login form with User Id and passwords fields"
		to LoginPage
           
		when: "A user enters the valid User Id and passwords Id"
		login(users);
		
		then: "Home page should be navigated"
		at Home
		
		when:"Click on legal menu and Click on legal Cases menu"
		
	         $("div[id='iFamilynetForm:j_id_71']").find("span",text:"Legal").click();
			 waitFor(20) {$("span",text:"Legal Cases").click()}
			 
		

	//	LegalCasesPage.Click();
		
		then:" It should on Legal cases Page"
		at LegalCasesPage
		
		when:"Enter all mandatory fields and click search Button"
		legalcases(search)
		
		then:"Court Case Informations should be displayed"
		at Courtcase
		
		where:
		[users,search] << Read.readXLSXFile();
	}
	
}
