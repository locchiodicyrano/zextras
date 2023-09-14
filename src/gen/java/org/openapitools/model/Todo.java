package org.openapitools.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.annotations.ApiModelProperty;

@JsonTypeName("Todo")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-09-11T19:32:20.886982500+02:00[Europe/Rome]")
public class Todo   {
  private @Valid Long id;
  private @Valid String name;
  private @Valid String creation;
  private @Valid Long numberOfTasks;

  /**
   **/
  public Todo id(Long id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("id")
  @NotNull
  public Long getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Long id) {
    this.id = id;
  }

  /**
   **/
  public Todo name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("name")
  @NotNull
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  public Todo creation(String creation) {
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
  public Todo numberOfTasks(Long numberOfTasks) {
    this.numberOfTasks = numberOfTasks;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("numberOfTasks")
  public Long getNumberOfTasks() {
    return numberOfTasks;
  }

  @JsonProperty("numberOfTasks")
  public void setNumberOfTasks(Long numberOfTasks) {
    this.numberOfTasks = numberOfTasks;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Todo todo = (Todo) o;
    return Objects.equals(this.id, todo.id) &&
        Objects.equals(this.name, todo.name) &&
        Objects.equals(this.creation, todo.creation) &&
        Objects.equals(this.numberOfTasks, todo.numberOfTasks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, creation, numberOfTasks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Todo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    creation: ").append(toIndentedString(creation)).append("\n");
    sb.append("    numberOfTasks: ").append(toIndentedString(numberOfTasks)).append("\n");
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

