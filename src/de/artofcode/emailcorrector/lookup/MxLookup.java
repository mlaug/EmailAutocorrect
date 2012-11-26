package de.artofcode.emailcorrector.lookup;

import java.util.Hashtable;
import javax.naming.*;
import javax.naming.directory.*;

public class MxLookup {

	public static int doLookup(String hostName) throws NamingException {
		Hashtable env = new Hashtable();
		env.put("java.naming.factory.initial",
				"com.sun.jndi.dns.DnsContextFactory");
		DirContext ictx = new InitialDirContext(env);
		Attributes attrs = ictx.getAttributes(hostName, new String[] { "MX" });
		Attribute attr = attrs.get("MX");
		if (attr == null)
			return (0);
		return (attr.size());
	}

}
