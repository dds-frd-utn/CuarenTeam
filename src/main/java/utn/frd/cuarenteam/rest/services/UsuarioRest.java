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
import utn.frd.cuarenteam.entity.Usuarios;
import utn.frd.cuarenteam.sessions.UsuariosFacade;

/**
 *
 * @author Fausto
 */
@Path("/usuario")
public class UsuarioRest {
    @EJB
    private UsuariosFacade ejbUsuariosFacade;
    
    //obtener todas las entidades
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Usuarios> findAll(){
        return ejbUsuariosFacade.findAll();
    }
    
    //crear entidades
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Usuarios usuario){
        ejbUsuariosFacade.create(usuario);
    }
    
    //actualizar entidades
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{num_cuenta}")
    public void edit(@PathParam("num_cuenta")long num_cuenta, Usuarios usuario){
        ejbUsuariosFacade.edit(usuario);
    }
//eliminar entidades
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Path("/{num_cuenta}")
    public void remove(@PathParam("num_cuenta")int num_cuenta){
        ejbUsuariosFacade.remove( ejbUsuariosFacade.find(num_cuenta) );
    }
    
    //obtener una entidad por numero de cuenta
    @GET
    @Path("/{num_cuenta}")
    @Produces({MediaType.APPLICATION_JSON})
    public Usuarios findByNum_cuenta(@PathParam("num_cuenta")int num_cuenta){
        return ejbUsuariosFacade.find(num_cuenta);
    }
}
