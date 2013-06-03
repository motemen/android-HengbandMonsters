package net.tokyoenvious.droid.hengbandmonsters;

/**
 * Created by motemen on 2013/05/28.
 */
public class TermColors {
    public static int TERM_DARK    = 0xFF000000;
    public static int TERM_WHITE   = 0xFFFFFFFF;
    public static int TERM_SLATE   = 0xFF7F7F7F;
    public static int TERM_ORANGE  = 0xFFFF7F00;
    public static int TERM_RED     = 0xFFBF0000;
    public static int TERM_GREEN   = 0xFF007F3F;
    public static int TERM_BLUE    = 0xFF0000FF;
    public static int TERM_UMBER   = 0xFF7F3F00;
    public static int TERM_L_DARK  = 0xFF3F3F3F;
    public static int TERM_L_WHITE = 0xFFBFBFBF;
    public static int TERM_VIOLET  = 0xFFFF00FF;
    public static int TERM_YELLOW  = 0xFFFFFF00;
    public static int TERM_L_RED   = 0xFFFF0000;
    public static int TERM_L_GREEN = 0xFF00FF00;
    public static int TERM_L_BLUE  = 0xFF00FFFF;
    public static int TERM_L_UMBER = 0xFFBF7F3F;

    public static int[] TERM_COLORS = {
        TERM_DARK, TERM_WHITE, TERM_SLATE, TERM_ORANGE, TERM_RED, TERM_GREEN, TERM_BLUE, TERM_UMBER, TERM_L_DARK, TERM_L_WHITE, TERM_VIOLET, TERM_YELLOW, TERM_L_RED, TERM_L_GREEN, TERM_L_BLUE, TERM_L_UMBER
    };

    public static int charToColor(String s) {
        return charToColor(s.charAt(0));
    }
    public static int charToColor(char c) {
        switch (c) {
            case 'd': return TERM_DARK;
            case 'w': return TERM_WHITE;
            case 's': return TERM_SLATE;
            case 'o': return TERM_ORANGE;
            case 'r': return TERM_RED;
            case 'g': return TERM_GREEN;
            case 'b': return TERM_BLUE;
            case 'u': return TERM_UMBER;
            case 'D': return TERM_L_DARK;
            case 'W': return TERM_L_WHITE;
            case 'v': return TERM_VIOLET;
            case 'y': return TERM_YELLOW;
            case 'R': return TERM_L_RED;
            case 'G': return TERM_L_GREEN;
            case 'B': return TERM_L_BLUE;
            case 'U': return TERM_L_UMBER;
            default:  return TERM_DARK;
        }
    }

    // #define TERM_DARK                0  /* 'd' */   /* 0,0,0 */
    // #define TERM_WHITE               1  /* 'w' */   /* 4,4,4 */
    // #define TERM_SLATE               2  /* 's' */   /* 2,2,2 */
    // #define TERM_ORANGE              3  /* 'o' */   /* 4,2,0 */
    // #define TERM_RED                 4  /* 'r' */   /* 3,0,0 */
    // #define TERM_GREEN               5  /* 'g' */   /* 0,2,1 */
    // #define TERM_BLUE                6  /* 'b' */   /* 0,0,4 */
    // #define TERM_UMBER               7  /* 'u' */   /* 2,1,0 */
    // #define TERM_L_DARK              8  /* 'D' */   /* 1,1,1 */
    // #define TERM_L_WHITE             9  /* 'W' */   /* 3,3,3 */
    // #define TERM_VIOLET             10  /* 'v' */   /* 4,0,4 */
    // #define TERM_YELLOW             11  /* 'y' */   /* 4,4,0 */
    // #define TERM_L_RED              12  /* 'R' */   /* 4,0,0 */
    // #define TERM_L_GREEN            13  /* 'G' */   /* 0,4,0 */
    // #define TERM_L_BLUE             14  /* 'B' */   /* 0,4,4 */
    // #define TERM_L_UMBER            15  /* 'U' */   /* 3,2,1 */

}
