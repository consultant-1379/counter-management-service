/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2019
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.ericsson.oss.services.countermanagement.rest.resources;

import com.ericsson.oss.services.countermanagement.api.CounterManagementService;
import com.ericsson.oss.services.countermanagement.api.dto.FlexCounterDTO;
import com.ericsson.oss.services.countermanagement.impl.ServiceStatisticsBean;
import org.slf4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

/*
 * Rest Services 
 *  
 * Resources are served relative to the servlet path specified in the {@link ApplicationPath}
 * annotation.
 * 
 */
@Path("/v1")
@RequestScoped
public class CounterManagementRestResource {

    @Inject
    private Logger logger;

    @Inject
    private ServiceStatisticsBean stats;

    @Inject
    private CounterManagementService counterManagementService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("flex-counters")
    public Response getAllFlexCounters() {
        this.logger.debug("Get Flex Counters...");
        List<FlexCounterDTO> flexCounterList= this.counterManagementService.getFlexCounters();
        return Response.status(Response.Status.OK).entity(flexCounterList).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("flex-counters/{flexcountername}")
    public Response getFlexCounterByName(@PathParam("flexcountername") final String counterName) {
        this.logger.debug("Get Flex Counter...");
        FlexCounterDTO flexCounter = this.counterManagementService.getFlexCounterByName(counterName);
        if(flexCounter == null){
            Response.status(Response.Status.NOT_FOUND);
        }
        return Response.status(Response.Status.OK).entity(flexCounter).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("flex-counters")
    public Response createFlexCounters( final List<FlexCounterDTO> flexCounters) {
        this.logger.debug("Create Flex Counters...");
        List<FlexCounterDTO> flexCounterList= this.counterManagementService.createFlexCounters(flexCounters);
        return Response.status(Response.Status.OK).entity(flexCounterList).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("flex-counters")
    public Response updateFlexCounter( final FlexCounterDTO flexCounter) {
        this.logger.debug("Update Flex Counter...");
        this.counterManagementService.updateFlexCounter(flexCounter);
        return Response.status(Response.Status.OK).entity(flexCounter).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("flex-counters")
    public Response deleteFlexCounters( final List<FlexCounterDTO> flexCounters) {
        //TODO: Delete counters should be done based on list of ids or names instead of Objects list
        this.logger.debug("Delete Flex Counters...");
        Map<String, String> deletedMap = this.counterManagementService.deleteFlexCounters(flexCounters);
        return Response.status(Response.Status.OK).entity(deletedMap).build();
    }

}