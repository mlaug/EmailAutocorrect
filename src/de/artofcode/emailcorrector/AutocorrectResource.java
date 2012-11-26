package de.artofcode.emailcorrector;

import java.io.IOException;

import javax.naming.NamingException;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import de.artofcode.emailcorrector.lookup.MxLookup;

public class AutocorrectResource extends ServerResource {

	@Get
	public String validate() throws IOException {
		String email = (String) this.getRequestAttributes().get("email");
		String delimiter = "@";
		String domain = email.split(delimiter)[1];
		MxLookup.doLookup(domain, "mx");
		return "ok";
	}

}
