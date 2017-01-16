package io.khasang.genelove.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "authorisations")
public class Authorisation {

    @EmbeddedId
    private AuthorisationKey authorisationKey;

    public AuthorisationKey getAuthorisationKey() {
        return authorisationKey;
    }

    public void setAuthorisationKey(AuthorisationKey authorisationKey) {
        this.authorisationKey = authorisationKey;
    }
}