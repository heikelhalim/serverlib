package com.insider.travel.japan.wabisabi.serverlib.domain.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "admin_account_password_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminAccountPasswordHistory.findById", query = "SELECT w FROM AdminAccountPasswordHistory w WHERE w.adminAccountPasswordHistoryPK.id = :id ORDER BY w.adminAccountPasswordHistoryPK.accountUpdateVersion DESC")
})
public class AdminAccountPasswordHistory extends CommonModel {
    
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected AdminAccountPasswordHistoryPK adminAccountPasswordHistoryPK;

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

    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "email")
    private String email;

    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AdminAccountMaster adminAccountMaster;
    
    public AdminAccountPasswordHistory() {
    }
    
    public AdminAccountPasswordHistory(AdminAccountPasswordHistoryPK adminAccountPasswordHistoryPK) {
        this.adminAccountPasswordHistoryPK = adminAccountPasswordHistoryPK;
    }
    
    public AdminAccountPasswordHistory(AdminAccountPasswordHistoryPK adminAccountPasswordHistoryPK, String passwordHash) {
        this.adminAccountPasswordHistoryPK = adminAccountPasswordHistoryPK;
        this.passwordHash = passwordHash;
    }

    public AdminAccountPasswordHistoryPK getAdminAccountPasswordHistoryPK() {
        return adminAccountPasswordHistoryPK;
    }

    public void setAdminAccountPasswordHistoryPK(AdminAccountPasswordHistoryPK adminAccountPasswordHistoryPK) {
        this.adminAccountPasswordHistoryPK = adminAccountPasswordHistoryPK;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AdminAccountMaster getAdminAccountMaster() {
        return adminAccountMaster;
    }

    public void setAdminAccountMaster(AdminAccountMaster adminAccountMaster) {
        this.adminAccountMaster = adminAccountMaster;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminAccountPasswordHistoryPK != null ? adminAccountPasswordHistoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminAccountPasswordHistory)) {
            return false;
        }
        AdminAccountPasswordHistory other = (AdminAccountPasswordHistory) object;
        if ((this.adminAccountPasswordHistoryPK == null && other.adminAccountPasswordHistoryPK != null) || (this.adminAccountPasswordHistoryPK != null && !this.adminAccountPasswordHistoryPK.equals(other.adminAccountPasswordHistoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.insider.travel.japan.wabisabi.serverlib.domain.model.AdminAccountPasswordHistory[ adminAccountPasswordHistoryPK=" + adminAccountPasswordHistoryPK + " ]";
    }
    
}
