package com.hackathon.demo.models;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;


@JsonRootName("RegisterUserProfileRequest")
public class RegisterUserProfileRequest implements Serializable {

  private String firstName;
  private String lastName;

  private MultipartFile audioFile;
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }
  @JsonProperty("audioFile")
  public MultipartFile getAudioFile() {
    return audioFile;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setAudioFile(MultipartFile audioFile) {
    this.audioFile = audioFile;
  }

  public RegisterUserProfileRequest(String firstName, String lastName, MultipartFile audioFile) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.audioFile = audioFile;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof RegisterUserProfileRequest that)) return false;
      return Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getAudioFile(), that.getAudioFile());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getLastName(), getAudioFile());
  }

  @Override
  public String toString() {
    return "RegisterUserProfileRequest{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", audioFile=" + audioFile +
            '}';
  }
}
