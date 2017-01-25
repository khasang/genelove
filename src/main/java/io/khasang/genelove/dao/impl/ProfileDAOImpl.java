package io.khasang.genelove.dao.impl;

import io.khasang.genelove.dao.ProfileDAO;
import io.khasang.genelove.entity.Profile;
import io.khasang.genelove.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class ProfileDAOImpl implements ProfileDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public ProfileDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addProfile(Profile profile, User user) {
        profile.setUser(user);
        sessionFactory.getCurrentSession().save(profile);
    }

    public List<Profile> getUserProfiles (User user) {
        TypedQuery<Profile> query = sessionFactory.getCurrentSession().
                createNativeQuery("SELECT * FROM profiles WHERE user_id = ?", Profile.class);
        query.setParameter(1, user.getId());
        return query.getResultList();
    }

    @Override
    public Profile getProfileById (long id) {
        TypedQuery<Profile> query = sessionFactory.getCurrentSession().createNativeQuery("" +
                "SELECT * FROM profiles WHERE id = ?", Profile.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public void updateProfile(Profile profile, User user) {
        profile.setUser(user);
        this.sessionFactory.getCurrentSession().update(profile);
    }

    @Override
    public void hideProfile(Profile profile){

    }

    @Override
    public void shareProfile(Profile profile){

    }

    @Override
    public List<Profile> getProfiles(int ageFrom, int ageTo, String gender, String marital, User user){
        TypedQuery<Profile> query = sessionFactory.getCurrentSession().
                createNativeQuery("SELECT * FROM profiles WHERE age BETWEEN ? AND ? AND gender = ? " +
                        "AND marital_status = ? AND user_id != ?", Profile.class);
        query.setParameter(1, ageFrom);
        query.setParameter(2, ageTo);
        query.setParameter(3, gender);
        query.setParameter(4, marital);
        query.setParameter(5, user.getId());
        return query.getResultList();
    }
}
