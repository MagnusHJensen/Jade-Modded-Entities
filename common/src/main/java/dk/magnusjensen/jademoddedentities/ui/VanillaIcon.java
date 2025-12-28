package dk.magnusjensen.jademoddedentities.ui;

public enum VanillaIcon {
    WHITE_HEART(25, 0, 9, 9);


    // Horizontal and vertical coordinates of the icon in the texture
    public final int u;
    public final int v;
    // Texture width and height of the icon
    public final int tw;
    public final int th;

    VanillaIcon(int u, int v, int tw, int th) {
        this.u = u;
        this.v = v;
        this.tw = tw;
        this.th = th;
    }
}
