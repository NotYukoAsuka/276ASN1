package ydsun.servingsizecalculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * Class to manage a collection of pots.
 */
public class PotCollection extends ArrayList<Parcelable> implements Serializable{
    private List<Pot> pots = new ArrayList<>();
    private Context mCtx;

    public void addPot(Pot pot) {
        pots.add(pot);
    }

    public void changePot(Pot pot, int indexOfPotEditing) {
        validateIndexWithException(indexOfPotEditing);
        pots.remove(indexOfPotEditing);
        pots.add(indexOfPotEditing, pot);
    }

    public void removePot(int indexOfPotEditing){
        validateIndexWithException(indexOfPotEditing);
        pots.remove(indexOfPotEditing);
    }

    public int countPots() {
        return pots.size();
    }
    public Pot getPot(int index) {
        validateIndexWithException(index);
        return pots.get(index);
    }

    // Useful for integrating with an ArrayAdapter
    public String[] getPotDescriptions() {
        String[] descriptions = new String[countPots()];
        for (int i = 0; i < countPots(); i++) {
            Pot pot = getPot(i);
            descriptions[i] = pot.getName() + " - " + pot.getWeightInG() + "g";
        }
        return descriptions;
    }

    private void validateIndexWithException(int index) {
        if (index < 0 || index >= countPots()) {
            throw new IllegalArgumentException();
        }
    }

    public PotCollection(Context ctx) {
        mCtx = ctx;
    }

    public void save(){
        SharedPreferences sp = mCtx.getSharedPreferences(BuildConfig.APPLICATION_ID + ".PREFERENCE_FILE_KEY", Context.MODE_PRIVATE);
        for(int i = 0; i < this.countPots(); i++){
            Pot pot = this.pots.get(i);
            sp.edit().putString("pot" + i, pot.serialize()).apply();
        }
    }

    public void load(){
        SharedPreferences sp = mCtx.getSharedPreferences(BuildConfig.APPLICATION_ID + ".PREFERENCE_FILE_KEY", Context.MODE_PRIVATE);
        int i = 0;
        while(true) {
            String potString = sp.getString("pot" + i, null);
            if (potString == null) break;
            Pot pot = new Pot("defualt",0);
            pot.parse(potString);
            this.addPot(pot);
            sp.edit().putString("Pot" + i, null).apply(); // clear storage
            i++;
        }
    }

    public void clear_data(){
        SharedPreferences sp = mCtx.getSharedPreferences(BuildConfig.APPLICATION_ID + ".PREFERENCE_FILE_KEY", Context.MODE_PRIVATE);
        sp.edit().clear().apply();
    }
}