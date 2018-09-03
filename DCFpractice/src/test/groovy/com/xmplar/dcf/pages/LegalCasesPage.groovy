package com.xmplar.dcf.pages

import geb.Page

class LegalCasesPage extends Page {
	static atCheckWaiting = true
	static at = {title == "Court Case"}
	public static content= {
		formId { $("form", id:"iFamilynetForm") }
		category { $("div",id:"iFamilynetForm:category_label")}
		type {$("div",id:"iFamilynetForm:type_label")}
		status{$("div",id:"iFamilynetForm:status")}
		legalregion {$("div",id:"iFamilynetForm:srclegalRegion_label")}
		attorney {$("div",id:"iFamilynetForm:srcstaff_label")}
		assignmenttype{$("div",id:"iFamilynetForm:j_id_5k_13_label")}
		searchButton{$("div",id:"iFamilynetForm:searchBtn")}
			}
	
	def legalCases(search)
	{
		waitFor(20){category.click()}
		waitFor(20){$("li[data-label='"+search.get("Category")+"']").click()}
		waitFor(20){type.click()}
		waitFor(20){$("li[data-label='"+search.get("Type")+"']").click()}
		waitFor(20){status.click()}
		waitFor(20){$("li[data-label='"+search.get("Status")+"']").click()}
		waitFor(20){legalregion.click()}
		waitFor(20){$("li[data-label='"+search.get("Legalregion")+"']").click()}
		waitFor(20){attorney.click()}
		waitFor(20){$("li[data-label='"+search.get("Attorney")+"']").click()}
		waitFor(20){assignmenttype.click()}
		waitFor(20){$("li[data-label='"+search.get("Assignmenttype")+"']").click()}
		searchButton.click()
	}
			
}
