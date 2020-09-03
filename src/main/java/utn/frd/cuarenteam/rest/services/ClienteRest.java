package utn.frd.cuarenteam.rest.services;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utn.frd.cuarenteam.entity.Clientes;
import utn.frd.cuarenteam.sessions.ClientesFacade;

/**
 *
 * @author Sergio
 */
@Path("/cliente")
public class ClienteRest {
    @EJB
    private ClientesFacade ejbClienteFacade;
    
    //obtener todas las entidades
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Clientes> findAll(){
        return ejbClienteFacade.findAll();
    }
    
    //crear entidades
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Clientes cliente){
        ejbClienteFacade.create(cliente);
    }
    
    //actualizar entidades
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{num_cuenta}")
    public void edit(@PathParam("num_cuenta")long num_cuenta, Clientes cliente){
        ejbClienteFacade.edit(cliente);
    }
    
    
//eliminar entidades
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Path("/{num_cuenta}")
    public void remove(@PathParam("num_cuenta")int num_cuenta){
        ejbClienteFacade.remove( ejbClienteFacade.find(num_cuenta) );
    }
    
    //obtener una entidad por numero de cuenta
    @GET
    @Path("/{num_cuenta}")
    @Produces({MediaType.APPLICATION_JSON})
    public Clientes findByNum_cuenta(@PathParam("num_cuenta")int num_cuenta){
        return ejbClienteFacade.find(num_cuenta);
    }
}
