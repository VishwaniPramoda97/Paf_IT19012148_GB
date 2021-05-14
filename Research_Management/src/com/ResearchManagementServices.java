package com;

import model.ResearchManagement;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Research")

public class ResearchManagementServices {
	
	ResearchManagement research = new ResearchManagement();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readResearch() {
		return research.readResearch();
	}
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertResearch(@FormParam("name") String name,
			@FormParam("email") String email,
			@FormParam("projectTitle") String projectTitle,
			@FormParam("totalCost") String totalCost,
			@FormParam("duration") String duration,@FormParam("catogary") String catogary) {
		String output = research.insertResearch(name, email, projectTitle, totalCost, duration, catogary);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateResearch(String ResearchData) {
		// Convert the input string to a JSON object
		JsonObject ResearchObject = new JsonParser().parse(ResearchData).getAsJsonObject();
		// Read the values from the JSON object

		String rid = ResearchObject.get("rid").getAsString();
		String name = ResearchObject.get("name").getAsString();
		String email = ResearchObject.get("email").getAsString();
		String projectTitle = ResearchObject.get("projectTitle").getAsString();
		String totalCost = ResearchObject.get("totalCost").getAsString();
		String duration = ResearchObject.get("duration").getAsString();
		String catogary = ResearchObject.get("catogary").getAsString();
		String output = research.updateResearch(rid, name, email, projectTitle, totalCost, duration, catogary);
		return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteResearch(String ResearchData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(ResearchData, "", Parser.xmlParser());

		String rid = doc.select("rid").text();
		String output = research.deleteResearch(rid);
		return output;
	}


}
