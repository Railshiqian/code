package com.shiqian.youknowme.Bean;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;

/**
 * Created by chenzd on 18-2-23.
 */
@Entity(
        // If you have more than one schema, you can tell greenDAO
        // to which schema an entity belongs (pick any string as a name).

        // Flag to make an entity "active": Active entities have update,
        // delete, and refresh methods.
        active = true,

        // Specifies the name of the table in the database.
        // By default, the name is based on the entities class name.
        nameInDb = "AWESOME_USERS",

        // Define indexes spanning multiple columns here.

        // Flag if the DAO should create the database table (default is true).
        // Set this to false, if you have multiple entities mapping to one table,
        // or the table creation is done outside of greenDAO.
        createInDb = true,

        // Whether an all properties constructor should be generated.
        // A no-args constructor is always required.
        generateConstructors = true,

        // Whether getters and setters for properties should be generated if missing.
        generateGettersSetters = true
)
public class User {

    @Id(autoincrement = false)
    @Index(unique = true)
    private Long userId;

    @Index(unique = true)
    private String realId;

    @Index
    private String userName;

    @Index
    private String userGender;

    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1507654846)
    private transient UserDao myDao;


    @Generated(hash = 586692638)
    public User() {
    }


    @Generated(hash = 1785523406)
    public User(Long userId, String realId, String userName, String userGender) {
        this.userId = userId;
        this.realId = realId;
        this.userName = userName;
        this.userGender = userGender;
    }


    public String getUserGender() {
        return userGender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    public String getRealId() {
        return this.realId;
    }

    public void setRealId(String realId) {
        this.realId = realId;
    }


    public Long getUserId() {
        return this.userId;
    }


    public void setUserId(Long userId) {
        this.userId = userId;
    }


    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2059241980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }
}
