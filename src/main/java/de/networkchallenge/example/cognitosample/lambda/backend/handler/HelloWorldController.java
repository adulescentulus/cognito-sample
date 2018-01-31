package de.networkchallenge.example.cognitosample.lambda.backend.handler;

import com.google.gson.Gson;
import de.networkchallenge.example.cognitosample.lambda.backend.model.ResponseObject;
import spark.Request;
import spark.Response;

import static spark.Spark.get;

public class HelloWorldController {


	public HelloWorldController() {
		Gson gson = new Gson();
		get("/hello/:name", HelloWorldController::parse, gson::toJson);
	}

	public static ResponseObject parse(Request request, Response response)
	{
		ResponseObject responseObject = new ResponseObject();
		String name = request.params(":name");
		responseObject.setStatus(ResponseObject.Status.OK).setName(name);
		return responseObject;
	}

}
