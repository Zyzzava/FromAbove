public class Cell {
    private Organism organism;

    public Cell() {
        this.organism = null;
    }

    public void setOrganism(Organism organism) {
        this.organism = organism;
    }

    public Organism getOrganism() {
        return organism;
    }
}
