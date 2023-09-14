package org.openapitools.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.openapitools.connection.DBConnection;
import org.openapitools.helpers.Helper;
import org.openapitools.model.Todo;
import org.openapitools.model.TodosPutRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/todos")
@Api(description = "the todos API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-09-11T19:32:20.886982500+02:00[Europe/Rome]")
public class TodosApi {

	@GET
	@Path("/{id}")
	@Produces({ "application/json" })
	@ApiOperation(value = "Get a todo", notes = "", response = Todo.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "get todos response", response = Todo.class) })
	public Response todosIdGet(@PathParam("id") String id) {
		
		try {
			if (!Helper.isNumeric(id))
				return Response.serverError().entity("id must be numeric!").build();
			
			DBConnection DbConnection = new DBConnection();
			Connection connection = DbConnection.connect();
	
//			SELECT todo.id, todo.name, todo.creation_timestamp, count(task.todo_id) AS cnt
//			  FROM public.todo todo,
//			       public.task task
//			 WHERE todo.id = 1
//			   AND todo.id = task.todo_id
//			 GROUP BY todo.id
			
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append(" SELECT todo.id, todo.name, todo.creation_timestamp, count(task.todo_id) AS cnt ");
			sqlQuery.append(" FROM public.todo todo, public.task task ");
			sqlQuery.append(" WHERE todo.id = ? AND todo.id = task.todo_id ");
			sqlQuery.append(" GROUP BY todo.id ");
			
			PreparedStatement statement = connection.prepareStatement(sqlQuery.toString());
			statement.setLong(1, Long.valueOf(id));
			
			ResultSet resultSet = statement.executeQuery();
	
			if (resultSet.next() == false) {
				return Response.serverError().entity("No data for id " + id + "!").build();
			} else {
				Todo todo = new Todo();
				todo.setId(resultSet.getLong("id"));
				todo.setName(resultSet.getString("name"));
				todo.setCreation(resultSet.getString("creation_timestamp"));
				todo.setNumberOfTasks(resultSet.getLong("cnt"));
				return Response.ok().entity(todo).build();
			}
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@PUT
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	@ApiOperation(value = "Create a todo", notes = "", response = Boolean.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "creation response", response = Boolean.class) })
	public Response todosPut(@Valid TodosPutRequest todosPutRequest) {
		
		try {
			if (todosPutRequest.getName().trim().equals(""))
				return Response.serverError().entity("name is mandatory!").build();
			
			DBConnection DbConnection = new DBConnection();
			Connection connection = DbConnection.connect();
	
//			INSERT INTO public.todo(name, creation_timestamp)
//			VALUES('palestra' , EXTRACT(EPOCH FROM CURRENT_TIMESTAMP) * 1000)
			
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append(" INSERT INTO public.todo(name, creation_timestamp) ");
			sqlQuery.append(" VALUES(? , EXTRACT(EPOCH FROM CURRENT_TIMESTAMP) * 1000) ");
			
			PreparedStatement statement = connection.prepareStatement(sqlQuery.toString());
			statement.setString(1, todosPutRequest.getName());
			statement.executeUpdate();
	
			return Response.ok().entity("Todo " + todosPutRequest.getName() + " successfully added!").build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
}
