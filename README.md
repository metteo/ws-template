# WebService Template

Shows how manually written endpoint interface and DTOs can be reused on both client and server side. wsdl is generated into client jar to allow instantation of Service object without refering to network hosted wsdl.

Pros:
 - save up on build time because there is no need to parse wsdl, generate client classes and compile them. In this case they are just compiled and could be versioned the same way as webservice interface.
 - sharing the same classes in server implementation and on clients allows finding usages of the interface in IDE (it's also possible with generated one but it's separate). It's also possible to do refactoring of the service interface and clients using it at the same time (during development time before given version of interface/wsdl is final).
 - interface related classes are nicely separated into own module/artifact. That should give a clear signal to developer that he should make the modifications carefully to not break backward compatibility.
 - hand written classes are nicer to use, they may include javadoc. The client jar might contain small utilities (but in general should not contain any bussiness logic - only WS entities and interfaces)
 - it's easier to make proxy apps that do some enriching on the request before passing it to actual webservice. The interface is shared so a proxy can just work on the entities and then call actual webservice without any converters between generated classes and the handwritten ones
 - DRY - even though classes from wsdl are generated they are equivalent so why not reuse what is already there when it's possible.
 - when used, SOAP protocol becomes totally transparent to Java clients. They make calls on the interface as if it was web service implementation class. Usage of soap instead of Corba / RMI still allows non-Java clients to use the webservice so there is no lock down to a specific technology.
 - WS entities can can contain JSR-303 Bean Validation annotations which can be used in both service implementation as well as clients before sending request.

Cons:
 - Requires to manually write some (not that much) code that would be otherwise generated: [UserService.java](https://github.com/metteo/ws-template/blob/master/client/src/main/java/io/github/metteo/ws/UserService.java) and optionally [UserEndpointAsync.java](https://github.com/metteo/ws-template/blob/master/client/src/main/java/io/github/metteo/ws/UserEndpointAsync.java). Some of it could also be generated by some annotation processor as mentioned in the comments.
 - Additional project to maintain. In case of fully generated approach we just get a jar which can be used as a dependency. In case of reuse, there has to be client project and service project with the implementation. This con could also be minimized by generating client jar from service jar by whitelisting java packages, same way ejb-client jar can be generated by [maven-ejb-plugin](http://maven.apache.org/plugins/maven-ejb-plugin/examples/generating-ejb-client.html).
 - If template is used without making releases of shared 'client' artifact, updating the client forces all app to use modified version of it (for example when using maven snapshots or if building from source)
