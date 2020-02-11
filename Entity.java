#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

/*
 * author ${USER}
 * version 1.0
*/

import java.io.Serializable;
import javax.persistence.*;

#set ($lcName = ${NAME.toLowerCase()})

@Entity
@Table(name="$lcName")
@NamedQuery(name = "${NAME}.deleteAllRows", query = "DELETE FROM $lcName")
public class ${NAME} implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public ${NAME}() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
