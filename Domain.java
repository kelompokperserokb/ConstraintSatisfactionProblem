import java.util.ArrayList;
import java.util.List;

public class Domain {
    public List<String> tryColor;
    public List<String> baseColors;
    public List<String> constraintColor;

    public Domain(String[] colors) {
        this.baseColors = new ArrayList<>();
        this.tryColor = new ArrayList<>();
        constraintColor = new ArrayList<>();
        for (int i = 0 ; i < colors.length ; i++){
            this.baseColors.add(colors[i]);
        }
    }
}