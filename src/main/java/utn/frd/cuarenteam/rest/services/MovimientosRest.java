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
import utn.frd.cuarenteam.entity.Movimientos;
import utn.frd.cuarenteam.sessions.MovimientosFacade;

/**
 *
 * @author Fausto
 */
@Path("/movimientos")
public class MovimientosRest {
    @EJB
    private MovimientosFacade ejbMovimientosFacade;
    
    //obtener todas las entidades
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Movimientos> findAll(){
        return ejbMovimientosFacade.findAll();
    }
    
    //crear entidades
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Movimientos movimientos){
        ejbMovimientosFacade.create(movimientos);
    }
    
    //actualizar entidades
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public void edit(@PathParam("id")long id, Movimientos movimientos){
        ejbMovimientosFacade.edit(movimientos);
    }
//eliminar entidades
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Path("/{id}")
    public void remove(@PathParam("id")int id){
        ejbMovimientosFacade.remove( ejbMovimientosFacade.find(id) );
    }
    
    //obtener una entidad por numero de cuenta
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Movimientos findById(@PathParam("id")int id){
        return ejbMovimientosFacade.find(id);
    }
}
