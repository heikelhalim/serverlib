package com.insider.travel.japan.wabisabi.serverlib.domain.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * 
 */
@Embeddable
public class AdminAccountPasswordHistoryPK implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "id")
    private String id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "account_update_version")
    private int accountUpdateVersion;
    
    public AdminAccountPasswordHistoryPK() {
    }
    
    public AdminAccountPasswordHistoryPK(String id, int accountUpdateVersion) {
        this.id = id;
        this.accountUpdateVersion = accountUpdateVersion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAccountUpdateVersion() {
        return accountUpdateVersion;
    }

    public void setAccountUpdateVersion(int accountUpdateVersion) {
        this.accountUpdateVersion = accountUpdateVersion;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        hash += (int) accountUpdateVersion;

        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminAccountPasswordHistoryPK)) {
            return false;
        }
        AdminAccountPasswordHistoryPK other = (AdminAccountPasswordHistoryPK) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        if (this.accountUpdateVersion != other.accountUpdateVersion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.insider.travel.japan.wabisabi.serverlib.domain.model.AdminAccountPasswordHistoryPK[ id=" + id + ", accountUpdateVersion=" + accountUpdateVersion + " ]";
    }
    
}
