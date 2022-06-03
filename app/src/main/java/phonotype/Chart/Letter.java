package phonotype.Chart;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Letter {
    public static final int BILABIAL = 0;
    public static final int LABIODENTAL = 1;
    public static final int DENTAL = 2;
    public static final int ALVEOLAR = 3;
    public static final int POST_ALVEOLAR = 4;
    public static final int RETROFLEX = 5;
    public static final int PALATAL = 6;
    public static final int VELAR = 7;
    public static final int UVULAR = 8;
    public static final int PHARYNGEAL = 9;
    public static final int GLOTTAL = 10;

    public static final int STOP = 0;
    public static final int AFFRICATE = 1;
    public static final int NASAL = 2;
    public static final int TRILL = 3;
    public static final int TAP = 4;
    public static final int FRICAIVE = 5;
    public static final int LATERAL_FRICATIVE = 6;
    public static final int APPROXIMENT = 7;
    public static final int LATERAL_APPROXIMENT = 8;

    public Letter(String value, int poa, int moa, boolean voiced, boolean labeled) {
        this.value = value;
        this.poa = poa;
        this.moa = moa;
        this.voiced = voiced;
        this.labeled = labeled;
    }

    public Letter(){}
    
    @JsonProperty("value")
    private String value;
    @JsonProperty("poa")
    private int poa;
    @JsonProperty("moa")
    private int moa;
    @JsonProperty("voiced")
    private boolean voiced;
    @JsonProperty("labeled")
    private boolean labeled;

    public String getValue() { return value; }
    public int getPoa() { return poa; }
    public int getMoa() { return moa; }
    public boolean getVoiced() { return voiced; }
    public boolean getLabeled() { return labeled; }

    public String getTitle() {
        String title = "";
        if(voiced) {title += "VOICED ";} else {title += "VOICELESS ";}
        switch(poa){
            case 0: title += "BILABIAL "; break;
            case 1: title += "LABIODENTAL "; break;
            case 2: title += "DENTAL "; break;
            case 3: title += "ALVEOLAR "; break;
            case 4: title += "POST ALVEOLAR "; break;
            case 5: title += "RETROFLEX "; break;
            case 6: title += "PALATAL "; break;
            case 7: title += "UVULAR "; break;
            case 8: title += "VELAR "; break;
            case 9: title += "PHARYNGEAL "; break;
            case 10: title += "GLOTTAL "; break;
        }
        switch(moa) {
            case 0: title += "STOP"; break;
            case 1: title += "AFFRICATE"; break;
            case 2: title += "NASAL"; break;
            case 3: title += "TRILL"; break;
            case 4: title += "TAP"; break;
            case 5: title += "FRICATIVE"; break;
            case 6: title += "LATERAL FRICATIVE"; break;
            case 7: title += "APPROXIMENT"; break;
            case 8: title += "LATERAL APPROXIMENT"; break;
        }
        return title;
    }

    public static String getTitle(int poa, int moa, boolean voiced) {
        String title = "";
        if(voiced) {title += "VOICED ";} else {title += "VOICELESS ";}
        switch(poa){
            case 0: title += "BILABIAL "; break;
            case 1: title += "LABIODENTAL "; break;
            case 2: title += "DENTAL "; break;
            case 3: title += "ALVEOLAR "; break;
            case 4: title += "POST ALVEOLAR "; break;
            case 5: title += "RETROFLEX "; break;
            case 6: title += "PALATAL "; break;
            case 7: title += "UVULAR "; break;
            case 8: title += "VELAR "; break;
            case 9: title += "PHARYNGEAL "; break;
            case 10: title += "GLOTTAL "; break;
        }
        switch(moa) {
            case 0: title += "STOP"; break;
            case 1: title += "AFFRICATE"; break;
            case 2: title += "NASAL"; break;
            case 3: title += "TRILL"; break;
            case 4: title += "TAP"; break;
            case 5: title += "FRICATIVE"; break;
            case 6: title += "LATERAL FRICATIVE"; break;
            case 7: title += "APPROXIMENT"; break;
            case 8: title += "LATERAL APPROXIMENT"; break;
        }
        return title;
    }
}