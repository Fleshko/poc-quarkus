package domain;
import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.Objects;

@MongoEntity(collection="defenses")
public class Defense extends PanacheMongoEntityBase {
    @BsonProperty("id")
    private String id;
    private String defenseId;
    private String firstStudent;
    private String specialty;
    private String company;
    private String companyPromotor;
    private String pxlPromotor;
    private String researchPaperTitle;

    public Defense() {

    }

    public Defense(String name, String specialty, String company, String companyPromotor, String pxlPromotor, String researchPaperTitle) {
        this.firstStudent = name;
        this.specialty = specialty;
        this.company = company;
        this.companyPromotor = companyPromotor;
        this.pxlPromotor = pxlPromotor;
        this.researchPaperTitle = researchPaperTitle;
        this.defenseId = "ABCDEF";
    }

    public String getId() {
        return id;
    }

    public String getDefenseId() {
        return defenseId;
    }

    public String getFirstStudent() {
        return firstStudent;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getCompany() {
        return company;
    }

    public String getCompanyPromotor() {
        return companyPromotor;
    }

    public String getPxlPromotor() {
        return pxlPromotor;
    }

    public String getResearchPaperTitle() {
        return researchPaperTitle;
    }

    public void setFirstStudent(String firstStudent) {
        this.firstStudent = firstStudent;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setCompanyPromotor(String companyPromotor) {
        this.companyPromotor = companyPromotor;
    }

    public void setPxlPromotor(String pxlPromotor) {
        this.pxlPromotor = pxlPromotor;
    }

    public void setResearchPaperTitle(String researchPaperTitle) {
        this.researchPaperTitle = researchPaperTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Defense defense = (Defense) o;

        return Objects.equals(defenseId, defense.defenseId);
    }

    @Override
    public int hashCode() {
        return defenseId != null ? defenseId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return defenseId + ";" + firstStudent + ';' + specialty + ';' +
                company + ';' + companyPromotor + ';' + pxlPromotor + ';' + researchPaperTitle;
    }
}
