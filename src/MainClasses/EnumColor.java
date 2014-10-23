package MainClasses;

import java.awt.Color;

public enum EnumColor {
	black, white;
	public static Color getOtherColor(Color color) {
		if(color.equals(Color.black))
			return Color.white;
		else
			return Color.black;
	}
}
