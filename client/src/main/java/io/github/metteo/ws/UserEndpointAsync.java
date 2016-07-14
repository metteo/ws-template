package io.github.metteo.ws;

import io.github.metteo.ws.jaxws.FindAllUsersResponse;

import java.util.concurrent.Future;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;

//Could be generated with annotation processor if main User endpoint is annotated with @GenerateAsync
@WebService(targetNamespace=UserService.SCHEMA_NAMESPACE, portName=UserService.PORT_NAME)
public interface UserEndpointAsync extends UserEndpoint {
	
	//specified explicitly because defaults are derived from namespace and method name which are
	//different than in main SEI due to conflicting signatures.
    @WebMethod(operationName = "findAllUsers")
    @RequestWrapper(localName = "findAllUsers", className = "io.github.metteo.ws.jaxws.FindAllUsers")
    @ResponseWrapper(localName = "findAllUsersResponse", className = "io.github.metteo.ws.jaxws.FindAllUsersResponse")
    public Response<FindAllUsersResponse> findAllUsersAsync();

    //recommended approach for async handling - method name is the same plus NIO is used
    @WebMethod
    public Future<?> findAllUsers(@WebParam(name = "asyncHandler") AsyncHandler<FindAllUsersResponse> asyncHandler);
}
