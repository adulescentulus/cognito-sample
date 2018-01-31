package de.networkchallenge.example.cognitosample.lambda.backend;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.internal.testutils.AwsProxyRequestBuilder;
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import de.networkchallenge.example.cognitosample.lambda.backend.model.ResponseObject;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import javax.ws.rs.HttpMethod;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple MainHandler.
 */
public class MainHandlerTest {

	@Test
	public void testHandle() throws ContainerInitializationException {

		final MainHandler mainHandler = new MainHandler();
		Context contextMock = Mockito.mock(Context.class);
		Mockito.when(contextMock.getLogger()).thenReturn(Mockito.mock(LambdaLogger.class));
		final AwsProxyResponse response = mainHandler.handleRequest(new AwsProxyRequestBuilder().path("/hello/world").method(HttpMethod.GET).build(), new MockLambdaContext());
		assertNotNull("Response must not be null", response);
		assertTrue(response.getBody().contains(ResponseObject.Status.OK.toString()));
		assertTrue(response.getBody().contains("world"));
	}

}
