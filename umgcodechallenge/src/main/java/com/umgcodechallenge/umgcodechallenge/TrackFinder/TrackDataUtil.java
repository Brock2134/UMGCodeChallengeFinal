package com.umgcodechallenge.umgcodechallenge.TrackFinder;

public class TrackDataUtil {

    private long id;
    private String ISRC;
    private String name;
    private int duration_ms;
    private boolean explicit;

    public TrackDataUtil(long id, String ISRC, String name, int duration_ms, boolean explicit) {
        this.id = id;
        this.ISRC = ISRC;
        this.name = name;
        this.duration_ms = duration_ms;
        this.explicit = explicit;
    }

    public TrackDataUtil(String ISRC, String name, int duration_ms, boolean explicit) {
        this.ISRC = ISRC;
        this.name = name;
        this.duration_ms = duration_ms;
        this.explicit = explicit;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return int return the duration_ms
     */
    public int getDuration_ms() {
        return duration_ms;
    }

    /**
     * @param duration_ms the duration_ms to set
     */
    public void setDuration_ms(int duration_ms) {
        this.duration_ms = duration_ms;
    }

    /**
     * @return boolean return the explicit
     */
    public boolean isExplicit() {
        return explicit;
    }

    /**
     * @param explicit the explicit to set
     */
    public void setExplicit(boolean explicit) {
        this.explicit = explicit;
    }

    /**
     * @return long return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return String return the ISRC
     */
    public String getISRC() {
        return ISRC;
    }

    /**
     * @param ISRC the ISRC to set
     */
    public void setISRC(String ISRC) {
        this.ISRC = ISRC;
    }

}
