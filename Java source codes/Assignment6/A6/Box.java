//Scott Audet
//Box class design

package A6;

public class Box {
	
	private int length;						//box length, inches
	private int width;						//box width, inches
	private int height;						//box height, inches
	
	public Box() {							//POST: new box 1x1x1
		length = 1;
		width = 1;
		height = 1;
	}
	
	public Box(int l, int w, int h) {		//POST: new box, user defined
		length = l;
		width = w;
		height = h;
	}
	
	public int getLength() {				//POST: return length, inches
		return length;
	}

	public void setLength(int length) {		//PRE: user defined length, inches
		this.length = length;				//POST: return length, inches
	}

	public int getWidth() {					//POST: return width, inches
		return width;
	}

	public void setWidth(int width) {		//PRE: user defined width, inches
		this.width = width;					//POST: return width, inches
	}

	public int getHeight() {				//POST: return height, inches
		return height;
	}

	public void setHeight(int height) {		//PRE: user defined height, inches
		this.height = height;				//POST: return height, inches
	}

	public void setDimensions(int l, int w, int h) {
		length = l;							//PRE: user dimensions, inches
		width = w;							//POST: return l, w, & h, inches
		height = h;
	}
	
	//area
	public int area() {						//POST: return surface area, inches^2
		return 2 * (width * length + height * length + height * width);
	}
	
	//volume method
	public int volume() {					//POST: return volume, inches^3
		return length * width * height;
	}

}
