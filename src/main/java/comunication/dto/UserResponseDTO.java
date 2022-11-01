package comunication.dto;

import java.util.List;

import lombok.Data;
import comunication.model.AppUserRole;

@Data
public class UserResponseDTO {
  private Integer id;
  private String username;
  private String email;
  List<AppUserRole> appUserRoles;

}
