package asessment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersPageResponse {
    private List<UserDTO> data;

    public UsersPageResponse() {}

    public List<UserDTO> getData() { return data; }
    public void setData(List<UserDTO> data) { this.data = data; }
}
