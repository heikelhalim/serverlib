package com.insider.travel.japan.wabisabi.serverlib.domain.model;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * 
 */
@Entity
@Table(name = "admin_locked_out")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminLockedOut.findById", query = "SELECT w FROM AdminLockedOut w WHERE w.adminAccountMaster.id = :accountId")
})
public class AdminLockedOut extends CommonModel {
    
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "id")
    private String id;

    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private AdminAccountMaster adminAccountMaster;

    @Column(name = "attempts")
    private Integer attempts;

    @Column(name = "locked_out_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lockedOutAt;

    @Size(max = 39)
    @Column(name = "ip_address")
    private String ipAddress;
    
    public AdminLockedOut() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AdminAccountMaster getAdminAccountMaster() {
        return adminAccountMaster;
    }

    public void setAdminAccountMaster(AdminAccountMaster adminAccountMaster) {
        this.adminAccountMaster = adminAccountMaster;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    public Date getLockedOutAt() {
        return lockedOutAt;
    }

    public void setLockedOutAt(Date lockedOutAt) {
        this.lockedOutAt = lockedOutAt;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
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
        if (!(object instanceof AdminLockedOut)) {
            return false;
        }
        AdminLockedOut other = (AdminLockedOut) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "com.insider.travel.japan.wabisabi.serverlib.domain.model.AdminLockedOut[ id=" + id + " ]";
    }
    
}
