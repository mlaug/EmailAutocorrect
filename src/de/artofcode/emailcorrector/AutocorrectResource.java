package de.artofcode.emailcorrector;

import javax.naming.NamingException;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import de.artofcode.emailcorrector.lookup.MxLookup;

public class AutocorrectResource extends ServerResource {

	@Get
	public String validate() {
		String email = (String) this.getRequestAttributes().get("email");
		String delimiter = "@";
		String domain = email.split(delimiter)[1];
		try {
			Integer mxRecordCount = MxLookup.doLookup(domain);
			if ( mxRecordCount > 0 ){
				return email;
			}
			return "shit address";
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			return e.getExplanation();
		}
	}

}
