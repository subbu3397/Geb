package com.xmplar.dcf.pages;
import geb.Page;

public class LoginPage extends Page
{
	static url="http://public.dcf.systems/fnet/web-2/login.jsf"
	static at = {title == "iFamilynet Login"}
	static content = {
		
		formId { $("form", id:"iFamilynetForm") }
		userId { $("input", name: "iFamilynetForm:vgUserId") }
		vgOrgId{ $("input", name: "iFamilynetForm:vgOrgId") }
				loginButton { $("button", id: "iFamilynetForm:j_id_v") }
		
	}
	
		
	def login(users)
	{
		userId.value(users.get("UserName"))
		vgOrgId.value(users.get("Password"))
		loginButton.click();	
	}
	
}
