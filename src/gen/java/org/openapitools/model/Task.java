package org.openapitools.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.annotations.ApiModelProperty;

@JsonTypeName("Task")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-09-11T19:32:20.886982500+02:00[Europe/Rome]")
public class Task   {
  private @Valid Long taskId;
  private @Valid Long todoId;
  private @Valid String description;
  private @Valid String creation;
  private @Valid Boolean isDone;

  /**
   **/
  public Task taskId(Long taskId) {
    this.taskId = taskId;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("taskId")
  public Long getTaskId() {
    return taskId;
  }

  @JsonProperty("taskId")
  public void setTaskId(Long taskId) {
    this.taskId = taskId;
  }

  /**
   **/
  public Task todoId(Long todoId) {
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
  public Task description(String description) {
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

  /**
   **/
  public Task creation(String creation) {
    this.creation = creation;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("creation")
  public String getCreation() {
    return creation;
  }

  @JsonProperty("creation")
  public void setCreation(String creation) {
    this.creation = creation;
  }

  /**
   **/
  public Task isDone(Boolean isDone) {
    this.isDone = isDone;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("isDone")
  public Boolean getIsDone() {
    return isDone;
  }

  @JsonProperty("isDone")
  public void setIsDone(Boolean isDone) {
    this.isDone = isDone;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Task task = (Task) o;
    return Objects.equals(this.taskId, task.taskId) &&
        Objects.equals(this.todoId, task.todoId) &&
        Objects.equals(this.description, task.description) &&
        Objects.equals(this.creation, task.creation) &&
        Objects.equals(this.isDone, task.isDone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskId, todoId, description, creation, isDone);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Task {\n");
    
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
    sb.append("    todoId: ").append(toIndentedString(todoId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    creation: ").append(toIndentedString(creation)).append("\n");
    sb.append("    isDone: ").append(toIndentedString(isDone)).append("\n");
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

