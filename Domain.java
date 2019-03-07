import java.util.ArrayList;
import java.util.List;

public class Domain {
    public List<String> colors;

    public Domain(String[] colors) {
        this.colors = new ArrayList<String>();
        for (int i = 0 ; i < colors.length ; i++){
            this.colors.add(colors[i]);
        }
    }
}
