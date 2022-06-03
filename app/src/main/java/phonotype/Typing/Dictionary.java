package phonotype.Typing;

import java.lang.reflect.Array;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dictionary {
    @JsonProperty("q") private String[] q;
    @JsonProperty("w") private String[] w;
    @JsonProperty("e") private String[] e;
    @JsonProperty("r") private String[] r;
    @JsonProperty("t") private String[] t;
    @JsonProperty("y") private String[] y;
    @JsonProperty("u") private String[] u;
    @JsonProperty("i") private String[] i;
    @JsonProperty("o") private String[] o;
    @JsonProperty("p") private String[] p;
    @JsonProperty("a") private String[] a;
    @JsonProperty("s") private String[] s;
    @JsonProperty("d") private String[] d;
    @JsonProperty("f") private String[] f;
    @JsonProperty("g") private String[] g;
    @JsonProperty("h") private String[] h;
    @JsonProperty("j") private String[] j;
    @JsonProperty("k") private String[] k;
    @JsonProperty("l") private String[] l;
    @JsonProperty("z") private String[] z;
    @JsonProperty("x") private String[] x;
    @JsonProperty("c") private String[] c;
    @JsonProperty("v") private String[] v;
    @JsonProperty("b") private String[] b;
    @JsonProperty("n") private String[] n;
    @JsonProperty("m") private String[] m;
    @JsonProperty(".") private String[] period;
    @JsonProperty("!") private String[] exclamationMark;
    @JsonProperty("?") private String[] questionMark;
    @JsonProperty("-") private String[] hyphen;
    @JsonProperty("[") private String[] openBracket;
    @JsonProperty("]") private String[] closeBracket;
    
    public String[] getLetter(char letter) {
        switch(letter) {
            case 'q': return q;
            case 'w': return w;
            case 'e': return e;
            case 'r': return r;
            case 't': return t;
            case 'y': return y;
            case 'u': return u;
            case 'i': return i;
            case 'o': return o;
            case 'p': return p;
            case 'a': return a;
            case 's': return s;
            case 'd': return d;
            case 'f': return f;
            case 'g': return g;
            case 'h': return h;
            case 'j': return j;
            case 'k': return k;
            case 'l': return l;
            case 'z': return z;
            case 'x': return x;
            case 'c': return c;
            case 'v': return v;
            case 'b': return b;
            case 'n': return n;
            case 'm': return m;
            case '.': return period;
            case '!': return exclamationMark;
            case '?': return questionMark;
            case '-': return hyphen;
            case '[': return openBracket;
            case ']': return closeBracket;
            default: return new String[0];
        }
    }

    public void setLetter(char letter, String[] array) {
        switch(letter) {
            case 'q': q = array; return;
            case 'w': w = array; return;
            case 'e': e = array; return;
            case 'r': r = array; return;
            case 't': t = array; return;
            case 'y': y = array; return;
            case 'u': u = array; return;
            case 'i': i = array; return;
            case 'o': o = array; return;
            case 'p': p = array; return;
            case 'a': a = array; return;
            case 's': s = array; return;
            case 'd': d = array; return;
            case 'f': f = array; return;
            case 'g': g = array; return;
            case 'h': h = array; return;
            case 'j': j = array; return;
            case 'k': k = array; return;
            case 'l': l = array; return;
            case 'z': z = array; return;
            case 'x': x = array; return;
            case 'c': c = array; return;
            case 'v': v = array; return;
            case 'b': b = array; return;
            case 'n': n = array; return;
            case 'm': m = array; return;
            case '.': period = array; return;
            case '!': exclamationMark = array; return;
            case '?': questionMark = array; return;
            case '-': hyphen = array; return;
            case '[': openBracket = array; return;
            case ']': closeBracket = array; return;
            default: return;
        }
    }

    public void AppendDictionary(Dictionary appenix) {
        for(char l: KeyListener.chars) {
            this.setLetter(l, concatenate(this.getLetter(l), appenix.getLetter(l)));
        }
    }

    public static <T> T[] concatenate(T[] a, T[] b) {
        int aLen = a.length;
        int bLen = b.length;
    
        @SuppressWarnings("unchecked")
        T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen);
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
    
        return c;
    }
}
