package com.lesfurets.model;

import java.time.LocalDate;
import java.util.Objects;

public class FicheAuto {

    private final int id;
    private final String offreUid;
    private final LocalDate creationDate;
    private final String codePostal;
    private final String email;
    private final String codeSra;
    private final int statut;

    public FicheAuto(int id, String offreUid, LocalDate creationDate, String codePostal, String email, String codeSra, int statut) {
        this.id = id;
        this.offreUid = offreUid;
        this.creationDate = creationDate;
        this.codePostal = codePostal;
        this.email = email;
        this.codeSra = codeSra;
        this.statut = statut;
    }

    @Override public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        FicheAuto ficheAuto = (FicheAuto) object;
        return Objects.equals(id, ficheAuto.id) &&
                Objects.equals(offreUid, ficheAuto.offreUid) &&
                Objects.equals(creationDate, ficheAuto.creationDate) &&
                Objects.equals(codePostal, ficheAuto.codePostal) &&
                Objects.equals(email, ficheAuto.email) &&
                Objects.equals(codeSra, ficheAuto.codeSra) &&
                Objects.equals(statut, ficheAuto.statut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, offreUid, creationDate, codePostal, email, codeSra, statut);
    }

    @Override
    public String toString() {
        return "FicheAuto{" +
                "id=" + id +
                ", offreUid='" + offreUid + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", email='" + email + '\'' +
                ", codeSra='" + codeSra + '\'' +
                ", statut=" + statut +
                '}';
    }

}
