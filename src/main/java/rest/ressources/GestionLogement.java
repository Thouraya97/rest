package rest.ressources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import rest.entities.Logement;
import rest.entities.Logement.Type;
import tn.esprit.business.LogementBusiness;

@Path("logements")
public class GestionLogement {
private List<Logement> logements;

private static LogementBusiness lgB = new LogementBusiness();
	

@GET
@Produces(MediaType.APPLICATION_JSON)
public Response getListLogements() {
	
	if(lgB.getLogements().size()!=0)
	{

		return Response.status(Status.FOUND).entity(lgB.getLogements()).build();}
	return Response.status(Status.NOT_FOUND).entity("liste est vide").build();
	}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("getListByDelegation")
public Response getLogementsbyDelegation(@QueryParam(value="delegation") String delegation) {
	if(lgB.getLogementsByDeleguation(delegation).size()!=0)
	{
		return Response.status(Status.FOUND).entity(lgB.getLogementsByDeleguation(delegation)).build();}
	return Response.status(Status.NOT_FOUND).entity("liste vide").build();

	}




@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("getListByGouvernorat")
public Response getLogementsbyGouvernorat(@QueryParam(value="gouvernorat") String gouvernorat) {
	if(lgB.getLogementsByGouvernorat(gouvernorat).size()!=0)
	{
		return Response.status(Status.FOUND).entity(lgB.getLogementsByGouvernorat(gouvernorat)).build();}
	return Response.status(Status.NOT_FOUND).entity("liste vide").build();

	}






@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("getListByType")
public Response getLogementsbyType(@QueryParam(value="type") Logement.Type type ) {
	if(lgB.getLogementsByType(type).size()!=0)
	{
		return Response.status(Status.FOUND).entity(lgB.getLogementsByType(type)).build();}
	return Response.status(Status.NOT_FOUND).entity("liste vide").build();

	}



@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("getListByPrice")
public Response getLogementsbyPrice(@QueryParam(value="prix") float prix ) {
	if(lgB.getLogementsByPrix(prix).size()!=0)
	{
		return Response.status(Status.FOUND).entity(lgB.getLogementsByPrix(prix)).build();}
	return Response.status(Status.NOT_FOUND).entity("liste vide").build();

	}


@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("getLogementByRef")
public Response getLogementsbyRef(@QueryParam(value="reference") int ref ) {
	if(lgB.getLogementsByReference(ref)!=null)
	{
		return Response.status(Status.FOUND).entity(lgB.getLogementsByReference(ref)).build();}
	return Response.status(Status.NOT_FOUND).entity("inexistant").build();

	}

























}
