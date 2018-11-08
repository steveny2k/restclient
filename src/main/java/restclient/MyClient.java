package restclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.List;

public class MyClient {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://github.com/");
        Invocation.Builder ib = target.request(MediaType.TEXT_HTML);
        Response resp = ib.get();
        System.out.println("Response status: " + resp.getStatus());
        System.out.println("Response headers: ");
        MultivaluedMap<String, Object> mm = resp.getHeaders();
        for (String key : mm.keySet()) {
            System.out.println(key + " : " + mm.get(key));
        }
        System.out.println("Entity body:\n" + resp.readEntity(String.class));
    }
}
