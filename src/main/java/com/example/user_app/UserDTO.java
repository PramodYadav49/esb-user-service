package com.example.user_app;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {

    @NotBlank(message = "name is required")
    @Size(min = 2, max = 50, message = "name must be between 2 and 50 characters")
    @JsonProperty("name")
    private String name;

    @NotBlank(message = "city is required")
    @JsonProperty("city")
    private String city;

    public UserDTO() {}
    public UserDTO(String name, String city) { this.name = name; this.city = city; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
}
