package tech.pdai.springboot.shardingjdbc.jpa.masterslave.entity.query;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleQueryBean {

    /**
     * contains name pattern.
     */
    private String name;

    /**
     * contains desc pattern.
     */
    private String description;

}
