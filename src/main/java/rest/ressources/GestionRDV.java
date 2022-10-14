package rest.ressources;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import rest.entities.Logement;
import rest.entities.RendezVous;
import tn.esprit.business.RendezVousBusiness;

@Path("rendezvous")

public class GestionRDV {
	List<RendezVous> listeRendezVous;
	GestionLogement logementMetier=new GestionLogement();
private static RendezVousBusiness rdB = new RendezVousBusiness(); 
	

@POST
@Consumes(MediaType.APPLICATION_JSON) 
@Produces(MediaType.TEXT_PLAIN)
	public Response addRendezVous(RendezVous Rdv) {
	if (rdB.addRendezVous(Rdv)) {
		return Response.status(Status.CREATED).entity("added successfully").build();}
	return Response.status(Status.NOT_FOUND).entity("failed to add").build();}

@GET
//@Produces(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_XML)
public Response getListRdv() {
	
	if(rdB.getListeRendezVous().size()!=0)
	{
		GenericEntity ma_liste = new GenericEntity<List<RendezVous>>(rdB.getListeRendezVous()){};

		return Response.status(Status.FOUND).entity(ma_liste).build();}
	return Response.status(Status.NOT_FOUND).entity("liste est vide").build();
	}

	
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("getListByRef")
public Response getRdvbyRef(@QueryParam(value="refLogement") int ref) {
	if(rdB.getListeRendezVousByLogementReference(ref).size()!=0)
	{
		return Response.status(Status.FOUND).entity(rdB.getListeRendezVousByLogementReference(ref)).build();}
	return Response.status(Status.NOT_FOUND).entity("liste vide").build();

	}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("{id}")
public Response getRdvById(@PathParam(value="id")int id) {
	
if(rdB.getRendezVousById(id)!=null) {
	return Response.status(Status.FOUND).entity(rdB.getRendezVousById(id)).build();}
return Response.status(Status.NOT_FOUND).entity("inexistant").build();}


@DELETE
@Path("{id}")
@Produces(MediaType.APPLICATION_JSON)
public Response deleteRdv(@PathParam(value="id") int id) {
	if(rdB.deleteRendezVous(id)) {
		return Response.status(Status.FOUND).entity(rdB.getListeRendezVous()).build();}
		return Response.status(Status.NOT_FOUND).entity("delete failed").build();}


@PUT
@Path("{id}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response updateRdv(@PathParam(value="id") int id, RendezVous rdv) {
	if(rdB.updateRendezVous(id, rdv))
		return Response.status(Status.FOUND).entity(rdv).build();
	return Response.status(Status.NOT_FOUND).entity("update failed").build();
	
}


}


	
	
