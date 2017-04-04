package cs143;

import java.util.Objects;

/**
 * This domain class represents one player in an online game and their
 * personal high score.
 * 
 * @author Linda Zuvich
 */
public class Player implements Comparable<Player> {
    
    //fields
    private String name;
    private int score;

    /**
     * Full constructor.
     *
     * @param name the player's name
     * @param score the player's highest score
     */
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * Provides access to the player's name.
     * 
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Allows the player's name to be set.
     *
     * @param name the player's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Provides access to the player's highest score.
     * 
     * @return the player's highest score
     */
    public int getScore() {
        return score;
    }

    /**
     * Allows the player's highest score to be set.
     * 
     * @param score the player's highest score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Provides a default string representation of an object of this class.
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Player: " + name + ", Score: " + score;
    }

    /**
     * Provides a unique hash code for this object, 
     * based on the case-insensitive player name.
     * 
     * @return the hash code
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.name.toLowerCase());
        return hash;
    }

    /**
     * Reports if the given object is equal to this object, 
     * based on the case-insensitive player name.
     * 
     * @param obj the object to compare to this one
     * @return true if the names are the same, false if not.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        return this.name.equalsIgnoreCase(other.name);
    }

    /**
     * Compares the given object with this one to determine sort order.
     * 
     * @param other the other object to compare to this one
     * @return a negative value if this object should come before the other one,
     * a positive value if it should come after, or zero if they are the same
     */
    @Override
    public int compareTo(Player other) {
        return other.score - this.score;
    }
    
}
