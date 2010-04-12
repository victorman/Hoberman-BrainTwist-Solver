package braintwist;
/**
 * @author Victor
 * testing
 */
import java.awt.Color;

public class ColorCode {
	public static final byte Yellow = 16;
	public static final byte Cyan = 32;
	public static final byte Lime = 64;
	public static final byte Green = (byte)0x80;
	public static final byte Blue = 1;
	public static final byte Red = 2;
	public static final byte Orange = 4;
	public static final byte Magenta = 8;

        public static Color getColorI(byte b) {
            int c = (byte)0xF & b;
            switch (c) {
                case 1:
                    return Color.BLUE;
                case 2:
                    return Color.RED;
                case 4:
                    return Color.ORANGE;
                case 8:
                    return Color.MAGENTA;
                default:
                    return Color.BLACK;
            }
            
        }

        public static Color getColorO(byte b) {
            int c = ((byte)0xF & (b>>4));
            switch (c) {
                case 1:
                    return Color.YELLOW;
                case 2:
                    return Color.CYAN;
                case 4:
                    return Color.PINK;
                case 8:
                    return Color.GREEN;
                default:
                    return Color.BLACK;
            }

        }
}
