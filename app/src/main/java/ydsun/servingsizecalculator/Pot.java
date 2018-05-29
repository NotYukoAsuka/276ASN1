package ydsun.servingsizecalculator;

/**
 * Store information about a single pot
 */

import java.io.Serializable;
import java.util.ArrayList;
import android.os.Parcelable;

public class Pot extends ArrayList<Parcelable> implements Serializable{
    private String name;
    private int weightInG;

    // Set member data based on parameters.
    public Pot(String name, int weightInG) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("name cannot be empty!");
        }
        else if(weightInG < 0){
            throw new IllegalArgumentException("weight must be positive!");
        }
        else {
            this.name = name;
            this.weightInG = weightInG;
        }
    }

    // Return the weight
    public int getWeightInG() {
        return weightInG;
    }

    // Set the weight. Throws IllegalArgumentException if weight is less than 0.
    public void setWeightInG(int weightInG) {
        if(weightInG < 0){
            throw new IllegalArgumentException("weight must be positive!");
        }
        else{
            this.weightInG = weightInG;
        }
    }

    // Return the name.
    public String getName() {
        return name;
    }

    // Set the name. Throws IllegalArgumentException if name is an empty string (length 0),
    // or if name is a null-reference.
    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("name cannot be empty!");
        }
        else{
            this.name = name;
        }
    }

    // Serialize Pots Into Strings
    public String serialize(){

        String change = this.getName().replace("¿", "？¿¿?");
        return change.replace(",", "¿") + ", " + this.getWeightInG();
    }

    // Bring Serialized String Back To Pot
    public void parse(String serialized){
        int pos = serialized.indexOf(",");
        String name = serialized.substring(0,pos);
        int weight = Integer.parseInt(serialized.substring(pos+2));
        name = name.replace("¿", ",");
        name = name.replace("？¿¿?", "¿");
        this.setName(name);
        this.setWeightInG(weight);
    }

}
