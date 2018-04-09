package co.edu.upb.appmed.feature.Entities;

public class Tour {

    private Site[] sites;

    public Tour() {
    }

    public Tour(Site[] sites) {
        this.sites = sites;
    }

    public Site[] getSites() {
        return sites;
    }

    public void setSites(Site[] sites) {
        this.sites = sites;
    }
}
