package sim.rest.proba;


import java.util.LinkedList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("/proba")
public class Proba {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String a() {
		return "<p>abababababfafaf</p>";
	}
	@Path("/a")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String aaaaa() {
		return "<p>aaaaaaaaaa</p>";
	}

	@Path("/sofija")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response b(@QueryParam("author") String author, @QueryParam("b") String b) throws JSONException {
		Response r = null;
		JSONObject obj = new JSONObject();
		// String a ="<p><b>Sofija <3</b> </p>";
		String a = "aaaaaa";
		LinkedList<String> knjige = new LinkedList<String>();
		knjige.add("Knjiga o dzungli");
		knjige.add("Bela griva");
		knjige.add("Kopilot");
		obj.put("knjige", knjige);
		obj.putOpt("proba", a);
		obj.put(author, author);
		obj.put(b, b);
		String aa = obj.toString();
		r = Response.ok(aa).build();

		return r;
	}
}
