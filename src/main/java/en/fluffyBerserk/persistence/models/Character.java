package en.fluffyBerserk.persistence.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Character {
    private long id;
    private String name;
    private int level;
    private int stamina;
    private int strength;
    private int intellect;
    private int armor;
    private String saveFilePath;
    private Timestamp savedAt;
    private Timestamp createdAt;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "level")
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Basic
    @Column(name = "stamina")
    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    @Basic
    @Column(name = "strength")
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Basic
    @Column(name = "intellect")
    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    @Basic
    @Column(name = "armor")
    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Basic
    @Column(name = "save_file_path")
    public String getSaveFilePath() {
        return saveFilePath;
    }

    public void setSaveFilePath(String saveFilePath) {
        this.saveFilePath = saveFilePath;
    }

    @Basic
    @Column(name = "saved_at")
    public Timestamp getSavedAt() {
        return savedAt;
    }

    public void setSavedAt(Timestamp savedAt) {
        this.savedAt = savedAt;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return id == character.id && level == character.level && stamina == character.stamina && strength == character.strength && intellect == character.intellect && armor == character.armor && Objects.equals(name, character.name) && Objects.equals(saveFilePath, character.saveFilePath) && Objects.equals(savedAt, character.savedAt) && Objects.equals(createdAt, character.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, level, stamina, strength, intellect, armor, saveFilePath, savedAt, createdAt);
    }
}
