package org.openapitools.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.annotations.ApiModelProperty;

@JsonTypeName("_tasks_put_request")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-09-11T19:32:20.886982500+02:00[Europe/Rome]")
public class TasksPutRequest   {
  private @Valid Long todoId;
  private @Valid String description;

  /**
   **/
  public TasksPutRequest todoId(Long todoId) {
    this.todoId = todoId;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("todoId")
  @NotNull
  public Long getTodoId() {
    return todoId;
  }

  @JsonProperty("todoId")
  public void setTodoId(Long todoId) {
    this.todoId = todoId;
  }

  /**
   **/
  public TasksPutRequest description(String description) {
    this.description = description;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("description")
  @NotNull
  public String getDescription() {
    return description;
  }

  @JsonProperty("description")
  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TasksPutRequest tasksPutRequest = (TasksPutRequest) o;
    return Objects.equals(this.todoId, tasksPutRequest.todoId) &&
        Objects.equals(this.description, tasksPutRequest.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(todoId, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TasksPutRequest {\n");
    
    sb.append("    todoId: ").append(toIndentedString(todoId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}

