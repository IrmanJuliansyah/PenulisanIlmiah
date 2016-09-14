package com.penulisan.ilmiah.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Irman Juliansyah
 */
@Entity
@Table(name = "tb_user_role")
public class UserRole implements Serializable {

    @Id
    @Column(name = "id_user_role", length = 150)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String idUserRole;

    @Column(name = "role", length = 20)
    private String role = "ROLE_USER";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email", nullable = false, foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private User user = new User();

    public String getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(String idUserRole) {
        this.idUserRole = idUserRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
