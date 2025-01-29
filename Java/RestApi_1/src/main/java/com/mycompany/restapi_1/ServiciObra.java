package com.mycompany.restapi_1;

import java.util.ArrayList;
import java.util.List;
 
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
 
@Path("/obra")
public class ServiciObra {
 
    private static List<Obra> listaObres = new ArrayList<Obra>() {
        {
            add(new Obra(1, "El pensador", "1920", "Escultura" ,"Auguste Rodin"));
            add(new Obra(2, "El noche estrellada", "1889","Pintura", "Van Gogh"));
            add(new Obra(5, "La Gioconda", "1503", "Pintura", "Leonardo da Vinci"));
        }
    };

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        return Response.ok(listaObres).build();
    }
 
    @GET
    @Path("/{ID_OBRA}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("ID_OBRA") int ID_OBRA) {
        Obra found = null;
        //Recorr la llista que retorna i serca l'id pertinent --tots son similars--
        for (int i = 0; i < listaObres.size(); i++) {
            if (listaObres.get(i).getID_OBRA() == ID_OBRA) {
                found = listaObres.get(i);
            }
        }
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("Obra not found").build();
        } else {
            return Response.ok(found).build();
        }
    }
    
    @GET
    @Path("/autor/{AUTOR}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObrarAutor(@PathParam("AUTOR") String AUTOR) {
        Obra found = null;
        for (int i = 0; i < listaObres.size(); i++) {
            if (listaObres.get(i).getAUTOR().equalsIgnoreCase(AUTOR)) {
                found = listaObres.get(i);
            }
        }
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("Obra not found").build();
        } else {
            return Response.ok(found).build();
        }
    }
    
    @POST
    @Path("/createObra")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(Obra obraRequest) {
        //Espera un objectan de tipus llista añ qual afegeix a la llista de de obres que hi ha i torna a montar
        this.listaObres.add(obraRequest);
        return Response.ok(listaObres).build();
 
    }
 
    @PUT
    @Path("/updateObra")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePacient(Obra obraUpdate) {
        //Rep un objecte obre i serque el que coincideix per ID i sustitueix tots els parametres del objecte que coincideix per els que te l'objecte nou
        
        Obra found = null;
        for (int i = 0; i < listaObres.size(); i++) {
            if (listaObres.get(i).getID_OBRA() == obraUpdate.getID_OBRA()) {
                found = listaObres.get(i);
            }
        }
 
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("Obra not found").build();
        } else {
            found.setID_OBRA(obraUpdate.getID_OBRA());
            found.setTITOL(obraUpdate.getTITOL());
            found.setANY(obraUpdate.getANY());
            found.setMODALITAT(obraUpdate.getMODALITAT());
            found.setAUTOR(obraUpdate.getAUTOR());
            return Response.ok(found).build();
        }
    }

    @DELETE
    @Path("/deleteObra/{ID_OBRA}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("ID_OBRA") int ID_OBRA) {
        //Recorr la llista i borre l'objecta que coincideix per ID        
        Obra found = null;
        for (int i = 0; i < listaObres.size(); i++) {
            if (listaObres.get(i).getID_OBRA() == ID_OBRA) {
                found = listaObres.get(i);
                listaObres.remove(found);
            }
        }
 
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("Obra not found").build();
        } else {
            return Response.ok(listaObres).build();
        }
    }
 
}