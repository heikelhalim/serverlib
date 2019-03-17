package com.insider.travel.japan.wabisabi.serverlib.domain.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * 
 */
@Entity
@Table(name = "admin_account_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminAccountMaster.findAll", query = "SELECT w FROM AdminAccountMaster w"),
    @NamedQuery(name = "AdminAccountMaster.findById", query = "SELECT w FROM AdminAccountMaster w WHERE w.id = :id"),
    @NamedQuery(name = "AdminAccountMaster.findByEmail", query = "SELECT w FROM AdminAccountMaster w WHERE LOWER(w.email) = LOWER(:email)"),
})

public class AdminAccountMaster extends CommonModel {
    
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "id")
    private String id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "full_name")
    private String fullName;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "email", unique = true)
    private String email;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "password_hash")
    private String passwordHash;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "admin_password")
    private String password;
    
    public AdminAccountMaster() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminAccountMaster)) {
            return false;
        }
        AdminAccountMaster other = (AdminAccountMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.insider.travel.japan.wabisabi.serverlib.common.domain.model.AdminAccountMaster[ id=" + id + " ]";
    }
    
}
