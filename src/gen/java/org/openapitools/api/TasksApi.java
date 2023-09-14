package org.openapitools.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
import org.openapitools.model.Task;
import org.openapitools.model.TasksPutRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/tasks")
@Api(description = "the tasks API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-09-11T19:32:20.886982500+02:00[Europe/Rome]")
public class TasksApi {
	
	@GET
	@Path("/{todoId}")
	@Produces({ "application/json" })
	@ApiOperation(value = "Get a list of tasks", notes = "", response = Task.class, responseContainer = "List", tags={  })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "get tasks response", response = Task.class, responseContainer = "List")
	})
	public Response tasksTodoIdGet(@PathParam("todoId") String todoId) {
		
		try {
			if (!Helper.isNumeric(todoId))
				return Response.serverError().entity("todoId must be numeric!").build();
			
			DBConnection DbConnection = new DBConnection();
			Connection connection = DbConnection.connect();
	
//			SELECT id, todo_id, description, creation_timestamp, is_done
//			  FROM public.task
//			 WHERE todo_id = 1
			
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append(" SELECT id, todo_id, description, creation_timestamp, is_done ");
			sqlQuery.append(" FROM public.task ");
			sqlQuery.append(" WHERE todo_id = ? ");
			
			PreparedStatement statement = connection.prepareStatement(sqlQuery.toString());
			statement.setLong(1, Long.valueOf(todoId));
			
			ResultSet resultSet = statement.executeQuery();
	
			if (resultSet.next() == false) {
				return Response.serverError().entity("No todos for id " + todoId + "!").build();
			} else {
				List<Task> tasks = new ArrayList<>();
				do {
					Task task = new Task();
					task.setTaskId(resultSet.getLong("id"));
					task.setTodoId(resultSet.getLong("todo_id"));
					task.setDescription(resultSet.getString("description"));
					task.setCreation(resultSet.getString("creation_timestamp"));
					task.setIsDone(resultSet.getBoolean("is_done"));
					tasks.add(task);
				} while (resultSet.next());
				
				return Response.ok().entity(tasks).build();
			}
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

    @PUT
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Create a new task for a specific todo", notes = "", response = Boolean.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "creation response", response = Boolean.class)
    })
    public Response tasksPut(@Valid TasksPutRequest tasksPutRequest) {
    	
    	try {
	    	if (!Helper.isNumeric(tasksPutRequest.getTodoId().toString()))
				return Response.serverError().entity("todoId must be numeric!").build();
	    	
	    	if (tasksPutRequest.getTodoId().toString().trim().equals(""))
				return Response.serverError().entity("todoId is mandatory!").build();
	    	
	    	if (tasksPutRequest.getDescription().trim().equals(""))
	    		return Response.serverError().entity("description is mandatory!").build();
    	
			DBConnection DbConnection = new DBConnection();
			Connection connection = DbConnection.connect();
			
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append(" SELECT id ");
			sqlQuery.append(" FROM public.todo ");
			sqlQuery.append(" WHERE todo.id = ? ");
			
			PreparedStatement statement = connection.prepareStatement(sqlQuery.toString());
			statement.setLong(1, Long.valueOf(tasksPutRequest.getTodoId()));
			
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next() == false) {
				return Response.serverError().entity("No todos found for id " + tasksPutRequest.getTodoId() + "!").build();
			}
	
//			INSERT INTO public.todo(todo_id, description, creation_timestamp)
//			VALUES(1, 'push-up' , EXTRACT(EPOCH FROM CURRENT_TIMESTAMP) * 1000)
			
			sqlQuery = new StringBuilder();
			sqlQuery.append(" INSERT INTO public.task(todo_id, description, creation_timestamp) ");
			sqlQuery.append(" VALUES(?, ? , EXTRACT(EPOCH FROM CURRENT_TIMESTAMP) * 1000) ");
			
			statement = connection.prepareStatement(sqlQuery.toString());
			statement.setLong(1, tasksPutRequest.getTodoId());
			statement.setString(2, tasksPutRequest.getDescription());
			statement.executeUpdate();
	
			return Response.ok().entity("Task " + tasksPutRequest.getDescription() + " successfully added!").build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
    }
}
